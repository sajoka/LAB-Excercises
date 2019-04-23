package e.wonka.lab4_4_stocks_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAdd;
    private EditText txtName;
    private EditText txtID;
    private ListView listView;
    private ArrayAdapter arrayAdapter;
    private Stocks stocks = new Stocks();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI
        listView = (ListView) findViewById(R.id.list_view);

        txtName = (EditText) findViewById(R.id.txt_stock_name);
        txtID = (EditText) findViewById(R.id.txt_stock_id);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        // Adapter
        setArrayAdapter(stocks.getStockArray());

        setSomeInitialStocks();
    }

    @Override
    public void onClick(View view) {
        if(!TextUtils.isEmpty(txtName.getText().toString()) && !TextUtils.isEmpty(txtID.getText().toString())){
            createNewStock(txtName.getText().toString(), txtID.getText().toString());
        } else {
            Toast.makeText(this, "Please enter company name and ID", Toast.LENGTH_SHORT).show();
        }
    }

    private void createNewStock(String name, String id){
        String sid = id.toUpperCase();
        if (!stocks.isStockinArray(sid)){
            stocks.addStock(new Stock(sid, name));
            setPriceForStock(sid);
        } else {
            Toast.makeText(this, "Stock with ID " + sid + " already added!",
                    Toast.LENGTH_LONG).show();
        }
    }

    // Some stocks on start of the app for demonstration
    private void setSomeInitialStocks(){
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
                            stocks.getStockByID(idTemp).setPrice(stockPrice);
                            arrayAdapter.notifyDataSetChanged();
                        } catch (Exception ex) {
                            Toast.makeText(getApplicationContext(), "ERROR: " + ex.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // delete the created stock from array when there is no price/id found
                        stocks.deleteStock(idTemp);
                        Toast.makeText(getApplicationContext(), "Stock not found, check the ID.", Toast.LENGTH_LONG).show();
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
