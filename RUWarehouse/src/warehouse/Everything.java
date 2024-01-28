package warehouse;

/*
 * Use this class to put it all together.
 */ 
public class Everything {
    public static void main(String[] args) {
        StdIn.setFile("everything.in");
        StdOut.setFile("everything.out");

	// Use this file to test all methods

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
            else if(find.equalsIgnoreCase("purchase")){   // purchase Product
                int day = StdIn.readInt();
                int identification = StdIn.readInt();
                int amount = StdIn.readInt();
                a.purchaseProduct(identification, day, amount);
            }
            else if(find.equalsIgnoreCase("delete")){   // purchase Product
                int identification = StdIn.readInt();
                a.deleteProduct(identification);
            }
            else if(find.equalsIgnoreCase("restock")){   // purchase Product
                int identification = StdIn.readInt();
                int amount = StdIn.readInt();
                a.restockProduct(identification,amount);
            }
        }
        StdOut.println(a);
    }
}
