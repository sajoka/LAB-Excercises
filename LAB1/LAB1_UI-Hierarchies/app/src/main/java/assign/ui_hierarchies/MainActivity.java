package assign.ui_hierarchies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Array of containing constant strings of countrynames
        final String[] COUNTRIES = {
                "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
                "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argenitna"
        };

        // assign the ListView from the View to myListView
        myListView = (ListView) findViewById(R.id.country_list_view);

        // create ArrayAdapter
        final ArrayAdapter<String> aa;

        // Create Adapter to populate the ListView
        // The ArrayAdapter converts from an arraylist into View items
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, COUNTRIES);
        myListView.setAdapter(aa);

    }
}
