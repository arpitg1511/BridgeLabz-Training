import java.io.*;

public class ImageByteArray {

    public static void main(String[] args) {
        String sourceFile = "original.jpg";    // original image
        String destFile = "copy.jpg";          // copied image

        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        FileOutputStream fos = null;

        try {
            // ===== Read image into byte array =====
            fis = new FileInputStream(sourceFile);
            baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096]; // read in 4 KB chunks
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageData = baos.toByteArray(); // image as byte array
            System.out.println("Image converted to byte array. Size: " + imageData.length + " bytes");

            // ===== Write byte array back to new file =====
            fos = new FileOutputStream(destFile);
            ByteArrayInputStream bais = new ByteArrayInputStream(imageData);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Byte array written back to " + destFile);

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (baos != null) baos.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}
