package practices.programmers;

public class BinaryCopy {

  public static void main(String[] ars) {
    Solution solution = new Solution();
    for (int i : solution.solution("110010101001")) {
      System.out.println(i);
    }

    for (int i : solution.solution("01110")) {
      System.out.println(i);
    }

    for (int i : solution.solution("1111111")) {
      System.out.println(i);
    }
  }

  static class Solution {
    public int[] solution(String s) {
      int zeroEleminationCount = 0;
      int transformCount = 0;

      while(s.length() > 1){
        transformCount++;

        int originLength = s.length();
        String str = "";

        if(s.contains("0")) {
          str = s.replaceAll("0", "");
          zeroEleminationCount += originLength - str.length();
        } else {
          str = s;
        }

        s = Integer.toBinaryString(str.length());
      }

      int[] answer = new int[]{transformCount, zeroEleminationCount};
      return answer;
    }

  }
}
