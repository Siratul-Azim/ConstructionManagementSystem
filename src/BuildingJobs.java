public class BuildingJobs {
    private String name;
    private double budget;
    private String stage;
    private WorkCrew crew;
    private double outstandingAmount;

    public BuildingJobs(String name, double budget) {
        this.name = name;
        this.budget = budget;
        this.stage = "Foundation";
        this.outstandingAmount = budget;
    }

    public String getName() {
        return name;
    }

    public double getBudget() {
        return budget;
    }

    public String getStage() {
        return stage;
    }

    public WorkCrew getCrew() {
        return crew;
    }

    public double getOutstandingAmount() {
        return outstandingAmount;
    }

    public void assignCrew(WorkCrew crew) {
        this.crew = crew;
    }

    public void makePayment(double amount) {
        outstandingAmount -= amount;
    }

    public void updateStage(String newStage) {
        this.stage = newStage;
    }

    public void displayJobDetails() {
        System.out.println("Job Name: " + name);
        System.out.println("Budget: $" + budget);
        System.out.println("Stage: " + stage);
        System.out.println("Assigned Crew: " + (crew != null ? crew.getName() : "None"));
        System.out.println("Outstanding Amount: $" + outstandingAmount);
    }
}