package practices.programmers;

//부족한 금액 계산하기
//https://school.programmers.co.kr/learn/courses/30/lessons/82612
public class ShortAmount {

  public static void main(String[] args) {
    System.out.println(solution(3, 20, 4));
  }

  public static long solution(int price, int money, int count) {
    long balance = calculatePrice(price, count) - money;
    return balance >= 0 ? balance : 0;
  }

  private static long calculatePrice(int price, int count) {
    if(count <= 0) {
      return count;
    }

    long sum = price * count;
    sum += calculatePrice(price, --count);

    return sum;
  }
}