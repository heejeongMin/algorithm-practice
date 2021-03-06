package practices.programmers;


public class TargetNumber {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(new int[]{1, 1, 1, 1, 1}, 3));
  }


  public static class Solution {


    public int solution(int[] numbers, int target) {
      return dfs(numbers, target, 0, 0, 0);
    }


    public int dfs(int[] numbers, int target, int pos, int result, int count) {
      //기저베이스
      if(pos >= numbers.length) {
        if(result == target) {
          return ++count;
        }
        return count;
      }

      int add = result + numbers[pos];
      int sub = result - numbers[pos];

      count = dfs(numbers, target, pos+1, add, count);
      count = dfs(numbers, target, pos+1, sub, count);

      return count;
    }
  }
}



