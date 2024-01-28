package warehouse;

public class Restock {
    public static void main(String[] args) {
        StdIn.setFile("restock.in");
        StdOut.setFile("restock.out");

        // Uset his file to test restock
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
            else{   // restock
                int identification = StdIn.readInt();
                int amount = StdIn.readInt();
                a.restockProduct(identification,amount);
            }
        }
        StdOut.println(a);
    }
}
