/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:

Input: s = "leetcode"
Output: 0

Example 2:

Input: s = "loveleetcode"
Output: 2

Example 3:

Input: s = "aabb"
Output: -1

Constraints:

1 <= s.length <= 10^5
s consists of only lowercase English letters.
*/

class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Long> charactersWithCount = s
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        for (Map.Entry<Character, Long> entry : charactersWithCount.entrySet())
            if (entry.getValue() == 1)
                return s.indexOf(entry.getKey());

        return -1;
    }
}