package warehouse;

/*
 * Use this class to test to addProduct method.
 */
public class AddProduct {
    public static void main(String[] args) {
        StdIn.setFile(args[0]);
        StdOut.setFile(args[1]);

	    // Use this file to test addProduct
        int number = StdIn.readInt();
        Warehouse a = new Warehouse();

        for(int i = 0;i< number;i++){
            int day = StdIn.readInt();
            int id = StdIn.readInt();
            String name = StdIn.readString();
            int stock = StdIn.readInt();
            int demand = StdIn.readInt();
            a.addProduct(id,name,stock,day,demand);
        }
        StdOut.println(a);
    }
}
