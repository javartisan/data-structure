package com.javartisan.data.structure.bintree;

import java.util.Objects;

/**
 * Created by liuguangxin on 2018/8/24.
 */
public class Node {

    public int val;
    public Node left;
    public Node right;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val == node.val &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    public Node(int val) {
        this.val = val;
    }

    public static Node buildTree() {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        root.left = node1;
        root.right = node2;
        node1.left = new Node(4);
        node1.right = new Node(5);
        node2.left = new Node(6);
        node2.right = new Node(7);
        return root;
    }
}