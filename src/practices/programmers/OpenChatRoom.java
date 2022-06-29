package practices.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChatRoom {

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.solution(
        new String[]{
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"});
  }

  public static class Solution {
    public String[] solution(String[] record) {

      String[] answer = getLogsNickNameReplaced(record, findNickNameChanged(record));

      for (int i = 0; i < answer.length; i++) {
        System.out.println(answer[i]);
      }

      return answer;
    }


    private String[] getLogsNickNameReplaced(
        String[] record,
        Map<String, String> nickNameChangedUserMap
    ) {
      List<String> str = new ArrayList<>();

      for (int i = 0; i < record.length; i++) {
        if (record[i].startsWith("C")) {
          continue;
        }

        String suffix = "님이 들어왔습니다.";
        if(record[i].startsWith("L")) {
          suffix = "님이 나갔습니다.";
        }

        String[] r = record[i].split(" ");
        str.add(nickNameChangedUserMap.get(r[1]) + suffix);
      }

      return str.toArray(String[]::new);
    }


    /*
    userid + ...
    userid _ ..

     */
    private Map<String, String> findNickNameChanged(String[] record) {
      Map<String, String> map = new HashMap<>();

      for (int i = 0; i < record.length; i++) {
        if (record[i].startsWith("L")) {
          continue;
        }
        String[] r = record[i].split(" ");
        map.put(r[1], r[2]);
      }

      return map;
    }


  }
}


