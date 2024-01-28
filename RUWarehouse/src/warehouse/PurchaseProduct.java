package warehouse;

public class PurchaseProduct {
    public static void main(String[] args) {
        StdIn.setFile("purchaseproduct.in");
        StdOut.setFile("purchaseproduct.out");

	// Use this file to test purchaseProduct

    Warehouse a = new Warehouse();
    int queries = StdIn.readInt();

    for(int i=0;i<queries;i++){
        String find = StdIn.readString();   // add or restock
    
        if(find.equalsIgnoreCase("add")){  // add
            int day = StdIn.readInt();
            int identification= StdIn.readInt();
            String name = StdIn.readString();
            int stock = StdIn.readInt();
            int demand = StdIn.readInt();
            a.addProduct(identification, name, stock, day, demand);
        }
        else{   // purchase Product
            int day = StdIn.readInt();
            int identification = StdIn.readInt();
            int amount = StdIn.readInt();
            a.purchaseProduct(identification, day, amount);
        }
    }
    StdOut.println(a);
    }
}
