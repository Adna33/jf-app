package eestec.jobfairapp;

/**
 * Created by XMAN on 8.10.2016.
 */
public class News {

    String name;
    String description;
    String content;


    public News(String name, String description, String content) {
        super();
        this.name = name;
        this.description = description;
        this.content = content;
    }
    public News(String name) {
        super();
        this.name = name;
    }

    public News() { super(); }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }


}
