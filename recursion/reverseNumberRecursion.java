
public class reverseNumberRecursion {
    static int sum = 0;     // taking extra space;

    static void revM1(int n) {
        if (n == 0) {
            return;
        }
        int reminder = n % 10;  // 1234.5
        sum = sum * 10 + reminder; //put 5 first then add it on first and add other as well
        revM1(n / 10);

    }
    public static void main(String[] args) {
        revM1(12345);
        System.out.println(sum);
    }

}


