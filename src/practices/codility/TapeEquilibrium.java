package practices.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TapeEquilibrium {

  public static void main(String[] ars) {
    Solution solution = new Solution();
    System.out.println(solution.solution(new int[]{3,1,2,4,3}));
//    System.out.println(solution.solution(new int[]{1,1,1}));
//    System.out.println(solution.solution(new int[]{3,1,7,-4}));
  }

  //A non-empty array
  //consisting of N integers
  //integer P : 0 < P < N -> splits this tape into two non-empty parts
  // { 0, 1, 2, 3 }
  static class Solution {
    public int solution(int[] A) {
      int left = 0;
      int right = 0;
      int sum = 0;

      for (int i : A) {
        sum += i;
      }


      List<Integer> list = new ArrayList<>();
      for (int i = 1; i < A.length; i++) {
        left += A[i-1] ;
        right = sum - left;
        list.add(Math.abs(left - right));
      }

      return Collections.min(list);
    }
  }
}

