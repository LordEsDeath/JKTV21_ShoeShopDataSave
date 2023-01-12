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
}
