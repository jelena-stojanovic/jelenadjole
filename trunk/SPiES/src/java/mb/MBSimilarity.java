/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import ejb.CallEJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
@Named(value = "mbsimilarity")
@Dependent
public class MBSimilarity {

    Dataset[] dss;
    Dataset ds1;
    Dataset ds2;
    String similaritymeasure;

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
//       if(dss.length>=2){
//        ds1=dss[0];
//        ds2=dss[1];
//        if (ds1 != null && ds2 != null) {
//            double calculateSimilarityD = CallEJB.getInstance().getSBSimilarity().calculateSimilarity(ds1, ds2, similaritymeasure);
//            return String.valueOf(calculateSimilarityD);
//        }}
        return "Ne radi jos";
    }
}
