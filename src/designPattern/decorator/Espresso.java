package designPattern.decorator;

/**
 * Created by wybe on 7/22/16.
 */
public class Espresso extends Beverage {
    public Espresso () {
        this.description = "Espresso";
    }

    @Override
    public double cost() {
        double cost ;
        switch (this.size) {
            case tall:
                cost = 1.99;
                break;
            case grande:
                cost = 2.49;
                break;
            case venti:
                cost = 2.99;
                break;
            default:
                cost = 0;
                break;
        }
        return cost;
    }

}
