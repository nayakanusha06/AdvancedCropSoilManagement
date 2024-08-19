import java.util.Scanner;
import java.util.Random;

class CropAdvisor {
    String recommendCrop(String soilType, double moisture, double pH) {
        if (soilType.equals("Loamy") && moisture > 50 && pH > 6.0) {
            return "Wheat";
        } else if (soilType.equals("Clay") && moisture < 50 && pH < 6.0) {
            return "Rice";
        } else {
            return "Maize";
        }
    }
}

class SoilSensor {
    Random random = new Random();

    double getMoisture() {
        return 30.0 + (50.0 * random.nextDouble());
    }

    double getPH() {
        return 4.5 + (3.5 * random.nextDouble());
    }

    String getSoilType() {
        String[] soilTypes = {"Loamy", "Clay", "Sandy"};
        return soilTypes[random.nextInt(soilTypes.length)];
    }
}

class DiseaseDetector {
    String detectDisease(String description) {
        if (description.contains("spot")) {
            return "Leaf Spot";
        } else if (description.contains("blight")) {
            return "Blight";
        } else {
            return "Unknown Disease";
        }
    }
}

public class CropSoilManager {
    static CropAdvisor advisor = new CropAdvisor();
    static SoilSensor sensor = new SoilSensor();
    static DiseaseDetector detector = new DiseaseDetector();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nWelcome to the Crop and Soil Management System");
            System.out.println("1. Get Crop Recommendation");
            System.out.println("2. Check Soil Health");
            System.out.println("3. Identify Plant Disease");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                getCropRecommendation();
            } else if (choice == 2) {
                checkSoilHealth();
            } else if (choice == 3) {
                identifyDisease(scanner);
            } else if (choice == 4) {
                System.out.println("Thanks for using the system. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void getCropRecommendation() {
        String soilType = sensor.getSoilType();
        double moisture = sensor.getMoisture();
        double pH = sensor.getPH();

        String recommendedCrop = advisor.recommendCrop(soilType, moisture, pH);

        System.out.println("\nCrop Recommendation:");
        System.out.println("Soil Type: " + soilType);
        System.out.println("Moisture Level: " + String.format("%.2f", moisture) + "%");
        System.out.println("pH Level: " + String.format("%.2f", pH));
        System.out.println("Recommended Crop: " + recommendedCrop);
    }

    static void checkSoilHealth() {
        String soilType = sensor.getSoilType();
        double moisture = sensor.getMoisture();
        double pH = sensor.getPH();

        System.out.println("\nSoil Health Report:");
        System.out.println("Soil Type: " + soilType);
        System.out.println("Moisture Level: " + String.format("%.2f", moisture) + "%");
        System.out.println("pH Level: " + String.format("%.2f", pH));

        if (moisture < 40) {
            System.out.println("Warning: Moisture is low. You might need to water the plants.");
        }
        if (pH < 5.5) {
            System.out.println("Warning: pH is too low. Consider adding lime.");
        }
    }

    static void identifyDisease(Scanner scanner) {
        System.out.print("Describe the plant issue (e.g., 'blight', 'spot'): ");
        String description = scanner.nextLine();

        String disease = detector.detectDisease(description);

        System.out.println("\nDisease Identification Result:");
        System.out.println("Disease: " + disease);

        if (disease.equals("Leaf Spot")) {
            System.out.println("Action: Apply a fungicide to control the leaf spot.");
        } else if (disease.equals("Blight")) {
            System.out.println("Action: Remove and destroy affected plants to prevent spread.");
        } else {
            System.out.println("Action: Consult an agricultural expert for further advice.");
        }
    }
}
