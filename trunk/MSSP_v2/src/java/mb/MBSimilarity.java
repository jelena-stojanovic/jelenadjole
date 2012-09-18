/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import ejb.CallEJB;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
@ManagedBean(name = "mbsimilarity")
@SessionScoped
public class MBSimilarity  implements Serializable{

    Dataset[] dss;
    Dataset ds1;
    Dataset ds2;
    String similaritymeasure;
    Dataset[] selecteddatasets;

    /**
     * Creates a new instance of MBSimilarity
     */
    public MBSimilarity() {
        ds1 = new Dataset();
        ds2 = new Dataset();
        
    }
    

    public Dataset getDs1() {
        return ds1;
    }

    public Dataset getDs2() {
        return ds2;
    }

    public void setDs1(Dataset ds1) {
        this.ds1 = ds1;
    }

    public void setDs2(Dataset ds2) {
        this.ds2 = ds2;
    }

    public Dataset[] getDss() {
        return dss;
    }

    public void setDss(Dataset[] dss) {
        this.dss = dss;
    }

    
    
    public String getSimilaritymeasure() {
        return similaritymeasure;
    }

    public void setSimilaritymeasure(String similaritymeasure) {
        this.similaritymeasure = similaritymeasure;
    }

    public String calculateSimilarityMeasure() {
       if(dss!=null&&dss.length>=2){
        ds1=dss[0];
           System.out.println(ds1.getTitle());
        ds2=dss[1];
        System.out.println(ds2.getTitle());
           System.out.println("SIm m is:"+similaritymeasure);
        if (ds1 != null && ds2 != null) {
            double calculateSimilarityD = CallEJB.getInstance().getSBSimilarity().calculateSimilarity(ds1, ds2, similaritymeasure);
            System.out.println("Similarity is:"+calculateSimilarityD);
            return String.valueOf(calculateSimilarityD);
        }}
        return "Ne radi jos";
    }
    
    public String measure(){
        if(similaritymeasure!=null){
        if(similaritymeasure.equalsIgnoreCase("1")) {
            return "Cosine Similarity";
        }
        return "Euclidian Similarity";
        } return "";
    }
}
