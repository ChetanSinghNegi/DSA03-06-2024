package tree;

import java.io.*;
import java.util.*;

public class IterativePrePostAndInorderTraversalsOfBinaryTree {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static void iterativePrePostInTraversal(Node node) {
    // state == 1 means node haven't traversed
    // state == 2 means node left traversed
    // state == 3 means node right tree left
    // state == 4 means node been traversed
    Stack<Pair> stack = new Stack<>();
    if (node == null)
      return;
    stack.push(new Pair(node, 1));
    StringBuilder preStr = new StringBuilder("");
    StringBuilder inStr = new StringBuilder("");
    StringBuilder postStr = new StringBuilder("");
    while (stack.size() > 0) {
      Pair topNode = stack.peek();
      if (topNode.state == 1) {
        preStr.append(topNode.node.data + " ");
        if (topNode.node.left != null)
          stack.push(new Pair(topNode.node.left, 1));
      } else if (topNode.state == 2) {
        inStr.append(topNode.node.data + " ");
      } else if (topNode.state == 3) {
        if (topNode.node.right != null)
          stack.push(new Pair(topNode.node.right, 1));
      } else {
        postStr.append(topNode.node.data + " ");
        stack.pop();
      }
      topNode.state++;
    }
    System.out.println(preStr.toString());
    System.out.println(inStr.toString());
    System.out.println(postStr.toString());
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    iterativePrePostInTraversal(root);
  }

}