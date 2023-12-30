import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WarehouseTransfer {
    public static void main(String[] args) {
        Loader loader = new LoaderRealization();
        ExecutorService executorService = Executors.newFixedThreadPool(3); // 3 грузчика

        // Создаем и добавляем товары на склад
        Item item1 = new Item("Item 1", 50);
        Item item2 = new Item("Item 2", 60);
        Item item3 = new Item("Item 3", 40);


        executorService.execute(() -> loader.loadItem(item1));
        executorService.execute(() -> loader.loadItem(item2));
        executorService.execute(() -> loader.loadItem(item3));


        executorService.shutdown();

        while (!executorService.isTerminated()) {
            // Ждем, пока все грузчики закончат загрузку
        }

        System.out.println("All items loaded. Starting unloading...");

        loader.unloadItems();
    }
}
