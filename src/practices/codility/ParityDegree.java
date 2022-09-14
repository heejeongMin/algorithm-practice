package practices.codility;

import java.math.BigDecimal;

public class ParityDegree {

  public static void main(String[] ars) {
    Solution solution = new Solution();
    System.out.println(solution.solution(1));
  }

  static class Solution {
    public int solution(int N) {
      int sqrt = 29;

      while(sqrt >= 0) {
        BigDecimal bigDecimal = new BigDecimal(Math.pow(2,sqrt));

        if(N%bigDecimal.intValue() != 0) {
          sqrt--;
          continue;
        }

        break;
      }

      return sqrt;
    }

  }
}
