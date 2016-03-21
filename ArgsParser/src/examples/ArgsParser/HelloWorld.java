package examples.ArgsParser;

import argsParser.ArgsParser;
import argsParser.FlaggedOption;
import argsParser.StringParser;

public class HelloWorld {
	
	public static void main(String[] args) throws Exception{
		
		FlaggedOption opt1 = new FlaggedOption("name1")
				.setArgDefault("5")
				.setArgFlag("-n")
				.setArgType(StringParser.INTEGER_PARSER);
		
		FlaggedOption opt2 = new FlaggedOption("name2")
				.setArgDefault("123555")
				.setArgFlag("-f")
				.setArgType(StringParser.STRING_PARSER);
		
		FlaggedOption opt3 = new FlaggedOption("name3")
				.setArgDefault("false")
				.setArgFlag("-g")
				.setArgType(StringParser.BOOLEAN_PARSER);
		
		ArgsParser argParser = new ArgsParser();
		argParser.registerParameter(opt1);
		argParser.registerParameter(opt2);
		argParser.registerParameter(opt3);
		argParser.parseArgs(args);
		
		
        System.out.println(argParser.getInt("name1"));
        System.out.println(argParser.getLong("name2"));
        System.out.println(argParser.getString("name3"));
        
        for(int i=0; i<argParser.getInt("name1"); i++){
        	System.out.println("Hello world");
        }
	}
}
