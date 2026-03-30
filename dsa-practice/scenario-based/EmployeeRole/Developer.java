class Developer extends Employee {

    private final double bonus;   // cached bonus

    public Developer(String name, double salary) {
        super(name, salary);
        this.bonus = salary > 50000.0 ? salary * 0.05 : 0.0;
    }

    @Override
    public double getBonus() {
        return bonus;
    }
}
