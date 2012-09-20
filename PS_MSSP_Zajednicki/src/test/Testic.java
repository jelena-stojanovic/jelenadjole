/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dataset.MetaAttributesAndStatisticsColection;

/**
 *
 * @author Jelena
 */
public class Testic {

    public static void main(String[] args) {

//        JOptionPane.showMessageDialog(null, "Систем не може да израчуна сличност скупова података", "Greska", JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Систем не може да нађе скуп података по задатој вредности", "Greska", JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Систем не може да обради скуп података", "Greska", JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Систем не може да креира скуп података", "Greska", JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Систем не може да запамти скуп података", "Greska", JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Систем не може да сачува скуп података на задатој локацији", "Greska", JOptionPane.ERROR_MESSAGE);
//        


        
        System.out.println("nesto");
        File path = new File("C:\\Users\\Jelena\\Documents\\NetBeansProjects\\MSSP_v2\\web");
        System.out.println("path");
        File[] files = path.listFiles();
        System.out.println(files.length);
        for (int i = 0; i < files.length; i++) {

            if (files[i].isFile()) { //this line weeds out other directories/folders
                System.out.println(files[i]);
            } else {
                File[] files1 = files[i].listFiles();

                for (int j = 0; j < files1.length; j++) {

                    if (files1[j].isFile()) { //this line weeds out other directories/folders
                        if (!files1[j].getPath().contains("svn")) {
                            System.out.println(files1[j]);
                        }
                    } else {

                        File[] files2 = files1[j].listFiles();
                        for (int k = 0; k < files2.length; k++) {

                            if (files2[k].isFile()) { //this line weeds out other directories/folders
                                if (!files2[k].getPath().contains("svn")&&!files2[k].getPath().contains("form")) {
                                    System.out.println(files2[k]);
                                }
                            } else {
                                File[] files3 = files2[k].listFiles();
                                for (int s = 0; s < files3.length; s++) {

                                    if (files3[s].isFile()) { //this line weeds out other directories/folders
                                        if (!files3[s].getPath().contains("svn")&&!files3[s].getPath().contains("form")) {
                                            System.out.println(files3[s]);
                                        }
                                    } else {
                                        File[] files4 = files3[s].listFiles();
                                        for (int p = 0; p < files4.length; p++) {

                                            if (files4[p].isFile()) { //this line weeds out other directories/folders
                                                if (!files4[p].getPath().contains("svn")&&!files4[p].getPath().contains("form")) {
                                                    System.out.println(files4[p]);
                                                }
                                            } else {
                                                File[] files5 = files4[p].listFiles();
                                                for (int m = 0; m < files5.length; m++) {

                                                    if (files5[m].isFile()) { //this line weeds out other directories/folders
                                                        if (!files5[m].getPath().contains("svn")&&!files5[m].getPath().contains("form")) {
                                                            System.out.println(files5[m]);
                                                        }
                                                    } else {
                                                        File[] files6 = files5[m].listFiles();
                                                        for (int l = 0; l < files6.length; l++) {

                                                            if (files6[l].isFile()) { //this line weeds out other directories/folders
                                                                if (!files6[l].getPath().contains("svn")&&!files6[l].getPath().contains("form")) {
                                                                    System.out.println(files6[l]);
                                                                }
                                                            } else {
                                                                File[] files7 = files6[l].listFiles();
                                                                for (int b = 0; b < files7.length; b++) {

                                                                    if (files7[b].isFile()) { //this line weeds out other directories/folders
                                                                        if (!files7[b].getPath().contains("svn")&&!files7[b].getPath().contains("form")) {
                                                                            System.out.println(files7[b]);
                                                                        }
                                                                    } else {
                                                                        System.out.println("Stigao do sedmog nivoa, ima jos foldera");
                                                                    }
                                                                }
                                                            }
                                                        }

                                                    }
                                                }

                                            }
                                        }
                                    }


                                }
                            }


                        }
                    }
                }
            }

//        
//        String[] availableMetaAttributeImplementationClassNames = MetaAttributesAndStatisticsColection.getInstance().getAvailableMetaAttributeImplementationClassNames();
//       for (String statclass : availableMetaAttributeImplementationClassNames) {
//            System.out.println(statclass);
//        }

//        
//        PrintWriter out = null;
//        try {
//            /*   double[] niz= {1,2,3,4,5,6,7,8,9,3,2,3,2,3,3,3,3,3};
//            for (int i = 0; i < niz.length; i++) {
//            double d = niz[i];
//            System.out.println(d);
//            }
//            HashMap<String, Double> statistic= new CalculatedNumericalStatistics().getValues(niz);
//            for (Map.Entry<String, Double> entry : statistic.entrySet()) {
//            String numericalStatistic = entry.getKey();
//            Double double1 = entry.getValue();
//            System.out.println(numericalStatistic+"="+double1);
//            }
//             */
//            double[][] dmds= new double[2][3];
//            dmds[0][0]=1.0;
//            dmds[0][1]=2.0;
//            dmds[0][2]=3.0;
//            dmds[1][0]=4.0;
//            dmds[1][1]=5.0;
//            dmds[1][2]=6.0;
//            out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\Jelena\\Desktop\\jelena.csv")));
//            //int noOfColums= dataset.getDataTable().getNumColums();
//            //int noOfRows= dataset.getDataTable().getNumRows();
//            double[][] doubleMatrix=dmds;
//            //                               trebalo bi da je broj redova
//            for (int i = 0; i < doubleMatrix.length; i++) {
//                double[] ds = doubleMatrix[i];
//                out.print(String.valueOf(ds[0]));
//                //                      broj kolona
//                for (int j = 1; j < ds.length; j++) {
//                    double d = ds[j];
//                    out.print(','+String.valueOf(d));
//                }
//                out.println();
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Testic.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            out.close();
//        }



        }

    }
}
