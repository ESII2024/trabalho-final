package DecoratorPattern;


import Uteis.print;
import Objeto.Objeto;

public class CertificateDecorator implements Objeto {
    private Objeto decoratedObject;

    public CertificateDecorator(Objeto decoratedObject) {
        this.decoratedObject = decoratedObject;
    }

    @Override
    public void display() {
        decoratedObject.display();
        print.log("Displaying Certificate");
    }
}