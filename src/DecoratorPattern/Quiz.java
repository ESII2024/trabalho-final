package DecoratorPattern;

import Data.print;
import Educational.EducationalContent;

public class Quiz extends BadgeDecorator implements EducationalContent {
    public Quiz() {
        super();
    }

    @Override
    public void display() {
        print.log("Displaying Quiz");
    }
}

