package th.ku.noter;

import java.sql.*;
import java.util.List;

public class SqliteConnector {

    private String url;
    private Connection c;
    private static SqliteConnector sqlite = new SqliteConnector();

    public SqliteConnector(){

        this.url = "jdbc:sqlite:noter.db";
        this.c = connect();

    }

    public static SqliteConnector getInstance(){
        return sqlite;
    }

    private Connection connect(){

        Connection conn = null;

        try{
            Class.forName("org.sqlite.JDBC");
            conn =  DriverManager.getConnection(this.url);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;

    }

    public ResultSet execute(String query){

        try{

            Statement stmt = c.createStatement();
            ResultSet re = stmt.executeQuery(query);
            return re;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    public void update(String query , List<Dao> dummies){

        try(PreparedStatement prep = c.prepareStatement(query) ){

            for (Dao dummy : dummies) {
                dummy.update(prep);
                prep.addBatch();
            }

            c.setAutoCommit(false);
            prep.executeBatch();
            c.setAutoCommit(true);

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

}
