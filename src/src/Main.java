import java.time.LocalDate;

public class Assignment {
    private int id;
    private String title;
    private String subject;
    private LocalDate deadline;
    private String priority;
    private boolean completed;

    public Assignment(int id, String title, String subject,
                      LocalDate deadline, String priority, boolean completed) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.deadline = deadline;
        this.priority = priority;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String toFileString() {
        return id + "|" + title + "|" + subject + "|" + deadline + "|" +
               priority + "|" + completed;
    }

    @Override
    public String toString() {
        return id + ". " + title + " | " + subject +
               " | Deadline: " + deadline +
               " | Priority: " + priority +
               " | " + (completed ? "Completed" : "Pending");
    }
}
