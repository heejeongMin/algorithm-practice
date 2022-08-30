package practices.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//https://school.programmers.co.kr/learn/courses/30/lessons/87946
public class Energy {

  public static void main (String[] args) {

    int[][] dungeons =
        new int[][] {
            {80, 20},
            {50, 40},
            {30, 10}};

    List<List<int[]>> result =
        getPermutation1(
            dungeons,
            dungeons.length,
            new ArrayList<>(),
            new ArrayList<>(),
            new HashSet<>());

    for (List<int[]> ints : result) {
      for (int[] anInt : ints) {
        for (int i : anInt) {
          System.out.print( i + " ");
        }
        System.out.print(", ");
      }
      System.out.println();
    }

    System.out.println(test(80, result));
  }

  public static int test(int k, List<List<int[]>> permutation) {
    int answer = 0;
    for (List<int[]> ints : permutation) {
      int cnt = 0;
      int energy = k;
      for (int[] anInt : ints) {
        if(energy < anInt[0]) {
          break;
        } else {
          ++cnt;
          energy -= anInt[1];
        }
      }
      if (answer < cnt) {
        answer = cnt;
      }
    }
    return answer;
  }

  public static List<List<int[]>> getPermutation1(
      int[][] dungeons,
      int length,
      List<int[]> tempDungeons,
      List<List<int[]>> permutation,
      Set<Integer> hasVisited
  ) {

    if(tempDungeons.size() == length) {
      permutation.add(new ArrayList<>(tempDungeons));
      return permutation;
    }

    for (int i = 0; i < dungeons.length; i++) {
      if(hasVisited.contains(i)) continue;

      hasVisited.add(i);
      tempDungeons.add(dungeons[i]);
      getPermutation1(
          dungeons,
          length,
          tempDungeons,
          permutation,
          hasVisited
      );
      tempDungeons.remove(tempDungeons.size()-1);
      hasVisited.remove(i);
    }
    return permutation;
  }

  public static Set<Integer> getPermutation(
      int energy,
      int[][] dungeons,
      List<int[]> tempDungeons,
      Set<Integer> numberOfDungeonsToPlay,
      Set<Integer> hasVisited
  ) {

    if(tempDungeons.size() == dungeons.length) {
      numberOfDungeonsToPlay.add(tempDungeons.size());
      return numberOfDungeonsToPlay;
    }

    for (int i = 0; i < dungeons.length; i++) {
      if(hasVisited.contains(i)) continue;
      if(energy < dungeons[i][0]) {
        numberOfDungeonsToPlay.add(tempDungeons.size());
        return numberOfDungeonsToPlay;
      }

      hasVisited.add(i);
      tempDungeons.add(dungeons[i]);
      getPermutation(
          energy - dungeons[i][1],
          dungeons,
          tempDungeons,
          numberOfDungeonsToPlay,
          hasVisited
          );
      tempDungeons.remove(tempDungeons.size()-1);
      hasVisited.remove(i);
    }
    return numberOfDungeonsToPlay;
  }
}
