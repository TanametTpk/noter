package th.ku.noter.source;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserNote implements Queriable {

    private String u_id;
    private String n_id;
    private String c_id;
    private int star;
    private int pin;

    public UserNote(String u_id, String n_id, String c_id, int star, int pin) {
        this.u_id = u_id;
        this.n_id = n_id;
        this.c_id = c_id;
        this.star = star;
        this.pin = pin;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getN_id() {
        return n_id;
    }

    public void setN_id(String n_id) {
        this.n_id = n_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public void insert(PreparedStatement prep) throws SQLException {
        prep.setString(1 , this.getU_id());
        prep.setString(2 , this.getN_id());
        prep.setString(3 , this.getC_id());
        prep.setInt(4 , this.getStar());
        prep.setInt(5 , this.getPin());
    }

    @Override
    public void update(PreparedStatement prep) throws SQLException {
        prep.setString(3 , this.getU_id());
        prep.setString(4 , this.getN_id());
        prep.setString(5 , this.getC_id());
        prep.setInt(1 , this.getStar());
        prep.setInt(2 , this.getPin());
    }

    @Override
    public void delete(PreparedStatement prep) throws SQLException {
        prep.setString(1 , this.getU_id());
        prep.setString(2 , this.getN_id());
        prep.setString(3 , this.getC_id());
    }
}
