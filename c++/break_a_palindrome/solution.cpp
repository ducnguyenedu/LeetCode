class Solution {
public:

    bool isPalindrome(string p) {
        string temp = p;
        reverse(temp.begin(), temp.end());
        return temp == p;
    }

    string breakPalindrome(string palindrome) {
        string temp = palindrome;
        int n = palindrome.length();
        if (n == 1) return "";
        if (palindrome[0] != 'a') {
            palindrome[0] = 'a';
            return palindrome;
        }
        int i = 0;
        while (i < n) {
            if (palindrome[i] == 'a') {
                if (i == n - 1) {
                    palindrome[n - 1] = 'b';
                    return palindrome;
                }
            } else {
                palindrome[i] = 'a';
                if (isPalindrome(palindrome)) {
                    palindrome[i] = temp[i];
                    i++;
                    continue;
                }
                return palindrome;
            }
            i++;
        }
        return "";
    }
};