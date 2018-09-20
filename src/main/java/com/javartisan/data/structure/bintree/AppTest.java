package com.javartisan.data.structure.bintree;




import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;



public class AppTest {


    public void post() {
        postPrint1(Node.buildTree());
        System.out.println();
        postPrint2(Node.buildTree());
        System.out.println();
        midPrint1(Node.buildTree());
        System.out.println();
        midPrint2(Node.buildTree());
        System.out.println();
        prePrint1(Node.buildTree());
        System.out.println();
        prePrint2(Node.buildTree());
    }

    public static void prePrint2(Node node) {

        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                //保存右子树，以后以递归思想当做一个独立的树进行遍历
                stack.push(node.right);
                System.out.print(node.val + "   ");
                node = node.left;
            }
            node = stack.pop();
        }
    }

    public static void prePrint1(Node node) {

        if (Objects.isNull(node)) {
            return;
        }
        System.out.print(node.val + "   ");
        prePrint1(node.left);
        prePrint1(node.right);
    }


    // 左根右
    public static void midPrint2(Node node) {

        Stack<Node> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.print(node.val + "   ");
            node = node.right;
        }
    }

    public static void midPrint1(Node node) {

        if (Objects.isNull(node)) {
            return;
        }

        midPrint1(node.left);
        System.out.print(node.val + "   ");
        midPrint1(node.right);


    }


    public static void postPrint1(Node node) {

        if (Objects.isNull(node)) {
            return;
        }

        postPrint1(node.left);
        postPrint1(node.right);
        System.out.print(node.val + "   ");


    }


    public static void postPrint2(Node node) {

        if (Objects.isNull(node)) {
            return;
        }

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
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
                continue;
            }

            System.out.print(node.val + "   ");
            visited.add(node);
            stack.pop();
        }


    }

}
