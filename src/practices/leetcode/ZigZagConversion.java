package practices.leetcode;

import java.util.*;

public class ZigZagConversion {

  public static void main(String[] args) {
    String answer = Solution.convert("PAYPALISHIRING", 3);
    System.out.println(answer);
  }

  static class Solution {
    public static String convert(String s, int numRows) {
      List<String[]> list = new ArrayList();
      list.add(new String[numRows]);

      int i = 0;
      int j = 0;
      boolean isToReverse = false;

      for (String str : s.split("")) {
        if (isToReverse) {
          list.add(new String[numRows]);
          list.get(++i)[--j] = str;
          if(numRows == 1 && j == 0) {
            j++;
          }
        } else {
          list.get(i)[j++] = str;
        }

        if (j == numRows) {
          isToReverse = true;
          if(numRows != 1) {
            j--;
          }
          continue;
        }

        if (j == 0 && numRows != 1) {
          isToReverse = false;
          j++;
        }
      }

      String answer = "";
      int idx = 0;
      int len = 0;

      while(idx < numRows) {
        while(len < list.size()) {
          String letter = list.get(len)[idx];
          if(letter != null) {
            answer += letter;
          }
          len++;
        }
        idx++;
        len = 0;
      }

      return answer;
    }
  }
}

