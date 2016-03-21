package argsParser;

import argsParser.stringParsers.*;

/**
* All parser instances are contained in this class.
* <p>You should define a parser for every FlaggedOption; i.e. "StringParser.INTEGER_PARSER".</p>
* @author Panagiotis Roropoulos
*/
public class StringParser {
	
	/** 
	* The only instance of a {@link argsParser.stringParsers.IntegerParser}.
	*/
	public static final IntegerParser INTEGER_PARSER = IntegerParser.getParser();
	/** 
	* The only instance of a {@link argsParser.stringParsers.BooleanParser}.
	*/
	public static final BooleanParser BOOLEAN_PARSER = BooleanParser.getParser();
	/** 
	* The only instance of a {@link argsParser.stringParsers.CharacterParser}.
	*/
	public static final CharacterParser CHAR_PARSER = CharacterParser.getParser();
	/** 
	* The only instance of a {@link argsParser.stringParsers.DoubleParser}.
	*/
	public static final DoubleParser DOUBLE_PARSER = DoubleParser.getParser();
	/** 
	* The only instance of a {@link argsParser.stringParsers.LongParser}.
	*/
	public static final LongParser LONG_PARSER = LongParser.getParser();
	/** 
	* The only instance of a {@link argsParser.stringParsers.RawStringParser}.
	*/
	public static final RawStringParser STRING_PARSER = RawStringParser.getParser();
}
