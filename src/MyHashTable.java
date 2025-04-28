public class MyHashTable <K, V>{
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

    }



    private HashNode<K, V>[] arr;
    private int capacity;
    private int size;

    private HashNode<K, V> head;
    private HashNode<K, V> tail;


    public MyHashTable(int capacity) {
        this.capacity = capacity;
    }
    private int  hash(K key) {
        return key.hashCode();
    }


    public void put(K key, V value) {
        int index = hash(key) % capacity;
        if (arr[index] ==  null) {
            arr[index] = new HashNode<K, V>(key, value);
            size++;
        }
        else {
            HashNode<K, V> current = arr[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = new HashNode<K, V>(key, value);
            size++;

        }

    }

    public V get(K key) {
        int index = hash(key) % capacity;
        if (arr[index].key.equals(key)) {
            return arr[index].value;
        }
        else {
            HashNode<K, V> current = arr[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    return current.value;
                }
                current = current.next;
            }

        }
        return null;
    }

    public V remove (K key) {
        int index = hash(key) % capacity;
        if (arr[index].key.equals(key)) {
            arr[index] = arr[index].next;
            size--;
            return arr[index].value;
        } else {
            HashNode<K, V> current = arr[index];
            while (current.next != null) {
                if (current.next.key.equals(key)) {
                    V temp = current.next.value;
                    current.next = current.next.next;
                    size--;
                    return temp;
                }
                current = current.next;
            }

        }
        return null;

    }

    public boolean contains(V value) {
        for (int i = 0; i < capacity; i++) {
            if (arr[i].value.equals(value)) {
                return true;
            }
            else {
                if (arr[i].next != null) {
                    HashNode<K, V> current = arr[i];
                    while (current.next != null) {
                        if (current.value.equals(value)) {
                            return true;
                        }
                        current = current.next;
                    }
                }
            }
        }
        return false;

    }

    public K getKey(V value) {
        for (int i = 0; i < capacity; i++) {
            if (arr[i].value.equals(value)) {
                return arr[i].key;
            }
            else {
                if (arr[i].next != null) {
                    HashNode<K, V> current = arr[i];
                    while (current.next != null) {
                        if (current.value.equals(value)) {
                            return current.key;
                        }
                        current = current.next;
                    }
                }
            }
        }
        return null ;
    }







}
