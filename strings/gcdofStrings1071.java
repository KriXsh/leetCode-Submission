class gcdofStrings1071 {

    // Helper function to calculate GCD of two numbers
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Helper function to check if str can be constructed by repeating base
    private boolean canConstruct(String str, String base) {
        if (str.length() % base.length() != 0)
            return false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() / base.length(); i++) {
            sb.append(base);
        }
        return sb.toString().equals(str);
    }

    public String gcdOfStrings(String str1, String str2) {
        // Find the GCD of the lengths of str1 and str2
        int len1 = str1.length();
        int len2 = str2.length();
        int gcdLength = gcd(len1, len2);

        // The potential greatest common divisor string
        String potentialGCD = str1.substring(0, gcdLength);

        // Check if this potentialGCD can construct both str1 and str2
        if (canConstruct(str1, potentialGCD) && canConstruct(str2, potentialGCD)) {
            return potentialGCD;
        } else {
            return "";
        }
    }
}
