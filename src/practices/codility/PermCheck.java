package practices.codility;

import java.util.Arrays;

public class PermCheck {

  public static void main(String[] ars) {
    Solution solution = new Solution();
//    System.out.println(solution.solution(new int[]{4,1,3}));
    System.out.println(solution.solution(new int[]{4,1,2,3}));
//    System.out.println(solution.solution(new int[]{1}));
//    System.out.println(solution.solution(new int[]{5}));
//    System.out.println(solution.solution(new int[]{1,5}));
//    System.out.println(solution.solution(new int[]{9,5}));
//    System.out.println(solution.solution(new int[]{4,5}));
  }

  static class Solution {
    public int solution(int[] A) {
      if(A.length == 1 ) {
        return (A[0] == 1)? 1 : 0;
      }

      Arrays.sort(A);
      if(A[0] != 1) {
        return 0;
      }

      int answer = 1;

      for (int i = 1; i < A.length; i++) {
        if(A[i-1] == A[i]-1) {
          continue;
        } else {
          answer = 0;
          break;
        }
      }
      return answer;
    }
  }
}
