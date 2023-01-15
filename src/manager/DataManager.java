/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import entity.Punches;
import entity.buyer;
import entity.ShopItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.interfaces.SaveInterfaces;

/**
 *
 * @author kostj
 */
public class DataManager implements SaveInterfaces{
    
    private final String FILENAME_BUYERS = "files/MyBuyers";
    private final String FILENAME_ITEMS = "files/MyItems";
    private final String FILENAME_PUNCHES = "files/MyPunches";
    private final File file;
    
    public DataManager() {
        file = new File("files");
        file.mkdirs();
    }
        
    @Override
    public List<Punches> loadPunches() {
        List<Punches> Punchese = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME_PUNCHES);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Punchese = (List<Punches>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода/вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return Punchese;
    }
    @Override
    public List<buyer> loadBuyers() {
        List<buyer>  customers = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME_BUYERS);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            customers = (List<buyer>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода/вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return customers;
    }
    @Override
    public List<ShopItem> loaditem() {
        List<ShopItem> shoes = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAME_ITEMS);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            shoes = (List<ShopItem>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода/вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        return shoes;
    }
    @Override
    public void saveitem(List<ShopItem> items) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME_ITEMS);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(items);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
        }
    }
    @Override
    public void savebuyer(List<buyer> buyers) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME_BUYERS);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(buyers);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
        }
    }
    
    @Override
    public void savePunches(List<Punches> Punchese){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAME_PUNCHES);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(Punchese);
            objectOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
        }
    }
    
}
