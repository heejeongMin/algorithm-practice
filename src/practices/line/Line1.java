package practices.line;


public class Line1 {

  public static void main(String[] args) {
    Solution solution = new Solution();
//    int[] answer = solution.test(new int[]{123457, 123458, 623456, 123436, 123456, 223344, 113344},
//        new int[]{123456, 123344, 223455});

    int[] answer = solution.test(new int[]{111122, 111133, 111123, 111132},
        new int[]{111123});

    for (int i : answer) {
      System.out.println(i);
    }

  }

  public static class Solution {

    public int[] test(int[] arr1, int[] arr2) {
      int[] answer = new int[arr2.length];

      for (int i = 0; i < arr2.length; i++) {
        char[] targets = String.valueOf(arr2[i]).toCharArray();

        for (int j = 0; j < arr1.length; j++) {
          int checksum = 0;
          char[] comp = String.valueOf(arr1[j]).toCharArray();
          for (int k = 0; k < targets.length; k++) {
            if (targets[k] != comp[k]) {
              checksum++;
            }
            if (checksum > 1) {
              break;
            }
          }
          if (checksum == 1) {
            answer[i] += 1;
          }
        }
      }
      return answer;
    }
  }
}




