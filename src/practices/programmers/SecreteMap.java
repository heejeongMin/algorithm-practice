package practices.programmers;


public class SecreteMap {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] answer = solution.solution(
        5,
        new int[]{9, 20, 28, 18, 11},
        new int[]{30, 1, 21, 17, 28});

    for (String s : answer) {
      System.out.print(s);
    }

  }

  static class Solution {

    private String[] getBinaryString(int num, int n){
      String binaryString = Integer.toBinaryString(num);
      if(binaryString.length() < n) {
        int pad = n - binaryString.length();
        while(pad-- > 0) {
          binaryString = "0" + binaryString;
        }
      }

      return binaryString.split("");
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
      String[] answer = new String[n];
      for(int i = 0; i<n; i++) {
        String[] arr1String = getBinaryString(arr1[i], n);
        String[] arr2String = getBinaryString(arr2[i], n);

        String decoded = "";
        for(int j=0; j<n; j++) {

          if(arr1String[j].equals("0") && arr2String[j].equals("0")) {
            decoded += " ";
          } else {
            decoded += "#";
          }
        }
        answer[i] = decoded;
      }
      return answer;
    }
  }

}
