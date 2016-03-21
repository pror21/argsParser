package argsParser.stringParsers;

import argsParser.StringParser;

/**
 * A parser for parsing Longs.  The parse() method delegates the actual
 * parsing to <code>Long.decode(String)</code>.
 * @author Panagiotis Roropoulos
 * @see argsParser.StringParser
 * @see java.lang.Long
 */
public class LongParser extends StringParser {

	/** Returns a {@link LongParser}.
	 * 
	 * <p>Convenient access to the only instance returned by
	 * this method is available through
	 * {@link argsParser.StringParser#LONG_PARSER}.</p>
	 *  
	 * @return a {@link LongParser}.
	 */
    public static LongParser getParser() {
		return new LongParser();
	}
    
    /**
     * Parses the specified argument into a Long.  This method delegates
     * the parsing to <code>Long.decode(arg)</code>.  If
     * <code>Long.decode()</code> throws a
     * NumberFormatException, it is encapsulated into an Exception and
     * re-thrown.
     *
     * @param arg the argument to parse
     * @return a Long object with the value contained in the specified argument.
     * @throws Exception if <code>Long.decode(arg)</code> throws a
     * NumberFormatException.
     * @see java.lang.Long
     */
    public long parse(String arg) throws Exception {
        Long result = null;
        try {
            result = Long.decode(arg);
        } catch (NumberFormatException e) {
            throw (
                new Exception(
                    "Unable to convert '" + arg + "' to a Long.",
                    e));
        }
        return (result);
    }
}
