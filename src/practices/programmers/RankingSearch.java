package practices.programmers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankingSearch {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] answer = solution.solution(
        new String[]{"java backend junior pizza 150", "python frontend senior chicken 210",
            "python frontend senior chicken 150", "cpp backend senior pizza 260",
            "java backend junior chicken 80", "python backend senior chicken 50"},
        new String[]{"java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150", "- and - and - and chicken 100",
            "- and - and - and - 150"});

    for (int i = 0; i < answer.length; i++) {
      System.out.println(answer[i]);
    }
  }

  public static class Solution {

    public int[] solution(String[] info, String[] query) {
      int[] answer = {};
      //1. info를 언어를 기준으로 맵으로
      Map map = getMap(info);
      //2. query를 2차원배열로
      String[][] queries = getQuery(query);
      //3.
      getResult(map, queries);
      return answer;
    }

    private void getResult(Map map, String[][] queries) {
      for (String[] query : queries) {
        int answer = 0;
        Map refMap = map;
        for (int i = 0; i < 5; i++) {
          if(i == 4) {
            for (Object o : refMap.keySet()) {
              int key = Integer.valueOf(String.valueOf(o));
              int score = Integer.valueOf(query[i]);
              if(key >= score) {
                answer = (Integer) refMap.get(o);
              }
            }
          } else {
            if(!query[i].equals("-")) {
              refMap = (Map) refMap.get(query[i]);
            }
          }
        }
      }
    }

    private String[][] getQuery(String[] query) {
      String[][] queries = new String[query.length][5];
      for (int i = 0; i < query.length; i++) {
        String[] str = query[i].split(" ");
        int idx = 0;
        for (int j = 0; j < str.length; j++) {
          if(str[j].equals("and")){
            continue;
          }
          queries[i][idx] = str[j];
          idx++;
        }
      }
      return queries;
    }

    private Map getMap(String[] info) {
      //lang,      position,    level,     food,      points
      Map<String, Map<String, Object>> map = new HashMap<>();

      for (String s : info) {
        String[] infos = s.split(" ");
        String lang = infos[0];

        if (map.containsKey(lang)) {
          map.put(lang, getMap2(map.get(lang), infos, 1));
        } else {
          map.put(lang, getMap2(new HashMap(), infos, 1));
        }
      }
      return map;
    }

    private Map getMap2(Map<String, Object> map, String[] info, int idx) {
      String criteria = info[idx];
      if (idx == info.length - 1) {
        if (map.containsKey(criteria)) {
          int i = (int) map.get(criteria);
          map.put(criteria, i++);
        } else {
          map.put(criteria, 1);
        }
        return map;
      }

      if (map.containsKey(criteria)) {
        map.put(criteria, getMap2((Map<String, Object>) map.get(criteria), info, idx + 1));
      } else {
        map.put(criteria, getMap2(new HashMap(), info, idx + 1));
      }
      return map;
    }


  }
}



