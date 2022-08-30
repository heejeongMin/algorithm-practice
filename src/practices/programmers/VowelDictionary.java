package practices.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//https://school.programmers.co.kr/learn/courses/30/lessons/84512
public class VowelDictionary {

  public static void main (String[] args) {

    System.out.println(solution("I"));

  }

  public static int solution(String word) {
    int answer = -1;
    String[] words = "AEIOU".split("");
    Set<String> permutation = getPermutation(words, new ArrayList<>(), new TreeSet<>());
    for (String s : permutation) {
      answer++;
      if(s.equals(word)){
        break;
      }
    }

    return answer;
  }

  public static Set<String> getPermutation(
      String[] words,
      List<String> temp,
      Set<String> permutation
  ) {

    if(temp.size() <= words.length) {
      String word = "";
      for (String s : temp) {
        word+=s;
      }
        permutation.add(word);
    }

    if(temp.size() == words.length) {
      return permutation;
    }

    for (int i = 0; i < words.length; i++) {
      temp.add(words[i]);
      getPermutation(words, temp, permutation);
      temp.remove(temp.size()-1 );
    }

    return permutation;
  }
}
