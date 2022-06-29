package practices.programmers;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class DevelopFunction {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] answer = solution.solution(
        new int[]{93, 30, 55},
        new int[]{1, 30, 5});
    // 5 10


    for(int i = 0; i < answer.length; i++) {
      System.out.println(answer[i]);
    }
  }

  public static class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
      Queue<Integer> stack = getRemainingDays(progresses, speeds);

      List<Integer> answer = new ArrayList<>();
      while(!stack.isEmpty()) {
        answer.add(getDeploymentsPerDay(stack));
      }

      return answer.stream().mapToInt(i->i).toArray();
    }

    public Queue<Integer> getRemainingDays(int[] progresses, int[] speeds) {
      Queue<Integer> queue = new LinkedList<>();
      for (int i = 0; i < progresses.length; i++) {
        int remaining = 100 - progresses[i];
        int days = remaining/speeds[i];
        if(remaining % speeds[i] != 0) {
          days+=1;
        }
        queue.add(days);
      }
      return queue;
    }

    // 5 10 1 1 20 1
    //  -> 1
    // 7 3 9 -> 2 1
    public int getDeploymentsPerDay(Queue<Integer> stack) {
      int days = stack.poll();
      int deploymentCnt = 0;

      while (!stack.isEmpty()) {
        if (days < stack.peek()) {
          deploymentCnt+=1;
          break;
        } else {
          stack.poll();
          deploymentCnt+=1;
        }
      }

      if(stack.isEmpty()) {
        return deploymentCnt+1;
      }

      return deploymentCnt;
    }


  }
}



