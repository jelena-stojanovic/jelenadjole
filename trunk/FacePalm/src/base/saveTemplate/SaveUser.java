/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package base.saveTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.FPUser;

/**
 *
 * @author Jelena
 */
public class SaveUser extends SaveTemplate{

    @Override
    public void execute(Object o) throws SQLException {
        FPUser fpuser= (FPUser) o;
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
    }
    
}
