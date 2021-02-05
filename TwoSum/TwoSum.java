package TwoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
//        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//                You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        You can return the answer in any order.

    }

    public static int[] twoSum_1(int[] nums, int target){

        for(int i=0; i < nums.length; i++){
            for(int j=i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }

        throw new IllegalArgumentException("No Solution");
    }

    public static int[] twoSum_2(int[] nums, int target){
        /*
            reduce the time complexity by trading space for speed
            In the first iteration, we add each element's value and
            its index to the table, then, in the second iteration we
            check if each elements complement exists in the table.
            Be aware that the complement must not be nums itself!

         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No Solution");
    }
}


