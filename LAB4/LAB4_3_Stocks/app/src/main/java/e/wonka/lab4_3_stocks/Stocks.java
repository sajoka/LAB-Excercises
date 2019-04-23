package e.wonka.lab4_3_stocks;

import java.util.ArrayList;

public class Stocks {

    // Member
    private ArrayList<Stock> stocks;

    // Constructor
    public Stocks(){
        stocks = new ArrayList<>();
    }

    // Add new Stock to Array
    public void addStock(Stock stock){
        stocks.add(stock);
    }

    // Getter
    public ArrayList<Stock> getStockArray() {
        return stocks;
    }

    // Search for stock in array using ID
    public Stock searchStock(String id){
        Stock stock = null;
        for(Stock s : stocks){
            if(s.getId() != null && s.getId().contains(id)){
                stock = s;
            }
        }
        return stock;
    }
}
