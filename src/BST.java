public class BST <K extends Comparable<K>, V>{
    private Node root;
    private class Node{
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }
    public void put(K key, V val){
        Node newNode = new Node(key, val);
        if(root == null){
            root = newNode;
        }else{
            Node currentNode = root;
            while(currentNode != null){
                if(newNode.val.compareTo(currentNode.val) > 0){
                    currentNode = currentNode.right;
                }else if(newNode.val.compareTo(currentNode.val) < 0){
                    currentNode = currentNode.left;
                }else if(newNode.val.equals(currentNode.val)){
                    return;
                }
            }
        }

    }
    public V get(K key){
        return null;
    public V get(K key){
        return null;
    public V get(K key){
        return null;
    }
    public void delete(K key){

    }
    public Iterable<K> iterator(){
        return null;
    }
}