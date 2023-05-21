import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class BST <K extends Comparable<K>, V> implements Iterable<K>{
    private Node root;
    private int size;

    @Override
    public Iterator<K> iterator() {
        List<K> keys = new ArrayList<>();
        inorderTraversal(root, keys);
        return keys.iterator();
    }
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }
    public BST(){
        size = 0;
    }
    public void put(K key, V val){
        root = put(root, key, val);
        size++;
    }

    private Node put(Node node, K key, V val) {
        if (node == null) {
            return new Node(key, val); // creating new Node and placing in empty position
        }

        int cmp = key.compareTo(node.key); // comparing generic types
        if (cmp < 0) {
            node.left = put(node.left, key, val); // left sub tree
        } else if (cmp > 0) {
            node.right = put(node.right, key, val); // right sub t3
        } else {
            node.val = val; // if we have such key rewrite
        }
        return node;
    }

    public V get(K key){
        return get(root, key);
    }
    private V get(Node node, K key) {
        if (node == null) {
            return null; // if there is no such value return null
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key); // if it is in the left sub tree
        } else if (cmp > 0) {
            return get(node.right, key); //if it is in the right sub tree
        } else {
            return node.val; // if it is the value we seek
        }
    }
    public void delete(K key){
        root = delete(root, key);
        size--;
    }
    private Node delete(Node node, K key){
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            node.left = delete(node.left, key);
        }else if(cmp > 0){
            node.right = delete(node.right, key);
        }else{
            if(node.left == null && node.right == null){
                return null;
            }
            if(node.left == null){
                return node.right;
            }else if(node.right == null){
                return node.left;
            }else{
                Node successor = findMin(node.right);
                node.key = successor.key;
                node.val = successor.val;
                node.right = delete(node.right,successor.key);
            }
        }
        return node;
    }
    private Node findMin(Node node){
        if(node.left == null){
            return node;
        }
        return findMin(node.left);
    }
    public void inorder(){
        inorder(root);
    }

    public void inorder(Node node){
        if(node!=null) {
            inorder(node.left);
            System.out.println(" KEY = " + node.key);
            inorder(node.right);
        }
    }
    private void inorderTraversal(Node node, List<K> keys) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, keys);
        keys.add(node.key);
        inorderTraversal(node.right, keys);
    }

}
