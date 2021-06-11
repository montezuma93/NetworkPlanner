import domain.Assignment;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.Networkplan;
import service.NetworkplanCalculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class NetworkPlannerApplication {

    public static void main(String[] args) throws Exception {
        Assignment createBackend = null;
        Assignment createFrontend = null;
        createFrontend = new Assignment("frontend",10, Arrays.asList(createBackend), Collections.emptyList());
        createBackend = new Assignment("backend",20, Collections.emptyList(), Arrays.asList(createFrontend));

        Networkplan networkplan = new Networkplan(Arrays.asList(createBackend, createFrontend));


        for (int i = 0; i < networkplan.getAssignments().size(); i++) {
            Assignment assignment = networkplan.getAssignments().get(i);
            System.out.println("----------------------------------------");
            System.out.println("| "+ assignment.getEarliestStartDate() + "     " + assignment.name + "     " +  assignment.getEarliestEndDate());
            System.out.println("|           " + networkplan.getAssignments().get(i).getDuration() );
            System.out.println("| " + assignment.getLatestStartDate() + "                  "  +  assignment.getLatestEndDate());
            System.out.println("----------------------------------------");
            System.out.println(" ");
        }
        NetworkplanCalculator.fillNetworkplan(networkplan);


        System.out.println("CALCULATING ----------------------------------------");
        for (int i = 0; i < networkplan.getAssignments().size(); i++) {
            Assignment assignment = networkplan.getAssignments().get(i);
            System.out.println("----------------------------------------");
            System.out.println("| "+ assignment.getEarliestStartDate() + "     " + assignment.name + "     " +  assignment.getEarliestEndDate());
            System.out.println("|           " + networkplan.getAssignments().get(i).getDuration() );
            System.out.println("| " + assignment.getLatestStartDate() + "                  "  +  assignment.getLatestEndDate());
            System.out.println("----------------------------------------");
            System.out.println(" ");
        }
        List<String> critialPath = NetworkplanCalculator.calculateCriticalPath(networkplan);


    }
}
