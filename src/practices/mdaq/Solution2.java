package practices.mdaq;

public class Solution2 {

  public static void main(String[] ars) {
    Solution solution = new Solution();
//    System.out.println(solution.solution(new int[]{3,2,3,2,3}));
//    System.out.println(solution.solution(new int[]{7,4,-2,4,-2,9}));
//    System.out.println(solution.solution(new int[]{7,-5,-5,-5,7,-1,7}));
    System.out.println(solution.solution(new int[]{4}));
  }

  static class Solution {
    public int solution(int[] A) {
      if(A.length == 1) {
        return 1;
      }

      int answer = 0;
      int idx = 0;
      while(idx < A.length-1) {
        int tempAnswer = test(idx, A);
        if(tempAnswer > answer) {
          answer = tempAnswer;
        }
        if(answer == A.length) {
          break;
        }
        idx++;
      }

      return answer;
    }

    public int test(int startIndex, int[] A){
      int count = 2;
      int prv = A[startIndex];
      int next = A[startIndex+1];
      int check = 0;
      for (int i = startIndex+2; i < A.length; i++) {
        if(check % 2 == 0){
          if(prv == A[i]) {
            count++;
            check++;
          } else {
            break;
          }
        } else {
          if(next == A[i]) {
            count++;
            check++;
          } else {
            break;
          }
        }
      }
      return count;
    }

  }
}
