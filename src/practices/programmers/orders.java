package practices.programmers;


public class ColoringBook {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution("abcabcdede"));
  }


  public static class Solution {

    /*
    1 2 3 4 5 6
    2
    3
    4

     */
    public int[] solution(int m, int n, int[][] picture) {
      int numberOfArea = 0;
      int maxSizeOfOneArea = 0;

      int[] answer = new int[2];
      answer[0] = numberOfArea;
      answer[1] = maxSizeOfOneArea;
      return answer;
    }
  }
}


