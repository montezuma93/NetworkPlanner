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

    public void printToConsole(){
        for (int i = 0; i < this.getAssignments().size(); i++) {
            Assignment assignment = this.getAssignments().get(i);
            System.out.println("-------------------------------");
            System.out.println("FAZ: " + assignment.getEarliestStartDate() + "     " + assignment.name +"    FEZ:" + " "+ assignment.getEarliestEndDate()+"  ");
            System.out.println("              " + this.getAssignments().get(i).getDuration()+"               ");
            System.out.println("SAZ: " + assignment.getLatestStartDate() + "                 SEZ: " + assignment.getLatestEndDate()+"  ");
            System.out.println("-------------------------------");
            System.out.println(" ");
        }
    }
}
