package practices.programmers;

import java.util.Stack;


public class PairElemination {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int result = solution.solution("baabaa");
    System.out.println(result);
  }

  public static class Solution {

    public int solution(String s) {
      Stack<Character> stack = new Stack<>();
      for(int i =0; i <s.length(); i++){
        char c = s.charAt(i);
        if(!stack.isEmpty() && stack.peek() == c) {
          stack.pop();
        } else {
          stack.push(c);
        }
      }
      return (stack.size() == 0)? 1 : 0;
    }

  }
}
