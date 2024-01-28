package warehouse;

/*
 * Use this class to test the betterAddProduct method.
 */ 
public class BetterAddProduct {
    public static void main(String[] args) {
        StdIn.setFile("betteraddproduct.in");
        StdOut.setFile("betteraddproduct.out");
        
        // Use this file to test betterAddProduct


        Warehouse a = new Warehouse();
        int queries = StdIn.readInt();

        for(int i=0;i<queries;i++){
            int day = StdIn.readInt();
            int identification= StdIn.readInt();
            String name = StdIn.readString();
            int stock = StdIn.readInt();
            int demand = StdIn.readInt();
            a.betterAddProduct(identification, name, stock, day, demand);
        }
        StdOut.println(a);
    }
}
