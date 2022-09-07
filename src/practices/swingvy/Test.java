package practices.swingvy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Test {

  public static void main(String[] args) {
    System.out.println(solve(getTestCase1()));

    List<String> list = new ArrayList<>();
    list.add("5 4 3");
    list.add("5 3 3");

    list.sort(Comparator.naturalOrder());
    System.out.println(list);
  }

  public static Integer[][] getTestCase1() {
    return new Integer[][] {
        {8},
        {4, 5},
        {2, 1, 2},
        {2, 3, 2, 1},
        {1, 5, 3, 4, 6}
    };
  }


  public static String solve(Integer[][] input) {
    List<Integer> sumList = new ArrayList<>();
    recursive(input, 0, 0, sumList, new Stack<>());


    Integer biggestNum = null;
    for (Integer num : sumList) {
      if(biggestNum == null) {
        biggestNum = num;
      } else {
        biggestNum = biggestNum.compareTo(num) == -1 ? num : biggestNum;
      }
    }

    return String.valueOf(biggestNum);
  }


  public static void recursive(
      Integer[][] input,
      int level,
      int startIndex,
      List<Integer> sumList,
      Stack<Integer> tempNums
  ) {
    for (int i = level; i < input.length; i++) {
      int range = startIndex + 2;
      for (int j = startIndex; j < range; j++) {
        if((level == 0 && j > 0) || (level > 0 && tempNums.isEmpty())) {
          return;
        }
        tempNums.add(input[i][j]);
        recursive(input, level+1, j, sumList, tempNums);
        if(tempNums.size() != input.length) {
          continue;
        }
        int sum = 0;
        for (Integer tempNum : tempNums) {
          System.out.print(tempNum + " ");
          sum+=tempNum;
        }
        System.out.println();
        startIndex++;
        sumList.add(sum);
        tempNums.pop();
      }
      tempNums.pop();
      if(tempNums.size() == 1 && level > 1) {
        return;
      }
      break;

    }
  }


}
