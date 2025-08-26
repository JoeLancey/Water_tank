package JAV_PACKAGE;

public abstract class allTanks {
    int capacity;
    int currentLevel;
    String type;

    public allTanks(int capacity, String type) {
        this.capacity = capacity;
        this.type = type;
        this.currentLevel = 0;
    }

    public abstract void fillTank(int liters);
    public abstract void useWater(int liters);
    public abstract void checkStatus();
}
