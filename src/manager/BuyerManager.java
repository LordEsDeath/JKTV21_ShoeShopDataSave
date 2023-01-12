/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.buyer;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author pupil
 */

public class BuyerManager {
    private final Scanner scanner;

    public BuyerManager() {
        scanner = new Scanner(System.in);
    }
    
    public buyer createBuyer(){
        buyer buyers = new buyer();
        System.out.print("Имя покупателя: ");
        buyers.setFirstname(scanner.nextLine());
        System.out.print("Фамилия покупателя: ");
        buyers.setLastname(scanner.nextLine());
        System.out.print("Телефон покупателя: ");
        buyers.setPhone(scanner.nextLine());
        System.out.print("Его баланц: ");
        buyers.setBalance(scanner.nextFloat());scanner.nextLine();
        return buyers;
    } 
    
    public void addMoney(List<buyer> buyers) {
        
        System.out.println("Список покупателей.");
        printListBuyers(buyers);
        System.out.println("Введите номер покупателя: ");
        int numberCustomer = scanner.nextInt(); scanner.nextLine();
        System.out.printf("У него %s евро%n",buyers.get(numberCustomer - 1).getBalance());
        System.out.println("Введите сумму: ");
        double addMoney = scanner.nextDouble();scanner.nextLine();
        buyers.get(numberCustomer - 1).setBalance(buyers.get(numberCustomer - 1).getBalance() + addMoney);
        
    }
    

    public void printListBuyers(List<buyer> buyers) {
        for (int i = 0; i < buyers.size(); i++) {
            System.out.printf("%d. Имя: %s Фамилия: %s Телефон: %s Сумма: %s%n",
                    (i+1),
                    buyers.get(i).getFirstname(),
                    buyers.get(i).getLastname(),
                    buyers.get(i).getPhone(),
                    buyers.get(i).getBalance()
            );
        }
    }
     
}
