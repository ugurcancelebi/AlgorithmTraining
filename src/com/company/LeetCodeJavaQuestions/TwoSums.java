package com.company.LeetCodeJavaQuestions;

import java.util.HashMap;

public class TwoSums {
    /*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    Example:
    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
    o(n2) time complexity
     */
   public int[] twoSum(int[] nums, int target) {
       for (int i = 0;i<nums.length;i++){
           for (int j = i+1;j<nums.length;j++){
               int diff = target - nums[j];
               if (nums[j] == diff){
                   return new int[] {i,j};
               }
            }
        }
       throw  new IllegalArgumentException("no match");
    }
    //o(n) linear time complexity
    public static int[] twoSums(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            int diff = target - nums[i];
            if (hashMap.containsKey(diff)){
                return new int[] {hashMap.get(diff),i};
            } hashMap.put(nums[i],i);
        }
        throw  new IllegalArgumentException("no match");
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,51,23,32,0};
        int target = 8;
        twoSums(arr,target);
    }
}
