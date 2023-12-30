import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SalesProgram {
    public static void main(String[] args) {
        LinkedList<SaleItem> soldItems = new LinkedList<>();

        // Добавление проданных товаров
        soldItems.add(new SaleItem("Товар1", 50.0));
        soldItems.add(new SaleItem("Товар2", 75.0));
        soldItems.add(new SaleItem("Товар1", 50.0));

        // Вывод списка проданных товаров
        for (SaleItem item : soldItems) {
            System.out.println("Продан товар: " + item.getName() + ", Цена: " + item.getPrice());
        }

        // Считаем общую сумму продаж
        double totalSales = soldItems.stream().mapToDouble(SaleItem::getPrice).sum();
        System.out.println("Общая сумма продаж: " + totalSales);

        // Считаем наиболее популярный товар
        Map<String, Integer> salesCountMap = new HashMap<>();
        for (SaleItem item : soldItems) {
            String name = item.getName();
            salesCountMap.put(name, salesCountMap.getOrDefault(name, 0) + 1);
        }

        String mostPopularItem = Collections.max(salesCountMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Наиболее популярный товар: " + mostPopularItem);
    }
}
