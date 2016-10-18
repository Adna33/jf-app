package eestec.jobfairapp;

import android.graphics.Bitmap;

/**
 * Created by XMAN on 8.10.2016.
 */
public class News {

    String name;
    String description;
    String content;
    Bitmap image;

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public News(String name, String description, String content, Bitmap image) {
        super();
        this.name = name;
        this.description = description;
        this.content = content;
        this.image = image;
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
