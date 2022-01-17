package palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> temp = new ArrayList<>();
    List<List<String>> ans = new ArrayList<List<String>>();

    public List<List<String>> partition(String s) {
        find(s, 0);
        return ans;
    }

    public void find(String s, int ptr) {
        if (ptr == s.length() && temp.size() > 0) {
            ans.add(new ArrayList<String>(temp));
            return;
        }

        for (int i = ptr; i < s.length(); i++) {
            String str = s.substring(ptr, i + 1);
            if (isPalindrome(str)) {
                temp.add(str);
                find(s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        }
        return true;
    }
}