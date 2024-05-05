import java.util.ArrayList;
import java.util.Scanner;


public class BuildingJobManager {
    private static ArrayList<BuildingJobs> buildingJobs = new ArrayList<>();
    private static ArrayList<WorkCrew> workCrews = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the main menu
        while (true) {
            System.out.println("Building Job Management System");
            System.out.println("1. Create a new work crew");
            System.out.println("2. Create a new building job");
            System.out.println("3. View job summary");
            System.out.println("4. View work crews for a stage");
            System.out.println("5. Assign work crew to job");
            System.out.println("6. Make payment");
            System.out.println("7. Update building stage");
            System.out.println("8. View job details");
            System.out.println("9. Exit");

            System.out.print("Enter your choice (1-9): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createWorkCrew(scanner);
                    break;
                case 2:
                    createBuildingJob(scanner);
                    break;
                case 3:
                    viewJobSummary();
                    break;
                case 4:
                    viewWorkCrewsForStage(scanner);
                    break;
                case 5:
                    assignCrewToJob(scanner);
                    break;
                case 6:
                    makePayment(scanner);
                    break;
                case 7:
                    updateBuildingStage(scanner);
                    break;
                case 8:
                    viewJobDetails(scanner);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createWorkCrew(Scanner scanner) {
        System.out.print("Enter crew name: ");
        String name = scanner.nextLine();
        System.out.print("Enter number of workers: ");
        int numWorkers = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        WorkCrew crew = new WorkCrew(name, numWorkers, null);
        workCrews.add(crew);
        System.out.println("Work crew created successfully.");
    }

    private static void createBuildingJob(Scanner scanner) {
        System.out.print("Enter job name: ");
        String name = scanner.nextLine();
        System.out.print("Enter budget: ");
        double budget = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        BuildingJobs job = new BuildingJobs(name, budget);
        buildingJobs.add(job);
        System.out.println("Building job created successfully.");
    }

    private static void viewJobSummary() {
        if (buildingJobs.isEmpty()) {
            System.out.println("No building jobs available.");
            return;
        }

        System.out.println("Job Summary:");
        for (BuildingJobs job : buildingJobs) {
            System.out.println("Job Name: " + job.getName());
            System.out.println("Budget: $" + job.getBudget());
            System.out.println("Stage: " + job.getStage());
            System.out.println("Assigned Crew: " + (job.getCrew() != null ? job.getCrew().getName() : "None"));
            System.out.println("Outstanding Amount: $" + job.getOutstandingAmount());
            System.out.println();
        }
    }

    private static void viewWorkCrewsForStage(Scanner scanner) {
        System.out.print("Enter building stage: ");
        String stage = scanner.nextLine();

        System.out.println("Work Crews capable of working on stage '" + stage + "':");
        for (WorkCrew crew : workCrews) {
            if (crew.canWorkOnStage(stage)) {
                System.out.println("- " + crew.getName());
            }
        }
    }

    private static void assignCrewToJob(Scanner scanner) {
        if (buildingJobs.isEmpty()) {
            System.out.println("No building jobs available.");
            return;
        }

        if (workCrews.isEmpty()) {
            System.out.println("No work crews available.");
            return;
        }

        System.out.println("Building Jobs:");
        for (int i = 0; i < buildingJobs.size(); i++) {
            System.out.println((i + 1) + ". " + buildingJobs.get(i).getName());
        }

        System.out.print("Enter job number to assign crew: ");
        int jobIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline character

        System.out.println("Work Crews:");
        for (int i = 0; i < workCrews.size(); i++) {
            System.out.println((i + 1) + ". " + workCrews.get(i).getName());
        }

        System.out.print("Enter crew number to assign: ");
        int crewIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline character

        BuildingJobs selectedJob = buildingJobs.get(jobIndex);
        WorkCrew selectedCrew = workCrews.get(crewIndex);
        selectedJob.assignCrew(selectedCrew);

        System.out.println("Work crew assigned to the job successfully.");
    }

    private static void makePayment(Scanner scanner) {
        if (buildingJobs.isEmpty()) {
            System.out.println("No building jobs available.");
            return;
        }

        System.out.println("Building Jobs:");
        for (int i = 0; i < buildingJobs.size(); i++) {
            System.out.println((i + 1) + ". " + buildingJobs.get(i).getName());
        }

        System.out.print("Enter job number to make payment: ");
        int jobIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline character

        BuildingJobs selectedJob = buildingJobs.get(jobIndex);
        System.out.print("Enter payment amount: ");
        double paymentAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        selectedJob.makePayment(paymentAmount);
        System.out.println("Payment made successfully.");
    }

    private static void updateBuildingStage(Scanner scanner) {
        if (buildingJobs.isEmpty()) {
            System.out.println("No building jobs available.");
            return;
        }

        System.out.println("Building Jobs:");
        for (int i = 0; i < buildingJobs.size(); i++) {
            System.out.println((i + 1) + ". " + buildingJobs.get(i).getName());
        }

        System.out.print("Enter job number to update stage: ");
        int jobIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline character

        BuildingJobs selectedJob = buildingJobs.get(jobIndex);
        System.out.print("Enter new stage: ");
        String newStage = scanner.nextLine();

        selectedJob.updateStage(newStage);
        System.out.println("Building stage updated successfully.");
    }

    private static void viewJobDetails(Scanner scanner) {
        if (buildingJobs.isEmpty()) {
            System.out.println("No building jobs available.");
            return;
        }

        System.out.println("Building Jobs:");
        for (int i = 0; i < buildingJobs.size(); i++) {
            System.out.println((i + 1) + ". " + buildingJobs.get(i).getName());
        }

        System.out.print("Enter job number to view details: ");
        int jobIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline character

        BuildingJobs selectedJob = buildingJobs.get(jobIndex);
        selectedJob.displayJobDetails();
    }
}