package practices.programmers;

public class JadenCase {

  public static void main(String[] ars) {
    Solution solution = new Solution();


    System.out.print(solution.solution("3people unFollowed me  "));
    System.out.println("end");
  }

  static class Solution {
    public String solution(String s) {
      String answer = "";
      boolean wasBlankBefore = true;
      for (char c : s.toCharArray()) {
        if(c == 32) {
          wasBlankBefore = true;
          answer += " ";
          continue;
        }

        if(wasBlankBefore) {
          answer += (c < 97)? c : Character.toString(c - 32);
          wasBlankBefore = false;
        } else {
          answer += (c < 97)? Character.toString(c+32) : c;
        }
      }

      return answer;
    }
  }
}
