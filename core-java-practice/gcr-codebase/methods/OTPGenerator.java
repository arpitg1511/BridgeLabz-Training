import java.util.*;

public class OTPGenerator {

    // Method to generate a 6-digit OTP
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
    }

    // Method to check if OTPs are unique
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {

        int[] otps = new int[10];

        // Generate OTPs 10 times
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
        }

        System.out.print("Generated OTPs: ");
        for (int otp : otps) {
            System.out.print(otp + " ");
        }
        System.out.println();

        // Check uniqueness
        System.out.println("All OTPs are unique: " + areOTPsUnique(otps));
    }
}
