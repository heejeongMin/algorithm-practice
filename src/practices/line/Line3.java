package practices.line;


public class Line3 {
  public static void main(String[] args) {
    Solution solution = new Solution();
    boolean[] answer = solution.test(new String[][]
        {
            {".....", ".XXX.", ".X.X.", ".XXX.", "....."},
            {"XXXXX", "XXXXX", "XXX.X", "XXX.X", "XXXXX"},
            {"XXXXX", "X...X", "X.X.X", "X...X", "XXXXX"},
            {"....X", ".....", "XXX..", "X.X..", "XXX.."},
            {".......", "XXX.XXX", "X.X.X.X", "XXX.XXX", "......."},
            {"XXXXX", "XX.XX", "X...X", "XX.XX", "XXXXX"}
        });

    for (boolean i : answer) {
      System.out.println(i);
    }
  }

  public static class Solution {
    public boolean[] test(String[][] grids) {
      for(int i = 0; i < grids.length; i ++) {
        String[] value = grids[i];
        int n = value.length;
        int m = value[0].length();
        String[][] board = new String[n][m];
        for(int j = 0; j < n; j++){
          String[] marks = value[j].split("");
          for(int k = 0; k<marks.length; k++){
            board[j][k] = marks[k];
          }
        }

        System.out.println(value);
      }
      return null;
    }
  }
}




