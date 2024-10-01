public class fuctorial {
    public static void main(String[] args){
        System.out.println(fuctorial(5));
    }
    static int fuctorial(int n){
        if(n == 0) {
            return 1;
        }
       
        return n * fuctorial(n-1);
    }
}
