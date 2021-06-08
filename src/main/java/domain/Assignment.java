package domain;

import java.util.List;

public class Assignment {

    private int earliestStartDate;
    private int latestStartDate;
    private int earliestEndDate;
    private int latestEndDate;

    private int duration;

    private List<Assignment> predecessors;
    private List<Assignment> successors;

    public Assignment(int duration, List<Assignment> predecessors, List<Assignment> successors) {
        this.duration = duration;
        this.predecessors = predecessors;
        this.successors = successors;
    }

    public int getEarliestStartDate() {
        return earliestStartDate;
    }

    public void setEarliestStartDate(int earliestStartDate) {
        this.earliestStartDate = earliestStartDate;
    }

    public int getLatestStartDate() {
        return latestStartDate;
    }

    public void setLatestStartDate(int latestStartDate) {
        this.latestStartDate = latestStartDate;
    }

    public int getEarliestEndDate() {
        return earliestEndDate;
    }

    public void setEarliestEndDate(int earliestEndDate) {
        this.earliestEndDate = earliestEndDate;
    }

    public int getLatestEndDate() {
        return latestEndDate;
    }

    public void setLatestEndDate(int latestEndDate) {
        this.latestEndDate = latestEndDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Assignment> getPredecessors() {
        return predecessors;
    }

    public void setPredecessors(List<Assignment> predecessors) {
        this.predecessors = predecessors;
    }

    public List<Assignment> getSuccessors() {
        return successors;
    }

    public void setSuccessors(List<Assignment> successors) {
        this.successors = successors;
    }
}
