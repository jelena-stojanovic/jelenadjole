/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataFormat;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Jelena
 */
public class CSVFormat extends DataFormat implements Serializable{

    private File csvFile;
    private boolean useFirstRowAsAttributeNames = true;
    private boolean trimLines = false;
    private boolean skipComments = true;
    private char commentCharacter = '#';
    private boolean useQuotesForNominal = true;
    private char quotesCharacter = '"';
    private char columnSeparator = ',';
    private char escapeCharacterForQuotes = '\\';
    private String datePattern="MM/dd/yyyy";
    public CSVFormat() {
    }

   
    public CSVFormat(File csvFile) {
        this.csvFile = csvFile;
    }

    /**
     * @return the csvFile
     */
    public File getCsvFile() {
        return csvFile;
    }

    /**
     * @param csvFile the csvFile to set
     */
    public void setCsvFile(File csvFile) {
        this.csvFile = csvFile;
    }

    /**
     * @return the useFirstRowAsAttributeNames
     */
    public boolean isUseFirstRowAsAttributeNames() {
        return useFirstRowAsAttributeNames;
    }

    /**
     * @param useFirstRowAsAttributeNames the useFirstRowAsAttributeNames to set
     */
    public void setUseFirstRowAsAttributeNames(boolean useFirstRowAsAttributeNames) {
        this.useFirstRowAsAttributeNames = useFirstRowAsAttributeNames;
    }

    /**
     * @return the trimLines
     */
    public boolean isTrimLines() {
        return trimLines;
    }

    /**
     * @param trimLines the trimLines to set
     */
    public void setTrimLines(boolean trimLines) {
        this.trimLines = trimLines;
    }

    /**
     * @return the skipComments
     */
    public boolean isSkipComments() {
        return skipComments;
    }

    /**
     * @param skipComments the skipComments to set
     */
    public void setSkipComments(boolean skipComments) {
        this.skipComments = skipComments;
    }

    /**
     * @return the commentCharacter
     */
    public char getCommentCharacter() {
        return commentCharacter;
    }

    /**
     * @param commentCharacter the commentCharacter to set
     */
    public void setCommentCharacter(char commentCharacter) {
        this.commentCharacter = commentCharacter;
    }

    /**
     * @return the useQuotesForNominal
     */
    public boolean isUseQuotesForNominal() {
        return useQuotesForNominal;
    }

    /**
     * @param useQuotesForNominal the useQuotesForNominal to set
     */
    public void setUseQuotesForNominal(boolean useQuotesForNominal) {
        this.useQuotesForNominal = useQuotesForNominal;
    }

    /**
     * @return the quotesCharacter
     */
    public char getQuotesCharacter() {
        return quotesCharacter;
    }

    /**
     * @param quotesCharacter the quotesCharacter to set
     */
    public void setQuotesCharacter(char quotesCharacter) {
        this.quotesCharacter = quotesCharacter;
    }

    /**
     * @return the columnSeparator
     */
    public char getColumnSeparator() {
        return columnSeparator;
    }

    /**
     * @param columnSeparator the columnSeparator to set
     */
    public void setColumnSeparator(char columnSeparator) {
        this.columnSeparator = columnSeparator;
    }

    /**
     * @return the escapeCharacterForQuotes
     */
    public char getEscapeCharacterForQuotes() {
        return escapeCharacterForQuotes;
    }

    /**
     * @param escapeCharacterForQuotes the escapeCharacterForQuotes to set
     */
    public void setEscapeCharacterForQuotes(char escapeCharacterForQuotes) {
        this.escapeCharacterForQuotes = escapeCharacterForQuotes;
    }

    /**
     * @return the datePattern
     */
    public String getDatePattern() {
        return datePattern;
    }

    /**
     * @param datePattern the datePattern to set
     */
    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }





}
