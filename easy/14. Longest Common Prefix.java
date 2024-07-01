/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLength = Arrays
                .stream(strs)
                .mapToInt(String::length)
                .min()
                .getAsInt();

        String prefix = "";
        for (int i = minLength; i > 0; i--) {
            prefix = strs[0].substring(0, i);
            boolean correctPrefix = true;
            for (String s : strs) {
                if (!s.startsWith(prefix)) {
                    correctPrefix = false;
                    break;
                }
            }
            if (correctPrefix)
                return prefix;
        }
        return "";
    }
}