
package jktv_shop;

import java.util.Scanner;
import entity.buyer;
import entity.ShopItem;
import java.util.List;
import java.util.Arrays;
import manager.BuyerManager;
import manager.ItemManager;

import manager.DataManager;
import manager.BaseManager;
import manager.interfaces.SaveInterfaces;

public class app {
    public static boolean saveToBase;
    private final Scanner scanner;
    private final ItemManager itemManager;
    private final BuyerManager buyerManager;
    private final SaveInterfaces saveInterfaces;
    private final List<buyer>buyers;
    private final List<ShopItem>items;
         
     
     
public app(){
     scanner = new Scanner(System.in);
     itemManager = new ItemManager();
     buyerManager = new BuyerManager();
     
     if(app.saveToBase){
            saveInterfaces = new BaseManager();
        }else{
            saveInterfaces = new DataManager();
        }
        buyers = saveInterfaces.loadBuyers();
        items = saveInterfaces.loaditem();
         
     
}

    public void run(){
        
        boolean repeat = true;
        do{
            System.out.println(" Выберите задачу из списка: ");
            System.out.println("0. Закрыть приложение");
            System.out.println("1. Добавить продукт");
            System.out.println("2. Список продаваемых продуктов");
            System.out.println("3. Добавить покупателя");
            System.out.println("4. Список покупателей");
            System.out.println("5. Добавление денег покупателю");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task){
                case 0:
                    repeat = false;
                    break;
                case 1:
                    items.add(itemManager.addItem());
                    saveInterfaces.saveitem(items);
                    break;
                case 2:
                    itemManager.printListItems(items);
                    break;
                case 3:

                    buyers.add(buyerManager.createBuyer());
                    saveInterfaces.savebuyer(buyers);
                    break;
                case 4:
                    buyerManager.printListBuyers(buyers);
                    break;
                case 5:
                    buyerManager.addMoney(buyers);
                    saveInterfaces.savebuyer(buyers);
                    break;

            }
        }while(repeat);
        System.out.println("Выключаюсь!!");
    }
    
    

    
}
