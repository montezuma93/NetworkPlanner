package Schulung;

public class Student extends Person {
    String mArtikelNummer;
    String note;
    public Student (String mArtikelNummerOut, String name){
        super(name);
        mArtikelNummer = mArtikelNummerOut;

    }
}
