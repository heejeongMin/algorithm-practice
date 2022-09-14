package practices.codility;

public class FrogJmp {

  public static void main(String[] ars) {
    Solution solution = new Solution();
    System.out.println(solution.solution(10, 85, 30));
    System.out.println(solution.solution(1, 20, 30));
  }

  static class Solution {
    public int solution(int X, int Y, int D) {
      int gap = Y - X;
      if(gap == 0) {
        return 0;
      } else {
        if(gap%D > 0) {
          return gap/D + 1;
        } else {
          return gap/D;
        }
      }
    }
  }
}
