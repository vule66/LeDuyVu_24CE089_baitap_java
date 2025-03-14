import java.io.*;
import java.util.concurrent.*;

public class Main {
    private static final int CHUNK_SIZE = 1024 * 1024; // 1MB

    public static void main(String[] args) {
        String inputFile = "file_lon.txt";
        String outputFile = "ket_qua_file_lon.txt";

        try (RandomAccessFile file = new RandomAccessFile(inputFile, "r")) {
            long fileSize = file.length();
            int threadCount = (int) Math.ceil((double) fileSize / CHUNK_SIZE);

            CountDownLatch latch = new CountDownLatch(threadCount);
            byte[][] results = new byte[threadCount][];

            for (int i = 0; i < threadCount; i++) {
                int startPosition = i * CHUNK_SIZE;
                int bufferSize = (int) Math.min(CHUNK_SIZE, fileSize - startPosition);

                byte[] buffer = new byte[bufferSize];
                Thread thread = new FileReaderThread(file, buffer, startPosition, latch, i, results);
                thread.start();
            }
            latch.await();
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                for (byte[] data : results) {
                    fos.write(data);
                }
            }

            System.out.println("Đã ghép nội dung vào file_ket_qua.txt");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
