package todo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by dmitry on 10.02.16.
 * It's test home projects
 */
@XmlRootElement
public class Todo {
    private int id;
    private String summary;
    private String description;

    public Todo() {
    }

    public Todo(int id, String summary, String description) {
        this.id = id;
        this.summary = summary;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
