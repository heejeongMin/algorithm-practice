package practices.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class TruckPassingBridge {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(2, 10, new int[]{7,4,5,6}));
//    System.out.println(solution.solution(100, 100, new int[]{10}));
////    System.out.println(solution.solution(3, 3, new int[]{1,1,1}));
//    System.out.println(
//    solution.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
  }

  public static class Solution {

    private int answer;

    private boolean checkIfBridgeCanHold(Queue queue, int nextWeight, int limitWeight, int bridge_length) {
      int currentWeight = 0;
      for (Object o : queue) {
        currentWeight += (int) o;
      }

      if (currentWeight + nextWeight <= limitWeight) {
        queue.add(nextWeight);
          answer += bridge_length - queue.size();
//          answer += bridge_length;
        return true;
      }
      return false;
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
      answer = 1;
      Queue queueOnBridge = new LinkedList();

      for (int i = 0; i < truck_weights.length; i++) {
        if (queueOnBridge.size() >= bridge_length) {
          queueOnBridge.poll();
          answer++;
        }

        if (checkIfBridgeCanHold(queueOnBridge, truck_weights[i], weight, bridge_length)) {
          if (queueOnBridge.size() >= bridge_length) {
            queueOnBridge.poll();
//            answer++;
          }
        } else {
          queueOnBridge.poll();
          answer++;
          while(!checkIfBridgeCanHold(queueOnBridge, truck_weights[i], weight, bridge_length)) {
            queueOnBridge.poll();
            answer++;
//            answer += bridge_length - queueOnBridge.size();
          }

        }

        if (i == truck_weights.length - 1) {
          queueOnBridge.poll();
          answer++;
        }


      }
      return answer;
    }
  }
}
