public class FirstIndexAndLastIndex {
  public static void main(String[] args) {
    int[] arr = new int[] { 1, 5, 10, 15, 22, 33, 33, 33, 33, 33, 33, 33, 33, 40, 42, 55, 66, 77 };
    int n = arr.length;
    int target = 33;
    int leftIdx = binarySearchLeftFunc(0, n - 1, arr, target);
    int rightIdx = binarySearchRightFunc(0, n - 1, arr, target);
    System.out.println(leftIdx + "  " + rightIdx);
  }

  public static int binarySearchLeftFunc(int li, int ri, int[] arr, int target) {
    int ans = -1;
    while (li <= ri) {
      int mid = (ri + li) / 2;
      if (arr[mid] > target) {
        ri = mid - 1;
      } else if (arr[mid] < target) {
        li = mid + 1;
      } else {
        ans = mid;
        ri = mid - 1;
      }
    }
    return ans;
  }

  public static int binarySearchRightFunc(int li, int ri, int[] arr, int target) {
    int ans = -1;
    while (li <= ri) {
      int mid = (ri + li) / 2;
      if (arr[mid] > target) {
        ri = mid - 1;
      } else if (arr[mid] < target) {
        li = mid + 1;
      } else {
        ans = mid;
        li = mid + 1;
      }
    }
    return ans;
  }
}

// 15 1 5 10 15 22 33 33 33 33 33 40 42 55 66 77 33

// 5 9