class palimedromeRecursion {
    static int rev(int n) {
        int digit = (int) (Math.log10(n) + 1);
        return helper(n, digit);
    }

    private static int helper(int n, int digit) {
        if (n == 0) {
            return n;
        }
        int rem = n % 10;   // not taking any extra space
        return rem * (int) (Math.pow(10, digit - 1)) + helper(n / 10, digit - 1);
    }

    static boolean palim(int n) {

        return n == rev(n);
    }

    public static void main(String[] args) {
        palim(12345);
        System.out.println(palim(11111));
    }
}
