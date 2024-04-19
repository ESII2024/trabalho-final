package DecoratorPattern;


import Objeto.Objeto;
import Uteis.print;

public class BadgeDecorator implements Objeto {
    private Objeto decoratedObject;

    public BadgeDecorator(Objeto decoratedObject) {
        this.decoratedObject = decoratedObject;
    }

    public BadgeDecorator() {}

    @Override
    public void display() {
        decoratedObject.display();
        print.log("Displaying Badge");
    }
}