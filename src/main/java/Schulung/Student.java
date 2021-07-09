package Schulung;

public class Student extends Person {
    public String matrikelnummer;
    public String note;


    public Student(String matrikelnummerOut, String name, String noteOut, Adresse adresse) {
        super(name, adresse);
        this.matrikelnummer = matrikelnummerOut;
        this.note = noteOut;

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", matrikelnummer='" + matrikelnummer + '\'' +
                ", note='" + note + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }

    void SichEinschreiben() {

    }
}
