package e.wonka.lab3_2_external_activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button btnWebsite, btnCall, btnMap;
    private EditText editTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buttons
        btnMap = findViewById(R.id.btn_openmap);
        btnMap.setOnClickListener(this);
        btnCall = findViewById(R.id.btn_createcall);
        btnCall.setOnClickListener(this);
        btnWebsite = findViewById(R.id.btn_website);
        btnWebsite.setOnClickListener(this);

        // EditText
        editTxt = findViewById(R.id.editText);
    }

    // Handler for OnClick-events (buttons)
    @Override
    public void onClick(View view) {
        Log.d("BUTTONS-CHECK", "onClick: called.");

        Intent intent;
        String url;

        switch (view.getId()){
                case R.id.btn_openmap:
                    intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("https://www.google.com/maps/place/Kotkantie+1," +
                                    "+90250+Oulu/@64.9996576,25.508514,17z/data=!3m1!4b1!4m5!3m4!" +
                                    "1s0x4681cd4540f50ef9:0x3ca7d42e58868c06!8m2!3d64.9996576!4d25.5107028"));
                    startActivity(intent);
                    break;
                case R.id.btn_createcall:
                    intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+358206110200"));
                    startActivity(intent);
                    break;
                case R.id.btn_website:
                    url = editTxt.getText().toString();

                    try {
                        // check URL
                        if (!url.substring(0,4).equals("https")){
                            url = "https://www." + url;
                        }
                        intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    }catch (Exception ex){
                        Toast.makeText(MainActivity.this,
                                "Incorrect URL: " + ex,
                                Toast.LENGTH_LONG).show();
                    }
                    break;
        }
    }
}
