/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.HashMap;
import java.util.Properties;
import javax.naming.InitialContext;
import logic.SeassionBeanAdministratorLocal;
import logic.SessionBeanDatasetLocal;
import logic.SessionBeanSimilarity;
import logic.SessionBeanSimilarityLocal;

/**
 *
 * @author Jelena
 */
public class CallEJB {

    private static CallEJB instance;
    private HashMap<String, Object> mapa = new HashMap<String, Object>();

    private CallEJB() {
        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial",
                "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("java.naming.factory.url.pkgs",
                "com.sun.enterprise.naming");
        props.setProperty("java.naming.factory.state",
                "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        try {
            InitialContext ctx = new InitialContext(props);


            SessionBeanDatasetLocal SBdataset = (SessionBeanDatasetLocal) ctx.lookup("java:global/SPiESEE/EJBSPiES/SessionBeanDataset");
            //SessionBeanDatasetLocal SBdataset = (SessionBeanDatasetLocal) ctx.lookup("java:comp/env/SessionBeanDataset");
            mapa.put("SBdataset", SBdataset);
            SeassionBeanAdministratorLocal SBadmin = (SeassionBeanAdministratorLocal) ctx.lookup("java:global/SPiESEE/EJBSPiES/SeassionBeanAdministrator");
            //SeassionBeanAdministratorLocal SBadmin = (SeassionBeanAdministratorLocal) ctx.lookup("java:comp/env/SeassionBeanAdministrator");
            mapa.put("SBadmin", SBadmin);
            SessionBeanSimilarityLocal SBSimilarity = (SessionBeanSimilarityLocal) ctx.lookup("java:global/SPiESEE/EJBSPiES/SessionBeanSimilarity");
            mapa.put("SBSimilarity", SBSimilarity);
        } catch (Exception e) {
            System.err.println("GRESKA: " + e.getMessage());
            e.printStackTrace();
        }


    }

    public static CallEJB getInstance() {
        if (instance == null) {
            instance = new CallEJB();
        }
        return instance;

    }

    public SeassionBeanAdministratorLocal getSBadmin() {
        return (SeassionBeanAdministratorLocal) mapa.get("SBadmin");
    }

    public SessionBeanDatasetLocal getSBdataset() {
        return (SessionBeanDatasetLocal) mapa.get("SBdataset");
    }
    public SessionBeanSimilarityLocal getSBSimilarity() {
        return (SessionBeanSimilarityLocal) mapa.get("SBSimilarity");
    }
}
