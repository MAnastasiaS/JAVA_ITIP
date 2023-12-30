public class Main {
    public static void main(String[] args) {
        // Пример использования хэш-таблицы
        HashTable hashTable = new HashTable(10);
        Product product1 = new Product("Товар 1", "Описание товара 1", 10.99, 5);
        Product product2 = new Product("Товар 2", "Описание товара 2", 19.99, 8);
        Product product3 = new Product("Товар 3", "Описание товара 3", 19.99, 8);



        hashTable.put("артикул1", product1);
        hashTable.put("артикул2", product2);
        hashTable.put("артикул3", product3);

        Product fetchedProduct = hashTable.get("артикул3");
        if (fetchedProduct != null) {
            System.out.println("Наименование: " + fetchedProduct.getName());
            System.out.println("Описание: " + fetchedProduct.getDescription());
            System.out.println("Цена: " + fetchedProduct.getPrice());
            System.out.println("Количество на складе: " + fetchedProduct.getQuantity());
        } else {
            System.out.println("Товар не найден");
        }

        hashTable.remove("артикул1");

        System.out.println("Количество товаров в хэш-таблице: " + hashTable.size());
        System.out.println("Хэш-таблица пуста? " + hashTable.isEmpty());
    }
}
