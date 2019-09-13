package th.ku.noter.source;

import java.sql.PreparedStatement;

public interface Queriable {

    public void update(PreparedStatement prep);

}
