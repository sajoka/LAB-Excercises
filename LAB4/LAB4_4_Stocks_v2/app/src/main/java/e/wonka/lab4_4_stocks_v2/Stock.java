package e.wonka.lab4_4_stocks_v2;

public class Stock {

    // Member
    private String id;
    private String companyName;
    private String price = "0";

    // Constructor
    public Stock(String id, String companyName){
        this.id = id;
        this.companyName = companyName;
    }

    // Constructor 2
    public Stock(String id, String companyName, String price){
        this.id = id;
        this.companyName = companyName;
        this.price = price;
    }

    // Set stocks price
    public void setPrice(String p){
        this.price = p;
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPrice() {
        return price;
    }

    // Override String method to show it correctly in ListView of MainActivity
    @Override
    public String toString() {
        return this.companyName + ": " + this.price + " USD";
    }
}
