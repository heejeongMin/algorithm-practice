package practices.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import practices.programmers.SecreteMap.Solution;

public class FailRate {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] answer = solution.solution(
        5,
        new int[]{2, 1, 2, 6, 2, 4, 3, 3});

    for (int s : answer) {
      System.out.print(s);
    }
  }

  static class Solution {
    public int[] solution(int N, int[] stages) {
      int[] answer = new int[N];
      Map<Integer, Double> map = new HashMap<>();
      for(int i = 1; i<=N; i++) {
        int played = 0;
        int playing = 0;
        for (int stage : stages) {
          if(stage == i) {
            played++;
            playing++;
          } else if (stage > i) {
            played++;
          }
        }

        double failRate = 0.0;
        if(played != 0) {
          failRate = (double)playing / (double)played;
        }
        map.put(i, failRate);
      }

      List<Integer> keySet = new ArrayList<>(map.keySet());
      keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
      for(int i=0; i<keySet.size(); i++) {
        answer[i] = keySet.get(i);
      }

      return answer;
    }
  }

}
