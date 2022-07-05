package practices.line;


public class Line2 {

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.test(new int[]{4});

  }

  public static class Solution {
    public void test(int[] arr){
      String str = test(arr, "");
      System.out.println(str);
     String[] strs = str.split("");
     int[] answer = new int[arr.length];
     for(int i = 0; i < strs.length; i++){
       answer[i] = Integer.parseInt(strs[i]);
     }

      for (int i : answer) {
        System.out.println(i);
      }


    }
    public String test(int[] arr, String answer) {
      if(arr.length == 1){
        return answer += String.valueOf(arr[0]);
      }
        int[] flipped = new int[arr.length];
        int idx = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
          flipped[idx] = arr[i];
          idx++;
        }

        int pos = arr.length % 2 == 0 ? arr.length / 2 : arr.length / 2 + 1;
        int[] firstHalf = new int[pos];
        int[] otherHalf = new int[arr.length - pos];

        for (int i = 0; i < pos; i++) {
          firstHalf[i] = flipped[i];
        }
        int idx2 = 0;
        for (int i = pos; i < flipped.length; i++) {
          otherHalf[idx2] = flipped[i];
          idx2++;
        }

        answer = test(firstHalf, answer);
        answer = test(otherHalf, answer);
        return answer;
      }
    }


  }




