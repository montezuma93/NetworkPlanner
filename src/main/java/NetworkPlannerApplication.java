import domain.Assignment;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.Networkplan;
import service.NetworkplanCalculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class NetworkPlannerApplication {

    public static void main(String[] args) {
        Assignment createBackend = null;
        Assignment createFrontend = new Assignment("frontend",10, Arrays.asList(createBackend), Collections.emptyList());
        createBackend = new Assignment("backend",20, Collections.emptyList(), Arrays.asList(createFrontend));
        Networkplan networkplan = new Networkplan(Arrays.asList(createBackend, createFrontend));
        for (int i = 0; i < networkplan.getAssignments().size(); i++) {
            System.out.println(networkplan.getAssignments().get(i).name);
            System.out.println("->.................................................");
            for (int j = 0; j < networkplan.getAssignments().get(i).getSuccessors().size(); j++) {
                System.out.println(networkplan.getAssignments().get(i).getSuccessors().get(j).name);
            }
            System.out.println(" ");
        }
        NetworkplanCalculator.fillNetworkplan(networkplan);
        List<String> critialPath = NetworkplanCalculator.calculateCriticalPath(networkplan);


    }
}
