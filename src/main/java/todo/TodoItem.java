package todo;

public class TodoItem {

    private int id;
    private final String title;
    private boolean complete;

    public TodoItem(int id, String title, boolean complete) {
        this.id = id;
        this.title = title;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getComplete() {
        return complete;
    }
}