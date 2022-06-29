package practices.programmers;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SocialDistance {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] i = solution.solution(
        new String[][]{
            {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        });

    for (int i1 : i) {
      System.out.println(i1);
    }
  }

  public static class Solution {

    public int[] solution(String[][] places) {
      int[] answer = test(places);
      return answer;
    }

    public int[] test(String[][] places) {
      int[] arr = new int[5];
      // X 는 괜찮음
      // O 이면 옆에 사람이 없어야함
      for (int i = 0; i < places.length; i++) {
        String[][] newArr = make2DimensionalArray(places[i]);
        boolean test = newARRCheck(newArr);
        arr[i] = test ? 1 : 0;
      }
      return arr;
    }

    public String[][] make2DimensionalArray(String[] arr) {
      String[][] newArr = new String[5][5];
      for (int i = 0; i < 5; i++) {
        String[] a = arr[i].split("");
        newArr[i] = a;
      }
      return newArr;
    }

    public boolean newARRCheck(String[][] newArr) {
      boolean test = true;
      check:
      for (int i = 0; i < newArr.length; i++) {
        for (int j = 0; j < newArr[i].length; j++) {
          String target = newArr[i][j];
          if (!target.equals("P")) {
            continue;
          }
          test = check(newArr, i, j);
          if (!test) {
            break check;
          }
        }
      }
      return test;
    }

    public boolean check(String[][] places, int i, int j) {
      int[][] pos = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
      boolean check = true;
      for (int k = 0; k < pos.length; k++) {
        int newI = i + pos[k][0];
        int newJ = j + pos[k][1];

        if (newI < 0 || newI > 4 || newJ < 0 || newJ > 4) {
          continue;
        }

        String target = places[newI][newJ];

        if (target.equals("P")) {
          if (k == pos.length - 1) {
            continue;
          }
          int kk = i + pos[k + 1][0];
          int ll = j + pos[k + 1][1];

          if (kk < 0 || kk > 4 || ll < 0 || ll > 4) {
            continue;
          }

          String another = places[kk][ll];
          if (!another.equals("X")) {
            check = false;
            break;
          }
        } else if (target.equals("O")){
          if (k == pos.length - 1) {
            continue;
          }
          int kk = i + pos[k + 1][0];
          int ll = j + pos[k + 1][1];

          if (kk < 0 || kk > 4 || ll < 0 || ll > 4) {
            continue;
          }

          String another = places[kk][ll];
          if (another.equals("P")) {
            check = false;
            break;
          }
        }
      }
      return check;
    }
  }
}


