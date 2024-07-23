package tree;

import java.util.Stack;

public class BinaryTree {
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

  public static void display(Node node) {
    if (node == null)
      return;
    StringBuilder st = new StringBuilder("");
    if (node.left != null) {
      st.append(node.left.data + " => ");
    } else {
      st.append("* => ");
    }
    st.append(node.data);
    if (node.right != null) {
      st.append(" <= " + node.right.data);
    } else {
      st.append(" <= *");
    }
    System.out.println(st.toString());
    display(node.left);
    display(node.right);
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }

    @Override
    public String toString() {
      // TODO Auto-generated method stub
      return this.node.data + " => " + this.state;
    }
  }

  public static void main(String[] args) {
    Integer[] arr = new Integer[] { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87,
        null, null };
    Stack<Pair> st = new Stack<>();
    Node rtNode = new Node(arr[0], null, null);
    Pair rtP = new Pair(rtNode, 1);
    st.push(rtP);
    int idx = 0;
    while (st.size() > 0) {
      // System.out.println("stack ===> " + st);
      Pair topPair = st.peek();
      if (topPair.state == 1) {
        // append left child
        idx++;
        if (arr[idx] != null) {
          topPair.node.left = new Node(arr[idx], null, null);
          Pair leftPair = new Pair(topPair.node.left, 1);
          st.push(leftPair); // now this pair will get handled due to stack LIFO policy
        } else {
          topPair.node.left = null;
        }
        topPair.state++; // state increased to right pair addition next time
      } else if (topPair.state == 2) {
        idx++;
        // append right child
        if (arr[idx] != null) {
          topPair.node.right = new Node(arr[idx], null, null);
          Pair rightPair = new Pair(topPair.node.right, 1);
          st.push(rightPair); // now this pair will get handled due to stack LIFO policy
        } else {
          topPair.node.right = null;
        }
        topPair.state++; // state increased to right pair addition next time
      } else {
        // skip
        st.pop();
      }
    }
    display(rtNode);

  }

}
