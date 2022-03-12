package practices.leetcode;

//https://leetcode.com/problems/add-two-numbers/
public class Add_Two_Numbers {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(
        9,
        new ListNode(9,
            new ListNode(9,
                new ListNode(9,
                    new ListNode(9,
                        new ListNode(9,
                            new ListNode(9)))))));
    ListNode l2 = new ListNode(
        9,
        new ListNode(9,
            new ListNode(9,
                new ListNode(9))));

    Add_Two_Numbers addTwoNumbers = new Add_Two_Numbers();
    ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
    print(result);
  }

  public static void print(ListNode l1) {
    if(l1 == null) {
      return;
    }

    System.out.println(l1.val);
    print(l1.next);
  }

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return  addTwoNumbers(l1, l2, 0);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2, int n) {
    int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + n;
    int num = 0;
    if (sum - 10 >= 0) {
      num = 1;
      sum = sum - 10;
    }

    if(l1 == null && l2 == null) {
      if(sum == 0) {
        return null;
      }
        return new ListNode(sum);
    }

    return new ListNode(sum,
        addTwoNumbers((l1 == null)? null : l1.next, (l2 == null)? null : l2.next, num));
  }
}
