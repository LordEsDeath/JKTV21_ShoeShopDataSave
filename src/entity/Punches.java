/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
/**
 *
 * @author pupil
 */
@Entity
public class Punches implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = {CascadeType.MERGE})
    private buyer buyer;
    @OneToOne (cascade = {CascadeType.MERGE})
    private ShopItem item;
    private int countItem;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date punchesDate;

    public Punches() {
    }

    public buyer getBuyer() {
        return buyer;
    }

    public void setCustomer(buyer buyer) {
        this.buyer = buyer;
    }

    public ShopItem getItem() {
        return item;
    }

    public void setShoe(ShopItem item) {
        this.item = item;
    }

    public int getCount() {
        return countItem;
    }

    public void setCount(int countItem) {
        this.countItem = countItem;
    }

    public Date getPunchesDate() {
        return punchesDate;
    }

    public void setPunchesDate(Date punchesDate) {
        this.punchesDate = punchesDate;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Puchase{" 
                + "customer=" + buyer 
                + ", shoe=" + item
                + ", countItem=" + countItem 
                + ", punchesDate=" + punchesDate 
                + '}';
    }
}
