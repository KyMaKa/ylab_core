import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class Main {


  // For random number generator.
  int seed = 1312321;

  /**
   * Used for generating random number.
   * Generates same sequence for same seed.*
   * @return int number.
   */
  int rand() {
    seed ^= seed << 13;

    seed ^= seed >> 17;

    seed ^= seed << 5;

    return seed / 100000;
  }

  public static void main(String[] args) {
    Main m = new Main();
    int[][] arr = new int[6][6];
    // Populating 2d array with random numbers.
    for (int row = 0; row < arr.length; row++)
      for (int col = 0; col < arr[row].length; col++)
        arr[row][col] = m.rand();

    int min = 10000000;
    int max = 0;
    int sum = 0;
    // Calculating sum of all elements and finding minimum and maximum.
    for (int[] row : arr)
      for (int el : row) {
        if (el < min)
          min = el;
        if (el > max)
          max = el;
        sum += el;
      }

    System.out.println("Minimum: " + min);
    System.out.println("Maximum: " + max);
    // Calculates and prints average.
    System.out.println("Average: " + sum / (arr.length * arr.length));
  }
}
