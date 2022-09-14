package practices.codility;

import java.util.Arrays;

public class PermMissingElem {

  public static void main(String[] ars) {
    Solution solution = new Solution();
//    System.out.println(solution.solution(new int[]{2, 3, 1, 5}));
//    System.out.println(solution.solution(new int[]{}));
//    System.out.println(solution.solution(new int[]{2, 3}));
    System.out.println(solution.solution(new int[]{1,2,3}));
//    System.out.println(solution.solution(new int[]{1}));
  }

  static class Solution {

    public int solution(int[] A) {
      if(A.length < 1) {
        return 1;
      } else if (A.length == 1 && A[0] != 1) {
        return 1;
      }

      Arrays.sort(A);
      if(A[0] != 1) {
        return 1;
      }

      int temp = 1;
      for (int i = 1; i < A.length; i++) {
        if (A[i] == temp + 1) {
          temp = A[i];
        } else {
          temp += 1;
          break;
        }
      }
      return (temp == A[A.length-1]) ? temp+1 : temp;
    }
  }
}
