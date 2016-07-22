package designPattern.decorator;

/**
 * Created by wybe on 7/22/16.
 */
public class Main {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage.setSize(Beverage.Size.venti);
        System.out.printf("%s(%s) $%.2f\n", beverage.getDescription(), beverage.getSize(), beverage.cost());

        beverage = new Mocha(beverage);
//        beverage = new Soy(beverage);
        System.out.printf("%s(%s) $%.2f\n", beverage.getDescription(), beverage.getSize(), beverage.cost());

    }
}
