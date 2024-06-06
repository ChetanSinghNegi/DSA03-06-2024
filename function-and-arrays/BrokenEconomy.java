import java.io.*;
import java.util.*;

public class BrokenEconomy {
  public static void main(String[] args) throws Exception {
    // write your code here
    int[] arr = new int[] { 5, 10, 15, 22, 33, 40, 42, 55 };
    int n = arr.length;
    int target = 43;
    HashMap<String, Integer> res = binarySearchFunc(0, n - 1, arr, target);
    int li = res.get("li");
    int ri = res.get("ri");
    if (res.get("found") == 1) {
      System.out.println("FOUND => " + arr[li]);
    } else {
      System.out.println("NOT FOUND : ");
      if (li < n)
        System.out.print(arr[li] + "  ");
      if (ri > 0)
        System.out.print(arr[ri] + "  ");
    }
  }

  public static HashMap<String, Integer> binarySearchFunc(int li, int ri, int[] arr, int target) {
    HashMap<String, Integer> hm = new HashMap<>();
    while (li <= ri) {
      int mid = (ri + li) / 2;
      if (arr[mid] > target) {
        ri = mid - 1;
      } else if (arr[mid] < target) {
        li = mid + 1;
      } else {
        hm.put("li", mid);
        hm.put("ri", mid);
        hm.put("found", 1);
        return hm;
      }
    }
    hm.put("li", li);
    hm.put("ri", ri);
    hm.put("found", -1);
    return hm;
  }
}
