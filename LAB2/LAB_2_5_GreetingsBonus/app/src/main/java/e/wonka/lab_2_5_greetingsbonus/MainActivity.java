package e.wonka.lab_2_5_greetingsbonus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText editText;
    private TextView textView;
    private String greeting = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextView);
        textView = findViewById(R.id.textView);

        Button buttonGer = findViewById(R.id.btnGer);
        Button buttonEng = findViewById(R.id.btnEng);
        Button buttonFin = findViewById(R.id.btnFin);
        Button buttonSur = findViewById(R.id.btnSur);

        buttonEng.setOnClickListener(this);
        buttonGer.setOnClickListener(this);
        buttonFin.setOnClickListener(this);
        buttonSur.setOnClickListener(this);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                textView.setText(greeting + editText.getText().toString());
            }
        });

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnEng:
                greeting = "Hi ";
                break;
            case R.id.btnGer:
                greeting = "Hallo ";
                break;
            case R.id.btnFin:
                greeting = "Terve ";
                break;
            case R.id.btnSur:
                greeting = "Hallo Servas Griaß di ";
                break;
        }

        if(greeting != null && greeting.length() > 0){
            textView.setText(greeting + editText.getText().toString());
        }
    }
}