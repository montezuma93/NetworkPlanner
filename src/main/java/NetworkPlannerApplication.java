import Schulung.Professor;
import Schulung.Student;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetworkPlannerApplication {

    public static void main(String[] args) throws Exception {
        String name = "Otto";
        String mArtikelNummerOut = "4";
        Student student= new Student(mArtikelNummerOut, name);
        System.out.println(student.name);
        Professor professor = new Professor("Zensen");
        System.out.println(professor.name);
    }
}
