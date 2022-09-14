package practices.mdaq;

public class Solution3 {

  public static void main(String[] ars) {
    Solution solution = new Solution();
//    System.out.println(solution.solution("BAAABAB"));
//    System.out.println(solution.solution("BBABAA"));
//    System.out.println(solution.solution("AABBBB"));
//    System.out.println(solution.solution("BBBBABB"));
//    System.out.println(solution.solution("BBBBBA"));

    System.out.println(solution.solution("BBAABAA"));
    System.out.println(solution.solution("BBB"));

  }

  static class Solution {
    public int solution(String S) {
      char[] arr = S.toCharArray();
      int cnt = 0;
      int bCnt = 0;
      int aCnt = 0;
      for (int i = 0; i < arr.length-1; i++) {
        if(arr[i] == 'B') {
          bCnt++;
        } else {
          aCnt++;
        }

        if(arr[i] == 'B' && arr[i+1] == 'A') {
          cnt++;
          if(bCnt > cnt) {
            cnt = bCnt;
          }
          bCnt = 0;
        }

        if(i+1 == S.length()-1 && arr[i+1] == 'A') {
          if(bCnt != 0) {
            cnt++;
          }
          aCnt++;
        }
      }

      return (cnt > aCnt)?  aCnt : cnt;
    }

  }
}
