package cs578badges;
import java.io.*;
import java.util.*;

import functions.FunctionIntf;
import functions.FunctionRegistry;

public class LearnAllTheThings {

	public static void main(String[] args) {				
		// Import the registry
		FunctionRegistry.instance().importFunctions();
		
		// Import the data set
		List<String> dataset = importDataSet("badges.txt");
		
		// Prepare a structure for storing results
		List<Statistics> stats = new ArrayList<Statistics>();
				
		// Iterate over each function
		Iterator<FunctionIntf> functionIter = FunctionRegistry.instance().functions();
		while (functionIter.hasNext())
		{	
			FunctionIntf function = functionIter.next();
			Statistics functionStats 
				= new Statistics(function.functionName(), function.submitter());			
			Iterator<String> datasetIter = dataset.iterator();
			while (datasetIter.hasNext())
			{
				String datasetEntry = datasetIter.next();
				// Remove leading/trailing whitespace
				datasetEntry.trim();
				// For now, we'll assume well formed data entries
				// Get expected result
				boolean expectedResult = datasetEntry.charAt(0) == '+' ? true : false;
				// for now, we'll assume well-formed entries
				String name = datasetEntry.substring(2);
				// get function result for given name
				boolean functionResult = function.output(name);
				
				// Compare results and update statistics
				if (functionResult == expectedResult)
				{
					functionStats.incrementCorrect();
				}
				else
				{
					functionStats.incrementIncorrect();
				}
				
			}
			stats.add(functionStats);
		}
		
		Collections.sort(stats);
		
		// Print statistics for tested functions
		System.out.println("CS 578 Badge Puzzle Function Tests\r\n");
		System.out.println("Submitter/FunctionName/Accuracy\r\n");
		
		Iterator<Statistics> statsIter = stats.iterator();
		while(statsIter.hasNext())
		{
			Statistics statsToPrint = statsIter.next();
			System.out.println(statsToPrint.toString());
		}
		System.out.println("Program Complete.");		
	}

	private static List<String> importDataSet(String filename)
	{
		List<String> dataSet = new ArrayList<String>();
		
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
		    while ((line = reader.readLine()) != null)
		    {
		    	dataSet.add(line);
		    }
		    reader.close();		    
		    return dataSet;
		}
		catch (Exception e)
		{
			System.console().printf("Couldn't find the input file.");			
		}
		return null;
	}	
}

class Statistics implements Comparable<Statistics>
{
	int numCorrect;
	int numIncorrect;
	String funcName;
	String subie;
	public Statistics(String functionName, String submitter)
	{
		numCorrect = 0;
		numIncorrect = 0;
		funcName = functionName;
		subie = submitter;
	}
	
	public String functionName()
	{
		return funcName;
	}
	public String submitter()
	{
		return subie;
	}		
	public void incrementCorrect()
	{
		numCorrect++;
	}
	public void incrementIncorrect()
	{
		numIncorrect++;
	}
	public double accuracy()
	{
		return (double)numCorrect/(double)(numIncorrect + numCorrect);
	}		
	public int compareTo(Statistics compareStats)
	{
		return (compareStats.numCorrect - this.numCorrect);
	}
	public String toString()
	{
		return ("Submitter: " + subie + " FunctionName: " + funcName + " Accuracy:" + String.valueOf(this.accuracy()));
	}
}
