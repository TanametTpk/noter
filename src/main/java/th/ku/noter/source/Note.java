package th.ku.noter.source;

import java.sql.PreparedStatement;

public class Note implements Queriable {

    private String id;
    private String content;

    public Note(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    @Override
    public void update(PreparedStatement prep) {

    }
}
