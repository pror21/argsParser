package argsParser.stringParsers;

import argsParser.StringParser;

/**
 * A parser for parsing Strings.  This is the simplest possible
 * StringParser, simply returning
 * the specified argument in all cases.  This class never throws an
 * Exception under any circumstances.
 * 
 * @author Panagiotis Roropoulos
 * @see argsParser.StringParser
 * @see java.lang.String
 */
public class RawStringParser extends StringParser {

	/** Returns a {@link StringParser}.
	 * 
	 * <p>Convenient access to the only instance returned by
	 * this method is available through
	 * {@link argsParser.StringParser#STRING_PARSER}.</p>
	 *  
	 * @return a {@link StringParser}.
	 */
    public static RawStringParser getParser() {
		return new RawStringParser();
	}
    
    /**
     * Returns the specified argument as a String.
     *
     * @param arg the argument to parse
     * @return the specified argument as a String.
     * @see java.lang.String
     */
    public String parse(String arg) {
        return arg;
    }
}
