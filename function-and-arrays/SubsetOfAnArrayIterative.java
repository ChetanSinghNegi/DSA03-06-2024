import java.util.*;

public class SubsetOfAnArrayIterative {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int totalSubset = (int) Math.pow(2, n);
    for (int i = 0; i < totalSubset; i++) {
      String binaryString = convertToReverseBinary(i);
      for (int j = 0; j < binaryString.length(); j++) {
        char ch = binaryString.charAt(j);
        if (ch != '0')
          System.out.print(arr[j] + " ");
      }
      System.out.println();
    }
    scn.close();
  }

  public static String convertToReverseBinary(int i) {
    int mul = 1;
    int binary = 0;
    while (i > 0) {
      int rem = i % 2;
      i = i / 2;
      binary = binary + mul * rem;
      mul *= 10;
    }
    StringBuilder binaryString = new StringBuilder(binary + "");
    return binaryString.reverse().toString();
  }
}
