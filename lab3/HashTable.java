import java.util.LinkedList;

class HashTable {
    private LinkedList<Entry>[] table;
    private int capacity;
    private int size;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        this.size = 0;
    }

    public void put(String key, Product value) {
        int index = hash(key);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        table[index].add(new Entry(key, value));
        size++;
    }

    public Product get(String key) {
        int index = hash(key);

        if (table[index] == null) {
            return null;
        }

        for (Entry entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    public void remove(String key) {
        int index = hash(key);

        if (table[index] == null) {
            return;
        }

        for (Entry entry : table[index]) {
            if (entry.getKey().equals(key)) {
                table[index].remove(entry);
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode() % capacity);
    }

    private class Entry {
        private String key;
        private Product value;

        public Entry(String key, Product value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Product getValue() {
            return value;
        }

        public void setValue(Product value) {
            this.value = value;
        }
    }
}
