/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import logic.SO.Import_Export.CSVExportDSToFile;
import model.dataFormat.CSVFormat;
import model.dataFormat.DataFormat;
import model.dataset.DataSet;
/**
 *
 * @author Djordje
 */
public class ControllerAL_DSExport {
    
    private ControllerAL_DSExport() {
    }
    
    public static ControllerAL_DSExport getInstance() {
        return ControllerAL_DSExportHolder.INSTANCE;
    }
    
    private static class ControllerAL_DSExportHolder {

        private static final ControllerAL_DSExport INSTANCE = new ControllerAL_DSExport();
    }
    
    public void exportDS (DataFormat dataFormat, DataSet ds) throws Exception {
        CSVExportDSToFile exporter = new CSVExportDSToFile();
        exporter.export(ds, (CSVFormat)dataFormat);
    }
    
}
