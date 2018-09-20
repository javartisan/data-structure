package com.javartisan.data.structure.bintree;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;




public class Main {

    public static void main(String[] args) {

        Node node = Node.buildTree();
        post(node);
        System.out.println();
        postTree(node);

    }

    public static void postTree(Node node) {
        if (Objects.isNull(node)) {
            return;
        }
        // 用于回溯的栈
        Stack<Node> stack = new Stack<>();
        // 用于存储已经遍历过的节点
        Set<Node> visited = new HashSet<>();//重写Node hashcode与equals方法
        stack.push(node);
        // 后序遍历打印节点的值都是打印的栈中的，因此只要判断栈不空则就是没有遍历结束
        while (!stack.isEmpty()) {
            node = stack.peek();
            // 当前节点的左节点不空而且该节点没有被遍历过
            while (Objects.nonNull(node.left) && !visited.contains(node.left)) {
                //存储到栈中，继续向下走
                stack.push(node.left);
                node = node.left;
            }
            // 此时已经走到了最左边了，开始回溯一个节点向右子树走
            node = stack.peek();
            // 右节点不空而且没有遍历过则添加到队列中
            if (Objects.nonNull(node.right) && !visited.contains(node.right)) {
                stack.push(node.right);
                // 此时可以将右节点看做一颗子树，从新开始以后序遍历的方式遍历该子树
                continue;
            }
            //左右子树为空或者左右子树已经遍历完毕，即可遍历该节点
            node = stack.pop();
            visited.add(node);
            System.out.print(node.val + "   ");
        }
    }

    public static void post(Node node) {
        if (Objects.isNull(node)) {
            return;
        }
        post(node.left);
        post(node.right);
        System.out.print(node.val + "   ");
    }
}
