package designPattern.decorator;

/**
 * Created by wybe on 7/22/16.
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with Mocha";
    }

    @Override
    public double cost() {
        double cost ;
        switch (this.beverage.size) {
            case tall:
                cost = .10;
                break;
            case grande:
                cost = .15;
                break;
            case venti:
                cost = .20;
                break;
            default:
                cost = 0;
                break;
        }
        return cost + this.beverage.cost();
    }
}
