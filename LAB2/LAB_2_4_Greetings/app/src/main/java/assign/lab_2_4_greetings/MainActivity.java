package assign.lab_2_4_greetings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText editText;
    private TextView textView;

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
    }

    @Override
    public void onClick(View view) {
        String enteredText =editText.getText().toString();

        switch (view.getId()){
            case R.id.btnEng:
                textView.setText("Hi " + enteredText + "!");
                break;
            case R.id.btnGer:
                textView.setText("Hallo " + enteredText + "!");
                break;
            case R.id.btnFin:
                textView.setText("Terve " + enteredText + "!");
                break;
            case R.id.btnSur:
                textView.setText("Hawe dere " + enteredText + "!");
                break;
        }
    }
}
