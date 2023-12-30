import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MaxElementFinder {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(4, 4);
        int numThreads = 4; // Количество потоков
        int rows = matrix.length;
        int columns = matrix[0].length;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        // Разделение матрицы на равные части
        int rowsPerThread = rows / numThreads;
        int extraRows = rows % numThreads;
        int startIndex = 0;

        for (int i = 0; i < numThreads; i++) {
            int endIndex = startIndex + rowsPerThread;
            if (i < extraRows) {
                endIndex++;
            }

            int[][] subMatrix = new int[endIndex - startIndex][columns];
            System.arraycopy(matrix, startIndex, subMatrix, 0, endIndex - startIndex);

            // Поиск наибольшего элемента в подматрице в отдельном потоке
            executorService.execute(new MaxElementFinderWorker(subMatrix));

            startIndex = endIndex;
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int maxElement = MaxElementFinderWorker.getMaxElement();
        System.out.println("Max element: " + maxElement);
    }

    private static int[][] generateMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }

        return matrix;
    }
}

class MaxElementFinderWorker implements Runnable {
    private int[][] matrix;
    private static int maxElement = Integer.MIN_VALUE;

    MaxElementFinderWorker(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public void run() {
        for (int[] row : matrix) {
            for (int element : row) {
                if (element > maxElement) {
                    synchronized (MaxElementFinderWorker.class) {
                        if (element > maxElement) {
                            maxElement = element;
                        }
                    }
                }
            }
        }
    }

    static int getMaxElement() {
        return maxElement;
    }
}
