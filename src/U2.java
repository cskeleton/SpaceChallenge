public class U2 extends Rocket {

    U2() {
        super(120, 18000, 290000, 0);
    }

    @Override
    public boolean launch() {
        setLaunchPct100(4*(getCurrentWeight()*1.0 / (getMaxWeight() - getSelfWeight())));
        return (Math.random()*100) > (getLaunchPct100()); //determine if a dependent event happen.
    }

    @Override
    public boolean land() {
        setLandPct100(8*(getCurrentWeight()*1.0 / (getMaxWeight() - getSelfWeight())));   // factor is 1.
        return (Math.random()*100) > getLandPct100();
    }
}
