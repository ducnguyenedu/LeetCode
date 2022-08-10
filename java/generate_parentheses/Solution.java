package generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> ans = new ArrayList<>();
    char[] arr;

    public List<String> generateParenthesis(int n) {
        if (n == 0) return ans;

        arr = new char[2 * n];

        build(0, 0, 0);
        return ans;
    }

    private void build(int i, int lt, int rt) {
        if (i == arr.length) {
            ans.add(new String(arr));
            return;
        }

        if (lt < arr.length / 2) {
            arr[i] = '(';
            build(i + 1, lt + 1, rt);
        }

        if (lt > rt && rt < arr.length / 2) {
            arr[i] = ')';
            build(i + 1, lt, rt + 1);
        }
    }
}
