public class Rocket implements SpaceShip {
    private int cost;   // MM dollars
    private int selfWeight; // kg
    private int maxWeight;  // kg
    private int currentWeight;  //kg
    private double launchPct100;   //pct*100
    private double landPct100;     //pct*100

    public Rocket(int cost, int selfWeight, int maxWeight, int currentWeight) {
        this.cost = cost;
        this.selfWeight = selfWeight;
        this.maxWeight = maxWeight;
        this.currentWeight = currentWeight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public final boolean canCarry(Item item) {
        return maxWeight > (currentWeight + item.getWeight());
    }

    @Override
    public final void carry(Item item) {
        currentWeight = currentWeight + item.getWeight();
    }


    // Getter and Setter
    public int getCost() {
        return cost;
    }

    public int getSelfWeight() {
        return selfWeight;
    }

    public double getLaunchPct100() {
        return launchPct100;
    }

    public void setLaunchPct100(double launchPct100) {
        this.launchPct100 = launchPct100;
    }

    public double getLandPct100() {
        return landPct100;
    }

    public void setLandPct100(double landPct100) {
        this.landPct100 = landPct100;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = this.currentWeight + currentWeight;
    }

}
