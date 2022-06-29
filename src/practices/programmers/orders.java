package practices.programmers;


import java.util.ArrayList;
  import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

public class orders {

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.solution(
        new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
        new int[]{2, 3, 5});

    solution.solution(
        new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
        new int[]{2, 3, 4});

    solution.solution(
        new String[]{"XYZ", "XWY", "WXA"},
        new int[]{2, 3, 4});

    solution.solution(
        new String[]{"BA", "BA", "AB"},
        new int[]{2, 5});

    solution.solution(
        new String[]{"CX", "CX"},
        new int[]{2});

    solution.solution(
        new String[]{"AX", "ACD","AX", "BCA"},
        new int[]{2, 3});

    solution.solution(
        new String[]{"ABCFG", "AC","CDE", "ACDE", "BCFG", "ACDEH"},
        new int[]{2, 3, 4});

    solution.solution(
        new String[]{"ABC", "ABC"},
        new int[]{2, 3});

    solution.solution(
        new String[]{"ABCD", "ABCD", "ABCD"},
        new int[]{2, 3, 4});

    solution.solution(
        new String[]{"ABCDE", "AB", "CDAB", "ABDE", "XABYZ", "ABXYZ", "ABCD", "ABCDE", "ABCDE", "ABCDE", "AB", "AB", "AB", "AB", "AB", "AB", "AB", "AB", "AB", "AB"},
        new int[]{2});
  }

  public static class Solution {

    public String[] solution(String[] orders, int[] course) {
      //1. 원하는 코스 개수대로 모든 콤비네이션 가지고 오기
      Set<String> sets = getAllCombo(orders, course);
      //2. 주문에서 몇개나 나왔는지 확인
      Map<String, Integer> map = test(sets, orders, course);
      //3. 몇개나왔는지 확인한것들중 많이 나온 콤보만 확인
      List<String> combos = getFinalCombo(map, course);
      //4. 정렬 및 조합이 같은애들 제외
      Collections.sort(combos);
      //5. 문자열들도 알파벳 순서
      List<String> sorted = sortCombo(combos);

//      noDuplicate(combos);
      System.out.println(sorted);
      System.out.println(map);

      System.out.println("-----");
      return sorted.toArray(String[]::new);
    }

    private List<String> sortCombo(List<String> combos) {
      List<String> noduple = new ArrayList<>();
      for (String combo : combos) {
        char[] c = combo.toCharArray();
        Arrays.sort(c);
        if(!noduple.contains(String.valueOf(c))){
          noduple.add(String.valueOf(c));
        }
      }
      return noduple;
    }

    private List<String> getFinalCombo(Map<String, Integer> map, int[] course){
      List<String> list = new ArrayList<>();

      for (int c : course) {
        int cnt = 2;
        Map<Integer, List<String>> tmp = new HashMap<>();

        for (Entry<String, Integer> entries : map.entrySet()) {
          String key = entries.getKey();
          if(key.length() != c) {
            continue;
          }

          if(cnt <= entries.getValue()) {
            if(cnt < entries.getValue()) {
              tmp.remove(cnt);
            }

            cnt = entries.getValue();
            if(tmp.containsKey(cnt)) {
              List<String> l = tmp.get(cnt);
              l.add(key);
              tmp.put(cnt, l);
            } else {
              List<String> l = new ArrayList<>();
              l.add(key);
              tmp.put(cnt, new ArrayList<>(l));
            }

          }
        }

        for (Entry<Integer, List<String>> e : tmp.entrySet()) {
          list.addAll(e.getValue());
        }
      }
      return list;
    }

    private Map<String, Integer> test(Set<String> sets, String[] orders, int[] course){
      Map<String, Integer> map = new HashMap<>();

      for (int i : course) {
        for (String set : sets) {
          if(i != set.length()) {
            continue;
          }
          int cnt = 0;
          for (String order : orders) {
            cnt += cnt(order, set);
            map.put(set, cnt);
          }
        }
      }
      return map;
    }

    private int cnt (String order, String set) {
      char[] sets = set.toCharArray();
      char[] orders = order.toCharArray();
      int cnt = 0;
      int check = set.length();

      for (char c : sets) {
        for (char order1 : orders) {
          if(c == order1) {
            check -=1;
            break;
          }
        }
        if(check == 0) {
          cnt++;
          break;
        }
      }
      return cnt;
    }

    private Set<String> getAllCombo(String[] orders, int[] course) {
      Set<String> sets = new HashSet<>();

      for (String order : orders) {
        String[] s = order.split("");
        for (int c : course) {
          for (int i = 0; i < s.length; i++) {
            this.getcombo(sets, s, "", i, c);
          }
        }
      }
      return sets;
    }

    public String getcombo(Set<String> sets, String[] s, String result, int pos, int targetLen) {

      if (result.length() == targetLen) {
        sets.add(result);
        return result;
      }

      String letter = result + s[pos];

      for(int i = pos+1; i <s.length; i++) {
        getcombo(sets, s, letter, i, targetLen);
      }

      if (letter.length() == targetLen) {
        sets.add(letter);
        return result;
      }

      return result;
    }
  }
}


