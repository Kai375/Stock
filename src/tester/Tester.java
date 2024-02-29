package tester;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.swing.filechooser.FileSystemView;

public class Tester
{
	private final Class<Object> classToTest;
	private final Method[] classMethods;
	private final Constructor<Object>[] classConstructors;

	private String className;
	private String results = "";

	private int countPass = 0;
	private int countFailed = 0;
	private int countMissing = 0;

	@SuppressWarnings("unchecked")
	public Tester(Object classTest)
	{
		classToTest = (Class<Object>) classTest.getClass();
		classMethods = classToTest.getMethods();
		classConstructors = (Constructor<Object>[]) classToTest.getConstructors();

		className = classToTest.getTypeName();
		className = className.substring(className.lastIndexOf(".") + 1);
	}

	public Object checkMethod(Object obj, String methodName, String correctAnswer, Object... methodArguments)
			throws Exception
	{
		Method methodToCheck = null;

		for (Method classMethod : classMethods)
			if (classMethod.getName().equals(methodName))
				methodToCheck = classMethod;

		if (methodToCheck != null)
		{
			int lineNum = Thread.currentThread().getStackTrace()[2].getLineNumber();
			Object returnObj = methodToCheck.invoke(obj, methodArguments);
			String methodOutput = returnObj == null ? obj.toString() : returnObj.toString();

			String message = String.format("Checking %s method - Line %d:", methodName, lineNum);

			results += underLineString(message);
			results += String.format("The %s test on: %s\n", className, obj.toString());
			results += String.format("The method input: %s\n", Arrays.toString(methodArguments));
			results += String.format("The method output: %s\n", methodOutput);
			results += String.format("The correct answer: %s\n", correctAnswer);

			if (methodOutput.equals(correctAnswer))
			{
				results += String.format("Your %s method is working properly\n\n", methodName);
				countPass++;
			}
			else
			{
				message = String.format("!!! *There is a problem with your %s method !!!", methodName);
				String exclamationMarkLine = exclamationMarkLine(message.length());

				results += String.format("%s\n%s\n%s\n\n", exclamationMarkLine, methodName, exclamationMarkLine);
				countFailed++;
			}

			return returnObj;
		}

		countMissing++;
		results += String.format("Couldn't find %s method\n\n", methodName);

		return null;
	}

	public Object checkConstructor(String correctAnswer, Object... methodArguments) throws Exception
	{
		Constructor<Object> con = null;
		int constructorIndex = -1;

		for (int i = 0; i < classConstructors.length; i++)
			if (classConstructors[i].getParameterCount() == methodArguments.length)
			{
				con = classConstructors[i];
				constructorIndex = i + 1;
			}

		if (con != null)
		{
			int lineNum = Thread.currentThread().getStackTrace()[2].getLineNumber();
			Object createObj = con.newInstance(methodArguments);
			String methodOutput = createObj.toString();

			String message = String.format("Checking index %d constructor - Line %d:", constructorIndex, lineNum);
			String className = classToTest.getName();
			className = className.substring(className.lastIndexOf('.') + 1);

			results += underLineString(message);
			results += String.format("The constructor input: %s\n", Arrays.toString(methodArguments));
			results += String.format("The %s toString: %s\n", className, methodOutput);
			results += String.format("The correct toString: %s\n", correctAnswer);

			if (methodOutput.equals(correctAnswer))
			{
				results += String.format("Your index %d constructor is WORKING properly\n\n", constructorIndex);
				countPass++;
			}
			else
			{
				message = String.format("!!! *There is a problem with your index %d constructor !!!", constructorIndex);
				String exclamationMarkLine = exclamationMarkLine(message.length());

				results += String.format("%s\n%s\n%s\n\n", exclamationMarkLine, message, exclamationMarkLine);

				countFailed++;
			}

			return createObj;
		}

		countMissing++;
		results += String.format("Couldn't find constructor with %d parameters\n\n", methodArguments.length);

		return null;
	}

	public void checkAliasing(Object d1, Object d2, boolean isShouldBeAliasing)
	{
		results += underLineString("Checking aliasing:");
		results += String.format("The first object: %s\n", d1.toString());
		results += String.format("The second object: %s\n", d2.toString());

		if (d1 == d2 && isShouldBeAliasing)
		{
			results += "You passed the aliasing test\n\n";
			countPass++;
		}
		else
		{
			String message = "!!! *You shouldn't have aliasing between this two object !!!";
			String exclamationMarkLine = exclamationMarkLine(message.length());

			results += String.format("%s\n%s\n%s\n\n", exclamationMarkLine, message, exclamationMarkLine);

			countFailed++;
		}
	}

	public void printResult(String fileName) throws IOException
	{
		int testsSum = countFailed + countPass;
		double passPrec = (double) countPass / testsSum * 100;
		String desktopPath = FileSystemView.getFileSystemView().getHomeDirectory().getPath();
		String fileLocation = String.format("%s\\%s.txt", desktopPath, fileName);
		String score = "";

		score += underLineString("Results");
		score += String.format("You passed %d out of %d\n", countPass, testsSum);
		score += String.format("You failed %d out of %d\n", countFailed, testsSum);
		score += String.format("Which is %.2f%% correct\n\n", passPrec);

		if (countMissing > 0)
			score += String.format(
					"%d tests didn't run because missing methods or constructors\ncheck if your method's name spells right\n\n",
					countMissing);

		results = score + results;

		BufferedWriter br = new BufferedWriter(new FileWriter(fileLocation));
		br.write(results);
		br.flush();
		br.close();
	}

	public String underLineString(String s)
	{
		return String.format("%s\n%s\n", s, new String(new char[s.length()]).replace('\0', '-'));
	}

	public String exclamationMarkLine(int length)
	{
		return new String(new char[length]).replace("\0", "!");
	}
}
