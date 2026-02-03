import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSV {

    private static final String SECRET_KEY = "1234567890123456"; // 16 chars = AES-128

    public static void main(String[] args) throws Exception {

        String csvFile = "employees_secure.csv";

        writeEncryptedCSV(csvFile);
        readDecryptedCSV(csvFile);
    }

    // Write encrypted data to CSV
    static void writeEncryptedCSV(String fileName) throws Exception {

        FileWriter writer = new FileWriter(fileName);

        writer.write("ID,Name,Email,Salary\n");

        writer.write("1,Arpit," +
                encrypt("arpit@gmail.com") + "," +
                encrypt("50000") + "\n");

        writer.write("2,Riya," +
                encrypt("riya@gmail.com") + "," +
                encrypt("65000") + "\n");

        writer.close();
        System.out.println("Encrypted CSV written successfully.");
    }

    // Read CSV and decrypt sensitive fields
    static void readDecryptedCSV(String fileName) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        br.readLine(); // skip header

        System.out.println("\nDecrypted Data:");
        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            String email = decrypt(data[2]);
            String salary = decrypt(data[3]);

            System.out.println(
                    "ID=" + data[0] +
                    ", Name=" + data[1] +
                    ", Email=" + email +
                    ", Salary=" + salary
            );
        }

        br.close();
    }

    // Encrypt using AES
    static String encrypt(String value) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes()));
    }

    // Decrypt using AES
    static String decrypt(String encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
    }
}
