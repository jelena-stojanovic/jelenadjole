/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.avatars;

import javax.swing.ImageIcon;
import model.Avatar;

/**
 *
 * @author Jelena
 */
public class FyeaAvatar extends Avatar{

    @Override
    public String getAvatarName() {
        return "F yea";
    }

    @Override
    public ImageIcon getAvatarImg() {
        return new ImageIcon(getClass().getResource("/gui/pictures/fyea.png"));
    }

    
}
