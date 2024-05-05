public class WorkCrew {
    private String name;
    private int numWorkers;
    private String[] capabilities;

    public WorkCrew(String name, int numWorkers, String[] capabilities) {
        this.name = name;
        this.numWorkers = numWorkers;
        this.capabilities = capabilities;
    }

    public String getName() {
        return name;
    }

    public int getNumWorkers() {
        return numWorkers;
    }

    public boolean canWorkOnStage(String stage) {
        for (String capability : capabilities) {
            if (capability.equalsIgnoreCase(stage)) {
                return true;
            }
        }
        return false;
    }
}