class MultiplyStrings {
    // Problem 43: Multiply Strings
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] ans = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int subres = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                subres += ans[p2];
                ans[p1] += subres / 10;
                ans[p2] = subres % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean started = false;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] != 0) {
                started = true;
            }
            if (started) {
                sb.append(ans[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
