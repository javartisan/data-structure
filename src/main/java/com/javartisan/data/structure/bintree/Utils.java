package com.javartisan.data.structure.bintree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by liuguangxin on 2018/9/20.
 */
public class Utils {

    public static void main(String[] args) {

        Node node = Node.buildTree();

//        AppTest.postPrint1(node);
//        System.out.println();
//        printPost(node);
        AppTest.prePrint1(node);
        System.out.println();
        printPre(node);


    }


    public static void printPre(Node node) {

        Stack<Node> stack = new Stack<>();

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                //不要将node.right理解为一个节点，而是理解为根节点为node.right的树，这样可以认为stack中存储的全是子树，所以每一次出栈的都是一颗子树
                stack.push(node.right);
                System.out.print(node.val + "   ");
                node = node.left;
            }
            // 子树出栈
            node = stack.pop();
        }

    }


    public static void printMid(Node node) {

        Stack<Node> stack = new Stack<>();

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            System.out.print(node.val + "   ");
            node = node.right;

        }


    }

    public static void printPost(Node node) {

        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            node = stack.peek();
            while (node.left != null && !visited.contains(node.left)) {
                stack.push(node.left);
                node = node.left;
            }

            node = stack.peek();
            if (node.right != null && !visited.contains(node.right)) {
                stack.push(node.right);
                // 右子树也是一颗树，作为一颗新树遍历
                continue;
            }
            System.out.print(node.val + "   ");
            visited.add(node);
            stack.pop();
        }

        System.out.println();
    }
}
