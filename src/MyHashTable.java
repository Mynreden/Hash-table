import java.security.KeyException;
import java.util.Arrays;

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
            return "(" + key + ", " + value + ")";
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

    public boolean contains(V value){
        for (int index = 0; index < this.M; index ++){
            HashNode<K, V> pointer = this.chainArray[index];
            while (pointer != null){
                if (pointer.value.equals(value)) return true;
                pointer = pointer.next;
            }
        }
        return false;
    }

    public K getKey(V value) throws Exception {
        for (int index = 0; index < this.M; index ++){
            HashNode<K, V> pointer = this.chainArray[index];
            while (pointer != null){
                if (pointer.value.equals(value)) return pointer.key;
                pointer = pointer.next;
            }
        }
        throw new Exception("Key does not exist");
    }

    public Object[] getValuesArray(){
        Object[] result = new Object[this.size];
        int i = 0;
        for (int index = 0; index < this.M; index ++){
            HashNode<K, V> pointer = this.chainArray[index];
            while (pointer != null){
                result[i] = pointer.value;
                i ++;
                pointer = pointer.next;
            }
        }
        return result;
    }

    public Object[] getKeysArray(){
        Object[] result = new Object[this.size];
        int i = 0;
        for (int index = 0; index < this.M; index ++){
            HashNode<K, V> pointer = this.chainArray[index];
            while (pointer != null){
                result[i] = pointer.key;
                i ++;
                pointer = pointer.next;
            }
        }
        return result;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append('[');
        int i = 0;
        for (int index = 0; index < this.M; index ++){
            HashNode<K, V> pointer = this.chainArray[index];
            while (pointer != null){
                result.append(pointer.toString()).append(", ");
                i ++;
                pointer = pointer.next;
            }
        }
        int length = result.length();
        result.delete(length - 2, length);
        result.append(']');
        return result.toString();
    }

    public int[] sizeOfBuckets(){
        int[] result = new int[this.M];
        for (int i = 0; i < this.M; i ++){
            int length = 0;
            HashNode<K, V> pointer = this.chainArray[i];
            while (pointer != null){
                pointer = pointer.next;
                length ++;
            }
            result[i] = length;
        }
        return result;
    }
}