import java.io.*;
import java.util.*;

public class AddLastInLinkedList {
  public static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }

    Node(int data, Node next) {
      this.next = next;
      this.data = data;
    }
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    void addLast(int val) {
      // O(1)
      Node last = new Node(val);
      if (size == 0) {
        head = tail = last;
        size++;
        return;
      } else {
        tail.next = last;
        tail = last;
        size++;
      }
    }
  }

  public static void testList(LinkedList list) {
    for (Node temp = list.head; temp != null; temp = temp.next) {
      System.out.println(temp.data);
    }
    System.out.println(list.size);

    if (list.size > 0) {
      System.out.println(list.tail.data);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LinkedList list = new LinkedList();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("addLast")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        list.addLast(val);
      }
      str = br.readLine();
    }

    testList(list);
  }
}