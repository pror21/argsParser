package argsParser.stringParsers;

import argsParser.StringParser;

/**
 * A parser for parsing Doubles. The parse() method delegates the actual
 * parsing to new Double(String). If a NumberFormatException is thrown by new
 * Double(String), it is encapsulated in an Exception and re-thrown.
 * 
 * @author Panagiotis Roropoulos
 * @see argsParser.StringParser
 * @see java.lang.Double
 */
public class DoubleParser extends StringParser {

	/** Returns a {@link DoubleParser}.
	 * 
	 * <p>Convenient access to the only instance returned by
	 * this method is available through
	 * {@link argsParser.StringParser#DOUBLE_PARSER}.</p>
	 *  
	 * @return a {@link DoubleParser}.
	 */
    public static DoubleParser getParser() {
		return new DoubleParser();
	}
    
    /**
     * Parses the specified argument into a Double.  This method simply
     * delegates the actual
     * parsing to new Double(String).  If a NumberFormatException is thrown by
     * new Double(String), it
     * is encapsulated in a ParseException and re-thrown.
     *
     * @param arg the argument to parse
     * @return a Double object with the value contained in the specified
     * argument.
     * @throws Exception if <code>new Double(arg)</code> throws a
     * NumberFormatException.
     * @see java.lang.Double
     */
    public double parse(String arg) throws Exception {
        Double result = null;
        try {
            result = new Double(arg);
        } catch (NumberFormatException e) {
            throw (
                new Exception(
                    "Unable to convert '" + arg + "' to a Double.",
                    e));
        }
        return (result);
    }
}
