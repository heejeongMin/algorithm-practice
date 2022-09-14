package practices.codility;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

  public static void main(String[] ars) {
    Solution solution = new Solution();
    System.out.println(solution.solution(5, new int[]{1,3,1,4,2,3,5,4}));
  }

  static class Solution {
    public int solution(int X, int[] A) {
      int answer = -1;
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < A.length; i++) {
        if(A[i] > X) {
          continue;
        }

        set.add(A[i]);
        if(set.size() == X) {
          answer = i;
          break;
        }
      }

      return answer;
    }
  }
}
