import java.util.ArrayList;
import java.util.List;


interface Loader {
    void loadItem(Item item);
    void unloadItems();
}

class LoaderRealization implements Loader {
    private static final int MAX_WEIGHT = 150;

    private List<Item> items;
    private int currentWeight;

    LoaderRealization() {
        this.items = new ArrayList<>();
        this.currentWeight = 0;
    }

    @Override
    public synchronized void loadItem(Item item) {
        while (currentWeight + item.getWeight() > MAX_WEIGHT) {
            try {
                wait(); // Ожидаем освобождения места для загрузки
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Добавляем товар на склад и обновляем текущий вес
        items.add(item);
        currentWeight += item.getWeight();

        System.out.println("Loaded item: " + item.getName() + " (" + item.getWeight() + " kg)");
    }

    @Override
    public synchronized void unloadItems() {
        // Выгружаем все товары со склада
        for (Item item : items) {
            System.out.println("Unloaded item: " + item.getName() + " (" + item.getWeight() + " kg)");
        }

        // Очищаем склад и сбрасываем текущий вес
        items.clear();
        currentWeight = 0;

        notifyAll(); // Уведомляем грузчиков о свободном месте для загрузки
    }
}

class Item {
    private String name;
    private int weight;

    Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    String getName() {
        return name;
    }

    int getWeight() {
        return weight;
    }
}
