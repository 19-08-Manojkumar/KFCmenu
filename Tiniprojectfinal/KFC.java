//project title : KFC E-shopping

/*    Description: The code represents a simple command-line program for an electronic shopping system based on the menu of a KFC restaurant.
                   Overall, this code simulates a basic electronic shopping experience at a KFC restaurant, where users can view the menu,
                   add items to their cart, view their cart, calculate the total cost, and complete the purchase.
                   The code is well-structured, making it easy to understand and modify if needed. */

package Tiniprojectfinal;
import javax.xml.namespace.QName;
import java.awt.*;
import java.util.List;
import java.util.Scanner;
import java.util.*;

class MenuItem{  
    private String name;  
    private double price;
    public MenuItem(String name,double price){
       this.name=name;   
        this.price=price;
    }
    public String getName(){
       return name;    
    }
   public double getPrice(){
       return price;
  }

 }
class Menu{
    private List<MenuItem> items;  
    public Menu(){
      items=new ArrayList<>();   
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
        for (MenuItem item : items) {  
            System.out.println(itemNo + " . " + item.getName() + " - ₹" + item.getPrice());
            itemNo++;
        }
    }
    public MenuItem getItem(int itemNumber){
        if (itemNumber >= 1 && itemNumber <= items.size()){  
            return items.get(itemNumber - 1);
        }
        return null;
    }
}
class ShopingCard{  //C3-class,C4-object
    private HashMap<MenuItem, Integer> CardItems =new HashMap<>();   
    public void addToCard(MenuItem item,int quantity){  
        if (CardItems.containsKey(item)){
            CardItems.put(item,CardItems.get(item)+quantity);
        }
        else {
            CardItems.put(item,quantity);   
        }
    }
    public void ViewCard(){
        if (CardItems.isEmpty()) {
            System.out.println("Your card is empty");
        }else {
            System.out.println("Your card");
            double total= 0;             
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
        for (Map.Entry<MenuItem,Integer> entry : CardItems.entrySet()){   
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
    public static void main(String[]args){  
        Scanner sc=new Scanner(System.in); 
        Menu menu=new Menu();
        ShopingCard card=new ShopingCard();

        System.out.println("Welcome to KFC !!!");
      boolean shopping=true;  

       while(shopping){  //k16-while   
            System.out.println("Options");
            System.out.println("1.View menu");
            System.out.println("2.Add items to card");
            System.out.println("3.View card");
            System.out.println("4.Checkout");
            System.out.println("5.Exit");

            System.out.print("Enter your Option : ");
            int choice= sc.nextInt();
            sc.nextLine();

            switch (choice){ 
                case 1 :     
                    menu.displayMenu();

                    break;    
                case 2:
                    menu.displayMenu();
                    System.out.print("Enter the item number: ");
                    int itemNumber =sc.nextInt();
                    sc.nextLine();
                    MenuItem SelectedMenuItem=menu.getItem(itemNumber);
                    if (SelectedMenuItem!=null){  
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
                    shopping=false;   
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
