package com.javartisan.cache;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author leodaxin
 * @date 2018-08-28
 * @email javartisan@163.com
 */
public class LRUCache<V> {

    /**
     * this max size of cache to store elements.
     *
     * @param maxSize
     */
    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * the max size of cache
     */
    private int maxSize;

    /**
     * the current size of cache.
     */
    private int currentSize = 0;

    /**
     * @return return the current size of cache.
     */
    public int getCurrentSize() {
        return currentSize;
    }

    private LinkedList<String, V> linkedList = new LinkedList<>();

    /**
     * set key-value to cache.
     *
     * @param key
     * @param value
     */
    public void set(String key, V value) {
        if (linkedList.contains(key)) {
            // update value by key
            linkedList.updateNode(key, value);
            return;
        }
        // insert one elemet that not in cache.
        if (maxSize == currentSize) {
            currentSize--;
            linkedList.removelastNode();
        }
        currentSize++;
        linkedList.add(new LinkedList.Node<>(key, value));

    }

    /**
     * @param key
     * @return the value of this,if not existed return null.
     */
    public V get(String key) {
        return linkedList.get(key);
    }

    /**
     * @param key remove the key-value from cache by key
     * @return
     */
    public LinkedList.Node<String, V> remove(String key) {
        LinkedList.Node<String, V> e = linkedList.remove(key);
        if (Objects.nonNull(e))
            currentSize--;
        return e;
    }

    /**
     * @param <K>
     * @param <V>
     */
    private static class LinkedList<K, V>

    {

        private Node<K, V> header = new Node<>();
        private Node<K, V> tail = new Node<>(header);

        private Set<K> keys = new HashSet<>();

        /**
         * @param node insert one node to list.
         */
        public void add(Node<K, V> node) {
            keys.add(node.getKey());
            node.next = header.next;
            node.next.before = node;
            header.next = node;
            node.before = header;
            if (tail == header) {
                tail = node;
            }
        }

        public boolean contains(K key) {

            return keys.contains(key);
        }

        /**
         * @param key
         * @return return the value of this key.
         */
        public V get(K key) {
            Node<K, V> tmpNode = header.next;
            while (tmpNode != tail) {
                if (tmpNode.getKey().equals(key)) {
                    // 元素被访问，需要将元素置到前面
                    tmpNode.next.before = tmpNode.before;
                    tmpNode.before.next = tmpNode.next;
                    add(tmpNode);
                    return tmpNode.getValue();
                }
                tmpNode = tmpNode.next;
            }
            return null;
        }

        /**
         * @param key remove the node of this key.
         * @return return the value of this key.
         */
        public Node<K, V> remove(K key) {
            Node<K, V> tmpNode = header.next;
            while (tmpNode != tail) {
                if (tmpNode.getKey().equals(key)) {
                    tmpNode.before.next = tmpNode.next;
                    tmpNode.next.before = tmpNode.before;
                    keys.remove(tmpNode.getKey());
                    return tmpNode;
                }
                tmpNode = tmpNode.next;
            }
            return null;
        }

        public void removelastNode() {
            // remove key
            Node<K, V> lastNode = tail.before;
            K key = lastNode.getKey();
            keys.remove(key);
            tail.before.before.next = tail;
            tail.before = tail.before.before;
            lastNode.before = null;
            lastNode.next = null;
        }

        public void updateNode(K key, V value) {

            Node<K, V> tmpNode = header.next;
            while (tmpNode != tail) {
                if (tmpNode.getKey().equals(key)) {
                    tmpNode.before.next = tmpNode.next;
                    tmpNode.next.before = tmpNode.before;
                    tmpNode.setValue(value);
                    add(tmpNode);
                    return;
                }
                tmpNode = tmpNode.next;
            }
        }

        /**
         * LinkedList 内部节点
         *
         * @param <> 元素类型
         */
        private static class Node<K, V> {

            private K key;
            private V value;
            private Node<K, V> before;
            private Node<K, V> next;

            public Node() {

            }

            public Node(Node<K, V> before) {
                before.next = this;
                this.before = before;
            }

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }

            public K getKey() {
                return key;
            }

            public void setKey(K key) {
                this.key = key;
            }

            public V getValue() {
                return value;
            }

            public void setValue(V value) {
                this.value = value;
            }

            public Node<K, V> getBefore() {
                return before;
            }

            public void setBefore(Node<K, V> before) {
                this.before = before;
            }

            public Node<K, V> getNext() {
                return next;
            }

            public void setNext(Node<K, V> next) {
                this.next = next;
            }
        }

    }

}


class Main {
    public static void main(String[] args) {

        LRUCache<String> cache = new LRUCache<>(5);
        for (int i = 0; i < 10; i++) {
            cache.set(i + "", i + "");
        }
        cache.set("7", "7");
        System.out.println(cache);

    }
}
