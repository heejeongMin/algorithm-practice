package practices.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {

  public static int lengthOfLongestSubstring(String s) {
      return check(s.toCharArray(), 0, 0);
  }

  public static int check(char[] chars, int pointer, int cnt) {
    if (pointer == chars.length) {
      return cnt;
    }

    int startIdx = pointer;
    int newCnt = 0;
    loop:
    for (int i = pointer; i < chars.length; i++) {
      for(int j = startIdx; j < i; j++) {
        if(chars[i] == chars[j]){
          break loop;
        }
      }
      ++newCnt;
    }

    return check(chars, ++pointer, cnt < newCnt? newCnt : cnt);
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("dd"));
  }
}
