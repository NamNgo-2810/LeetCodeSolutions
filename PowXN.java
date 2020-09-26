class PowXN {
    // Problem 50: Pow(x,n)
    public double myPow(double x, int n) {
        double result = 1;
        long posN = Math.abs((long) n);
        while (posN > 0) {
            if (posN % 2 == 1) result *= x;
            x *= x;
            posN /= 2;
        }
        return n < 0 ? 1 / result : result;
    }
}
