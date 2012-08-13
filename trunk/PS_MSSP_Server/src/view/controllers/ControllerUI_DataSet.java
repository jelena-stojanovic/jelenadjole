/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controllers;

import java.awt.Color;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import model.Reference;
import model.dataset.DataSet;
import model.dataset.Source;
import view.panels.datasets.FrmDataSet;

/**
 *
 * @author Djordje
 */
public class ControllerUI_DataSet extends OpstiKontrolerKI {

    FrmDataSet frmDataSet;
    ArrayList<Reference> references = new ArrayList<Reference>();

    public ControllerUI_DataSet(FrmDataSet pnlDataSet) throws IOException {
        oef = pnlDataSet;
        frmDataSet = (FrmDataSet) oef;
    }

    @Override
    public void KonvertujGrafickiObjekatUDomenskiObjekat() {
        DataSet dataSet = (DataSet) odo;
        Reference reference = new Reference();
        Source source = new Source();
        dataSet.setTitle(KonverterTipova.Konvertuj(frmDataSet.getTxtFieldDataSetTitle(), dataSet.getTitle()));
        dataSet.setDsDescription(KonverterTipova.Konvertuj(frmDataSet.getTxtAreaDescription(), dataSet.getDsDescription()));
        source.setCreator(KonverterTipova.Konvertuj(frmDataSet.getTfCreator(), source.getCreator()));
        source.setDonor(KonverterTipova.Konvertuj(frmDataSet.getTfDonor(), source.getDonor()));
        try {
            source.setDate(KonverterTipova.Konvertuj(frmDataSet.getTfDateDS(), source.getDate()));
        } catch (ParseException ex) {
            frmDataSet.getTfDateDS().setBackground(Color.red);
        }
//        reference.setAuthor(KonverterTipova.Konvertuj(frmDataSet.getTfAuthors(), reference.getAuthor()));
//        reference.setLocation(KonverterTipova.Konvertuj(frmDataSet.getTfLocation(), reference.getLocation()));
//        reference.setTitle(KonverterTipova.Konvertuj(frmDataSet.getTfTitle(), reference.getTitle()));
//        try {
//            reference.setDate(KonverterTipova.Konvertuj(frmDataSet.getTfDate(), reference.getDate()));
//        } catch (ParseException ex) {
//            JOptionPane.showMessageDialog(frmDataSet, "Unesite datum u \"MM/dd/yyyy\"  formatu.");
//            frmDataSet.getTfDate().setBorder(new EtchedBorder(Color.red, Color.black));
//        }
//        reference.setOtherInformation(KonverterTipova.Konvertuj(frmDataSet.getTfOtherInformation(), reference.getOtherInformation()));
        dataSet.setSource(source);
        dataSet.setReferences(references);
    }

    @Override
    public void KonvertujDomenskiObjekatUGrafickiObjekat() {
       DataSet dataSet = (DataSet) odo;
       KonverterTipova.Konvertuj(dataSet.getTitle(), frmDataSet.getTxtFieldDataSetTitle());
       KonverterTipova.Konvertuj(dataSet.getDsDescription(), frmDataSet.getTxtAreaDescription());
       KonverterTipova.Konvertuj(dataSet.getSource().getCreator(), frmDataSet.getTfCreator());
       KonverterTipova.Konvertuj(dataSet.getSource().getDonor(), frmDataSet.getTfDonor());
       KonverterTipova.Konvertuj(dataSet.getSource().getDate(), frmDataSet.getTfDateDS());
       KonverterTipova.Konvertuj(dataSet.getReferences(), frmDataSet.getListReferences());
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
}
