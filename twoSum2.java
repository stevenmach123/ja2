
public class twoSum2 {

    public int[] two(int[] numbers, int target) {
        int low= 0;
        int high =numbers.length-1;
        int[] a = new int[2];
        while(low < high){
            if(numbers[low]+numbers[high] >target ){
                high--;
            }
            else if(numbers[low]+numbers[high] < target){
                low++;
            }
            else{
                a[0]= low+1;a[1] =high+1;
                break;
            }
        }
        return a;


    }

}

