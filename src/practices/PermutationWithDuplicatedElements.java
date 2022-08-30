package practices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://aerocode.net/376
// 순열
// 길이가 n인 배열에서 r개의 요소를 차례대로 뽑아 새로운 배열을 만들었을때, 가능한 모든 배열의 합
public class PermutationWithDuplicatedElements {

  //중복된 요소가 있는 경우 1,1,2,3
  //가장 보편적인 방법은 하나의 임시 결과가 만들어질때마다 그것을 문자열로 변환하고, Set에들어있는지 확인한다.
  public static void main(String[] args) {
    System.out.println("============================ for 중첩으로 풀기 ============================");
    System.out.println();
    forLoopPermutation();

    //2. for 중첩으로 풀기, 중복 제거 boolean 컨트롤
    System.out.println();
    System.out.println("============================ for 중첩으로 풀기, 중복 제거 boolean 컨트롤 ============================");
//    forLoopPermutationWithBoolean();

    //2. for 중첩으로 풀기, 중복 제거 set 컨트롤
    System.out.println();
    System.out.println("============================ for 중첩으로 풀기, 중복 제거 set 컨트롤 ============================");
//    forLoopPermutationWithSet();


    // for 를 이용할 경우 arr가 작은 경우만 가능하다. 많아질수록 적어야하는 코드가 많아지기 때문. 재귀로 해결이 가능하다.
    System.out.println();
    System.out.println("============================ 재귀로 풀기 ============================");
//    recursivePermutation();

  }

  public static void forLoopPermutation() {
    final int[] arr = {1, 1, 2};
    final Set<String> result = new HashSet<>();

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        for (int k = 0; k < arr.length; k++) {
          result.add(String.valueOf(arr[i]) + arr[j] + arr[k]);
        }
      }
    }

    for (String str : result) {
      System.out.println(str);
    }
  }

  public static void forLoopPermutationWithBoolean() {
    final int[] arr = {1, 2, 3, 4};
    final List<int[]> result = new ArrayList<>();
    boolean[] isUsed = {false, false, false, false};

    for (int i = 0; i < arr.length; i++) {
      if(isUsed[i] == true) continue;
      isUsed[i] = true;

      for (int j = 0; j < arr.length; j++) {
        if(isUsed[j] == true) continue;
        isUsed[j] = true;

        for (int k = 0; k < arr.length; k++) {
          if(isUsed[k] == true) continue;
          isUsed[k] = true;

          result.add(new int[]{arr[i], arr[j], arr[k]});
          isUsed[k] = false;
        }
        isUsed[j] = false;
      }
      isUsed[i] = false;
    }

    for (int[] ints : result) {
      for (int anInt : ints) {
        System.out.print(anInt + " ");
      }
      System.out.println();
    }
  }

  public static void forLoopPermutationWithSet() {
    final int[] arr = {1, 2, 3, 4};
    final List<int[]> result = new ArrayList<>();
    Set<Integer> isUsed = new HashSet<>();

    for (int i = 0; i < arr.length; i++) {
      if(isUsed.contains(i)) continue;
      isUsed.add(i);

      for (int j = 0; j < arr.length; j++) {
        if(isUsed.contains(j)) continue;
        isUsed.add(j);

        for (int k = 0; k < arr.length; k++) {
          if(isUsed.contains(k)) continue;
          isUsed.add(k);

          result.add(new int[]{arr[i], arr[j], arr[k]});
          isUsed.remove(k);
        }
        isUsed.remove(j);
      }
      isUsed.remove(i);
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
        getPermutation(arr, 3, new ArrayList<>(), new ArrayList<>(), new HashSet<>());

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
      List<List<Integer>> answer, // 순열이 저장될 배열
      Set<Integer> isUsed
  ) {
    //순열 중 하나가 완성된 경우
    if(tempArr.size() == length) {
      answer.add(new ArrayList<>(tempArr));
      return answer;
    }

    // 사용되지 않은 요소 중 하나 사용
    for (int i = 0; i < arr.length; i++) {
      if(isUsed.contains(i)) continue;

      isUsed.add(i);
      tempArr.add(arr[i]);
      getPermutation(arr, length, tempArr, answer, isUsed);
      tempArr.remove(tempArr.size()-1 );
      isUsed.remove(i);
    }
    return answer;
  }


}
