package export.csv;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import model.attribute.Attribute;
import model.Instance;
import model.dataset.DataSet;
import com.rapidminer.parameter.ParameterType;
import com.rapidminer.parameter.ParameterTypeBoolean;
import com.rapidminer.parameter.ParameterTypeString;
import com.rapidminer.tools.Ontology;
import com.rapidminer.tools.io.Encoding;
import java.io.File;
import java.io.OutputStream;

/**
 * <p>
 * This operator can be used to write data into CSV files (Comma Separated
 * Values). The values and columns are separated by &quot;;&quot;. Missing data
 * values are indicated by empty cells.
 * </p>
 * 
 * @author Ingo Mierswa
 */
public class CSVDataSetExport extends AbstractStreamWriter {

	/** The parameter name for &quot;The CSV file which should be written.&quot; */
	private File csvFile;

	/** The parameter name for the column separator parameter. */
	private char columnSeparator = ';';

	/** Indicates if the attribute names should be written as first row. */
	private boolean writeAttributeNames = false;

	/**
	 * Indicates if nominal values should be quoted with double quotes. Quotes
	 * inside of nominal values will be escaped by a backslash.
	 */
	private boolean quoteNominalValues = false;

	/**
	 * Indicates if date attributes are written as a formated string or as
	 * milliseconds past since January 1, 1970, 00:00:00 GMT
	 */
	// TODO introduce parameter which allows to determine the written format see
	// Nominal2Date operator
	private String date_format = "dd-MM-yyyy";

	public CSVDataSetExport(OperatorDescription description) {
		super(description);
	}

	@Override
        public void writeStream(DataSet dataSet,OutputStream outputStream){
//        public void writeStream(DataSet dataSet,OutputStream outputStream){
		//String columnSeparator = getParameterAsString(PARAMETER_COLUMN_SEPARATOR);
		
            boolean quoteNominalValues= 
            //boolean quoteNominalValues = getParameterAsBoolean(PARAMETER_QUOTE_NOMINAL_VALUES);
		PrintWriter out = null;
		try {
			out = new PrintWriter(new OutputStreamWriter(outputStream, Encoding
					.getEncoding(this)));

			// write column names
			if (getParameterAsBoolean(writeAttributeNames)) {
				Iterator<Attribute> a = dataSet.getAttributes()
						.allAttributes();
				boolean first = true;
				while (a.hasNext()) {
					if (!first)
						out.print(columnSeparator);
					Attribute attribute = a.next();
					String name = attribute.getName();
					if (quoteNominalValues) {
						name = name.replaceAll("\"", "'");
						name = "\"" + name + "\"";
					}
					out.print(name);
					first = false;
				}
				out.println();
			}

			// write data
			for (Example example : dataSet) {
				Iterator<Attribute> a = dataSet.getAttributes()
						.allAttributes();
				boolean first = true;
				while (a.hasNext()) {
					Attribute attribute = a.next();
					if (!first)
						out.print(columnSeparator);
					if (!Double.isNaN(example.getValue(attribute))) {
						if (attribute.isNominal()) {
							String stringValue = example
									.getValueAsString(attribute);
							if (quoteNominalValues) {
								stringValue = stringValue.replaceAll("\"", "'");
								stringValue = "\"" + stringValue + "\"";
							}
							out.print(stringValue);
						} else {
							Double value = example.getValue(attribute);
							if (Ontology.ATTRIBUTE_VALUE_TYPE.isA(attribute
									.getValueType(), Ontology.DATE_TIME)) {
								if (getParameterAsBoolean(PARAMETER_FORMAT_DATE)) {
									Date date = new Date(value.longValue());
									String s = DateFormat.getInstance().format(
											date);
									out.print(s);
								} else {
									out.print(value);
								}
							} else {
								out.print(value);
							}

						}
					}
					first = false;
				}
				out.println();
			}
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	@Override
	protected boolean supportsEncoding() {
		return true;
	}

	@Override
	public List<ParameterType> getParameterTypes() {
		List<ParameterType> types = new LinkedList<ParameterType>();
		types.add(makeFileParameterType());
		// types.add(new ParameterTypeFile(PARAMETER_CSV_FILE,
		// "The CSV file which should be written.", "csv", false));
		types.add(new ParameterTypeString(columnSeparator,
				"The column separator.", ";", false));
		types
				.add(new ParameterTypeBoolean(
						writeAttributeNames,
						"Indicates if the attribute names should be written as first row.",
						true, false));
		types
				.add(new ParameterTypeBoolean(
						PARAMETER_QUOTE_NOMINAL_VALUES,
						"Indicates if nominal values should be quoted with double quotes.",
						true, false));
		types
				.add(new ParameterTypeBoolean(
						PARAMETER_FORMAT_DATE,
						"Indicates if date attributes are written as a formated string or as milliseconds past since January 1, 1970, 00:00:00 GMT",
						true, true));
		types.addAll(super.getParameterTypes());
		return types;
	}

	@Override
	String getFileParameterName() {
		// TODO Auto-generated method stub
		return PARAMETER_CSV_FILE;
	}

	@Override
	String getFileExtension() {
		// TODO Auto-generated method stub
		return "csv";
	}
}
