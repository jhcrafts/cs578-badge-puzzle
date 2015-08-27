package functions;
import java.util.*;

public class FuncJHCRandomGuess implements FunctionIntf 
{
	Random rng;
	
	public FuncJHCRandomGuess()
	{
		rng = new Random();
	}
	
	public boolean output(String name)
	{
		return rng.nextBoolean();
	}
	
	public String functionName()
	{
		return "JHC's Random Guess";
	}
	// Returns your name
	public String submitter()
	{
		return "Jordan Crafts";
	}		
}
