import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFileName = "source.txt";
        String destinationFileName = "destination.txt";

        try (InputStream inputStream = new FileInputStream(sourceFileName);
             OutputStream outputStream = new FileOutputStream(destinationFileName)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Содержимое файла успешно скопировано.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении или записи файла: " + e.getMessage());
        }
    }
