package practices.leetcode;

//todo 다시풀기
public class FibonacciNumber {

  //0, 1, 1, 2, 3, 5, 8, 13, 21
  public static void main (String[] args) {
    int result = Solution.fib(7);
    System.out.println(result);
  }

  static class Solution {
    public static int fib(int n) {
      if(n == 1) {
        return 1;
      }

      int i = 0;
      int j = 1;
      int sum = 0;
      for(int k = 1; k < n; k++) {
        sum = i + j ;
        i = j;
        j = sum;
      }
      return sum;
    }

  }

}
