package e.wonka.lab4_4_stocks_v2;

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

    // Get stock by searching for it using ID
    public Stock getStockByID(String id){
        Stock stock = null;
        for(Stock s : stocks){
            if(s.getId() != null && s.getId().contains(id)){
                stock = s;
            }
        }
        return stock;
    }

    // Check if stock exists in array
    public Boolean isStockinArray(String id){
        boolean b = false;
        for(Stock s : stocks){
            if(s.getId() != null && s.getId().contains(id)){
                b = true;
            }
        }
        return b;
    }

    // Delete stock from array
    public void deleteStock(String id){
        int stockIndex = -1;
        for(int i = 0; i < stocks.size(); i++){
            if(stocks.get(i).getId() != null && stocks.get(i).getId().contains(id)){
                stockIndex = i;
            }
        }
        if (stockIndex != -1){
            stocks.remove(stockIndex);
        }
    }
}
