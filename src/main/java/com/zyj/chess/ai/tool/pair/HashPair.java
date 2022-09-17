package com.zyj.chess.ai.tool.pair;

public final class HashPair<K, V> implements Pair<K, V> {
    static final class BinaryNode<K, V> {
        final Node<K, V> fixed, variable;

        public BinaryNode() {
            fixed = new Node<>(0, null, null, null);
            variable = new Node<>(0, null, null, null);
        }

        public Node<K, V> get(boolean state) {
            return state ? fixed : variable;
        }
    }

    static final class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
//        public void put(K key, V val) {
//            if (super.node == null) {
//                super.node = new Node<>(key, val, hash(key));
//                return;
//            }
//            int hash = hash(key);
//            boolean isNull = key == null;
//            Node<K, V> node = super.node, parentPair;
//            do {
//                if (node.hash == hash && (isNull ? node.key == null : key.equals(node.key))) {
//                    node.val = val;
//                    return;
//                } else {
//                    parentPair = node;
//                    node = node.next;
//                }
//            } while (node != null);
//            parentPair.next = new Node<>(key, val, hash(key));
//            ++size;
//        }
    }

    int size;
    int length;
    int futureSize;
    final BinaryNode<K, V>[] table;

    @SuppressWarnings("unchecked")
    public HashPair() {
        this.size = 16;
        this.length = 0;
        this.futureSize = this.size << 1;
        this.table = (BinaryNode<K, V>[]) new BinaryNode[16];
        for (int i = 0; i < 16; ++i) table[i] = new BinaryNode<>();
    }

    public V put(K key, V val) {
        int hash = hash(key);
        int index = size - 1 & hash;
        Node<K, V> nodes = table[index].get((futureSize - 1 & hash) == index);
//        HashMap s = new HashMap();
//        s.put()
        return val;
    }

    @Override
    public void get() {

    }

    int hash(Object key) {
        if (key == null) return 0;
        int hash = key.hashCode();
        return hash ^ (hash >>> 16);
    }

    public static void main(String[] args) {
//        System.out.println(9527 & 16-1);
//        System.out.println(9527 & 32-1);
//        System.out.println(9133 & 16-1);
//        System.out.println(9133 & 32-1);
//        System.out.println(5309 & 16-1);
//        System.out.println(5309 & 32-1);

        HashPair<String, Object> pair = new HashPair<>();
        pair.put("username", "Administrator");
    }
}