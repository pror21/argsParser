package argsParser.stringParsers;

import argsParser.StringParser;

/**
 * A parser for parsing Characters.  The parse() method requires an
 * argument of length exactly
 * equal to 1 in order to perform the conversion; otherwise, the first character of the String will be returned.
 * If everything else fails, it will throw an Exception.
 * 
 * @author Panagiotis Roropoulos
 * @see argsParser.StringParser
 * @see java.lang.Character
 */
public class CharacterParser extends StringParser {

	/** Returns a {@link CharacterParser}.
	 * 
	 * <p>Convenient access to the only instance returned by
	 * this method is available through
	 * {@link argsParser.StringParser#CHAR_PARSER}.</p>
	 *  
	 * @return a {@link CharacterParser}.
	 */
    public static CharacterParser getParser() {
		return new CharacterParser();
	}
    
    /**
     * Parses the specified argument into a Character.  The conversion is
     * performed by
     * checking that the specified argument is exactly 1 character long, then
     * encapsulating
     * that char in a Character object.  If the specified argument is not
     * exactly 1 character long, the first char of the string will returned.
     * If everything else fail it will throw an Exception.
     * 
     * @param arg the argument to parse
     * @return a Character object with the value contained in the specified
     * argument.
     * @throws Exception if (arg==null)
     * @see java.lang.Character
     */
    public char parse(String arg) throws Exception {
        if ((arg == null)) {
            throw (
                new Exception(
                    "Unable to convert '" + arg + "' to a Character."));
        }
        return (new Character(arg.charAt(0)));
    }
}
