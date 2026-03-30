
import java.util.Scanner;

/*
 * Custom exception for robot safety issues
 */
class RobotSafetyException extends Exception {
    public RobotSafetyException(String message) {
        super(message);
    }
}

/*
 * Class responsible for calculating hazard risk
 */
class RobotHazardAuditor {

    public double calculateHazardRisk(double armPrecision,
                                      int workerDensity,
                                      String machineryState)
            throws RobotSafetyException {

        // Validation checks
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException("Error: Arm precision must be between 0.0 and 1.0");
        }

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException("Error: Worker density must be between 1 and 20");
        }

        machineryState = machineryState.toLowerCase();
        double machineRiskFactor;

        // Decide risk factor based on machinery condition
        if (machineryState.equals("worn")) {
            machineRiskFactor = 1.3;
        } else if (machineryState.equals("faulty")) {
            machineRiskFactor = 2.0;
        } else if (machineryState.equals("critical")) {
            machineRiskFactor = 3.0;
        } else {
            throw new RobotSafetyException("Error: Unsupported machinery state");
        }

        // Final hazard risk calculation
        double hazardRisk =
                ((1.0 - armPrecision) * 15.0) +
                (workerDensity * machineRiskFactor);

        return hazardRisk;
    }
}

/*
 * Main class
 */
public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter Arm Precision (0.0 - 1.0):");
            double armPrecision = Double.parseDouble(sc.nextLine());

            System.out.println("Enter Worker Density (1 - 20):");
            int workerDensity = Integer.parseInt(sc.nextLine());

            System.out.println("Enter Machinery State (Worn / Faulty / Critical):");
            String machineryState = sc.nextLine();

            RobotHazardAuditor auditor = new RobotHazardAuditor();
            double risk = auditor.calculateHazardRisk(
                    armPrecision,
                    workerDensity,
                    machineryState
            );

            System.out.println("Robot Hazard Risk Score: " + risk);

        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input format.");
        }
    }
}
