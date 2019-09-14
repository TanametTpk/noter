package th.ku.noter.source;

import java.sql.PreparedStatement;

public class Note implements Queriable {

    private String id;
    private String content;
    private boolean star;
    private boolean pin;

    public Note(String id, String content, boolean star, boolean pin) {
        this.id = id;
        this.content = content;
        this.star = star;
        this.pin = pin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStar() {
        return star;
    }

    public void setStar(boolean star) {
        this.star = star;
    }

    public boolean isPin() {
        return pin;
    }

    public void setPin(boolean pin) {
        this.pin = pin;
    }

    @Override
    public void update(PreparedStatement prep) {

    }
}
