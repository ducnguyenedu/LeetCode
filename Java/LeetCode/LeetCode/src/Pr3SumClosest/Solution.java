package Pr3SumClosest;

import java.io.IOException;
import java.util.Arrays;

class Solution {
    public static int threeSumClosest(int[] nums, int target) {
    	  int diff = Integer.MAX_VALUE;
          int sum = 0;
          Arrays.sort(nums);

          for(int i = 0; i < nums.length - 2; i++) {

              int l = i + 1;
              int r = nums.length - 1;

              while(l < r) {

                  int current_sum = nums[i] + nums[l] + nums[r];


                  if(Math.abs(target - current_sum) < diff){
                      diff = Math.abs(target - current_sum);
                      sum = current_sum;
                  }

                  if(diff == 0) return  target;


                  if(nums[i] + nums[l] + nums[r] < target) {
                      l++;
                  }
                  else
                      r--;
              }

          }



          return sum;
    }
    public static void main(String[] args) throws IOException {
    	int[] nums= new int[4];
    	nums[0]=-1;
    	nums[1]=2;
    	nums[2]=1;
    	nums[3]=-4;
    	int target=1;
    	System.out.println(threeSumClosest(nums,target)+"");
    }
}