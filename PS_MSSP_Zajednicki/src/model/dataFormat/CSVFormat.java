/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataFormat;

import java.io.File;

/**
 *
 * @author Jelena
 */
public class CSVFormat extends DataFormat{

    //public static final String PARAMETER_CSV_FILE = "file_name";
    private File csvFile;
    //public static final String PARAMETER_USE_FIRST_ROW_AS_ATTRIBUTE_NAMES = "use_first_row_as_attribute_names";
    private boolean useFirstRowAsAttributeNames = false;
    //public static final String PARAMETER_TRIM_LINES = "trim_lines";
    private boolean trimLines = false;
    //public static final String PARAMETER_SKIP_COMMENTS = "skip_comments";
    private boolean skipComments = true;
//    public static final String PARAMETER_COMMENT_CHARS = "comment_characters";
    private char commentCharacter = '#';
//    public static final String PARAMETER_USE_QUOTES = "use_quotes";
    private boolean useQuotesForNominal = true;
//    public static final String PARAMETER_QUOTES_CHARACTER = "quotes_character";
    private char quotesCharacter = '"';
//    public static final String PARAMETER_COLUMN_SEPARATORS = "column_separators";
    private char columnSeparator = ';';
//    public static final String PARAMETER_ESCAPE_CHARACTER = "escape_character_for_quotes";
    private char escapeCharacterForQuotes = '\\';

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





}
