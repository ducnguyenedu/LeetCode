class Solution {
public:
    int numDecodings(string s) {
        if (s.empty() || s[0] == '0')
            return 0;
        std::vector<int> dp(s.size() + 1, 0);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); ++i) {
            int num = std::atoi(s.substr(i - 1, 2).c_str());
            if ((num <= 26 && num >= 10) && (num % 10 != 0)) {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else if ((num <= 26 && num >= 10) && (num % 10 == 0)) {
                dp[i + 1] = dp[i - 1];
            } else if ((num > 26 || num < 10) && (num % 10 != 0)) {
                dp[i + 1] = dp[i];
            } else if ((num > 26 || num < 10) && (num % 10 == 0)) {
                dp[i + 1] = 0;
            }
        }

        return dp[s.size()];
    }
};