package service;

import java.util.Collections;
import java.util.List;

public final class NetworkplanCalculator {

    public static void fillNetworkplan(Networkplan networkplan) {
        // Calculate EarliestStartPoint, LatestStartPoint, EarliestEndPoint, LatestEndPoint
    }

    public static List<String> calculateCriticalPath(Networkplan networkplan) {
        return Collections.emptyList();
    }

    int calculateEndDate(int start, int duration) {
        return start + duration;
    }

}