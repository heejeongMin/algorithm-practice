package practices.leetcode;

// https://leetcode.com/problems/two-sum/
public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    for(int i = 1; i<nums.length; i++) {
      for(int j = i; j < nums.length; j++) {
        if(nums[j]+nums[j-i] == target) return new int[]{j, j-i};
      }
    }
    return null;
  }

  public static void main(String[] args) {
    TwoSum twoSum = new TwoSum();
    int[] result = twoSum.twoSum(new int[]{3,2, 3}, 6);

    for (int i : result) {
      System.out.println(i);
    }
  }
}
