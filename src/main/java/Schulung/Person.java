package Schulung;

public class Person {
    public String name;
    String email;
    String telefonnummer;
    Adresse adresse;


    public Person(String name, String email, String telefonnummer, Adresse wohnadresse){
        this.name = name;
        this.email = email;
        this.telefonnummer = telefonnummer;
        this.adresse = wohnadresse;
    }
}
