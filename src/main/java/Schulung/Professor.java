package Schulung;

public class Professor extends Person {
    float lohn;

    public Professor(String name, String email, String telefonnummer, Adresse adresse, float lohnOut) {
        super(name, email, telefonnummer, adresse);
        this.lohn = lohnOut;
    }

}
