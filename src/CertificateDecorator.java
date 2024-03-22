public class CertificateDecorator implements EducationalObject {
    private EducationalObject decoratedObject;

    public CertificateDecorator(EducationalObject decoratedObject) {
        this.decoratedObject = decoratedObject;
    }

    @Override
    public void display() {
        decoratedObject.display();
        addCertificate();
    }

    private void addCertificate() {
        System.out.println("Certificado adicionado!");
    }
}