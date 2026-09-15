
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AssignmentManager {
    private List<Assignment> assignments;
    private FileHandler fileHandler;
    private int nextId;

    public AssignmentManager(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        this.assignments = fileHandler.loadAssignments();

        nextId = 1;

        for (Assignment assignment : assignments) {
            if (assignment.getId() >= nextId) {
                nextId = assignment.getId() + 1;
            }
        }
    }

    public void addAssignment(String title, String subject,
                              LocalDate deadline, String priority) {

        Assignment assignment = new Assignment(
                nextId++, title, subject, deadline, priority, false
        );

        assignments.add(assignment);
        fileHandler.saveAssignments(assignments);
    }

    public List<Assignment> getAssignments() {
        return new ArrayList<>(assignments);
    }

    public boolean markCompleted(int id) {
        for (Assignment assignment : assignments) {
            if (assignment.getId() == id) {
                assignment.setCompleted(true);
                fileHandler.saveAssignments(assignments);
                return true;
            }
        }

        return false;
    }

    public boolean deleteAssignment(int id) {
        boolean removed = assignments.removeIf(
                assignment -> assignment.getId() == id
        );

        if (removed) {
            fileHandler.saveAssignments(assignments);
        }

        return removed;
    }

    public int getCompletedCount() {
        int count = 0;

        for (Assignment assignment : assignments) {
            if (assignment.isCompleted()) {
                count++;
            }
        }

        return count;
    }
}
