/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]

Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100
*/

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> numsWithCounts = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(i -> 1)));

        LinkedHashMap<Integer, Integer> numsWithCountsSorted = numsWithCounts.entrySet().stream()
                .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()) == 0 ? e2.getKey().compareTo(e1.getKey())
                        : e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> x, LinkedHashMap::new));

        String numsSorted = numsWithCountsSorted.entrySet().stream()
                .map(entry -> (entry.getKey() + " ").repeat(entry.getValue()))
                .collect(Collectors.joining(""));

        return Arrays.stream(numsSorted.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}