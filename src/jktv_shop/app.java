
package jktv_shop;

import entity.Punches;
import java.util.Scanner;
import entity.buyer;
import entity.ShopItem;
import java.util.List;
import java.util.Arrays;
import manager.BuyerManager;
import manager.ItemManager;
import manager.PunchesHistory;

import manager.DataManager;
import manager.BaseManager;
import manager.interfaces.SaveInterfaces;

public class app {
    public static boolean saveToBase;
    private final Scanner scanner;
    private final ItemManager itemManager;
    private final BuyerManager buyerManager;
    private final PunchesHistory punchesHistory;
    private final SaveInterfaces saveInterfaces;
    private final List<buyer>buyers;
    private final List<ShopItem>items;
    private final List<Punches>Punches;

         
     
     
public app(){
     scanner = new Scanner(System.in);
     itemManager = new ItemManager();
     buyerManager = new BuyerManager();
     punchesHistory = new PunchesHistory();
     
     if(app.saveToBase){
            saveInterfaces = new BaseManager();
        }else{
            saveInterfaces = new DataManager();
        }
        buyers = saveInterfaces.loadBuyers();
        items = saveInterfaces.loaditem();
        Punches = saveInterfaces.loadPunches();
         
     
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
            System.out.println("5. Совершить покупку");
            System.out.println("6. Сколько денег заработал магазин");
            System.out.println("7. Добавление денег покупателю");
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
//                    addPurchase(pm.createPurchase(customers, shoes));
                    Punches.add(punchesHistory.createPunches(buyers, items));
//                    dataManager.savePurchases(purchases);
//                    dataManager.saveCustomers(customers);
//                    dataManager.saveShoes(shoes);
                    saveInterfaces.savePunches(Punches);
                    saveInterfaces.savebuyer(buyers);
                    saveInterfaces.saveitem(items);
                    break;
                case 6:
//                    pm.PriceOfAllPurchase(purchases);
                    punchesHistory.PriceOfAllPunches(Punches);
                    break;
                case 7:
                    buyerManager.addMoney(buyers);
                    saveInterfaces.savebuyer(buyers);
                    break;

            }
        }while(repeat);
        System.out.println("Выключаюсь!!");
    }
    
    

    
}
