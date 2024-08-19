import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

// Mock AI Model for Crop Recommendation
class CropRecommendationModel {
    public String recommendCrop(String soilType, double moistureLevel, double pH) {
        // Simulated AI-based crop recommendation
        if ("Loamy".equals(soilType) && moistureLevel > 50 && pH > 6.0) {
            return "Wheat";
        } else if ("Clay".equals(soilType) && moistureLevel < 50 && pH < 6.0) {
            return "Rice";
        } else {
            return "Maize";
        }
    }
}

// Simulated IoT Device for Soil Health Monitoring
class IoTDevice {
    public double getSoilMoisture() {
        // Simulated moisture level reading
        return ThreadLocalRandom.current().nextDouble(30.0, 80.0);
    }

    public double getSoilPH() {
        // Simulated pH level reading
        return ThreadLocalRandom.current().nextDouble(4.5, 8.0);
    }

    public String getSoilType() {
        // Simulated soil type detection
        String[] soilTypes = {"Loamy", "Clay", "Sandy"};
        return soilTypes[ThreadLocalRandom.current().nextInt(soilTypes.length)];
    }
}

// Simulated Disease Detection using Image Recognition
class DiseaseDetectionModel {
    public String detectDisease(String image) {
        // Simulated disease detection
        if (image.contains("spot")) {
            return "Leaf Spot";
        } else if (image.contains("blight")) {
            return "Blight";
        } else {
            return "Unknown Disease";
        }
    }
}

// Main Application
public class AdvancedCropSoilManagementSystem {
    static CropRecommendationModel cropModel = new CropRecommendationModel();
    static IoTDevice ioTDevice = new IoTDevice();
    static DiseaseDetectionModel diseaseModel = new DiseaseDetectionModel();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Advanced Crop and Soil Management System ---");
            System.out.println("1. Get AI-Powered Crop Recommendation");
            System.out.println("2. Monitor Soil Health (IoT)");
            System.out.println("3. Detect Plant Disease from Image");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    getCropRecommendation();
                    break;
                case 2:
                    monitorSoilHealth();
                    break;
                case 3:
                    detectPlantDisease(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void getCropRecommendation() {
        String soilType = ioTDevice.getSoilType();
        double moisture = ioTDevice.getSoilMoisture();
        double pH = ioTDevice.getSoilPH();

        String recommendedCrop = cropModel.recommendCrop(soilType, moisture, pH);

        System.out.println("\n--- AI-Powered Crop Recommendation ---");
        System.out.println("Soil Type: " + soilType);
        System.out.println("Soil Moisture: " + String.format("%.2f", moisture) + "%");
        System.out.println("Soil pH Level: " + String.format("%.2f", pH));
        System.out.println("Recommended Crop: " + recommendedCrop);
    }

    public static void monitorSoilHealth() {
        String soilType = ioTDevice.getSoilType();
        double moisture = ioTDevice.getSoilMoisture();
        double pH = ioTDevice.getSoilPH();

        System.out.println("\n--- Real-Time Soil Health Monitoring ---");
        System.out.println("Soil Type: " + soilType);
        System.out.println("Soil Moisture: " + String.format("%.2f", moisture) + "%");
        System.out.println("Soil pH Level: " + String.format("%.2f", pH));
        
        // Additional action based on soil health
        if (moisture < 40) {
            System.out.println("Alert: Low moisture detected! Consider irrigating the soil.");
        }
        if (pH < 5.5) {
            System.out.println("Alert: Low pH detected! Consider adding lime to the soil.");
        }
    }

    public static void detectPlantDisease(Scanner scanner) {
        System.out.print("Enter image description (e.g., 'blight', 'spot'): ");
        String imageDescription = scanner.nextLine();

        String detectedDisease = diseaseModel.detectDisease(imageDescription);

        System.out.println("\n--- Plant Disease Detection ---");
        System.out.println("Detected Disease: " + detectedDisease);
        
        // Simulated advice
        if ("Leaf Spot".equals(detectedDisease)) {
            System.out.println("Suggested Treatment: Use a fungicide spray.");
        } else if ("Blight".equals(detectedDisease)) {
            System.out.println("Suggested Treatment: Remove and destroy infected plants.");
        } else {
            System.out.println("Suggested Treatment: Consult an agricultural expert.");
        }
    }
}
