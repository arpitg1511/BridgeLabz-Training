import java.io.*;

public class EfficientFileCopy {

    static void copyWithBuffer(String src, String dest) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));

            byte[] buffer = new byte[4096]; // 4 KB
            int bytesRead;

            long start = System.nanoTime();
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            bos.flush();

            long end = System.nanoTime();
            System.out.println("Buffered copy time: " + (end - start) / 1_000_000 + " ms");

            bis.close();
            bos.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void copyWithoutBuffer(String src, String dest) {
        try {
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest);

            byte[] buffer = new byte[4096]; // still read in 4 KB chunks
            int bytesRead;

            long start = System.nanoTime();
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.flush();

            long end = System.nanoTime();
            System.out.println("Normal copy time: " + (end - start) / 1_000_000 + " ms");

            fis.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        
        String sourceFile = "C:\\Users\\disco\\OneDrive\\Desktop\\data.txt";
        String destBuffered = "C:\\BridgeLabz-Training\\collections-practice\\gcr-codebase\\streams\\destination.txt";
        String destNormal = "C:\\BridgeLabz-Training\\collections-practice\\gcr-codebase\\streams\\destinationII.txt";

        System.out.println("Copying using Buffered Streams...");
        copyWithBuffer(sourceFile, destBuffered);

        System.out.println("Copying using Normal Streams...");
        copyWithoutBuffer(sourceFile, destNormal);
    }
}
