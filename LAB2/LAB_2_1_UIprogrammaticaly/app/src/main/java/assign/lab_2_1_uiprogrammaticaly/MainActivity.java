package assign.lab_2_1_uiprogrammaticaly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // User Interface (adds Button to the ContentView
        final Button gameButton = new Button(this);
        gameButton.setText("I'm a button, click me!");
        setContentView(gameButton);

        // OnClick
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCount++;
                gameButton.setText("You have clicked me " + clickCount + " times.");
            }
        });

    }
}
