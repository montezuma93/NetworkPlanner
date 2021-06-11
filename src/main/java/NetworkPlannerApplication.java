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

        Assignment createFrontend = new Assignment(123, Collections.emptyList(), Collections.emptyList());
        Networkplan networkplan = new Networkplan(Arrays.asList(createFrontend));
        NetworkplanCalculator.fillNetworkplan(networkplan);
        List<String> critialPath = NetworkplanCalculator.calculateCriticalPath(networkplan);



    }
}
