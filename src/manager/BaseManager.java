/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import entity.Punches;
import entity.buyer;
import entity.ShopItem;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import manager.interfaces.SaveInterfaces;
/**
 *
 * @author kostj
 */
public class BaseManager implements SaveInterfaces{
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public BaseManager() {
        emf = Persistence.createEntityManagerFactory("shoeshop");
        em = emf.createEntityManager();
    }
    @Override
   public void savebuyer(List<buyer> buyers) {
       em.getTransaction().begin();
       for (int i = 0; i < buyers.size(); i++) {
           buyer Buyer = buyers.get(i);
           if(Buyer.getId() == null){
                em.persist(Buyer);
            }else{
                em.merge(Buyer);
            }
       }
       em.getTransaction().commit();
   }
   @Override
   public List<buyer> loadBuyers() {
       return em.createQuery("SELECT b FROM buyer b").getResultList();
   }
    @Override
   public void saveitem(List<ShopItem> items) {
       em.getTransaction().begin();
       for (int i = 0; i < items.size(); i++) {
           ShopItem item = items.get(i);
           if(item.getId() == null){
                em.persist(item);
            }else{
                em.merge(item);
            }
       }
       em.getTransaction().commit();
   }
   @Override
   public List<ShopItem> loaditem() {
       return em.createQuery("SELECT s FROM ShopItem s").getResultList();
   }
@Override
   public void savePunches(List<Punches> Punchese) {
        em.getTransaction().begin();
       for (int i = 0; i < Punchese.size(); i++) {
           Punches punchese = Punchese.get(i);
           if(punchese.getId() == null){
                em.persist(punchese);
            }else{
                em.merge(punchese);
            }
       }
       em.getTransaction().commit();
   }

    @Override
   public List<Punches> loadPunches() {
       return em.createQuery("SELECT p FROM Punches p").getResultList();
   }
}