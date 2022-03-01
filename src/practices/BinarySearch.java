package practices;

/**
 * In sorted array find the position of the number I want. Spliting the array in half and the number
 * in half is smaller than the number I want, go to right half. If its bigger move to the left.
 * Repeat until find. geeksforgeeks.org/binary-search/
 */
public class BinarySearch {

  int searchResult(int[] arr, int numToFind) {
    int range = arr.length - 1;
    int startPos = 0;

    while (startPos <= range) {
      int halfPos = startPos + (range - 1) / 2; //5
      if (arr[halfPos] == numToFind) {
        return halfPos;
      }

      if (arr[halfPos] < numToFind) {
        startPos = ++halfPos;
      } else {
        range = --halfPos;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    BinarySearch search = new BinarySearch();
    int[] ars = {1, 3, 7, 8, 10, 25};
    int numToFind = 10;
    int resultPos = search.searchResult(ars, numToFind);

    if (resultPos == -1) {
      System.out.println("Element not present");
    } else {
      System.out.println("Element found at index " + resultPos);
    }
  }
}
