package practices.programmers;


//내가 풀이한 방법
//1. partition 별로 그룹을 만들어 나누고 압축률 확인하여 제일작은 것 반환
public class CompressWords {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution("abcabcdede"));
  }

  public static class Solution {

    public int solution(String s) {
      int compressTolerance = s.length() / 2;
      int answer = 1;
      for (int i = 1; i <= compressTolerance; i++) {
        String[] chars = partition(s, i);
        int compressLevel = compress(chars);
        if(answer == 1){
          answer = compressLevel;
        } else if (answer > compressLevel) {
          answer = compressLevel;
        }
      }

      return answer;
    }

    public int compress(String[] chars) {
      int cnt = 1;
      String answerStr = "";

      //comp = a, a = 2
      for (int i = 0; i < chars.length; i++) {
        if (i == chars.length - 1) {
          if(cnt == 1) {
            answerStr += chars[i];
          } else {
            answerStr += cnt + chars[i];
          }
          break;
        }
        if (chars[i].equals(chars[i + 1])) {
          cnt++;
        } else {
          if(cnt == 1) {
            answerStr += chars[i];
          } else {
            answerStr += cnt + chars[i];
          }

          cnt = 1;
        }
      }

      return answerStr.trim().length();
    }

    private String[] partition(String s, int partition) {
      String[] str = s.split("");

      String[] returnChar = s.length() % partition == 0
          ? new String[s.length() / partition]
          : new String[s.length() / partition + 1];
      String group = "";
      int n = 0;
      int idx = 0;
      for (int i = 0; i < str.length; i++) {

        group += str[i];
        n++;

        if (n == partition) {
          returnChar[idx] = group;
          idx++;
          n = 0;
          group = "";
        }

        if(i == str.length-1 && group != "") {
          returnChar[idx] = group;
        }
      }
      return returnChar;
    }
  }
}


