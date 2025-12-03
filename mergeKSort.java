
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class mergeKSort{
   
    static void convertLL(ListNode lists[],LinkedList l[]){
        for(int i=0; i<lists.length; i++){
        
            l[i]= new LinkedList<>();
            ListNode cur= lists[i];
            while(cur !=null){
                l[i].add(cur.val);
                cur = cur.next;
            }
        }
    }
    static int compare(int a,int b){
        return a-b;
    }
    static LinkedList merge(LinkedList<Integer> l1,LinkedList<Integer> l2){
        LinkedList<Integer> merge= new LinkedList<>();
        while(!l1.isEmpty() && !l2.isEmpty() ){
            if(  compare(l1.getFirst(),l2.getFirst()) <0 ){
                int a = l1.pollFirst();
                merge.add(a);
                
            }
            else{
                int a = l2.pollFirst();
                merge.add(a);
            
            }
                    
        }

        while(!l1.isEmpty()){
           merge.add(l1.pollFirst());
           
        }
        while(!l2.isEmpty()){
            merge.add(l2.pollFirst());
        }
        return merge;
        
    }

    static  Integer[] merge2(Integer[] r1,Integer[] r2){
        int x= 0;int y= 0;int z=0;
        Integer[] merge = new Integer[r1.length+r2.length];
        while( x<r1.length && y< r2.length){
          
            if(compare(r1[x],r2[y]) < 0){
                merge[z]= r1[x]; x++;
            }
            else{
                
                merge[z]= r2[y]; y++;
            }
            z++;
        }
        if(x< r1.length)
             System.arraycopy(r1,x,merge,z,r1.length-x);
        else if(y<r2.length)
            System.arraycopy(r2,y,merge,z,r2.length- y);

        return merge;
    }

    
    /*LinkedList merging(l,int counter){
        if (l.size == 0) return;
        if(l.size ==1) returns l[0];
        s1= l.remove(counter);
        s2= l.remove(counter);

        l1 = merge(l[0],l[1]);
        l.add(counter,l1);
      
        merging(l,counter+1);
            
        
    }*/
    LinkedList<Integer> run2(LinkedList<Integer> l_arr[],int size){
        if(size ==2)
            return merge(l_arr[0],l_arr[1]);
        if(size==1) 
            return l_arr[0];
        int half_n = size/2;
        int x= 0; int z=0;
        int y = half_n;
        LinkedList<Integer> l1_arr[] = new LinkedList[half_n];
        LinkedList<Integer> l2_arr[] = new LinkedList[size-half_n]; 
        System.out.print(x);System.out.print(" ");
        System.out.print(y);
        System.out.println();
        while( x< half_n || y< size ){
            if(x<half_n){
               l1_arr[z] = l_arr[x];
               x++;
            }
            if(y<size){
                l2_arr[z] = l_arr[y];
                y++;
            }
            z++;
        }
        
            
        LinkedList<Integer> l1 = run2(l1_arr,half_n);
        LinkedList<Integer> l2 =  run2(l2_arr,size-half_n);
        return merge(l1,l2);
         

    }




    Integer[] srun2(LinkedList<Integer> l,int size ){
        if(l.size() ==1){ 
            Integer[] a = {l.get(0)}; return a;
         }
        int half_n = size/2;
        Integer[]s1=new Integer[half_n];
        Integer[]s2= new Integer[size-half_n];
        System.arraycopy(l.toArray(),0,s1,0,half_n);
        System.arraycopy(l.toArray(),half_n,s2,0,size-half_n);
        
        Integer[] ar1 = srun2(new LinkedList<>(Arrays.asList(s1)),half_n);
        Integer[] ar2 = srun2(new LinkedList<>(Arrays.asList(s2)),size-half_n);

      
        return merge2(ar1,ar2);

        
        
    } 




    LinkedList<Integer> merge1(ListNode[] lists) {
        
        int n = lists.length;
        LinkedList l[] = new LinkedList[n];
        convertLL(lists,l);
        if(lists.length==0 || (lists.length==1 && lists[0]==null) ){
            return null;
        }
        LinkedList<Integer> e = run2(l,n);
        return e;
        

    } 

    LinkedList merge2(LinkedList[] lists) {
        
        int n = lists.length;
      
        if(lists.length==0 || (lists.length==1 && lists[0]==null) ){
            return null;
        }

        LinkedList<Integer> e = run2(lists,n);
        return e;
        

    } 

  
    LinkedList<Integer>[] prep_merge(LinkedList<Integer>[] lists){
        int n = lists.length;
        if(lists.length==0 || (lists.length==1 && lists[0]==null) ){
            return null;
        }
        for(int i=0;i<n;i++){
            Integer[] e =srun2(lists[i],lists[i].size());
            LinkedList<Integer> a = new LinkedList<>(Arrays.stream(e).collect(Collectors.toList()) );
            lists[i] = a;
        }
        return lists;

    }



    // extra review 
    void merge_state(Integer[] fi, Integer[] prev, int base,int i,int mid_base){
         
        int end = Math.min(fi.length,base + 2*i) ;
        int mid = Math.min(fi.length,mid_base);
        int start1 = base; 
        int start2  = mid;
        int track = base; 
        System.out.print(i);
        while(start1 < mid && start2 < end){
            if(prev[start1] >= prev[start2]){
                fi[track] = prev[start1];
                start1++; 
                
            }else{
                fi[track] = prev[start2];
                start2++;
            }

            track++;
        }
        if(start1 <mid ){
            System.arraycopy(prev, start1, fi, track, mid-start1);
        }
        else{
            System.arraycopy(prev, start2, fi, track, end-start2);

        }
        
    }

    LinkedList<Object> state(LinkedList<Integer> data){
        int n = data.size(); 
        Integer[] fi = new Integer[n];
        Integer[]  prev =  new Integer[n]; 
        for(int i =0; i<n;i++){
            prev[i] =data.get(i);
        }
        for(int i =1;i<= n/2;i*=2){
            for(int base=0;base<n ; base += i*2 ){
                merge_state(fi,prev,base,i,base+i);
            }
            System.arraycopy(fi,0,prev,0,fi.length);
        }
        System.out.println();
        return new LinkedList<>(Arrays.asList(fi));

    }
    


}