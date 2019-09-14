package th.ku.noter.request;

import th.ku.noter.source.Note;

public class NoteReq {

    private Note note;
    private String userId;
    private String collectionId;

    public NoteReq(Note note, String userId, String collectionId) {
        this.note = note;
        this.userId = userId;
        this.collectionId = collectionId;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }
}
