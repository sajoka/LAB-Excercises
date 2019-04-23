package e.wonka.lab_2_3_morecomplexuiv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Member
    private ListView listView;
    private EditText editText;
    private ArrayList <String> countryArray = new ArrayList();
    private ArrayAdapter<String> arrayAdapter;

    final String[] COUNTRIES = {
            "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra"
            /*, "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argenitna"*/
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createUI();

        fillArrayList(COUNTRIES);

        setArrayAdapter(countryArray);
    }

    // Create and initialize ArrayAdapter
    private void setArrayAdapter(ArrayList arrayList){
        arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

    }

    // Fill an ArrayList with data from any String []
    private void fillArrayList(String [] stringArray){
        for(int i=0; i < stringArray.length; i++){
            countryArray.add(stringArray[i]);
        }
    }

    // Add Button pressed
    private void addButtonPressed(){
        String text = editText.getText().toString();
        if((text != null && text.length() > 0) && !countryArray.contains(text) ) {
            countryArray.add(text);
        }
        arrayAdapter.notifyDataSetChanged();
    }

    // Remove Button pressed
    private void removeButtonPressed(){
        String text = editText.getText().toString();
        countryArray.remove(text);
        arrayAdapter.notifyDataSetChanged();
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

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addButtonPressed();
            }
        });

        removeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                removeButtonPressed();
            }
        });

        // Add layout to parent layout
        parentLayout.addView(horizontalLayout);

        // EditText
        editText = new EditText(this);
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
