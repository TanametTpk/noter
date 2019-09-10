package th.ku.noter.source;

public class Note {

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
}
