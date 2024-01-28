package warehouse;

/*
 *
 * This class implements a warehouse on a Hash Table like structure, 
 * where each entry of the table stores a priority queue. 
 * Due to your limited space, you are unable to simply rehash to get more space. 
 * However, you can use your priority queue structure to delete less popular items 
 * and keep the space constant.
 * 
 * @author Ishaan Ivaturi
 */ 
public class Warehouse {
    private Sector[] sectors;
    
    // Initializes every sector to an empty sector
    public Warehouse() {
        sectors = new Sector[10];

        for (int i = 0; i < 10; i++) {
            sectors[i] = new Sector();
        }
    }
    
    /**
     * Provided method, code the parts to add their behavior
     * @param id The id of the item to add
     * @param name The name of the item to add
     * @param stock The stock of the item to add
     * @param day The day of the item to add
     * @param demand Initial demand of the item to add
     */
    public void addProduct(int id, String name, int stock, int day, int demand) {
        evictIfNeeded(id);
        addToEnd(id, name, stock, day, demand);
        fixHeap(id);
    }

    /**
     * Add a new product to the end of the correct sector
     * Requires proper use of the .add() method in the Sector class
     * @param id The id of the item to add
     * @param name The name of the item to add
     * @param stock The stock of the item to add
     * @param day The day of the item to add
     * @param demand Initial demand of the item to add
     */
    private void addToEnd(int id, String name, int stock, int day, int demand) {
        // IMPLEMENT THIS METHOD
        Product something = new Product(id, name, stock, day, demand);
        int location = id % 10;
        sectors[location].add(something);
    }

    /**
     * Fix the heap structure of the sector, assuming the item was already added
     * Requires proper use of the .swim() and .getSize() methods in the Sector class
     * @param id The id of the item which was added
     */
    private void fixHeap(int id) {
        // IMPLEMENT THIS METHOD
        int location = id % 10;
        int index = sectors[location].getSize();
        sectors[location].swim(index);
    }

    /**
     * Delete the least popular item in the correct sector, only if its size is 5 while maintaining heap
     * Requires proper use of the .swap(), .deleteLast(), and .sink() methods in the Sector class
     * @param id The id of the item which is about to be added
     */
    private void evictIfNeeded(int id) {
       // IMPLEMENT THIS METHOD
       int location = id % 10;
       
       if(sectors[location].getSize() == 5){
            int lowest = 1;
            for(int i = 2; i < 6; i++){
             if(sectors[location].get(i).getPopularity() < sectors[location].get(lowest).getPopularity()){
                lowest = i;
             }
            }
            sectors[location].swap(lowest,5);
            sectors[location].deleteLast();
            sectors[location].sink(lowest);
            
       }
    }

    /**
     * Update the stock of some item by some amount
     * Requires proper use of the .getSize() and .get() methods in the Sector class
     * Requires proper use of the .updateStock() method in the Product class
     * @param id The id of the item to restock
     * @param amount The amount by which to update the stock
     */
    public void restockProduct(int id, int amount) {
        // IMPLEMENT THIS METHOD
        int location = id % 10;

        for(int i = 1; i <= sectors[location].getSize();i++){
            if(sectors[location].get(i).getId() == id){
                sectors[location].get(i).updateStock(amount);
            }
        }
    }
    
    /**
     * Delete some arbitrary product while maintaining the heap structure in O(logn)
     * Requires proper use of the .getSize(), .get(), .swap(), .deleteLast(), .sink() and/or .swim() methods
     * Requires proper use of the .getId() method from the Product class
     * @param id The id of the product to delete
     */
    public void deleteProduct(int id) {
        // IMPLEMENT THIS METHOD
        int location = id % 10;

        for(int i = 1; i <= sectors[location].getSize();i++){
            if(sectors[location].get(i).getId() == id){  
                sectors[location].swap(i,sectors[location].getSize());
                sectors[location].deleteLast();
                sectors[location].sink(i);
            }
        }
    }
    
    /**
     * Simulate a purchase order for some product
     * Requires proper use of the getSize(), sink(), get() methods in the Sector class
     * Requires proper use of the getId(), getStock(), setLastPurchaseDay(), updateStock(), updateDemand() methods
     * @param id The id of the purchased product
     * @param day The current day
     * @param amount The amount purchased
     */
    public void purchaseProduct(int id, int day, int amount) {
        // IMPLEMENT THIS METHOD
        int location = id % 10;

        for(int i = 1; i <= sectors[location].getSize();i++){
            if(sectors[location].get(i).getId() == id){
                if(sectors[location].get(i).getStock() >= amount){
                    sectors[location].get(i).updateStock(-amount);
                    sectors[location].get(i).setLastPurchaseDay(day);
                    sectors[location].get(i).updateDemand(amount);
                    sectors[location].sink(i);
                }
            }
        }
    }
    
    /**
     * Construct a better scheme to add a product, where empty spaces are always filled
     * @param id The id of the item to add
     * @param name The name of the item to add
     * @param stock The stock of the item to add
     * @param day The day of the item to add
     * @param demand Initial demand of the item to add
     */
    public void betterAddProduct(int id, String name, int stock, int day, int demand) {
        // IMPLEMENT THIS METHOD
        int location = id % 10;
        int checkL;

        checkL = location + 1;
        if(checkL == 10){
            checkL = 0;
        }

        if(sectors[location].getSize() < 5){       // if there is space
            addToEnd(location, name, stock, day, demand);
            fixHeap(location);
        }
        
        else{
            while(sectors[checkL].getSize() == 5 && checkL != location){
            if(checkL == 9){
                checkL = 0;
                }
                else{
                    checkL++;
                }
            }
            evictIfNeeded(checkL);
            addToEnd(checkL, name, stock, day, demand);
            fixHeap(checkL);
        }
    }

    /*
     * Returns the string representation of the warehouse
     */
    public String toString() {
        String warehouseString = "[\n";

        for (int i = 0; i < 10; i++) {
            warehouseString += "\t" + sectors[i].toString() + "\n";
        }
        
        return warehouseString + "]";
    }

    /*
     * Do not remove this method, it is used by Autolab
     */ 
    public Sector[] getSectors () {
        return sectors;
    }
}
