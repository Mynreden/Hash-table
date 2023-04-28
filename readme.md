Documentation:

Note: V and K are parameters of value and key

MyHashTable() - default constructor. default size = 11

MyHashTable(int M) - constructor get size;

void put(K key, V value) - adding element to hashTable

V get(K key) - getting element from hashTable by key

public V remove(K key) - removing element from hashTable by key

public boolean contains(V value) - check is hashTable contain value

public K getKey(V value) - getting key by value

Object[] getValuesArray() - getting array of all values stored in hashTable

Object[] getKeysArray() - getting array of all keys stored in hashTable

String toString() - String implementation of hashTable 

int[] sizeOfBuckets() - getting array of number collisions in each bucket