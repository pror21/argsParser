package argsParser.stringParsers;

import argsParser.StringParser;

/**
 * A parser for parsing Integers.  The parse() method delegates the actual
 * parsing to Integer.decode(String).
 * 
 * @author Panagiotis Roropoulos
 * @see argsParser.StringParser
 * @see java.lang.Integer
 */
public class IntegerParser extends StringParser {

	/** Returns a {@link IntegerParser}.
	 * 
	 * <p>Convenient access to the only instance returned by
	 * this method is available through
	 * {@link argsParser.StringParser#INTEGER_PARSER}.</p>
	 *  
	 * @return a {@link IntegerParser}.
	 */
    public static IntegerParser getParser() {
		return new IntegerParser();
	}
    
    /**
     * Parses the specified argument into an Integer.  This method delegates
     * the parsing to <code>Integer.decode(arg)</code>.  If
     * <code>Integer.decode()</code> throws a
     * NumberFormatException, it is encapsulated into an Exception and
     * re-thrown.
     *
     * @param arg the argument to parse
     * @return an Integer object with the value contained in the specified
     * argument.
     * @throws Exception if <code>Integer.decode(arg)</code> throws a
     * NumberFormatException.
     * @see java.lang.Integer
     */
    public int parse(String arg) throws Exception {
        Integer result = null;
        try {
            result = Integer.decode(arg);
        } catch (NumberFormatException nfe) {
            throw (
                new Exception(
                    "Unable to convert '" + arg + "' to an Integer.",
                    nfe));
        }
        return (result);
    }
}
