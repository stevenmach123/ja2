import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TimeNeededtoBuyTicket {
    //https://leetcode.com/problems/time-needed-to-buy-tickets/solutions/3918164/brute-force-optimized-queue-interviewer-mindset/
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count=0;
        while(tickets[k] > 0 ){
            for(int i =0;i< tickets.length;i++){
                if(tickets[i]==0)
                    continue;
                tickets[i]--;
                count++;
                if(i ==k && tickets[k]==0)
                    return count;
                
            }
        }
        return count;
    }

    public int timeRequiredToBuy2(int[] tickets, int k) { 
        Queue<Integer> s = new LinkedList<>();
        for(int i=0;i<tickets.length;i++)
            s.add(i);
        int count=0;
        while(!s.isEmpty()){
            int c = s.poll();
            tickets[c]--;
            count++;
            if(c==k  && tickets[c]==0)
                return count;
            if(tickets[c] == 0)
                continue;
            s.add(c);
        }
        return count;

        
    }



}
