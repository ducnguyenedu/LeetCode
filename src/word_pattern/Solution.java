package word_pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        List<String> nm = new ArrayList<>();
        int i, j = 0, k = s.length();
        for (i = 1; i < k; i++) {
            if (s.charAt(i) == ' ') {
                nm.add(s.substring(j, i));
                j = i + 1;
            }
        }
        nm.add(s.substring(j, i));
        if (nm.size() != pattern.length())
            return false;
        HashMap<String, Character> kk = new HashMap<>();
        k = nm.size();
        for (i = 0; i < k; i++) {
            if (kk.containsKey(nm.get(i))) {
                if (kk.get(nm.get(i)) != pattern.charAt(i))
                    return false;
            }
            if (kk.containsValue(pattern.charAt(i)) && !kk.containsKey(nm.get(i)))
                return false;
            else
                kk.put(nm.get(i), pattern.charAt(i));
        }
        return true;
    }
}