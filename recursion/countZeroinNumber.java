class countZeroinNumber {
    public static void main(String[] args) {
          System.out.println(countZero(1200222));
      }
      static int countZero(int n){  /// pass as an argument
         return helper(n, 0);
      }
      private static int helper(int n, int count){
          if(n ==0){
              return count;
          }
          int rem = n % 10;
          if(rem == 0){
              return helper(n/10, count+1);
          }
          return helper(n/10 ,count);
      }
    
  }