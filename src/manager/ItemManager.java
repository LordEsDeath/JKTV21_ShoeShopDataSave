/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.ShopItem;
import entity.buyer;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class ItemManager {
     private final Scanner scanner;
     
public ItemManager(){
     scanner = new Scanner(System.in);
}

public ShopItem addItem(){
                    ShopItem item = new ShopItem();
                    System.out.println("Введите название обуви: ");
                    item.setName(scanner.nextLine());
                    System.out.println("Укажите Цену: ");
                    item.setPrice(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Укажите количество Продуктов: ");
                    item.setAmount(scanner.nextInt());
                    scanner.nextLine();
         return item;


}
public void printListItems(List<ShopItem> items){
    
for(int i  = 0; i < items.size(); i++) {
            System.out.printf("%d. Название: %s Цена: %s Количество: %s%n"
                    ,(i+1)
                    ,items.get(i).getName()
                    ,items.get(i).getPrice()
                    ,items.get(i).getAmount()
                    
            );
        }
    }

}