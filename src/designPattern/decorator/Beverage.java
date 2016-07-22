package designPattern.decorator;

/**
 * Created by wybe on 7/22/16.
 */
public abstract class Beverage {
    String description = "Unknown beverage";
    Size size;
    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return this.size;
    }

    public enum Size {
        tall, grande, venti;

    }
}
