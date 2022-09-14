package practices.codility;

public class ParkingBill {

  public static void main(String[] ars) {
    Solution solution = new Solution();
    System.out.println(solution.solution("10:00", "13:21"));
    System.out.println(solution.solution("09:42", "11:42"));
  }


  static class Solution {
    public int solution(String E, String L) {
      int entranceFee = 2;
      int firstHour = 3;
      int extraCharge = 4;
      int splitIndex = E.indexOf(":");

      int extraChargeHours = Integer.parseInt(L.substring(0, splitIndex)) -
          Integer.parseInt(E.substring(0, splitIndex)) - 1;

      if(extraChargeHours < 0) {
         return entranceFee + firstHour;
      }

      int minutes = (60 - Integer.parseInt(L.substring(splitIndex+1)))
          + Integer.parseInt(E.substring(splitIndex+1));

      if(minutes >= 60) {
        minutes = 60 - minutes;
      }

      int fee = entranceFee + firstHour + extraChargeHours * extraCharge;
      if(minutes > 0) {
        fee += extraCharge;
      }

      return fee;
    }
  }
}
