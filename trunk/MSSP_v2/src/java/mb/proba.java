/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import ejb.CallEJB;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Administrator;
import model.dataset.Dataset;
import to.DataSetTO;

/**
 *
 * @author Jelena
 */
@Named(value = "proba")
@Dependent
public class proba {

    
    Dataset updatedataset;
   
    List<Dataset> allADatasets = new ArrayList<Dataset>();
    
    /**
     * Creates a new instance of proba
     */
    public proba() {
        updatedataset= new  Dataset();
    }

    public List<Dataset> getAllADatasets() {
        allADatasets=getDssTO();
        return allADatasets;
    }

    public Dataset getUpdatedataset() {
        return updatedataset;
    }

    public void setAllADatasets(List<Dataset> allADatasets) {
        this.allADatasets = allADatasets;
    }

    public void setUpdatedataset(Dataset updatedataset) {
        this.updatedataset = updatedataset;
    }
    
    public String updateDS(){
        if(updatedataset!=null&&updatedataset.getTitle()!=null){
                 CallEJB.getInstance().getSBdataset().updateDataset(updatedataset);
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Administrator " + updatedataset.getTitle() + " has been successfully updated! :)"));
                 updatedataset= new Dataset();
        }
        
        return "./indexAdmin.xhtml";
    }
 public List<Dataset> getDatasets() {
        List<Dataset> sviAdministratori = CallEJB.getInstance().getSBdataset().getAllDatasets();
        return sviAdministratori;
    }
public String update(){
    return "./updateDataset.xhtml";
}

public List<Dataset> getDssTO(){
        List<Dataset> dslist = new ArrayList<Dataset>();
        List<DataSetTO> dslistTO = CallEJB.getInstance().getSBdataset().getAllDatasetsTO();
        for (DataSetTO dsto : dslistTO) {
            dslist.add(new Dataset(dsto));
        }
        return dslist;
    }
 
}
