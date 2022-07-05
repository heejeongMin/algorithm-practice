package practices.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidParentheses {

  public static void main(String[] args) {
    Solution solution = new Solution();
    boolean result = solution.isValid("(])");
    System.out.println(result);
  }

  static class Solution {

    public boolean isValid(String s) {
      boolean isValid = false;

      Stack<String> stack = new Stack();
      for (String target : s.split("")) {
        if (isOpenParentheses(target)) {
          stack.add(target);
          continue;
        }

        if (stack.isEmpty()) {
          isValid = false;
          break;
        }

        if (isPair(stack.peek(), target)) {
          isValid = true;
          stack.pop();
        } else {
          isValid = false;
          break;
        }
      }

      if (!stack.isEmpty()) {
        isValid = false;
      }

      return isValid;
    }

    private boolean isOpenParentheses(String s) {
      return "(,{,[".indexOf(s) >= 0;
    }

    private boolean isPair(String opened, String closed) {
      switch (closed) {
        case ")":
          return opened.equals("(");
        case "}":
          return opened.equals("{");
        case "]":
          return opened.equals("[");
      }
      return false;
    }
  }
}
