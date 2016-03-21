package argsParser;

import java.util.Map;

import argsParser.stringParsers.BooleanParser;
import argsParser.stringParsers.CharacterParser;
import argsParser.stringParsers.DoubleParser;
import argsParser.stringParsers.IntegerParser;
import argsParser.stringParsers.LongParser;

/** Encapsulates the results of ArgsParser parse() methods.
 * A number of getXXX() methods are provided
 * to make your code more readable and to avoid re-casting.
 * @author Panagiotis Roropoulos
 */
public class ArgsParser {
	
    /**
     * Map of this ArgsParser's AbstractParameters keyed on their unique ID.
     */
	private Map<String, FlaggedOption> paramsByID = null;
	
    /**
     * Map of this ArgsParser's AbstractParameters keyed on their short flag.
     */
	private Map<String, FlaggedOption> paramsByShortFlag = null;
	
    /**
     * String Array which contains all user defined arguments and their values.
     */
	private String[] argValues = null;
	
    /**
     * Creates a new ArgsParser with an empty configuration.  It must be configured
     * with registerParameter() before its parse() methods may be called.
     */
    public ArgsParser() {
    	init();
    }

	private void init() {
		paramsByID = new java.util.HashMap<String, FlaggedOption>();
		paramsByShortFlag = new java.util.HashMap<String, FlaggedOption>();
	}
	
    /**
     * Registers the specified Parameter FlaggedOption with this ArgsParser.
     *
     * <p>Registering a Parameter, registers the specified FlaggedOption(s) to HashMaps.
     * Therefore you can't register twice a parameter with the same name/id or short flag.</p>
     * 
     * @param param the Parameter to register.
     * @throws Exception if this Parameter cannot be added. Possible
     * reasons include:
     * <ul>
     *     <li>Another Parameter with the same Name/ID has already been
     *      registered.</li>
     *  <li>You are attempting to register a FlaggedOption without a short flag.</li>
     *  <li>You are attempting to register a FlaggedOption with a short flag that is already
     *  defined in this ArgsParser.</li>
     * </ul>
     */
	public void registerParameter(FlaggedOption param) throws Exception {
		String paramID = param.getArgName();
		String paramShortFlag = param.getArgFlag();
		
        if (paramsByID.containsKey(paramID)) {
            throw (
                new Exception(
                    "A parameter with ID '"
                        + paramID
                        + "' has already been registered."));
        }
        
        if (paramsByShortFlag.containsKey(paramShortFlag)) {
            throw (
                new Exception(
                    "A parameter with Short Flag '"
                        + paramShortFlag
                        + "' has already been registered."));
        }
        
        //Finally put params in hashmaps
        paramsByID.put(paramID, param);
        paramsByShortFlag.put(paramShortFlag, param);
	}
	
    /**
     * Transfers all user specified arguments to this ArgsParser string array.
     * 
     * @param args the user specified arguments string array.
     */
	public void parseArgs(String[] args){
		this.argValues = args;
	}
	
    /**
     * Returns the FlaggedOption object by specifying it's string name (id).
     * 
     * @param id the name/id of the FlaggedOption.
     * @return the specific FlaggedOption object.
     */
	public FlaggedOption getFlaggedOptionObjectByID(String id){
		FlaggedOption opt = (FlaggedOption)paramsByID.get(id);
		return opt;
	}
	
    /**
     * Returns the first integer value associated with the specified name/id.  If
     * the specified id does not
     * exist within this ArgsParser, or if the object(s) associated with the
     * specified id are not of
     * type java.lang.Integer, the specified default value is returned.
     * @param name the name of the integer value to retrieve
     * @return the first integer value associated with the specified name.  If
     * the specified name does not
     * exist within this ArgsParser, or if the object(s) associated with the
     * specified id are not of
     * type java.lang.Integer, the specified default value is returned.
     */
	public int getInt(String name) throws Exception{
		int result = 0;
		FlaggedOption opt = null;
		opt = getFlaggedOptionObjectByID(name);
		IntegerParser intParser = new IntegerParser();
		
		for(int i=0; i<argValues.length; i++){
			if(argValues[i].contains(opt.getArgFlag())){
				//Checks if array is out of bound and return default value
				if(i==argValues.length - 1) 
					return Integer.parseInt(opt.getArgDefault());
				//Checks if after the flag exists a digit and parse it, otherwise return default value
				if(argValues[i+1].matches(".*\\d.*"))
						result = intParser.parse(argValues[i+1]);
				else
					return Integer.parseInt(opt.getArgDefault());
			}
		}
		//Return 0 if everything fail
		return result;
	}
	
    /**
     * Returns the first boolean value associated with the specified name/id.  If
     * the specified id does not
     * exist within this ArgsParser, or if the object(s) associated with the
     * specified id are not of
     * type java.lang.Boolean, the specified default value is returned.
     * @param name the id of the boolean value to retrieve
     * @return the first boolean value associated with the specified id.  If
     * the specified id does not
     * exist within this ArgsParser, or if the object(s) associated with the
     * specified id are not of
     * type java.lang.Boolean, the specified default value is returned.
     */
	public boolean getBoolean(String name) throws Exception{
		boolean result = false;
		FlaggedOption opt = null;
		opt = getFlaggedOptionObjectByID(name);
		BooleanParser boolParser = new BooleanParser();
		
		for(int i=0; i<argValues.length; i++){
			if(argValues[i].contains(opt.getArgFlag())){
				//Checks if array is out of bound and return default value
				if(i==argValues.length - 1) 
					return Boolean.parseBoolean(opt.getArgDefault());
				//Checks if after the flag exists a boolean and parse it, otherwise return default value
				if(argValues[i+1].matches("true") || argValues[i+1].matches("false"))
						result = boolParser.parse(argValues[i+1]);
				else
					return Boolean.parseBoolean(opt.getArgDefault());
			}
		}
		//Return false if everything fail
		return result;
	}
	
    /**
     * Returns the first character of a string value associated with the specified name/id.  If
     * the specified id does not
     * exist within this ArgsParser, or if the object(s) associated with the
     * specified id are not of
     * type java.lang.Character, the specified default value is returned.
     * @param name the id of the char value to retrieve
     * @return the first char value associated with the specified id.  If
     * the specified id does not
     * exist within this ArgsParser, or if the object(s) associated with the
     * specified id are not of
     * type java.lang.Character, the specified default value is returned.
     */
	public char getCharacter(String name) throws Exception{
		char result = 'X';
		FlaggedOption opt = null;
		opt = getFlaggedOptionObjectByID(name);
		CharacterParser charParser = new CharacterParser();
		
		for(int i=0; i<argValues.length; i++){
			if(argValues[i].contains(opt.getArgFlag())){
				//Checks if array is out of bound and return default value
				if(i==argValues.length - 1) 
					return opt.getArgDefault().charAt(0);
				//Checks if after the flag exists a single char and parse it, otherwise return default value
				if(argValues[i+1].length()==1)
						result = charParser.parse(argValues[i+1]);
				else
					return opt.getArgDefault().charAt(0);
			}
		}
		//Return X if everything fail
		return result;
	}
	
    /**
     * Returns the first double value associated with the specified name/id.  If
     * the specified id does not
     * exist within this ArgsParser, or if the object(s) associated with the
     * specified id are not of
     * type java.lang.Double, the specified default value is returned.
     * @param name the id of the double value to retrieve
     * @return the first double value associated with the specified id.  If
     * the specified id does not
     * exist within this ArgsParser, or if the object(s) associated with the
     * specified id are not of
     * type java.lang.Double, the specified default value is returned.
     */
	public double getDouble(String name) throws Exception{
		double result=0;
		FlaggedOption opt = null;
		opt = getFlaggedOptionObjectByID(name);
		DoubleParser doubleParser = new DoubleParser();
		
		for(int i=0; i<argValues.length; i++){
			if(argValues[i].contains(opt.getArgFlag())){
				//Checks if array is out of bound and return default value
				if(i==argValues.length - 1) 
					return Double.parseDouble(opt.getArgDefault());
				//Checks if after the flag exists a double and parse it, otherwise return default value
				if(Double.parseDouble(argValues[i+1])==Math.floor(Double.parseDouble(argValues[i+1])))
						result = doubleParser.parse(argValues[i+1]);
				else
					return Double.parseDouble(opt.getArgDefault());
			}
		}
		//Return 0 if everything fail
		return result;
	}
	
    /**
     * Returns the first long value associated with the specified name/id.  If
     * the specified id does not
     * exist within this ArgsParser, or if the object(s) associated with the
     * specified id are not of
     * type java.lang.Long, the specified default value is returned.
     * @param name the id of the long value to retrieve
     * @return the first long value associated with the specified id.  If
     * the specified id does not
     * exist within this ArgsParser, or if the object(s) associated with the
     * specified id are not of
     * type java.lang.Long, the specified default value is returned.
     */
	public long getLong(String name) throws Exception{
		long result=0;
		FlaggedOption opt = null;
		opt = getFlaggedOptionObjectByID(name);
		LongParser longParser = new LongParser();
		
		for(int i=0; i<argValues.length; i++){
			if(argValues[i].contains(opt.getArgFlag())){
				//Checks if array is out of bound and return default value
				if(i==argValues.length - 1) 
					return Long.parseLong(opt.getArgDefault());
				//Checks if after the flag exists a double and parse it, otherwise return default value
				if(Long.parseLong(argValues[i+1])==Math.floor(Long.parseLong(argValues[i+1])))
						result = longParser.parse(argValues[i+1]);
				else
					return Long.parseLong(opt.getArgDefault());
			}
		}
		//Return 0 if everything fail
		return result;
	}
	
    /**
     * Returns the first string value associated with the specified name/id.  If
     * the specified id does not
     * exist within this ArgsParser, or if the object(s) associated with the
     * specified id are not of
     * type java.lang.String, the specified default value is returned.
     * @param name the id of the string value to retrieve
     * @return the first string value associated with the specified id.  If
     * the specified id does not
     * exist within this ArgsParser, or if the object(s) associated with the
     * specified id are not of
     * type java.lang.String, the specified default value is returned.
     */
	public String getString(String name) throws Exception{
		String result = null;
		FlaggedOption opt = null;
		opt = getFlaggedOptionObjectByID(name);
		
		for(int i=0; i<argValues.length; i++){
			if(argValues[i].contains(opt.getArgFlag())){
				//Checks if array is out of bound and return default value
				if(i==argValues.length - 1) 
					return opt.getArgDefault();

				result = argValues[i+1];
			}
		}
		//Return null if everything fail
		return result;
	}
}
