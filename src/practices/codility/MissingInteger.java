package practices.codility;

import java.util.Arrays;

public class MissingInteger {

  public static void main(String[] ars) {
    Solution solution = new Solution();
    System.out.println(solution.solution(new int[]{1,3,6,4,1,2}));
    System.out.println(solution.solution(new int[]{1,2,3}));
    System.out.println(solution.solution(new int[]{-1,-3}));
    System.out.println(solution.solution(new int[]{2}));
    System.out.println(solution.solution(new int[]{1}));
    System.out.println(solution.solution(new int[]{-1}));
    System.out.println(solution.solution(new int[]{98,99999}));
  }

  static class Solution {

    public int solution(int[] A) {
      Arrays.sort(A);
      int min = 1;
      for (int i : A) {
        if( i == min ) {
          min++;
        }
      }
      return  min;
    }
  }
}
