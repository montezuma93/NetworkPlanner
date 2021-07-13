package Schulung;

import java.util.Objects;

public class Student extends Person {
    public String matrikelnummer;
    public String note;


    public Student(String mArtikelNummerOut, String name, String email, String telefonnummer, Adresse wohnadresse) {
        super(name, email, telefonnummer, wohnadresse);
        matrikelnummer = mArtikelNummerOut;
    }

    @Override
    public boolean equals(Object o) {    // wenn parameter gleich sind
        Student student = (Student) o;
        if (this.matrikelnummer == student.matrikelnummer) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(matrikelnummer, note);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telefonnummer='" + telefonnummer + '\'' +
                ", wohnadresse=" + adresse.toString() +
                ", mArtikelNummer='" + matrikelnummer + '\'' +
                ", note='" + note + '\'' +
                '}';

    }

    void SichEinschreiben() {

    }
}
