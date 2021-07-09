package Schulung;

public class Professor extends Person {
    float lohn;
    public Professor(String name,float lohnOut, Adresse adresse){
        super(name,adresse);
        Adresse wAdresse5 = new Adresse("Kasernstr.",12479,"Graz","Österreich");
        Professor professor = new Professor("Peter",wAdresse5);
        lohnOut = 3400;
        lohn = lohnOut;

    }

    public Professor(String name,Adresse adresse) {
        super(name,adresse);

    }
}
