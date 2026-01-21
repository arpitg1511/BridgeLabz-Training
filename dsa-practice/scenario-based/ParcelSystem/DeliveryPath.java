class DeliveryPath {

    private StageNode start;

    // Add stage at end
    public void appendStage(String stage) {
        StageNode node = new StageNode(stage);

        if (start == null) {
            start = node;
            return;
        }

        StageNode temp = start;
        while (temp.nextStage != null) {
            temp = temp.nextStage;
        }
        temp.nextStage = node;
    }

    // Insert stage after given stage
    public void insertCheckpoint(String afterStage, String newStage) {
        StageNode temp = start;

        while (temp != null) {
            if (temp.getStageName().equals(afterStage)) {
                StageNode node = new StageNode(newStage);
                node.nextStage = temp.nextStage;
                temp.nextStage = node;
                System.out.println("Checkpoint added after " + afterStage);
                return;
            }
            temp = temp.nextStage;
        }

        System.out.println("Stage not found. Checkpoint not inserted.");
    }

    // Forward traversal
    public void trackParcel() {
        if (start == null) {
            System.out.println("Parcel tracking unavailable (missing data).");
            return;
        }

        StageNode temp = start;
        System.out.print("Parcel Status: ");

        while (temp != null) {
            System.out.print(temp.getStageName());
            temp = temp.nextStage;

            if (temp != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}
