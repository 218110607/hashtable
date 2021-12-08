package Hash.src;
public class Node<K,V> {
    public K Key;
    public V Value;
    public Node next;

    public Node(K key, V val, Node next) {
        this.Key = key;
        this.Value = val;
        this.next = next;
    }

}
