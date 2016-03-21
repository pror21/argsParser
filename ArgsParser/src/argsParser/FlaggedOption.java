package argsParser;

/**
* A model of a flagged option.
* A flagged option must be preceded by a short flag; i.e. "-n 5".
* @author Panagiotis Roropoulos
*/
public class FlaggedOption {

	/**
	* The current name flag for this FlaggedOption.
	* It is required in order to tell the parser which of the flag you want to parse.
	*/
	private String argName;
	/**
	* The current data type of the flag for this FlaggedOption.
	* It is required to choose which data type parser you want; i.e. "INTEGER_PARSER"
	*/
	private StringParser argType;
	/**
	* The current default value of the flag for this FlaggedOption.
	* It is not required but it is highly recommended to use a default value.
	*/
	private String argDefault;
	/**
	* The current short parameter key of the flag for this FlaggedOption.
	* It is required to set a short key; i.e. "-n", "-help"
	*/
	private String argFlag;
	
	/**
	* A shortcut constructor that creates a new FlaggedOption and configures
	* its most commonly used settings.
	*/
	public FlaggedOption(String argName) {
		setArgName(argName);
		setArgType(argType);
		setArgDefault(argDefault);
		setArgFlag(argFlag);
	}
	
	/**
	* Sets the name flag for this FlaggedOption. (REQUIRED)
	* @param argName the name flag for this FlaggedOption.
	*/
	public FlaggedOption setArgName(String argName) {
		this.argName = argName;
		return (this);
	}
	
	/**
	* Sets the data type/parser flag for this FlaggedOption. (REQUIRED)
	* @param argType the parser flag for this FlaggedOption.
	*/
	public FlaggedOption setArgType(StringParser argType) {
		this.argType = argType;
		return (this);
	}
	
	/**
	* Sets the default value for this parameter.
	* @param argDefault the default value for this parameter.
	*/
	public FlaggedOption setArgDefault(String argDefault) {
		this.argDefault = argDefault;
		return (this);
	}
	
	/**
	* Sets the short flag for this FlaggedOption. (REQUIRED)
	* @param argFlag the short flag for this FlaggedOption.
	*/
	public FlaggedOption setArgFlag(String argFlag) {
		this.argFlag = argFlag;
		return (this);
	}
	
	/**
	* Returns the name of this FlaggedOption.
	* @return the name of this FlaggedOption.
	*/
	public String getArgName() {
		return this.argName;
	}
	
	/**
	* Returns the type/parser for this FlaggedOption.
	* @return the type/parser for this FlaggedOption.
	*/
	public StringParser getArgType() {
		return this.argType;
	}
	
	/**
	* Returns the default value for this parameter.
	* @return the default value for this parameter.
	*/
	public String getArgDefault() {
		return this.argDefault;
	}
	
	/**
	* Returns the short flag for this FlaggedOption.
	* @return the short flag for this FlaggedOption.
	*/
	public String getArgFlag() {
		return this.argFlag;
	}
}
