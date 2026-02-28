import java.util.LinkedList;
import java.util.Objects;
import java.util.Iterator;

class MyHashMap<K, V> {
private static class Node<K, V> {
final K key;
V value;

Node(K key, V value) {
this.key = key;
this.value = value;
}
}

private static final int INITIAL_CAPACITY = 16;
private static final double LOAD_FACTOR = 0.75;

private LinkedList<Node<K, V>>[] table;
private int size;

@SuppressWarnings("unchecked")
public MyHashMap() {
table = new LinkedList[INITIAL_CAPACITY];
}

private int getIndex(K key) {
if (key == null) return 0;
// Использую битовую маску, чтобы избежать отрицательных индексов
return (key.hashCode() & 0x7FFFFFFF) % table.length;
}

public void put(K key, V value) {
if ((double) size / table.length >= LOAD_FACTOR) {
resize();
}

int index = getIndex(key);
if (table[index] == null) {
table[index] = new LinkedList<>();
}

for (Node<K, V> node : table[index]) {
if (Objects.equals(node.key, key)) {
node.value = value;
return;
}
}

table[index].add(new Node<>(key, value));
size++;
}

public V get(K key) {
int index = getIndex(key);
if (table[index] != null) {
for (Node<K, V> node : table[index]) {
if (Objects.equals(node.key, key)) {
return node.value;
}
}
}
return null;
}

public V remove(K key) {
int index = getIndex(key);
if (table[index] == null) return null;

Iterator<Node<K, V>> iterator = table[index].iterator();
while (iterator.hasNext()) {
Node<K, V> node = iterator.next();
if (Objects.equals(node.key, key)) {
V val = node.value;
iterator.remove();
size--;
return val;
}
}
return null;
}

@SuppressWarnings("unchecked")
private void resize() {
LinkedList<Node<K, V>>[] oldTable = table;
table = new LinkedList[oldTable.length * 2];
size = 0; 

for (LinkedList<Node<K, V>> bucket : oldTable) {
if (bucket != null) {
for (Node<K, V> node : bucket) {
this.put(node.key, node.value);
}
}
}
}

public int size() {
return size;
}
}
