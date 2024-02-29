package item;

import date.Date;

import java.io.BufferedWriter;

import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;


import javax.swing.filechooser.FileSystemView;


public class FoodItemTester
{
	public static int tests = 0;
	public static int passed = 0;
	public static int failed = 0;
	public static ArrayList<Integer> failedLines = new ArrayList<>();

	public static String testLog = "";

	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		Date d_1 = new Date(1, 3, 2012);
		Date d0 = new Date(21, 4, 2012);
		Date d1 = new Date(20, 1, 2014);
		Date d2 = new Date(30, 1, 2014);
		Date d3 = new Date(5, 2, 2014);
		Date d4 = new Date(24, 8, 2014);
		Date d5 = new Date(12, 4, 2016);
		Date d6 = new Date(23, 6, 2019);
		Date d6_5 = new Date(24, 8, 2019);
		Date d7 = new Date(24, 1, 2020);
		Date d8 = new Date(26, 2, 2020);

		FoodItem tomato = new FoodItem("tomato", 154, 30, d1, d2, 20, 30, 5);
		FoodItem tomatoCopy = new FoodItem(tomato);
		FoodItem cabbage = new FoodItem("", 999, 0, d4, d3, 30, 20, 0);
		FoodItem f1 = new FoodItem("", 10000, 1, d4, d3, 20, 20, 0);
		FoodItem carrot = new FoodItem("carrot", 154, 30, d6, d7, 20, 30, 5);
		FoodItem onion = new FoodItem("onion", 154, 30, d6, d7, 20, 30, 5);

		System.out.println("Test is in progress please wait");

		printTestData("constructor aliasing", "d1 == tomato.getProductionDate()", d1 == tomato.getProductionDate(),
				false);
		printTestData("constructor aliasing", "d2 == tomato.getExpiryDate()", d2 == tomato.getExpiryDate(), false);
		printTestData("copy constructor aliasing", "tomato.getProductionDate() == tomatoCopy.getProductionDate()",
				tomato.getProductionDate() == tomatoCopy.getProductionDate(), false);
		printTestData("copy constructor aliasing", "tomato.getExpiryDate() == tomatoCopy.getExpiryDate()",
				tomato.getExpiryDate() == tomatoCopy.getExpiryDate(), false);

		printTestData("default name", "cabbage.getName().equals(\"item\")", cabbage.getName().equals("item"), true);
		printTestData("default catalogue", "cabbage.getCatalogueNumber() == 9999",
				cabbage.getCatalogueNumber() == 9999, true);
		printTestData("default catalogue", "f1.getCatalogueNumber() == 9999", f1.getCatalogueNumber() == 9999, true);
		printTestData("default quantity", "cabbage.getQuantity() == 0", cabbage.getQuantity() == 0, true);
		printTestData("default production date", "cabbage.getProductionDate().equals(d4)",
				cabbage.getProductionDate().equals(d4), true);
		printTestData("default expiry date", "cabbage.getExpiryDate().equals(d4.tomorrow())",
				cabbage.getExpiryDate().equals(d4.tomorrow()), true);
		printTestData("default min temperature", "cabbage.getCatalogueNumber() == 9999",
				cabbage.getMinTemperature() == 20, true);
		printTestData("default max temperature", "cabbage.getMaxTemperature() == 30", cabbage.getMaxTemperature() == 30,
				true);
		printTestData("default price", "cabbage.getPrice() == 1", cabbage.getPrice() == 1, true);

		tomato.setQuantity(-1);
		printTestData("setQuantity", "tomato.getQuantity() == -1", tomato.getQuantity() == -1, false);
		tomato.setQuantity(0);
		printTestData("setQuantity", "tomato.getQuantity() == 0", tomato.getQuantity() == 0, true);
		tomato.setQuantity(1);
		printTestData("setQuantity", "tomato.getQuantity() == 1", tomato.getQuantity() == 1, true);

		printTestData("getProductionDate aliasing", "carrot.getProductionDate() == d6",
				carrot.getProductionDate() == d6, false);
		printTestData("getExpiryDate aliasing", "carrot.getExpiryDate() == d7", carrot.getExpiryDate() == d7, false);

		printTestData("setProductionDate aliasing", "tomato.getProductionDate() == d1",
				tomato.getProductionDate() == d1, false);
		tomato.setProductionDate(d0);
		d0.setDay(15);
		printTestData("setProductionDate aliasing", "tomato.getProductionDate().getDay() == 15",
				tomato.getProductionDate().getDay() == 15, false);
		tomato.setProductionDate(d3);
		printTestData("setProductionDate", "tomato.getProductionDate().equals(d3)",
				tomato.getProductionDate().equals(d3), false);
		tomato.setProductionDate(tomato.getExpiryDate());
		printTestData("setProductionDate", "tomato.getProductionDate().equals(tomato.getExpiryDate())",
				tomato.getProductionDate().equals(tomato.getExpiryDate()), true);

		printTestData("setExpiryDate aliasing", "tomato.getExpiryDate() == d2", tomato.getExpiryDate() == d2, false);
		tomato.setExpiryDate(d5);
		d5.setDay(15);
		printTestData("setExpiryDate aliasing", "tomato.getExpiryDate().getDay() == 15",
				tomato.getExpiryDate().getDay() == 15, false);
		tomato.setExpiryDate(d_1);
		printTestData("setExpiryDate", "cabbage.getExpiryDate().equals(d_1)", tomato.getExpiryDate().equals(d_1), false);
		tomato.setExpiryDate(tomato.getProductionDate());
		printTestData("setExpiryDate", "cabbage.getExpiryDate().equals(tomato.getProductionDate())",
				tomato.getExpiryDate().equals(tomato.getProductionDate()), true);

		cabbage.setPrice(0);
		printTestData("setPrice", "cabbage.getPrice() == 0", cabbage.getPrice() == 0, false);
		cabbage.setPrice(1);
		printTestData("setPrice", "cabbage.getPrice() == 1", cabbage.getPrice() == 1, true);
		cabbage.setPrice(-1);
		printTestData("setPrice", "cabbage.getPrice() == -1", cabbage.getPrice() == -1, false);

		printTestData("equals", "cabbage.equals(tomato)", cabbage.equals(tomato), false);
		//printTestData("equals", "cabbage.equals(cabbage)", cabbage.equals(cabbage), true);
		printTestData("equals", "cabbage.equals(carrot)", cabbage.equals(carrot), false);
		printTestData("equals", "cabbage.equals(new FoodItem(cabbage))", cabbage.equals(new FoodItem(cabbage)), true);

		printTestData("isFresh", "carrot.isFresh(d0)", carrot.isFresh(d0), false);
		printTestData("isFresh", "carrot.isFresh(d8)", carrot.isFresh(d8), false);
		printTestData("isFresh", "carrot.isFresh(d6)", carrot.isFresh(d6), true);
		printTestData("isFresh", "carrot.isFresh(d7)", carrot.isFresh(d7), true);
		printTestData("isFresh", "carrot.isFresh(d6_5)", carrot.isFresh(d6_5), true);

		String carrotToString = "FoodItem: carrot\tCatalogueNumber: 9999\tProductionDate: 23/06/2019\tExpiryDate: 24/01/2020\tQuantity: 30";
		printTestData("toString", "carrot.toString().equals(carrotToString)", carrot.toString().equals(carrotToString),
				true);

		printTestData("olderFoodItem", "carrot.olderFoodItem(onion)", carrot.olderFoodItem(onion), false);
		onion.setProductionDate(d6_5);
		printTestData("olderFoodItem", "carrot.olderFoodItem(onion)", carrot.olderFoodItem(onion), true);
		onion.setExpiryDate(d6_5);
		printTestData("olderFoodItem", "carrot.olderFoodItem(onion)", carrot.olderFoodItem(onion), true);
		onion.setExpiryDate(d8);
		printTestData("olderFoodItem", "carrot.olderFoodItem(onion)", carrot.olderFoodItem(onion), true);
		onion.setProductionDate(d7);
		printTestData("olderFoodItem", "carrot.olderFoodItem(onion)", carrot.olderFoodItem(onion), true);
		onion.setExpiryDate(d7);
		printTestData("olderFoodItem", "carrot.olderFoodItem(onion)", carrot.olderFoodItem(onion), true);
		onion.setProductionDate(d5);
		printTestData("olderFoodItem", "carrot.olderFoodItem(onion)", carrot.olderFoodItem(onion), false);
		onion.setExpiryDate(d7);
		printTestData("olderFoodItem", "carrot.olderFoodItem(onion)", carrot.olderFoodItem(onion), false);
		onion.setExpiryDate(d6);
		printTestData("olderFoodItem", "carrot.olderFoodItem(onion)", carrot.olderFoodItem(onion), false);
		onion.setExpiryDate(d5);
		printTestData("olderFoodItem", "carrot.olderFoodItem(onion)", carrot.olderFoodItem(onion), false);

		printTestData("olderFoodItem", "onion.olderFoodItem(carrot)", onion.olderFoodItem(carrot), true);
		printTestData("olderFoodItem", "onion.olderFoodItem(f1)", onion.olderFoodItem(f1), false);
		printTestData("olderFoodItem", "onion.olderFoodItem(tomatoCopy)", onion.olderFoodItem(tomatoCopy), false);
		printTestData("olderFoodItem", "onion.olderFoodItem(onion)", onion.olderFoodItem(onion), false);
		printTestData("olderFoodItem", "carrot.olderFoodItem(onion)", carrot.olderFoodItem(onion), false);
		printTestData("olderFoodItem", "tomatoCopy.olderFoodItem(onion)", tomatoCopy.olderFoodItem(onion), true);
		printTestData("olderFoodItem", "carrot.olderFoodItem(cabbage)", carrot.olderFoodItem(cabbage), false);

		cabbage.setQuantity(10);
		cabbage.setPrice(3);
		printTestData("howManyItems", "cabbage.howManyItems(5) == 1", cabbage.howManyItems(5) == 1, true);
		printTestData("howManyItems", "cabbage.howManyItems(6) == 2", cabbage.howManyItems(6) == 2, true);
		printTestData("howManyItems", "cabbage.howManyItems(40) == 10", cabbage.howManyItems(40) == 10, true);
		printTestData("howManyItems", "cabbage.howManyItems(7) == 2", cabbage.howManyItems(7) == 2, true);
		printTestData("howManyItems", "cabbage.howManyItems(7) == 2", cabbage.howManyItems(0) == 0, true);
		printTestData("howManyItems", "cabbage.howManyItems(7) == 2", cabbage.howManyItems(-1) == 0, true);

		cabbage.setPrice(5);
		carrot.setPrice(8);
		printTestData("isCheaper", "cabbage.isCheaper(carrot)", cabbage.isCheaper(carrot), true);
		carrot.setPrice(4);
		printTestData("isCheaper", "cabbage.isCheaper(carrot)", cabbage.isCheaper(carrot), false);
		carrot.setPrice(cabbage.getPrice());
		printTestData("isCheaper", "cabbage.isCheaper(carrot)", cabbage.isCheaper(carrot), false);

		results();
		boolean isWorked = exportLog("FoodItem_Tester_Results_49Q14srBqj");

		if (isWorked)
		{
			System.out.println("Finished :)");
			System.out
					.println("Check your desktop, you should see a new text file named with the name that you chosen");
			System.out.println("the default file name is \"FoodItem_Tester_Results_49Q14srBqj\"");
			System.out.println("If you did failed in something you can search the word \"Failed\" in the text file");
		}
		else
			System.out.println("Something went wrong when tried to export the test results");
	}

	public static void printTestData(String methodTest, String conditionString, boolean condition,
			boolean expectedResult)
	{
		int lineNum = Thread.currentThread().getStackTrace()[2].getLineNumber();
		testLog += "\n";
		testLog += addUnderline(String.format("Testing %s - Line %d:", methodTest, lineNum)) + "\n";
		testLog += String.format("Condition: %s -> %b\n", conditionString, condition);
		testLog += String.format("Expecting: %s\n", expectedResult);

		tests++;

		if (expectedResult == condition)
		{
			testLog += "Passed\n";
			passed++;
		}
		else
		{
			testLog += "Failed\n";
			failedLines.add(lineNum);
			failed++;
		}
	}

	public static void results()
	{
		String resultLog = "";
		resultLog += addUnderline("Results:") + "\n";
		resultLog += String.format("You passed %d out of %d\n", passed, tests);

		if (failed > 0)
		{
			resultLog += String.format("You failed %d tests\n", failed);
			resultLog += String.format("Check the tests lines that you failed\n%s\n", failedLines);
		}
		else
			resultLog += "You are amazing :)\n";

		testLog = resultLog + testLog;
	}

	public static String addUnderline(String s)
	{
		return s + "\n" + new String(new char[s.length()]).replace("\0", "-");
	}

	public static boolean exportLog(String fileName)
	{
		try
		{
			String desktopPath = FileSystemView.getFileSystemView().getHomeDirectory().getPath();
			String filePath = String.format("%s\\%s.txt", desktopPath, fileName);

			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
			bw.write(testLog);
			bw.flush();
			bw.close();

			return true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return false;
	}

}
