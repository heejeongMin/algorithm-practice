package practices.programmers;

import java.util.HashSet;
import java.util.Set;

public class combination {

  public static void main(String[] args) {
    Solution solution = new Solution();
//    solution.solution("ABCD");

    String[] s = "ABCD".split("");
    Set<String> sets = new HashSet<>();
    int[] course = {2,3,4};
    for (int c : course) {
      for(int i = 0; i < s.length; i++) {
        solution.solution2(
            sets, s, "", i, c);
      }
    }

    System.out.println(sets.toString());
  }

  public static class Solution {

    public String solution2(Set<String> sets, String[] s, String result, int pos, int targetLen) {

      if (result.length() == targetLen) {
        sets.add(result);
        return result;
      }

      String letter = result + s[pos];

      for(int i = pos+1; i <s.length; i++) {
        // A + B  1
        // A + B + C  2
        solution2(sets, s, letter, i, targetLen);
      }

      if (letter.length() == targetLen) {
        sets.add(letter);
        return result;
      }

      return result;
    }

    public void solution(String s) {
      Set<String> sets = new HashSet<>();
      String[] str = s.split("");

      int[] combo =  new int[]{2, 3};

      for (int c : combo) {
        for (int i = 0; i < str.length; i++) {
          String letter = str[i];

          //abc, abd
          for(int j=i+1; j<str.length; j++) {
            String kkk = letter + str[j];
            if(c == kkk.length()) {
              sets.add(kkk);
            }
          }
        }
      }
      System.out.println(sets.toString());
    }
  }

}
