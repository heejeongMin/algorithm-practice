package practices.codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxCounters {

  public static void main(String[] ars) {
    Solution solution = new Solution();
    int[] answer = solution.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
    for (int i : answer) {
      System.out.println(i);
    }

//    int[] answer2 = solution.solution(2, new int[]{1, 2});
//    for (int i : answer2) {
//      System.out.println(i);
//    }
  }

  static class Solution {

    public int[] solution(int N, int[] A) {
      int[] arr = new int[N];

      int maxNum = 0;
      int nextMax = 0;
      for (int i = 0; i < A.length; i++) {
        if(A[i] == N+1) {
          maxNum = nextMax;
        } else {
          int idx = A[i] -1;

          if(arr[idx] < maxNum) {
            arr[idx] = maxNum + 1;
          } else {
            arr[idx]++;
          }

          if(arr[idx] > nextMax) {
            nextMax = arr[idx];
          }
        }
      }

      for (int i = 0; i < arr.length; i++) {
        if(arr[i] < maxNum) {
          arr[i] = maxNum;
        }
      }

      return arr;
    }
  }
}

/*
int[] arr = new int[N];

      int maxNum = 0;
      for (int i = 0; i < A.length; i++) {
        if(A[i] == N+1) {
          for(int j = 0; j < N; j++) {
            arr[j] = maxNum;
          }
        } else {
          int temp = arr[A[i] - 1] + 1;
          arr[A[i] - 1] = temp;
          if(temp > maxNum) {
            maxNum = temp;
          }
        }
      }

      return arr;
 */