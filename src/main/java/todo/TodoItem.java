package todo;

import org.springframework.data.annotation.Id;

public class TodoItem {

    @Id
    private String id;
    private final String title;
    private boolean complete;

    public TodoItem(String title, boolean complete) {
        this.title = title;
        this.complete = complete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getComplete() {
        return complete;
    }
}