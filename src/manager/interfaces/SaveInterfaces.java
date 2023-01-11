/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager.interfaces;
import entity.buyer;
import entity.ShopItem;
import java.util.List;

/**
 *
 * @author kostj
 */


public interface SaveInterfaces {
    
    public void savebuyer(List<buyer> buyers);
    public List<buyer> loadBuyers();
    
    
    public void saveitem(List<ShopItem> items);
    public List<ShopItem> loaditem();
    
    
}
