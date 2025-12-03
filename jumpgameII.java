class jumpgameII {
    public int jump(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            int reach = nums[i];
            int min = Integer.MAX_VALUE;
            for(int x=i;x <= x +reach && x < nums.length;x++){
                min = Integer.min(min, x+1);
            }
            arr[i]= min ;
        }
       return arr[0];
    }
}

/*
  for(){ 

  } 

 */