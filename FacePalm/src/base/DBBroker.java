/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import exceptions.UserDoesNotExistException;
import exceptions.UserNameAndPasswordDoNotMatchException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logic.GetAreaOfInterest;
import model.AreaOfInterest;
import model.FPUser;
import model.Message;
import model.Status;
import model.UserProfile;
import model.userProfiles.FactoryMethodUserProfile;

/**
 *
 * @author Jelena
 */
public class DBBroker {

    private Connection connection;
    private static DBBroker instance;
    private String serverName = "localhost"; 
    private String mydatabase = "facepalm"; 
    private final String url = "jdbc:mysql://" + serverName + ":3306/" + mydatabase; 
    private String username = "root"; 
    private String password = ""; 
    private final String driver= "com.mysql.jdbc.Driver";
   
    private DBBroker() throws ClassNotFoundException,SQLException{
        loadDriver(driver);
    }
    public static DBBroker getinstance() throws SQLException, ClassNotFoundException{
        if(instance == null) instance = new DBBroker();
        return instance;
    }
    
    private void loadDriver(String nameOfDriver) throws ClassNotFoundException{
        Class.forName(nameOfDriver);
    }
    
    private void setConnection() throws SQLException{
        connection = DriverManager.getConnection(url,username,password);
    }
    private void closeConnecstion() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public List<FPUser> getAllFPUsers() throws SQLException, Exception{
        setConnection();
        String query = "select * from fpuser";
        Statement dbstatement = connection.createStatement();
        ResultSet rs = dbstatement.executeQuery(query);

        List<FPUser> lfpuUsers = new ArrayList<FPUser>();
        while (rs.next()) {
            String usernamee= rs.getString("username");
            String passwordd=rs.getString("password");
            String firstName=rs.getString("firstname");
            String lastName=rs.getString("lastname");
            char sex=(rs.getString("sex").charAt(0));
            String email=rs.getString("email");
            String avatar= rs.getString("avatar");
            String aoi1= rs.getString("aoi1");
            String aoi2= rs.getString("aoi2");
            String aoi3= rs.getString("aoi3");
            UserProfile userprofile= new FactoryMethodUserProfile().getUserProfile(avatar, aoi1, aoi2, aoi3);

            FPUser fPUser= new FPUser(usernamee, passwordd, firstName, lastName, sex, email, userprofile);
            System.out.println(fPUser);
            lfpuUsers.add(fPUser);
        }
        closeConnecstion();
        return lfpuUsers;
    }

    public FPUser getUser(String username) throws SQLException,UserDoesNotExistException, Exception{
        setConnection();
        
        String sqlQuery = "select * from fpuser where username=?";
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery(); 
        FPUser fPUser=null;
        
          while (rs.next()) {
            String usernamee= rs.getString("username");
            String passwordd=rs.getString("password");
            String firstName=rs.getString("firstname");
            String lastName=rs.getString("lastname");
            char sex=(rs.getString("sex").charAt(0));
            String email=rs.getString("email");
            String avatar= rs.getString("avatar");
              System.out.println(avatar);
            String aoi1= rs.getString("aoi1");
            String aoi2= rs.getString("aoi2");
            String aoi3= rs.getString("aoi3");
            UserProfile userprofile= new FactoryMethodUserProfile().getUserProfile(avatar, aoi1, aoi2, aoi3);

            fPUser= new FPUser(usernamee, passwordd, firstName, lastName, sex, email, userprofile);
            System.out.println(fPUser);
        }
      
        closeConnecstion();
        if(fPUser==null) throw  new UserDoesNotExistException();
        
        return fPUser;
    }
    
    public FPUser getUser(String username, String password) throws SQLException, UserNameAndPasswordDoNotMatchException, Exception{
        setConnection();
        String sqlQuery = "select * from fpuser where username=? AND password=? ";
        PreparedStatement ps = connection.prepareStatement(sqlQuery);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery(); 
        FPUser fPUser=null;
        
        while (rs.next()) {
            String usernamee= rs.getString("username");
            String passwordd=rs.getString("password");
            String firstName=rs.getString("firstname");
            String lastName=rs.getString("lastname");
            char sex=(rs.getString("sex").charAt(0));
            String email=rs.getString("email");
            String avatar= rs.getString("avatar");
            String aoi1= rs.getString("aoi1");
            String aoi2= rs.getString("aoi2");
            String aoi3= rs.getString("aoi3");
            UserProfile userprofile= new FactoryMethodUserProfile().getUserProfile(avatar, aoi1, aoi2, aoi3);

            fPUser= new FPUser(usernamee, passwordd, firstName, lastName, sex, email, userprofile);
            System.out.println(fPUser);
        }
        closeConnecstion();
        if(fPUser==null) throw  new UserNameAndPasswordDoNotMatchException();
        
        return fPUser;
        
        
    }
    
    public void saveFPUser(FPUser fpuser) throws SQLException {
        setConnection();
        String query = "INSERT INTO fpuser(username, password, firstName, lastName, sex, email, avatar, aoi1, aoi2, aoi3) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        
        preparedStatement.setString(1, fpuser.getUsername());
        preparedStatement.setString(2, fpuser.getPassword());
        preparedStatement.setString(3, fpuser.getFirstName());
        preparedStatement.setString(4,fpuser.getLastName());
        preparedStatement.setString(5,String.valueOf(fpuser.getSex()));
        preparedStatement.setString(6,fpuser.getEmail());
        preparedStatement.setString(7,fpuser.getUserProfile().getAvatar().getAvatarName());
        preparedStatement.setString(8,(fpuser.getUserProfile().getAreasOfInterest().get(0).getAreaName()));
        preparedStatement.setString(9,(fpuser.getUserProfile().getAreasOfInterest().get(1).getAreaName()));
        preparedStatement.setString(10,(fpuser.getUserProfile().getAreasOfInterest().get(2).getAreaName()));
        
        preparedStatement.executeUpdate();
        closeConnecstion();
    }

    public void checkUser(FPUser fPUser) throws SQLException, Exception{
        List<FPUser> baseList= getAllFPUsers();
            if(baseList.contains(fPUser))
                throw new Exception("Vec ste registrovani");
       
    }
    
    public void saveStatuus(Status status) throws SQLException {
        setConnection();
        String query = "INSERT INTO status(statustext,nostatuslike,nostatusfacepalm,statususer,statusareaofinterest) VALUES (?,?,?,?,?)";
        
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        
        preparedStatement.setString(1, status.getStatusText());
        preparedStatement.setInt(2, status.getNoLike());
        preparedStatement.setInt(3, status.getNofacePalm());
        preparedStatement.setString(4,status.getFpuser().getUsername());
        preparedStatement.setString(5,status.getAreaOfInterest().getAreaName());
        
        preparedStatement.executeUpdate();
        closeConnecstion();
    }
    
    public List<Status> getAllStatus() throws SQLException, Exception{
        setConnection();
        List<Status> statuses= new ArrayList<Status>();
        String query = "select * from status";
        Statement dbstatement = connection.createStatement();
        ResultSet rs = dbstatement.executeQuery(query);

        while (rs.next()) {
            FPUser fpuser=getUser(rs.getString("statususer"));
            String statusText= rs.getString("statustext");
            AreaOfInterest areaOfInterest= GetAreaOfInterest.getAreaOfInterest(rs.getString("statusareaofinterest"));
            System.out.println(areaOfInterest);
            int noLike= rs.getInt("nostatuslike");
            int nofacePalm=rs.getInt("nostatusfacepalm");
            Status status = new Status(fpuser, statusText, areaOfInterest, noLike, nofacePalm);
            statuses.add(status);
        }
        closeConnecstion();
        return statuses;
    }

    public List<Message> getAllMesages() {
        List<Message> messages = new ArrayList<Message>();
        
        
        
        return messages;
    }

    public void checkAvailability(String username) throws SQLException, Exception {
        List<FPUser> baseList= getAllFPUsers();
        for (FPUser fPUser : baseList) {
            if(fPUser.getUsername().equals(username))
                throw new Exception("Ovo korisničko ime već postoji, izaberite neko drugo");
        }
        }

    public void updateStatus(Status status) throws SQLException {
        
        setConnection();
        String query= "UPDATE status SET nostatuslike=?,nostatusfacepalm=?,statususer=?,statusareaofinterest=? WHERE statustext=?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, status.getNoLike());
        preparedStatement.setInt(2, status.getNofacePalm());
        preparedStatement.setString(3,status.getFpuser().getUsername());
        preparedStatement.setString(4,status.getAreaOfInterest().getAreaName());
        preparedStatement.setString(5, status.getStatusText());
        
        preparedStatement.executeUpdate();
        closeConnecstion();
    
    }
   
}


