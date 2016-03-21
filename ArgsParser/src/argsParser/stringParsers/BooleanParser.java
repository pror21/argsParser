package argsParser.stringParsers;

import argsParser.StringParser;

/**
 * <p>A parser for parsing Booleans.</p>
 *
 * <p>When parsing, the following arguments are interpreted as TRUE:
 * <ul>
 *         <li>null</i>
 *         <li>"t" (case-insensitive)</li>
 *         <li>"true" (case-insensitive)</li>
 *         <li>"y" (case-insensitive)</li>
 *         <li>"yes" (case-insensitive)</li>
 *         <li>"1"</li>
 * </ul>
 * <p>The following arguments are interpreted as FALSE:
 * <ul>
 *         <li>"f" (case-insensitive)</li>
 *         <li>"false" (case-insensitive)</li>
 *         <li>"n" (case-insensitive)</li>
 *         <li>"no" (case-insensitive)</li>
 *         <li>"0"</li>
 * </ul>
 * 
 * <p>All other input throws an Exception.
 * @author Panagiotis Roropoulos
 * @see argsParser.StringParser
 * @see java.lang.Boolean
 */
public class BooleanParser extends StringParser {

	/** Returns a {@link BooleanParser}.
	 * 
	 * <p>Convenient access to the only instance returned by
	 * this method is available through
	 * {@link argsParser.StringParser#BOOLEAN_PARSER}.</p>
	 *  
	 * @return a {@link BooleanParser}.
	 */
    public static BooleanParser getParser() {
		return new BooleanParser();
	}
    
    /**
     * Converts the specified argument into a Boolean.
     *
     * <p>When parsing, the following arguments are interpreted as TRUE:
     * <ul>
     *         <li>null</i>
     *         <li>"t" (case-insensitive)</li>
     *         <li>"true" (case-insensitive)</li>
     *         <li>"y" (case-insensitive)</li>
     *         <li>"yes" (case-insensitive)</li>
     *         <li>"1"</li>
     * <ul>
     * <p>The following arguments are interpreted as FALSE:
     * <ul>
     *         <li>"f" (case-insensitive)</li>
     *         <li>"false" (case-insensitive)</li>
     *         <li>"n" (case-insensitive)</li>
     *         <li>"no" (case-insensitive)</li>
     *         <li>"0"</li>
     * </ul>
     * 
     * <p>All other input throws a ParseException.
     * @param arg the argument to convert to a Boolean.
     * @return a Boolean as described above.
     * @throws Exception if none of the above cases are matched.
     */
    public Boolean parse(String arg) throws Exception {
        boolean result = false;
        if ((arg == null)
            || arg.equalsIgnoreCase("t")
            || arg.equalsIgnoreCase("true")
            || arg.equalsIgnoreCase("y")
            || arg.equalsIgnoreCase("yes")
            || arg.equals("1")) {
            result = true;
        } else if (
            arg.equalsIgnoreCase("f")
                || arg.equalsIgnoreCase("false")
                || arg.equalsIgnoreCase("n")
                || arg.equalsIgnoreCase("no")
                || arg.equals("0")) {
            result = false;
        } else {
            throw (
                new Exception(
                    "Unable to convert '" + arg + "' to a boolean value."));
        }
        return (new Boolean(result));
    }
}
