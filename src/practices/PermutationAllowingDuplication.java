package practices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://aerocode.net/376
// 순열
// 길이가 n인 배열에서 r개의 요소를 차례대로 뽑아 새로운 배열을 만들었을때, 가능한 모든 배열의 합
public class PermutationAllowingDuplication {

  public static void main(String[] args) {
    System.out.println("============================ for 중첩으로 풀기 ============================");
    System.out.println();
//    forLoopPermutation();

    System.out.println();
    System.out.println("============================ 재귀로 풀기 ============================");
    recursivePermutation();

  }

  public static void forLoopPermutation() {
    final int[] arr = {1, 2, 3, 4};
    final List<int[]> result = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        for (int k = 0; k < arr.length; k++) {
//          if (i == j || j == k || k == i) { //중복을 허용하니 난이도가 내려감.
//            continue; // 중복 배제
//          }
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

  public static void recursivePermutation() {
    final int[] arr = {1, 2, 3, 4};
    List<List<Integer>> answer =
        getPermutation(arr, 3, new ArrayList<>(), new ArrayList<>());

    for (List<Integer> integers : answer) {
      for (Integer integer : integers) {
        System.out.print(integer + " ");
      }
      System.out.println();
    }
  }

  public static List<List<Integer>> getPermutation(
      int[] arr, //원본
      int length, // 만들 순열의 길이
      List<Integer> tempArr, //순열 중 하나를 임시로 저장할 배열
      List<List<Integer>> answer // 순열이 저장될 배열
  ) {
    //순열 중 하나가 완성된 경우
    if(tempArr.size() == length) {
      answer.add(new ArrayList<>(tempArr));
      return answer;
    }

    // 사용되지 않은 요소 중 하나 사용
    for (int i = 0; i < arr.length; i++) {

      tempArr.add(arr[i]);
      getPermutation(arr, length, tempArr, answer);
      tempArr.remove(tempArr.size()-1 );
    }
    return answer;
  }


}
