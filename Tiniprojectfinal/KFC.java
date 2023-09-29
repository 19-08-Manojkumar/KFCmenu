//NAME : MANOJKUMAR M
//Enrollment Number : EBEON0823780424
//Tini project title : KFC E-shopping

/*    Description: The code represents a simple command-line program for an electronic shopping system based on the menu of a KFC restaurant.
                   Overall, this code simulates a basic electronic shopping experience at a KFC restaurant, where users can view the menu,
                   add items to their cart, view their cart, calculate the total cost, and complete the purchase.
                   The code is well-structured, making it easy to understand and modify if needed. */

//Keywords used : class,public,private,new,void,if,else,switch,case,default,for,while,return,break,static,true,false,etc.
//K = keyword
//C =Concept

package Tiniprojectfinal;
import javax.xml.namespace.QName;
import java.awt.*;
import java.util.List;
import java.util.Scanner;
import java.util.*;

class MenuItem{  //K1-class, C1-class concept
    private String name;  //K2-private ,K3-String
    private double price;
    public MenuItem(String name,double price){
       this.name=name;    //K4-this
        this.price=price;
    }
    public String getName(){
       return name;    //K5-return
    }
   public double getPrice(){
       return price;
  }

 }
class Menu{
    private List<MenuItem> items;  //C2-list
    public Menu(){
      items=new ArrayList<>();   //C3-Arraylist
      items.add(new MenuItem("Chicken burger",150));
      items.add(new MenuItem("veg burger ",130));
      items.add(new MenuItem("Popcorn  Chicken",165));
      items.add(new MenuItem("Boneless strips ",219));
      items.add(new MenuItem("Smokey grill ",539));
      items.add(new MenuItem("Hot wings ",350));
    }
    public void displayMenu() {
        System.out.println("Menu card");
        int itemNo = 1;  //K6-int
        for (MenuItem item : items) {   //K7-for
            System.out.println(itemNo + " . " + item.getName() + " - ₹" + item.getPrice());
            itemNo++;
        }
    }
    public MenuItem getItem(int itemNumber){
        if (itemNumber >= 1 && itemNumber <= items.size()){  //K8-if
            return items.get(itemNumber - 1);
        }
        return null;
    }
}
class ShopingCard{  //C3-class,C4-object
    private HashMap<MenuItem, Integer> CardItems =new HashMap<>();   //C4-collection
    public void addToCard(MenuItem item,int quantity){  //K9-int
        if (CardItems.containsKey(item)){
            CardItems.put(item,CardItems.get(item)+quantity);
        }
        else {
            CardItems.put(item,quantity);   //K10-else
        }
    }
    public void ViewCard(){
        if (CardItems.isEmpty()) {
            System.out.println("Your card is empty");
        }else {
            System.out.println("Your card");
            double total= 0;             //K11-double
            for (Map.Entry<MenuItem,Integer> entry : CardItems.entrySet()){
                MenuItem item=entry.getKey();
                int quantity=entry.getValue();
                double itemTotal=item.getPrice()*quantity;
                System.out.println(item.getName()+" x "+quantity+"=  ₹ "+itemTotal);
                total+=itemTotal;
            }
            System.out.println("Total ="+total);
        }
    }
    public double CalculateTotal(){
        double total=0;
        for (Map.Entry<MenuItem,Integer> entry : CardItems.entrySet()){   //C5-for looping
            MenuItem item=entry.getKey();
            int quantity=entry.getValue();
            double itemTotal=item.getPrice()*quantity;
            total+=itemTotal;
        }
        return total;
    }
    public void checkOut(){
        double total=CalculateTotal();
        System.out.println("Total ="+total);
        System.out.println(" Please proceed to payment");
        System.out.println(" Thank you come again!!!");
    }
}

public class KFC {
    public static void main(String[]args){  //K12-Static
        Scanner sc=new Scanner(System.in);  //K13-new,C6-scanner
        Menu menu=new Menu();
        ShopingCard card=new ShopingCard();

        System.out.println("Welcome to KFC !!!");
      boolean shopping=true;  //K14-true,K15-boolean

       while(shopping){  //k16-while   //C7-while looping
            System.out.println("Options");
            System.out.println("1.View menu");
            System.out.println("2.Add items to card");
            System.out.println("3.View card");
            System.out.println("4.Checkout");
            System.out.println("5.Exit");

            System.out.print("Enter your Option : ");
            int choice= sc.nextInt();
            sc.nextLine();

            switch (choice){  //K17-switch
                case 1 :      //K18-case
                    menu.displayMenu();

                    break;    //K19-break
                case 2:
                    menu.displayMenu();
                    System.out.print("Enter the item number: ");
                    int itemNumber =sc.nextInt();
                    sc.nextLine();
                    MenuItem SelectedMenuItem=menu.getItem(itemNumber);
                    if (SelectedMenuItem!=null){  //C8-Conditional Statements
                        System.out.print("Enter the quantity : ");
                        int quantity=sc.nextInt();
                        sc.nextLine();
                        card.addToCard(SelectedMenuItem,quantity);
                        System.out.println(SelectedMenuItem.getName()+" added to your card");
                    }
                    else{
                        System.out.println("invalid option");
                    }
                    break;
                case 3:
                    card.ViewCard();
                    break;
                case 4:
                    card.ViewCard();
                    card.checkOut();
                    shopping=false;   //K20-flase
                    break;
                case 5:
                    shopping=false;
                    break;
                default:
                    System.out.println("Enter the valid option!!");
            }
        }
                sc.close();
    }
}
