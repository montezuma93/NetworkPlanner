//Das ist ein Test-Kommentar
//Kommentar von Emilia
package service;

import domain.Assignment;

import java.util.List;

public class Networkplan {



    private List<Assignment> assignments;

    public Networkplan(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}
