package practices;

public class BinaryInsertionSort {

  static int binarySearch(int a[], int subject, int startIdx, int range) {
    while(startIdx <= range){
      int mid = startIdx + (range - startIdx) / 2;
      if(a[mid] == subject) {
        return mid;
      } else if (a[mid] <= subject) {
        startIdx = mid + 1;
      } else if (a[mid] > subject) {
        range = mid -1;
      }
    }
    return startIdx;
  }

  // Function to sort an array a[] of size 'n'
  static void insertionSort(int a[], int n) {
    int i, startIdx, subject, pos;

    for ( i= 1; i < n; i++){
      startIdx = i-1;
      subject = a[i];

      pos = binarySearch(a, subject, 0, startIdx);
      while (startIdx >= pos) {
        a[startIdx +1] = a[startIdx];
        startIdx--;
      }
      a[startIdx + 1] = subject;
    }

  }

  //23 37 0
  // Driver Code
  public static void main(String[] args) {
    int a[]
        = {37, 23, 0, 17, 12, 72, 31, 46, 100, 88, 54};
    int n = a.length, i;

    insertionSort(a, n);

    System.out.println("Sorted array:");
    for (i = 0; i < n; i++) {
      System.out.print(a[i] + " ");
    }

  }

}
