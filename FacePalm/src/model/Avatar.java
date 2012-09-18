/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import javax.swing.ImageIcon;

/**
 *
 * @author Jelena
 */
abstract public class Avatar {
    private String avatarName;
    private ImageIcon avatarImg;

    abstract public String getAvatarName();

    abstract public ImageIcon getAvatarImg() ;
   
    
}
