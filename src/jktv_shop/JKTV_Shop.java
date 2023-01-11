
package jktv_shop;


public class JKTV_Shop {


    public static void main(String[] args) {
        if(args.length > 0 && "base".equals(args[0])){
            app.saveToBase = true;
        }else{
            app.saveToBase = false;
        }
        app app = new app();
        app.run();
    }
    
}
