package practices.programmers;

public class BiggestAndSmallest {

  public static void main(String[] ars) {
    Solution solution = new Solution();
    System.out.println(solution.solution("1 2 3 4"));
    System.out.println(solution.solution("-1 -2 -3 -4"));
    System.out.println(solution.solution("-1 -1"));

  }

  static class Solution {
    public String solution(String s) {
      int biggest = 0;
      int smallest = 0;

      String[] str = s.split(" ");
      biggest = Integer.parseInt(str[0]);
      smallest = Integer.parseInt(str[0]);

      for (int i = 1; i < str.length; i++) {
        int n = Integer.parseInt(str[i]);

        if(biggest < n) {
          biggest = n;
        }

        if(smallest > n) {
          smallest = n;
        }
      }

      return smallest + " " + biggest;
    }
  }
}
