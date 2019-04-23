package e.wonka.lab3_1_menus;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View view;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txt_color);

        // get constraint layout (view)
        view = findViewById(R.id.layout);
    }

    // Loads color_menu.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.color_menu, menu);
        return true;
    }

    // Handler for selection in menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_blue:
                textView.setText("Blue");
                view.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                showToast("Blue clicked");
                return true;
            case R.id.menu_green:
                textView.setText("Green");
                view.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                showToast("Green clicked");
                return true;
            case R.id.menu_red:
                textView.setText("Red");
                view.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                showToast("Red clicked");
                return true;
            case R.id.menu_yellow:
                textView.setText("(Almost) Yellow");
                view.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                showToast("Yellow clicked");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Pop-up message (for testings)
    public void showToast(String message)
    {
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
