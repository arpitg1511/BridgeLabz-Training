class CarNode {
    private int carNumber;
    CarNode link;

    public CarNode(int carNumber) {
        this.carNumber = carNumber;
        this.link = null;
    }

    public int getCarNumber() {
        return carNumber;
    }
}
