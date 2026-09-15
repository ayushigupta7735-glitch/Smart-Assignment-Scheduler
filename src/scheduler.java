import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Scheduler {

    public List<Assignment> generateSchedule(
            List<Assignment> assignments) {

        List<Assignment> schedule = new ArrayList<>();

        for (Assignment assignment : assignments) {

            if (!assignment.isCompleted()) {
                schedule.add(assignment);
            }
        }

        schedule.sort(
            Comparator
                .comparingInt(
                    (Assignment a) ->
                        priorityScore(a.getPriority())
                )
                .reversed()
                .thenComparing(Assignment::getDeadline)
        );

        return schedule;
    }

    private int priorityScore(String priority) {

        if (priority.equalsIgnoreCase("HIGH")) {
            return 3;
        }

        if (priority.equalsIgnoreCase("MEDIUM")) {
            return 2;
        }

        return 1;
    }

    public String getStatus(Assignment assignment) {

        long daysLeft =
                java.time.temporal.ChronoUnit.DAYS.between(
                        LocalDate.now(),
                        assignment.getDeadline()
                );

        if (daysLeft <= 1) {
            return "URGENT";
        }

        if (daysLeft <= 3) {
            return "DO SOON";
        }

        if (daysLeft <= 7) {
            return "THIS WEEK";
        }

        return "PLANNED";
    }
}
