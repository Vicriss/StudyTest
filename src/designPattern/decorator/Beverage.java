package designPattern.decorator;

/**
 * Created by wybe on 7/22/16.
 */
public abstract class Beverage {
    String description = "Unknown beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
