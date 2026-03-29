public class Task {
    private String title;
    private String priority;
    private boolean isCompleted;

    public Task(String title, String priority) {
        this.title = title;
        this.priority = priority;
        this.isCompleted = false;
    }

    public String getTitle() {
        return title;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return title + " [" + priority + "] - " + (isCompleted ? "Completed" : "Pending");
    }
}