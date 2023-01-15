/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.buyer;
import entity.Punches;
import entity.ShopItem;
import java.util.Arrays;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 *
 * @author pupil
 */
public class PunchesHistory {
    private final ItemManager itemManager;
    private final BuyerManager buyerManager;
    private final Scanner scanner;
    
    public PunchesHistory(){ 
        itemManager= new ItemManager();
        buyerManager=new BuyerManager();
        scanner= new Scanner(System.in);
}
public Punches createPunches(List<buyer> buyers, List<ShopItem> items) {
        Punches Punches = new Punches();
        
        System.out.println("Список покупателелей.");
        buyerManager.printListBuyers(buyers);
        System.out.println("Выберете номер из списка: ");
        int numberBuyer = scanner.nextInt(); scanner.nextLine();
        
        System.out.println("Список обуви.");
        itemManager.printListItems(items);
        System.out.println("Выберете номер из списка: ");
        int numberItem = scanner.nextInt(); scanner.nextLine();
        
        System.out.println("Введите количество");
        int countItem = scanner.nextInt(); scanner.nextLine();
        
//        purchase.setCustomer(customers[numberCustomer-1]);
        Punches.setCustomer(buyers.get(numberBuyer - 1));
//        purchase.setShoe(shoes[numberShoe-1]);
        Punches.setShoe(items.get(numberItem - 1));
        Punches.setCount(countItem);
        Punches.setPunchesDate(new GregorianCalendar().getTime());
//        shoes[numberShoe-1].setCountItem(shoes[numberShoe-1].getCountItem()-itemQtty);
        items.get(numberItem- 1).setAmount(items.get(numberItem - 1).getAmount() - countItem);
//        customers[numberCustomer - 1].setCash(customers[numberCustomer -1].getCash() - itemQtty * shoes[numberShoe - 1].getPrice());
        buyers.get(numberBuyer - 1).setBalance(buyers.get(numberBuyer - 1).getBalance() - countItem * items.get(numberItem - 1).getPrice());
        
        return Punches;
    }
    
    public void PriceOfAllPunches(List<Punches>punchese) {
        double shopMoney = 0;
        for(int i = 0; i < punchese.size(); i++) {
            shopMoney += punchese.get(i).getCount() * punchese.get(i).getItem().getPrice();
        }
        System.out.println("Всего заработано" + shopMoney);
    }
    
    public void printHistoryPunches(Punches[] punchese) {
        for(int i  = 0; i < punchese.length; i++) {
            Punches punches = punchese[i];
            System.out.printf("%d. Покупатель: %s. Товар: %s Количество:  %s  Дата покупки: %s%n"
                ,i + 1
                ,punches.getBuyer()
                ,punches.getItem()
                ,punches.getCount()
                ,punches.getPunchesDate()
            );
        }
    }  
}
