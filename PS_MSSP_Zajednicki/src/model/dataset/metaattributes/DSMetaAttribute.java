/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataset.metaattributes;

import model.dataset.Dataset;

/**
 *
 * @author Jelena
 */
public interface DSMetaAttribute  {
    public double calculate(Dataset dataSet);
    public void register();
    public String getName();
    public double getValue();
}
