package DecoratorPattern;

import Data.print;
import Educational.EducationalObject;

public class BadgeDecorator extends EducationalObject {
    private EducationalObject decoratedObject;

    public BadgeDecorator(EducationalObject decoratedObject) {
        this.decoratedObject = decoratedObject;
    }

    public BadgeDecorator() {}

    @Override
    public void display() {
        decoratedObject.display();
        print.log("Displaying Badge");
    }
}