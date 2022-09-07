package practices.codility;

import java.util.Arrays;

public class CyclicRotation {

  public static void main(String[] args) {
    Solution solution = new Solution();
//    for (int i : solution.solution(new int[]{3, 8, 9, 7, 6}, 3)) {
//      System.out.println(i);
//    }
//
//    for (int i : solution.solution(new int[]{1,2,3,4}, 4)) {
//      System.out.println(i);
//    }
//
//    for (int i : solution.solution(new int[]{0,0,0}, 1)) {
//      System.out.println(i);
//    }
//
//    for (int i : solution.solution(new int[]{1,2}, 3)) {
//      System.out.println(i);
//    }

//    for (int i : solution.solution(new int[]{-4}, 0)) {
//      System.out.println(i);
//    }

//    for (int i : solution.solution(new int[]{4, 6, 0, 0, -2, 10}, 2)) {
//      System.out.println(i);
//    }

    for (int i : solution.solution(new int[]{}, 2)) {
      System.out.println(i);
    }
  }

  static class Solution {
    public int[] solution(int[] A, int K) {
      if(A.length ==0 || K == 0) {
        return A;
      }

      int[] answer = new int[A.length];
      while(K > 0) {
        answer[0] = A[A.length-1];
        for (int i = 0; i < A.length-1; i++) {
          answer[i+1] = A[i];
        }
        A = Arrays.copyOf(answer, A.length);
        K--;
      }

      return answer;
    }
  }

}
