package practices.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int result = solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
    System.out.println(result);
  }

  public static class Solution {

    public int solution(int[] priorities, int location) {
      Queue queue = new LinkedList();

      for (int priority : priorities) {
        queue.add(priority);
      }

      int printedCount = 0;
      while(location >= 0){
        int doc = (int) queue.poll();
        if(queue.stream().anyMatch(i -> (int) i > doc)) {
          queue.add(doc);
          if (location == 0) {
            location = queue.size()-1;
          } else {
            location--;
          }
        } else {
          location--;
          printedCount++;
        }
      }

      return printedCount;
    }
  }
}
