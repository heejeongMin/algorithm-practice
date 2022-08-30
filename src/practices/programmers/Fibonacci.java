package practices.programmers;

public class Fibonacci {
  // 0 1 1 2 3 5

  public static void main(String[] ars) {
    long prv = getFibonacci(1, 4, 0L, 1L);
    long cur = getFibonacci(1, 3, 0L, 1L);

    long prvRemainder = prv % 7;
    long curRemainder = cur % 7;

    System.out.println(prvRemainder + " " +  curRemainder);
    System.out.println((prvRemainder +  curRemainder) % 7);
  }
  // 1 + 1 = 2

  public static long getFibonacci (int time, int n, long prv, long cur) {
    if (time == n) return cur;
    return getFibonacci(++time, n, cur, prv+cur);
  }

}
