package practices.codility;

import java.util.Arrays;

public class OddOccurrencesInArray {

  public static void main(String[] ars) {
    Solution solution = new Solution();
    System.out.println(solution.solution(new int[]{9,3,9,3,9,7,9}));
  }

  static class Solution {
    public int solution(int[] A) {
      Arrays.sort(A);
      int num = A[0];
      int count = 0;

      for (int i : A) {
        if(num == i) {
          count++;
        } else {
          if(count %2 !=0) {
            break;
          }
          num = i;
          count = 1;
        }
      }

      return num;
    }
  }
}

/* performance 25%
 List<Integer> num = new ArrayList<>();
 for (int i : A) {
 int idx = num.indexOf(i);
 if(idx != -1) {
 num.remove(idx);
 } else {
 num.add(i);
 }
 }
 return num.get(0);
 */
