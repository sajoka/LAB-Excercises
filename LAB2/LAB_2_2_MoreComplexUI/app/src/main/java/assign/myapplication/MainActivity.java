package assign.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Member
    private ListView listView;

    final String[] COUNTRIES = new String[] {
            "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
            "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argenitna"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create the User Interface
        createUI();

        // Load list of countries into ListView
        final ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, COUNTRIES);
        listView.setAdapter(arrayAdapter);

    }

    // Method to create the UI
    private void createUI(){

        // LinearLayout parent view (vertical)
        LinearLayout parentLayout = new LinearLayout(this);
        parentLayout.setOrientation(LinearLayout.VERTICAL);
        parentLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        setContentView(parentLayout);

        // LinearLayout (horizontal)
        LinearLayout horizontalLayout = new LinearLayout(this);
        horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
        horizontalLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        horizontalLayout.setGravity(Gravity.CENTER);

        // Buttons
        Button addBtn = new Button(this);
        Button editBtn = new Button(this);
        Button removeBtn = new Button(this);

        addBtn.setText("ADD");
        editBtn.setText("EDIT");
        removeBtn.setText("REMOVE");

        horizontalLayout.addView(addBtn);
        horizontalLayout.addView(editBtn);
        horizontalLayout.addView(removeBtn);

        // Add layout to parent layout
        parentLayout.addView(horizontalLayout);

        // EditText
        EditText editText = new EditText(this);
        editText.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        parentLayout.addView(editText);

        // ListView
        listView = new ListView(this);
        listView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        parentLayout.addView(listView);
    }
}
