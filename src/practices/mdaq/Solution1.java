package practices.mdaq;

import java.util.Arrays;

public class Solution1 {

  public static void main(String[] ars) {
    Solution solution = new Solution();
    System.out.println(solution.solution(new int[]{4, 6, 2, 2, 6, 6, 1}));
  }

  static class Solution {

    int solution(int[] A) {
      int N = A.length;
      int result = 0;
      Loop:
      for (int i = 0; i < N; i++) {
        for (int j = N-1; j >= i; j--) {
          if (A[i] == A[j]) {
            result = Math.max(result, Math.abs(i - j));
            if(result > 0) {
              break Loop;
            }
          }
        }
      }
      return result;
    }
  }
}
