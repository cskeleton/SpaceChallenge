public class U1 extends Rocket {

    U1() {
        super(100, 10000, 180000, 0);
    }

    @Override
    public boolean launch() {
        setLaunchPct100(5*(getCurrentWeight()*1.0 / (getMaxWeight() - getSelfWeight())));
        return (Math.random()*100) > (getLaunchPct100()); //determine if a dependent event happen.
    }

    @Override
    public boolean land() {
        setLandPct100(1*(getCurrentWeight()*1.0 / (getMaxWeight() - getSelfWeight())));   // factor is 1.
        return (Math.random()*100) > getLandPct100();
    }
}
