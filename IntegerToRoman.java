class IntegerToRoman {
    // Problem 12: Integer to Roman
    int[] num = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String[] sym = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    int i = 12;
    public String intToRoman(int n) {
        String res = "";
        while (n > 0) {
            int div = n/num[i];
            n %= num[i];
            while (div > 0) {
                res += sym[i];
                div--;
            }
            i--;
        }
        return res;
    }
}
