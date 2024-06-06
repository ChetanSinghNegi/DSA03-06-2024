
public class BinarySearch {
  public static void main(String[] args) {
    int[] arr = new int[] { 1, 4, 6, 2, 6, 10 };
    int n = arr.length;
    int target = 44;
    boolean found = binarySearchFunc(0, n - 1, arr, target);
    if (found) {
      System.out.println("FOUND");
    } else {
      System.out.println("NOT FOUND");
    }
  }

  public static boolean binarySearchFunc(int li, int ri, int[] arr, int target) {
    while (li <= ri) {
      int mid = (ri + li) / 2;
      if (arr[mid] > target) {
        ri = mid - 1;
      } else if (arr[mid] < target) {
        li = mid + 1;
      } else {
        return true;
      }
    }
    return false;
  }
}
