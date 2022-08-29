import java.util.Arrays;

public class Main {

  private int partition(int[] array, int start, int pivot) {
    int cnt = start;
    for (int i = start; i < pivot; i++)
      if (array[i] < array[pivot]) {
        int tmp = array[cnt];
        array[cnt] = array[i];
        array[i] = tmp;
        cnt++;
      }
    int tmp = array[pivot];
    array[pivot] = array[cnt];
    array[cnt] = tmp;

    return cnt;
  }

  int[] sort(int[] array, int start, int end) {

    if (end <= start)
      return null;

    int pivot = partition(array, start, end);
    sort(array, start, pivot - 1);
    sort(array, pivot + 1, end);
    return array;
  }

  private void tests() {
    int[] arrTest = new int[]{1,2,3,4,5,6,7};
    System.out.print("Test for already sorted array: " + Arrays.toString(arrTest));
    int[] arrSortedTest = sort(arrTest, 0, arrTest.length - 1);
    System.out.println(" is " + (arrSortedTest == arrTest));

    arrTest = new int[]{4,4,4,4,4,4};
    System.out.print("Test for array with all same elements: " + Arrays.toString(arrTest));
    arrSortedTest = sort(arrTest, 0, arrTest.length - 1);
    System.out.println(" is " + (arrSortedTest == arrTest));

    arrTest = new int[]{-1,-2,-3,-4,-5};
    System.out.print("Test for array with negative numbers: " + Arrays.toString(arrTest));
    arrSortedTest = sort(arrTest, 0, arrTest.length - 1);
    System.out.println(" is " + Arrays.toString(arrSortedTest));

    arrTest = new int[]{3,4,4,4,1,2};
    System.out.print("Test for array with duplicates: " + Arrays.toString(arrTest));
    arrSortedTest = sort(arrTest, 0, arrTest.length - 1);
    System.out.println(" is " + Arrays.toString(arrSortedTest));
  }

  public static void main(String[] args) {

    Main m = new Main();

    int[] arr = new int[]{5,6,3,2,5,1,4,9};
    System.out.println("Given array: " + Arrays.toString(arr));
    arr = m.sort(arr, 0, arr.length - 1);
    System.out.println("Sorted array: " + Arrays.toString(arr));

    m.tests();
  }
}
