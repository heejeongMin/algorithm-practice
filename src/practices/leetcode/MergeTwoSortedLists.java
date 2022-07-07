package practices.leetcode;

import java.util.List;
import practices.leetcode.MergeTwoSortedLists.Solution.ListNode;

public class MergeTwoSortedLists {

  public static void main(String[] args) {
    int[] arr = {};
    ListNode node1 = new ListNode();
    ListNode currentNode = node1;
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        makeListNode(arr[i], currentNode);
      } else {
        currentNode.next = makeListNode(arr[i], new ListNode());
        currentNode = currentNode.next;
      }
    }

    int[] arr2 = {0};
    ListNode node2 = new ListNode();
    ListNode currentNode2 = node2;
    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        makeListNode(arr2[i], currentNode2);
      } else {
        currentNode2.next = makeListNode(arr2[i], new ListNode());
        currentNode2 = currentNode2.next;
      }
    }

//    ListNode test1 = node1;
//    while(test1 != null) {
//      System.out.println(test1.val);
//      test1 = test1.next;
//    }
//
//    ListNode test2 = node2;
//    while(test2 != null) {
//      System.out.println(test2.val);
//      test2 = test2.next;
//    }

    ListNode listNode = Solution.mergeTwoLists(node1, node2);
    ListNode test3 = listNode;
    while (test3 != null) {
      System.out.println(test3.val);
      test3 = test3.next;
    }
  }

  public static ListNode makeListNode(int i, ListNode listNode) {
    listNode.val = i;
    return listNode;
  }


  static class Solution {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      if(list1 == null && list2 == null) {
        return null;
      }

      boolean begin = true;
      ListNode listNode = new ListNode();
      ListNode currentMergingNode = listNode;

      while (list1 != null || list2 != null) {
        ListNode node = begin ? currentMergingNode : new ListNode();

        if (list1 == null) {
          node = makeListNode(list2.val, node);
          list2 = list2.next;
        } else if (list2 == null) {
          node = makeListNode(list1.val, node);
          list1 = list1.next;
        } else {
          if (list1.val <= list2.val) {
            node = makeListNode(list1.val, node);
            list1 = list1.next;
          } else {
            node = makeListNode(list2.val, node);
            list2 = list2.next;
          }
        }

        if (begin) {
          currentMergingNode = node;
          begin = false;
        } else {
          currentMergingNode.next = node;
          currentMergingNode = currentMergingNode.next;
        }
      }

      return listNode;
    }

    static public class ListNode {

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
  }
}
