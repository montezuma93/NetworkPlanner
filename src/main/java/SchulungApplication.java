import Schulung.Adresse;
import Schulung.Professor;
import Schulung.Student;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SchulungApplication {

    public static void main(String[] args) throws Exception {
        String matrikelnummerOut = "4";
        String name = "Olaf";
        String noteOut = "2,4";
        Adresse wAdresse1 = new Adresse("Weinsheimerstr.", 55548, "Rüdesheim", "Deutschland");
        Adresse wAdresse2 = new Adresse("Alpenstr.", 17584, "Bern", "Schweiz");
        Adresse wAdresse3 = new Adresse("Babedibubedistr.", 87517, "Rom", "Italien");
        Adresse wAdresse4 = new Adresse("Kasernstr.", 01255, "Graz", "Österreich");
        Student student1 = new Student("24", "Niklas", "3,2","0152", wAdresse1);
        Student student2 = new Student("19", "Hugo", "2,6","0152", wAdresse2);
        Student student3 = new Student("10", "Achim", "1,4","0152", wAdresse3);
        Student student4 = new Student("19", "Leo", "2,0","0152", wAdresse4);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }


        System.out.println("\nName: " + student1.name + "\nMatrikelnummer: " + student1.matrikelnummer + "\nDurchschnittsnote: " + student1.note);
        System.out.println("\nName: " + student2.name + "\nMatrikelnummer: " + student2.matrikelnummer + "\nDurchschnittsnote: " + student2.note);


        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-");
        Student student = new Student(matrikelnummerOut, name, noteOut,"0123", new Adresse("Street", 12344, "Eine Stadt", "Land"));
        System.out.println("Name: " + student.name + "\n" + "Matrikelnummer: " + matrikelnummerOut + "\nDurchschnittsnote: " + noteOut);
        float lohnOut = 3400;
        Professor professor = new Professor("Herrmann","email", "0123", new Adresse("testStraße", 71234, "Stadt", "Deutschland"), 1000);
        System.out.println("Professor: " + professor.name);
        System.out.println("Lohn: " + lohnOut + " €");
        System.out.println("--------------------");
    }
}
