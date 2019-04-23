package e.wonka.lab4_3_stocks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import android.widget.ListView;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter arrayAdapter;
    private Stocks stocks = new Stocks();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI
        listView = (ListView) findViewById(R.id.list_view);

        // Adapter
        setArrayAdapter(stocks.getStockArray());

        createSomeStocks();
    }

    // Initial stocks
    private void createSomeStocks(){
        stocks.addStock(new Stock("AAPL", "Apple"));
        stocks.addStock(new Stock("GOOGL", "Google"));
        stocks.addStock(new Stock("FB", "Facebook"));
        stocks.addStock(new Stock("NOK", "Nokia"));
        setPriceForStock("AAPL");
        setPriceForStock("GOOGL");
        setPriceForStock("FB");
        setPriceForStock("NOK");
    }

    // Fetch the JSONObject from the specific URL using the ID of the stock
    private void setPriceForStock(String id) {

        final String idTemp = id;

        String url = "https://financialmodelingprep.com/api/company/price/" +
                id + "?datatype=json";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String stockPrice = response.getJSONObject(idTemp).get("price").toString();
                            stocks.searchStock(idTemp).setPrice(stockPrice);
                            arrayAdapter.notifyDataSetChanged();

                        } catch (Exception ex) {
                            Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error: " + error.toString(), Toast.LENGTH_LONG).show();
                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

    // Create and initialize ArrayAdapter
    private void setArrayAdapter(ArrayList arrayList) {
        arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
    }
}
