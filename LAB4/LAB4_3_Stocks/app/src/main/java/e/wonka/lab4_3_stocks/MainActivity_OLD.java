/* package e.wonka.lab4_3_stocks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class MainActivity_OLD extends AppCompatActivity {

    private TableLayout table;
    private final String [] ids = {"AAPL", "GOOGL", "FB", "NOK"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        table = (TableLayout) findViewById(R.id.table_layout);
        table.setStretchAllColumns(true);

        jsonParse(ids);

    }

    private void jsonParse(final String [] stockIDs){
        // get stocks as long as there are IDs for them
        for(int i = 0; i < stockIDs.length; i++) {
            String url = "https://financialmodelingprep.com/api/company/price/" + stockIDs[i] + "?datatype=json";
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            String result = "";
                            try{
                                result = response.toString();
                                if(result.contains("AAPL")) {
                                    addStockToTable("Apple: " + response.getJSONObject("AAPL").get("price") + " USD");
                                } else if(result.contains("GOOGL")){
                                    addStockToTable("Google: " + response.getJSONObject("GOOGL").get("price") + " USD");
                                }  else if(result.contains("FB")){
                                    addStockToTable("Facebook: " + response.getJSONObject("FB").get("price") + " USD");
                                }  else if(result.contains("NOK")){
                                    addStockToTable("Nokia: " + response.getJSONObject("NOK").get("price") + " USD");
                                }
                            } catch (Exception ex){
                                Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show();
                            }

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "Connection Error: " + error.toString() , Toast.LENGTH_LONG).show();
                        }
                    });

            // Access the RequestQueue through your singleton class.
            MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
        }
    }

    // Method to creating TableRow for each stock
    // and fill TableView with it
    private void addStockToTable(String stockString){

            TableRow row= new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            row.setBackgroundResource(R.drawable.row_border);

            TextView tv = new TextView(this);
            tv.setPadding(0,20,0,20);
            tv.setText(stockString);
            tv.setTextSize(22);
            row.addView(tv);

            table.addView(row);
        }
}
*/
