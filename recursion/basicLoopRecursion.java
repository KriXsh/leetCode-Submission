// loops using recursitions

public class basicloopRecursion {
    public static void main(String[] args){
        func(1)

    }
    static int func(int n){
        if(n ==6) return false;
        System.out.println(n);
        func(n+1);
    }
    
}
