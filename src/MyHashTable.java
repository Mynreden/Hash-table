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
    private final HashNode[] chainArray;
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
        this.size++;
        int index = hash(key);
        HashNode temp = new HashNode<>(key, value);
        if (this.chainArray[index] == null){
            this.chainArray[index] = temp;
            return;
        }
        HashNode pointer = this.chainArray[index];
        while (pointer.next != null){
            pointer = pointer.next;
        }
        pointer.next = temp;
    }

    public V get(K key){}

    public V remove(K key){}

    public boolean contains(V value){}

    public K getKey(V value) {}
}