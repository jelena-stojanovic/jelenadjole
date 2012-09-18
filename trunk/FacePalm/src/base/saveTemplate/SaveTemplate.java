/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package base.saveTemplate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jelena
 */
public abstract class SaveTemplate {
    protected Connection connection;
    protected String serverName = "localhost"; 
    protected String mydatabase = "facepalm"; 
    protected String url = "jdbc:mysql://" + serverName + ":3306/" + mydatabase; 
    protected String username = "root"; 
    protected String password = ""; 
    protected String driver= "com.mysql.jdbc.Driver";
   
    public void save(Object o) throws SQLException, ClassNotFoundException{
        openConnection();
        execute(o);
        closeConnection();
    }
    
    private void openConnection() throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection(url,username,password);
    }
    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    public abstract  void execute(Object o) throws SQLException;
}
