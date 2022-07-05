package practices.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Palindrome {

  public static void main(String[] args) {
    Solution solution = new Solution();
    boolean result = solution.isPalindrome(-1);
    // -1 false
    // 0 true

    System.out.println(result);
  }


  static class Solution {
    public boolean isPalindrome(int x) {
      if(x < 10) {
        return x >= 0;
      }

      boolean isPalindrome = true;
      boolean isNegative = x < 0;

      if(isNegative) {
        x *= -1;
      }

      Deque<Integer> deque = new LinkedList<>();
      while(x > 0) {
        deque.add(x%10);
        x /= 10;
      }

      boolean isFirst = true;
      while(!deque.isEmpty()) {
        int a = deque.pollFirst();

        if(deque.isEmpty()) {
          break;
        }

        int b = deque.pollLast();

        if(isFirst && isNegative){
          a *= -1;
          isFirst = false;
        }

        if(a-b != 0){
          isPalindrome = false;
          break;
        }
      }

      return isPalindrome;
    }
  }

}
