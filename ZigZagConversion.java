class ZigZagConversion {
    //Problem 6: ZigZag Conversion
    public String convert(String s, int numRows) {
        if (numRows >= s.length() || numRows == 1) return s;
        boolean[] used = new boolean[s.length()];
        int step = (numRows - 1) * 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += step) {
                if (!used[j]) {
                    sb.append(s.charAt(j));
                    used[j] = true;
                }
                if (j + step - 2*i < s.length()) {
                    if (!used[j + step - 2*i]) {
                        sb.append(s.charAt(j + step - 2*i));
                        used[j + step - 2*i] = true;
                    }
                }
            }
        }
        return sb.toString();
    }
}
