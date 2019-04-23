package e.wonka.lab4_4_stocks_v2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity_old_with_callback extends AppCompatActivity implements View.OnClickListener {

    private Button btnAdd;
    private EditText txtName;
    private EditText txtID;
    private ListView listView;
    private ArrayAdapter arrayAdapter;
    private Stocks stocks = new Stocks();
    private String tempPrice = "N.A.";

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

        // Initial stocks
        stocks.addStock(new Stock("GOOGL", "Google"));
        stocks.addStock(new Stock("FB", "Facebook"));
        stocks.addStock(new Stock("NOK", "Nokia"));

        // arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        getPrice("GOOGL");
        Log.d("PRIE", "onClick: " + tempPrice);
    }


    // Callback function to get the current stock price for stock with String id
    private void getPrice(String id){
        final String idTemp = id;
        getJSONObject(new VolleyCallback(){
            @Override
            public void onSuccess(JSONObject result){
                try{
                    tempPrice = result.getJSONObject(idTemp).get("price").toString();
                } catch (JSONException ex){
                    ex.printStackTrace();
                }
            }
        }, id);
    }

    // Fetch the JSONObject from the specific URL using the ID of the stock
    private String getJSONObject(final VolleyCallback callback, String id) {

        final String price = "N.A.";

        String url = "https://financialmodelingprep.com/api/company/price/" +
                id + "?datatype=json";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            callback.onSuccess(response);

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
        return price;
    }

    // Create and initialize ArrayAdapter
    private void setArrayAdapter(ArrayList arrayList) {
        arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
    }

    private void addStocksToTable(Stocks s) {
        for (int i = 0; i < s.getStockArray().size() - 1; i++) {
            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            TextView tv = new TextView(this);
            tv.setPadding(0, 20, 0, 20);
            tv.setText(s.getStockArray().get(i).getCompanyName() +
                    ": " + s.getStockArray().get(i).getPrice() + " USD");
            tv.setTextSize(22);
            row.addView(tv);

            listView.addView(row);
        }
    }
}
