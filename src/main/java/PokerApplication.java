import Poker.Player;
import Poker.PokerGame;
import domain.Assignment;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.Networkplan;
import service.NetworkplanCalculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class PokerApplication {

    public static void main(String[] args) throws Exception {

        Player player1 = new Player("Niklas", 3000);
        Player player2 = new Player("Saskia", 3000);
        Player player3 = new Player("Christian", 3000);
        Player player4 = new Player("Sarah", 3000);
        PokerGame pokerGame = new PokerGame(List.of(player1, player2, player3, player4), 50, 100);
        //Aufrufen der Karten
        System.out.println(pokerGame.generateCards());

      //  pokerGame.generateCards();











/*

        String matrikelnummerOut = "4";
        String name = "Olaf";
        String noteOut = "2,4";
        Adresse wAdresse1 = new Adresse("Weinsheimerstr.",55548,"Rüdesheim","Deutschland");
        Adresse wAdresse2 = new Adresse("Alpenstr.",17584,"Bern","Schweiz");
        Adresse wAdresse3 = new Adresse("Babedibubedistr.",87517,"Rom","Italien");
        Adresse wAdresse4 = new Adresse("Kasernstr.",01255,"Graz","Österreich");
        Student student1 = new Student("24","Niklas","3,2", wAdresse1);
        Student student2 = new Student("19","Hugo","2,6",wAdresse2);
        Student student3 = new Student("10","Achim","1,4",wAdresse3);
        Student student4 = new Student("19","Leo","2,0",wAdresse4);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
       for (int i =0; i< students.size(); i++){

           System.out.println(students.get(i).toString());
        }

 */
/*

        System.out.println("\nName: "+student1.name+"\nMatrikelnummer: " + student1.matrikelnummer+"\nDurchschnittsnote: " +student1.note);
        System.out.println("\nName: "+student2.name+"\nMatrikelnummer: " + student2.matrikelnummer+"\nDurchschnittsnote: " +student2.note);


        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-");
        Student student = new Student(matrikelnummerOut, name, noteOut);
        System.out.println("Name: " + student.name + "\n" + "Matrikelnummer: " + matrikelnummerOut + "\nDurchschnittsnote: " +noteOut);
        float lohnOut = 3400;
        //Professor professor = new Professor( lohnOut);
        Professor professor = new Professor("Herrmann");
        System.out.println("Professor: " + professor.name);
        System.out.println("Lohn: " + lohnOut + " €");
        System.out.println("--------------------");

*/
        Assignment createBackend = null;
        Assignment createFrontend = null;
        createFrontend = new Assignment("frontend", 10, Arrays.asList(createBackend), Collections.emptyList());
        createBackend = new Assignment("backend ", 20, Collections.emptyList(), Arrays.asList(createFrontend));

        Networkplan networkplan = new Networkplan(Arrays.asList(createBackend, createFrontend));
        networkplan.printToConsole();



/*
        for (int i = 0; i < networkplan.getAssignments().size(); i++) {
            Assignment assignment = networkplan.getAssignments().get(i);
            System.out.println("----------------------------------------");
            System.out.println("| " + assignment.getEarliestStartDate() + "     " + assignment.name + "     " + assignment.getEarliestEndDate());
            System.out.println("|           " + networkplan.getAssignments().get(i).getDuration());
            System.out.println("| " + assignment.getLatestStartDate() + "                  " + assignment.getLatestEndDate());
            System.out.println("----------------------------------------");
            System.out.println(" ");
        }*/
        NetworkplanCalculator.fillNetworkplan(networkplan);


        System.out.println("----------CALCULATING----------");
        networkplan.printToConsole();
        /*for (int i = 0; i < networkplan.getAssignments().size(); i++) {
            Assignment assignment = networkplan.getAssignments().get(i);
            System.out.println("----------------------------------------");
            System.out.println("| " + assignment.getEarliestStartDate() + "     " + assignment.name + "     " + assignment.getEarliestEndDate());
            System.out.println("|           " + networkplan.getAssignments().get(i).getDuration());
            System.out.println("| " + assignment.getLatestStartDate() + "                  " + assignment.getLatestEndDate());
            System.out.println("----------------------------------------");
            System.out.println(" ");
        }*/
        List<String> critialPath = NetworkplanCalculator.calculateCriticalPath(networkplan);


    }
}
