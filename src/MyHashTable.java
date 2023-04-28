import java.security.KeyException;

public class MyHashTable<K, V> {
    private static class HashNode<K, V>{
        private final K key;
        private final V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    private final HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size = 0;

    public MyHashTable(){
        this.chainArray = new HashNode[this.M];
    }

    public MyHashTable(int M){
        this.chainArray = new HashNode[M];
        this.M = M;
    }

    public int hash(K key){
        return Math.abs(key.hashCode() % this.M);
    }

    public void put(K key, V value){
        this.size ++;
        int index = hash(key);
        HashNode<K, V> temp = new HashNode<>(key, value);
        if (this.chainArray[index] == null){
            this.chainArray[index] = temp;
            return;
        }
        HashNode<K, V> pointer = this.chainArray[index];
        while (pointer.next != null){
            pointer = pointer.next;
        }
        pointer.next = temp;
    }

    public V get(K key) throws Exception {
        int index = hash(key);
        HashNode<K, V> pointer = this.chainArray[index];
        while (pointer != null && !pointer.key.equals(key)){
            pointer = pointer.next;
        }
        if (pointer == null) throw new Exception("Key does not exist");
        return pointer.value;
    }

    public V remove(K key) throws Exception {
        this.size --;
        int index = hash(key);
        HashNode<K, V> pointer = this.chainArray[index];
        HashNode<K, V> previous = null;
        while (pointer != null && !pointer.key.equals(key)){
            previous = pointer;
            pointer = pointer.next;
        }
        if (pointer == null) throw new Exception("Key does not exist");
        if (previous == null) {
            this.chainArray[index] = pointer.next;
        }
        else{
            previous.next = pointer.next;
        }
        return pointer.value;
    }

    public boolean contains(V value){}

    public K getKey(V value) {}
}