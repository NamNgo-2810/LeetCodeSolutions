class StringToInteger {
    //Problem 8: Strign to Integer - atoi
    public int myAtoi(String str) {
        if(str.length() <= 0) return 0;
        int length = str.length();
        int res = 0;
        int start = 0;
        int negative = 1;

        for(; start < length; start++) {
            if(str.charAt(start) != ' ') {
                break;
            }
        }

        if (start == length) return res;

        if (str.charAt(start) == '-') {
            negative = -1;
            start++;
        }
        else if (str.charAt(start) == '+') {
            negative = 1;
            start++;
        }


        for(int i = start; i < length; i++){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                int temp = str.charAt(i) - '0';

                if (res*negative > Integer.MAX_VALUE/10 || (res*negative == Integer.MAX_VALUE/10 && temp >= 7)) {
                    return Integer.MAX_VALUE;
                }
                else if(res*negative < Integer.MIN_VALUE/10 || (res*negative == Integer.MIN_VALUE/10 && temp >= 8)) {
                    return Integer.MIN_VALUE;
                }

                res = (res * 10) + (temp);
            }
            else break;
        }

        return res * negative;
    }
}
