package service;

import domain.Assignment;

import java.util.Collections;
import java.util.List;

public final class NetworkplanCalculator {

    public static void fillNetworkplan(Networkplan networkplan) throws Exception {
        Assignment assignment = getStartTask(networkplan);
        assignment.setEarliestStartDate(0);
        assignment.setEarliestEndDate(assignment.getEarliestStartDate() + assignment.getDuration());

        for(Assignment nextAssignment  : assignment.getSuccessors()) {
            nextAssignment.setEarliestStartDate(nextAssignment.getPredecessors().get(0).getLatestStartDate());
            nextAssignment.setEarliestStartDate(nextAssignment.getEarliestStartDate() + nextAssignment.getDuration());
        }
        // Calculate EarliestStartPoint, LatestStartPoint, EarliestEndPoint, LatestEndPoint
    }

    private static Assignment getStartTask(Networkplan networkplan) throws Exception {
        for(Assignment assignment : networkplan.getAssignments()) {
            if(assignment.getPredecessors().isEmpty()) {
                return assignment;
            }
        }
        throw new Exception("Kein Task ohne Vorgänger gefunden");
    }

    public static List<String> calculateCriticalPath(Networkplan networkplan) {
        return Collections.emptyList();
    }

    int calculateEndDate(int start, int duration) {
        return start + duration;
    }

}