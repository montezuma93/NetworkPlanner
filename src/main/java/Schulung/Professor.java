package Schulung;

public class Professor extends Person {
    float lohn;

    public Professor(String name, String email, String telefonnummer, Adresse adresse, float lohnOut) {
        super(name, email, telefonnummer, adresse);
        lohnOut = 3400;
        this.lohn = lohnOut;
        Adresse wAdresse5 = new Adresse("Kasernstr.", 12479, "Graz", "Österreich");
        Professor professor = new Professor("Peter", "email@gmail.com", "48568", wAdresse5, lohnOut);

    }

}
