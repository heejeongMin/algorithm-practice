package practices.codility;

public class BinaryGap {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(1041));
    System.out.println(solution.solution(32));

  }


  static class Solution {
    public int solution(int N) {
      char[] binary = Integer.toBinaryString(N).toCharArray();
      int count = 0;
      int temp = 0;
      for (char c : binary) {
        if(c == '0') {
          temp++;
        } else {
          if(temp > count) {
            count = temp;
          }
          temp = 0;
        }
      }
      return count;
    }
  }
}


