/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function(nums) {
    for (let i = 0; i < nums.length-1; i++) {
      const isDuplicate = nums[i];
      for (let j = i+1; j < nums.length; j++) {
          const element = nums[j];
          if(isDuplicate == element){
              return isDuplicate;
          }
        }  
    }  
  };