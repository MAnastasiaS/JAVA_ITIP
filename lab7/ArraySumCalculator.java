import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ArraySumCalculator {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numThreads = 4; // Количество потоков
        int arrayLength = array.length;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        // Разделение массива на равные части
        int chunkSize = arrayLength / numThreads;
        int startIndex = 0;

        for (int i = 0; i < numThreads; i++) {
            int endIndex = startIndex + chunkSize;
            if (i == numThreads - 1) {
                endIndex = arrayLength;
            }

            int[] subArray = new int[endIndex - startIndex];
            System.arraycopy(array, startIndex, subArray, 0, endIndex - startIndex);

            // Вычисление суммы элементов подмассива в отдельном потоке
            executorService.execute(new ArraySumCalculatorWorker(subArray));

            startIndex = endIndex;
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // Ждем, пока все потоки завершат работу
        }

        int totalSum = ArraySumCalculatorWorker.getTotalSum();
        System.out.println("Total sum: " + totalSum);
    }
}

class ArraySumCalculatorWorker implements Runnable {
    private int[] array;
    private static int totalSum = 0;

    ArraySumCalculatorWorker(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        // Суммируем результаты подмассивов
        synchronized (ArraySumCalculatorWorker.class) {
            totalSum += sum;
        }
    }

    static int getTotalSum() {
        return totalSum;
    }
}
