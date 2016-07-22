package designPattern.decorator;

/**
 * Created by wybe on 7/22/16.
 */
public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with Soy";
    }

    @Override
    public double cost() {
        return .30 + beverage.cost();
    }
}
