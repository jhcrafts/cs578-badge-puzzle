package functions;
import java.lang.String;

public interface FunctionIntf {	
	// Returns:
	// true if your function results in a '+' 
	// false if your function results in a '-' 
	public boolean output(String name);
	// Returns a string naming your function
	public String functionName();
	// Returns your name
	public String submitter();
}
