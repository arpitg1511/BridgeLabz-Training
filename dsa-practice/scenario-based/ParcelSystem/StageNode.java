class StageNode {
    private String stageName;
    StageNode nextStage;

    public StageNode(String stageName) {
        this.stageName = stageName;
        this.nextStage = null;
    }

    public String getStageName() {
        return stageName;
    }
}
