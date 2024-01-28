package warehouse;

/*
 * Use this class to test the deleteProduct method.
 */ 
public class DeleteProduct {
    public static void main(String[] args) {
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);

	// Use this file to test deleteProduct

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
        else{   // delete
            int identification = StdIn.readInt();
            a.deleteProduct(identification);
        }
    }
    StdOut.println(a);
    }
}
