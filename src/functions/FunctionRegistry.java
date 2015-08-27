package functions;
import java.util.*;

public class FunctionRegistry {
	
	private Vector<FunctionIntf> functionList;
	
	private static FunctionRegistry singleton;
	private FunctionRegistry()
	{
		functionList = new Vector<FunctionIntf>();
	}
	
	public static FunctionRegistry instance()
	{
		if (singleton == null)
		{
			singleton = new FunctionRegistry();
		}
		return singleton;
	}
	
	public Iterator<FunctionIntf> functions()
	{
		return functionList.iterator();
	}
		
	public void importFunctions()
	{
		// CS578 Guys - Add your function to the registry here!!!
		functionList.add(new FuncJHCRandomGuess());
		// functionList.add(new YOURFUNCTION1HERE());
		// functionList.add(new YOURFUNCTION2HERE());
		// functionList.add(new YOURFUNCTION3HERE());
		// functionList.add(new YOURFUNCTION4HERE());
		// functionList.add(new YOURFUNCTION5HERE());
		// functionList.add(new YOURFUNCTION6HERE());
		// functionList.add(new YOURFUNCTION7HERE());
		// functionList.add(new YOURFUNCTION8HERE());
	}
}
