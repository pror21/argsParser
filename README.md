## ArgsParser


ArgsParser is a command line argument parser library for Java.


You can parse all basic data types like int, boolean, char, double, long and string.




### Usage:


#### 1) Create a FlaggedOption object and set all the necessary parameter values.



e.g: 


    FlaggedOption opt1 = new FlaggedOption("f1")
    
    		.setArgDefault("100") 
    		
    		.setArgFlag("-n")
    		
    		.setArgType(StringParser.INTEGER_PARSER);
    		




The name (ID) of the object must be unique, duplicates will throw Exception.

argDefault is the default value the parameter gets in case the user did not specify a value.

argFlag is the short flag of the parameter and must be unique, duplicates will throw Exception.

argType is the type of the parser.

All of these parameters are required.






#### 2) Create an ArgsParser object, register all FlaggedOptions and parse user arguments.


e.g:


	ArgsParser argParser = new ArgsParser();
	
	argParser.registerParameter(f1);
	
	argParser.parseArgs(args);
	
	
	
#### 3) Get any parsed value by using ArgsParser.getXXX(), where XXX is the proper parser.


e.g:


    argParser.getInt("f1")