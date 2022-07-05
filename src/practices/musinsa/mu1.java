package practices.musinsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mu1 {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] answer = solution.solution(new int[][]{
        {1, 1, 0, 1, 1},
        {0, 1, 1, 0, 0},
        {0, 0, 0, 0, 0},
        {1, 1, 0, 1, 1},
        {1, 0, 1, 1, 1},
        {1, 0, 1, 1, 1}
    });

    for (int s : answer) {
      System.out.println(s);
    }
  }

  //검은색 0
  //흰색 1
  static class Solution {

    public int[] solution(int[][] v)
    {
      int[] answer = new int[2];

      int total = 0;
      int space = 0;
      for(int i = 0; i<v.length; i++) {

        List<Integer> nums = new ArrayList<>();
        test(v[i], v, i, 0, true, nums);
        if(nums.size() > 0) {
          total += nums.size();

          for (Integer num : nums) {
            if(space < num) {
              space = num;
            }
          }
        }
      }

      answer[0] = total;
      answer[1] = space;

      return answer;
    }

    private int test(int[] arr, int[][] v, int idx, int pos, boolean toContinue, List<Integer> list){
      int count = 0;
      for(int i = pos; i < arr.length; i++) {
        int num = arr[i];

        if(num == 0) {
          if(toContinue) {
            if(count != 0) {
              list.add(count);
              count = 0;
            }
            continue;
          } else {
            break;
          }
        } else {
          //1이긴 한데 앞에서 이미 체크했는지 위에 1 이거나 위가 0이지만 왼쪽이 1 이면 continue
          if(toContinue && idx != 0 && i != 0){
            if(v[idx-1][i] == 1) {
              continue;
            } else if (i-1 >= 0 && v[idx-1][i-1] == 1){
              continue;
            }
          }
        }

        if(idx+1 >= v.length) {
          if(num == 1){
            count++;
          }
          break;
        }

        count += test(v[idx+1], v, idx+1, i, false, list);
        count++;
      }

      if(toContinue && count != 0) {
        list.add(count);
      }

      return count;
    }

  }
}
