package stock;

import date.Date;
import item.FoodItem;

import java.util.Arrays;

/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockTester
{
    public static void main(String[] args)
    {
        System.out.println("\n*********************** START OF STOCK TESTER**************************************");        
        // Stock        
        Date t1 = new Date(1,1,2000);
        Date t2 = new Date(1,1,2001);
        Date t3 = new Date(1,1,2004);
        Date t4 = new Date(12,2,2011);
        Date t5 = new Date(1,6,2003);

        FoodItem f1 = new FoodItem("Milk", 1111, 12, t1, t2, 7, 10, 3);
        FoodItem f2 = new FoodItem("Honey", 2222, 2, t1, t3, 6, 10, 20);
        FoodItem f3 = new FoodItem("PopCorn", 3333, 2, t1, t3, 6, 10, 12);
        FoodItem f4 = new FoodItem("Honey", 2222, 5, t3, t4, 6, 10, 20);
        FoodItem f5 = new FoodItem("Honey", 2222, 5, t3, t2, 6, 10, 20);
        FoodItem f6 = new FoodItem("Butter", 4444, 4, t1, t2, 6, 10, 5);

        Stock st = new Stock();
        st.addItem(f1);
        st.addItem(f2);
        st.addItem(f3);
        st.addItem(f4);
        st.addItem(f5);
        st.addItem(f6);

        System.out.println("Testing method \"getNoOfItems\":");
        System.out.println("After adding 3 Food items to the Stock, the method \"getNoOfItems\" returns: " + st.getNumOfItems()+"\n");//should print Honey and PopCorn
        System.out.print("Testing method \"toString\" - ");
        System.out.println("The Stock looks like this:\n" + st);

        String list = st.order(5);
        System.out.println("This is the list to order (items quantity below 5) : " + list);//should print Honey and PopCorn
        System.out.println("The number of items that can be store at 8 degrees are:  " + st.howMany(8));// should print 16
        System.out.println("The most expensive item on stock is:\n" + st.mostExpensive());// should print the Honey
        System.out.println("Total items in stock: " + st.howManyPieces());// should print 16

        String[] updateList={"Milk","Milk","PopCorn","Butter"};
        System.out.println("\nUpdating Stock with "+ Arrays.toString(updateList));
        st.updateStock(updateList);        
        System.out.println("List after update is (2 milks less in stock -> leaving 10 in the stock):\n"+ st);

        System.out.println("Min temperature of stock should be: " +st.getTempOfStock()); // should be 7

        st.removeAfterDate (t5);
        System.out.println("Deleting from stock all items with expiry date before "+t5+ "\n"+
            "After deletion the stock looks like this:\n" + st);

        System.out.println("\n*********************** END OF STOCK TESTER**************************************");
    }
}
