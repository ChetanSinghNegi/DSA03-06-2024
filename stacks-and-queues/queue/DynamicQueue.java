package queue;

import java.io.*;

public class DynamicQueue {

  public static class CustomQueue {
    int[] data;
    int frontIdx;
    int size;
    int backIdx;

    public CustomQueue(int cap) {
      data = new int[cap];
      frontIdx = 0;
      backIdx = 0;
      size = 0;
    }

    int size() {
      return size;
    }

    void display() {
      int cap = data.length;
      System.out.print("Res => ");
      for (int i = 0; i < size; i++) {
        int idx = (frontIdx + i) % cap;
        System.out.print(data[idx] + " ");
      }
      System.out.println();
    }

    void add(int val) {

      int cap = data.length;
      if (size == cap) {
        int[] newData = new int[cap * 2];
        for (int i = 0; i < cap; i++) {
          int currIdx = (backIdx + i) % cap;
          newData[i] = data[currIdx];
        }
        data = newData;
        backIdx = size;
        frontIdx = 0;
      }
      backIdx = backIdx % data.length;
      data[backIdx++] = val;
      size++;
    }

    int remove() {

      if (size == 0) {
        System.out.println("Queue underflow");
        return -1;
      }
      frontIdx = frontIdx % data.length;
      int removedData = data[frontIdx];
      data[frontIdx++] = 0;
      size--;
      return removedData;
    }

    int peek() {
      if (size == 0) {
        System.out.println("Queue underflow");
        return -1;
      }
      frontIdx = frontIdx % data.length;
      return data[frontIdx];
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomQueue qu = new CustomQueue(n);

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      } else if (str.startsWith("display")) {
        qu.display();
      }
      str = br.readLine();
    }
  }
}