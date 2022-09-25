package letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> letterCombinations(String s) {
        Map<Character, Character[]> digits = new HashMap<Character, Character[]>();
        digits.put('2', new Character[]{'a', 'b', 'c'});
        digits.put('3', new Character[]{'d', 'e', 'f'});
        digits.put('4', new Character[]{'g', 'h', 'i'});
        digits.put('5', new Character[]{'j', 'k', 'l'});
        digits.put('6', new Character[]{'m', 'n', 'o'});
        digits.put('7', new Character[]{'p', 'q', 'r', 's'});
        digits.put('8', new Character[]{'t', 'u', 'v'});
        digits.put('9', new Character[]{'w', 'x', 'y', 'z'});
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                for (int j = 0; j < digits.get(s.charAt(i)).length; j++) {
                    char t;
                    t = digits.get(s.charAt(i))[j];
                    res.add(String.valueOf(t));
                }
            } else {
                int len = res.size();
                for (int k = 0; k < len; k++) {
                    String c = res.remove(0);
                    for (int j = 0; j < digits.get(s.charAt(i)).length; j++) {
                        char t;
                        t = digits.get(s.charAt(i))[j];
                        res.add(c + t);
                    }
                }
            }
        }
        return res;
    }
}
