/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author Jelena
 */
public class Status{

    private FPUser fpuser;
    private String statusText;
    private AreaOfInterest areaOfInterest;
    private int noLike;
    private int nofacePalm;

    public Status(FPUser fpuser, String statusText, AreaOfInterest areaOfInterest, int noLike, int nofacePalm) {
        this.fpuser = fpuser;
        this.statusText = statusText;
        this.areaOfInterest = areaOfInterest;
        this.noLike = noLike;
        this.nofacePalm = nofacePalm;
    }

    /**
     * @return the fpuser
     */
    public FPUser getFpuser() {
        return fpuser;
    }

    /**
     * @param fpuser the fpuser to set
     */
    public void setFpuser(FPUser fpuser) {
        this.fpuser = fpuser;
    }

    /**
     * @return the statusText
     */
    public String getStatusText() {
        return statusText;
    }

    /**
     * @param statusText the statusText to set
     */
    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    /**
     * @return the areaOfInterest
     */
    public AreaOfInterest getAreaOfInterest() {
        return areaOfInterest;
    }

    /**
     * @param areaOfInterest the areaOfInterest to set
     */
    public void setAreaOfInterest(AreaOfInterest areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

    /**
     * @return the noLike
     */
    public int getNoLike() {
        return noLike;
    }

    /**
     * @param noLike the noLike to set
     */
    public void setNoLike(int noLike) {
        this.noLike = noLike;
    }

    /**
     * @return the nofacePalm
     */
    public int getNofacePalm() {
        return nofacePalm;
    }

    /**
     * @param nofacePalm the nofacePalm to set
     */
    public void setNofacePalm(int nofacePalm) {
        this.nofacePalm = nofacePalm;
    }

    @Override
    public String toString() {
        return "Status{" + "fpuser=" + fpuser + ", statusText=" + statusText + ", areaOfInterest=" + areaOfInterest + ", noLike=" + noLike + ", nofacePalm=" + nofacePalm + '}';
    }
    
    
    
}
