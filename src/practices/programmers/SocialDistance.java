package practices.programmers;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Tuple {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] i = solution.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
    for (int i1 : i) {
      System.out.println(i1);
    }
  }

  public static class Solution {

    public int[] solution(String s) {
      //1. array로 가져오기
      String[] c = replace(s);
      //2. cnt
      Map<String, Integer> map = cnt(c);
      //3. tuple
      return getTuple(map);
    }

    public String[] replace(String s) {
      s = s.replaceAll("\\{", "");
      s = s.replaceAll("\\}", "");
      return s.split(",");
    }

    public Map<String, Integer> cnt(String[] c) {
      Map<String, Integer> map = new HashMap<>();

      for (String c1 : c) {
        if (map.containsKey(c1)) {
          Integer i = map.get(c1);
          map.put(c1, i + 1);
        } else {
          map.put(c1, 1);
        }
      }

      return map;
    }

    public int[] getTuple(Map<String, Integer> map) {
      int[] arr = new int[map.size()];
      for (Entry<String, Integer> entries : map.entrySet()) {
        int pos = map.size() - entries.getValue();
        arr[pos] = Integer.valueOf(entries.getKey());
      }

      return arr;
    }


  }
}


