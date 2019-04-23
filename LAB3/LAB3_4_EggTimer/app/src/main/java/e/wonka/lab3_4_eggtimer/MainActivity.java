package e.wonka.lab3_4_eggtimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private int seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtTime = findViewById(R.id.txt_time);
        Button btnStart = findViewById(R.id.btn_start);

        // Button onClick
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seconds = Integer.parseInt(txtTime.getText().toString());
                Intent intent = new Intent(MainActivity.this, TimerCountdownActivity.class);

                // pass seconds to other activity
                intent.putExtra("seconds", seconds);
                startActivity(intent);
            }
        });

    }
}
