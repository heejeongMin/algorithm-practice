package practices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://aerocode.net/376
// 조합
// 순서가 중요하지 않은 순열 (1,2,3 과 1,3,2는 같다고 봄)
public class CombinationAllowingDuplication {

  public static void main(String[] args) {
    System.out.println("============================ for 중첩으로 풀기 ============================");
    System.out.println();
//    forLoopCombination();

    System.out.println();
    System.out.println("============================ 재귀로 풀기 ============================");
    recursiveCombination();
  }

  public static void forLoopCombination() {
    final int[] arr = {1, 2, 3, 4};
    final List<int[]> result = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) { // 조합인 건 여전하기 때문에 오름차순 제약이 없어 지진 않았고, 마지막으로 선택된것을 다시 사용할 수 있다고 생각하면 좋다.
        for (int k = j; k < arr.length; k++) {
          result.add(new int[]{arr[i], arr[j], arr[k]});
        }
      }
    }

    for (int[] ints : result) {
      for (int anInt : ints) {
        System.out.print(anInt + " ");
      }
      System.out.println();
    }
  }

  public static void recursiveCombination() {
    final int[] arr = {1, 2, 3, 4};
    List<List<Integer>> answer =
        getCombination(arr, 3, new ArrayList<>(), new ArrayList<>(), 0);

    for (List<Integer> integers : answer) {
      for (Integer integer : integers) {
        System.out.print(integer + " ");
      }
      System.out.println();
    }
  }

  public static List<List<Integer>> getCombination(
      int[] arr, //원본
      int length, // 만들 조합 길이
      List<Integer> tempArr, //조합 중 하나를 임시로 저장할 배열
      List<List<Integer>> answer, // 조합이 저장될 배열
      int lastIndex
  ) {
    //순열 중 하나가 완성된 경우
    if(tempArr.size() == length) {
      answer.add(new ArrayList<>(tempArr));
      return answer;
    }

    // 사용되지 않은 요소 중 하나 사용
    for (int i = lastIndex + 0; i < arr.length; i++) {
      tempArr.add(arr[i]);
      getCombination(arr, length, tempArr, answer, i);
      tempArr.remove(tempArr.size()-1 );
    }
    return answer;
  }
}
