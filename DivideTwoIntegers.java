class DivideTwoIntegers {
    // Problem 29: Divide Two Integers
    public int divide(int dividend, int divisor) {
        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        long val = ldivide(ldividend, ldivisor);
        if (positive) {
            if (val > (long)Integer.MAX_VALUE) {  // for case {Integer.MIN_VALUE, -1}
                return Integer.MAX_VALUE;
            }
            return (int)val;
        } else {
            return (int)(~(val - 1));
        }
    }

    private long ldivide(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }

        long res = 1;
        long tmp = divisor;
        while (tmp<<1 <= dividend) {
            tmp <<= 1;
            res <<= 1;
        }

        return res + ldivide(dividend - tmp, divisor);
    }
}
