package DecoratorPattern;

import Data.print;
import Educational.EducationalObject;

public class CertificateDecorator extends EducationalObject {
    private EducationalObject decoratedObject;

    public CertificateDecorator(EducationalObject decoratedObject) {
        this.decoratedObject = decoratedObject;
    }

    @Override
    public void display() {
        decoratedObject.display();
        print.log("Displaying Certificate");
    }
}