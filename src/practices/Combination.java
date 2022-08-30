package practices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://aerocode.net/376
// 조합
// 순서가 중요하지 않은 순열 (1,2,3 과 1,3,2는 같다고 봄)
public class Combination {

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
      for (int j = i+1; j < arr.length; j++) { //순열과 다른점은 j 를 i+1로 초기화
        for (int k = j+1; k < arr.length; k++) { //순열과 다른점은 k 를 j+1로 초기화 --> 오름차순으로 강제하였기 때문에 다음 순서로 초기화함
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
        getCombination(arr, 3, new ArrayList<>(), new ArrayList<>(), new HashSet<>(), -1);

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
      Set<Integer> isUsed,
      int lastIndex
  ) {
    //순열 중 하나가 완성된 경우
    if(tempArr.size() == length) {
      answer.add(new ArrayList<>(tempArr));
      return answer;
    }

    // 사용되지 않은 요소 중 하나 사용
    for (int i = lastIndex + 1; i < arr.length; i++) {
      if(isUsed.contains(i)) continue;

      isUsed.add(i);
      tempArr.add(arr[i]);
      getCombination(arr, length, tempArr, answer, isUsed, i);
      tempArr.remove(tempArr.size()-1 );
      isUsed.remove(i);
    }
    return answer;
  }
}
