/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controllers;

import tools.KonverterTipova;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import model.OpstiDomenskiObjekat;
import model.Reference;
import model.ReferencePK;
import model.dataset.Dataset;
import model.dataset.Source;
import view.forms.OpstaEkranskaForma;
import view.panels.datasets.FrmDataSet;

/**
 *
 * @author Djordje
 */
public class ControllerUI_DataSet extends OpstiKontrolerKI {

    FrmDataSet frmDataSet;
    ArrayList<Reference> references = new ArrayList<Reference>();

    public ControllerUI_DataSet(FrmDataSet pnlDataSet){
        oef = pnlDataSet;
        this.frmDataSet = pnlDataSet;
        
    }

    public void setOdo(OpstiDomenskiObjekat odo) {
        this.odo = odo;
    }

    public void setOef(OpstaEkranskaForma oef) {
        this.oef = oef;
    }

    public void setFrmDataSet(FrmDataSet frmDataSet) {
        this.frmDataSet = frmDataSet;
    }

    
    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        Dataset dataSet = (Dataset) odo;
        Reference reference = new Reference();
        Source source = new Source();
        dataSet.setTitle(KonverterTipova.Konvertuj(frmDataSet.getTxtFieldDataSetTitle(), dataSet.getTitle()));
        dataSet.setDsDescription(KonverterTipova.Konvertuj(frmDataSet.getTxtAreaDescription(), dataSet.getDsDescription()));
        source.setCreator(KonverterTipova.Konvertuj(frmDataSet.getTfCreator(), source.getCreator()));
        source.setDonor(KonverterTipova.Konvertuj(frmDataSet.getTfDonor(), source.getDonor()));
        try {
            source.setSourceDate(KonverterTipova.Konvertuj(frmDataSet.getTfDateDS(), source.getSourceDate()));
        } catch (ParseException ex) {
            frmDataSet.getTfDateDS().setBackground(Color.red);
        }
        dataSet.setSource(source);
        for (int i = 0; i < references.size(); i++) {
            Reference reference1 = references.get(i);
            reference1.setDataset(dataSet);
            ReferencePK refpk= new ReferencePK(i, dataSet.getDataSetID());
            reference1.setReferencePK(refpk);
            
        }
        dataSet.setReferenceList(references);
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
       Dataset dataSet = (Dataset) odo;
       KonverterTipova.Konvertuj(dataSet.getTitle(), frmDataSet.getTxtFieldDataSetTitle());
       KonverterTipova.Konvertuj(dataSet.getDsDescription(), frmDataSet.getTxtAreaDescription());
       KonverterTipova.Konvertuj(dataSet.getSource().getCreator(), frmDataSet.getTfCreator());
       KonverterTipova.Konvertuj(dataSet.getSource().getDonor(), frmDataSet.getTfDonor());
       KonverterTipova.Konvertuj(dataSet.getSource().getSourceDate(), frmDataSet.getTfDateDS());
       KonverterTipova.Konvertuj(dataSet.getReferenceList(), frmDataSet.getListReferences());
    }

    public void addReference() {
        try {
            String author = frmDataSet.getTfAuthors().getText().trim();
            String title = frmDataSet.getTfTitle().getText().trim();
            String location = frmDataSet.getTfLocation().getText().trim();
            String dateS = frmDataSet.getTfDate().getText().trim();
            Date date = null;
            if (dateS != null) {
                date = new SimpleDateFormat("MM/dd/yyyy").parse(dateS);
            }
            String otherInformation = frmDataSet.getTfOtherInformation().getText().trim();

            Reference ref = new Reference(author, title, date, location, otherInformation);
            references.add(ref);
            DefaultListModel dlm = new DefaultListModel();
            for (Reference refer : references) {
                dlm.addElement(refer);
            }
            frmDataSet.getListReferences().setModel(dlm);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frmDataSet, "Unesite datum u \"MM/dd/yyyy\"  formatu.");
            frmDataSet.getTfDate().setBorder(new EtchedBorder(Color.red, Color.black));
        }

    }

    public void updateDS() {
        
        String SOObradi = SOObradi();
        JOptionPane.showMessageDialog(frmDataSet, SOObradi);
    }
}
