//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 8720 👎 0

package com.sou.sfspcgw.backup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] numsTemp = Arrays.copyOf(nums,nums.length);
            Arrays.sort(nums);
            int i = 0;
            int j = nums.length-1;
            while(i<j){
                int sum = nums[i]+nums[j];
                if(sum==target){
                    break;
                }else if(sum<target){
                    i++;
                }else{
                    j--;
                }
            }
            int index = 0;
            int[] result = new int[2];
            for(int t=0;t<numsTemp.length;t++){
                if(numsTemp[t]==nums[i]||numsTemp[t]==nums[j]){
                    result[index] = t;
                    index++;
                }
                if(index>1){
                    break;
                }
            }
            return result;
        }
    }
    class Solution1 {
        public int[] twoSum(int[] nums, int target) { if(nums!=null){
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                if((map.get(nums[i])!=null)&&(nums[i]+map.get(nums[i])==target)){
                    return new int[]{map.get(nums[i]),i};
                }else if(map.get(target-nums[i])!=null){
                    return new int[]{map.get(target-nums[i]),i};
                }else{
                    map.put(nums[i],i);
                }
            }
        }
        return new int[]{};
        }
    }


}