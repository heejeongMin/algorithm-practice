package practices.leetcode;

//Todo 다시풀기
public class SymmetricTree {

  public static void main(String[] args) {
    int[] arr = {1, 2, 2, 3, 4, 4, 3};
    TreeNode treeNode = new TreeNode();
    treeNode.val = 1;
    treeNode.left = new TreeNode(2);
    treeNode.right = new TreeNode(2);

    treeNode.left.left = new TreeNode(3);
    treeNode.left.right = new TreeNode(4);

    treeNode.right.left = new TreeNode(4);
    treeNode.right.right = new TreeNode(3);

    boolean result = Solution.isSymmetric(treeNode);

    System.out.println("" + result);

  }

  static class Solution {

    static public boolean isSymmetric(TreeNode root) {
      return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode a, TreeNode b) {
      if(a == null && b == null) {
        return true;
      }

      if(a == null || b ==null) {
        return false;
      }

      return a.val==b.val
          && isMirror(a.left, b.right)
          && isMirror(a.right, b.left);
    }
  }


  static public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

}
