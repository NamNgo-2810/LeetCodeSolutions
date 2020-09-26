class RegularExpressionMatching {
    // Problem 10: Regular Expression Matching
    int[][] dp; // 1 means true, -1 means false, 0 means null

    public boolean isMatch(String s, String p) {

        if (p.isEmpty()) return s.isEmpty();


        dp = new int[s.length() + 1][p.length() + 1];
        return recDP(0, 0, s, p);

        /*Recursive method
        If the first one matched
        boolean firstMatch = !s.isEmpty() && (p.charAt(0)=='.' || p.charAt(0) == s.charAt(0));
        if (p.length()>=2 && p.charAt(1) == '*') {
        //p[1] == '*' -> either skip, or match one char for s
        // Repeat 0 times and the rest matched || repeat >=1 times and first matched
            return isMatch(s, p.substring(2)) || firstMatch && isMatch(s.substring(1), p);
        }
        else { // If not containing * at p[1]
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }*/





        /*Bottom-up DP,
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;

        // Why here i start from n and not n - 1?
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean first_match = (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
                if (j + 1 < p.length() && p.charAt(j+1) == '*') dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                else dp[i][j] = first_match && dp[i+1][j+1];
            }
        }
        return dp[0][0];*/
    }

    public boolean recDP(int i, int j, String s, String p) {
        // First check dp
        if (dp[i][j] != 0) return dp[i][j] == 1;

        // The last one
        if (j == p.length()) return i == s.length();

        // Then check first match
        boolean firstMatch = i < s.length() && (p.charAt(j)=='.' || p.charAt(j) == s.charAt(i));
        boolean ret;
        // Check if p[j+1] == '*'
        if (p.length() - j >= 2 && p.charAt(j+1) == '*') ret = recDP(i, j + 2, s, p) || firstMatch && recDP(i + 1, j, s, p);
        else ret = firstMatch && recDP(i + 1, j + 1, s, p);

        dp[i][j] = ret ? 1 : -1;

        return ret;
            /*if (p.length()>=2 && p.charAt(1) == '*') {
            // p[1] == '*' -> either skip, or match one char for s
            // Repeat 0 times and the rest matched || repeat >=1 times and first matched
                return isMatch(s, p.substring(2)) || firstMatch && isMatch(s.substring(1), p);
            }
            else { // If not containing * at p[1]
                return firstMatch && isMatch(s.substring(1), p.substring(1));
            }*/

    }
}
