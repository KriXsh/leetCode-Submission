class fibonacci {
    public static void main(String[] args) {
        int ans = fibo(4);
        System.out.println("Try programiz.pro-" + ans);
    }

    static int fibo(int n) {
        if (n < 2) return n; // base case
        return fibo(n-1) + fibo(n-2);
    }
}