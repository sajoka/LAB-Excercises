package e.wonka.lab3_3_zoo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity_OLD extends AppCompatActivity implements View.OnClickListener {

    // value for selection [0 = mammals, 1 = birds]
    private int selection = 0;

    private ImageView topLeft, topRight, bottomLeft, bottomRight;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ImageViews
        topLeft = findViewById(R.id.top_left);
        topRight = findViewById(R.id.top_right);
        bottomLeft = findViewById(R.id.bottom_left);
        bottomRight = findViewById(R.id.bottom_right);

        // OnClickListener for ImageViews
        topLeft.setOnClickListener(this);
        topRight.setOnClickListener(this);
        bottomLeft.setOnClickListener(this);
        bottomRight.setOnClickListener(this);
    }

    // Get animals
    private void loadAnimals(int i){
        switch (i){
            case 0:
                topLeft.setImageResource(R.drawable.bear);
                topRight.setImageResource(R.drawable.wolf);
                bottomLeft.setImageResource(R.drawable.elephant);
                bottomRight.setImageResource(R.drawable.lamb);
                break;
            case 1:
                topLeft.setImageResource(R.drawable.huuhkaja);
                topRight.setImageResource(R.drawable.peippo);
                bottomLeft.setImageResource(R.drawable.peukaloinen);
                bottomRight.setImageResource(R.drawable.punatulkku);
                break;
                default:
                    break;
        }
    }

    // OnClick Listener for sounds
    @Override
    public void onClick(View view) {
        if(selection == 0){
            switch(view.getId()){
                case R.id.top_left:
                    playSound(R.raw.bear);
                    break;
                case R.id.top_right:
                    playSound(R.raw.wolf);
                    break;
                case R.id.bottom_left:
                    playSound(R.raw.elephant);
                    break;
                case R.id.bottom_right:
                    playSound(R.raw.lamb);
                    break;
                    default:
                        break;
            }
        } else {
            switch(view.getId()){
                case R.id.top_left:
                    playSound(R.raw.huuhkaja_norther_eagle_owl);
                    break;
                case R.id.top_right:
                    playSound(R.raw.peippo_chaffinch);
                    break;
                case R.id.bottom_left:
                    playSound(R.raw.peukaloinen_wren);
                    break;
                case R.id.bottom_right:
                    playSound(R.raw.punatulkku_northern_bullfinch);
                    break;
                default:
                    break;
            }

        }
    }

    // play sound
    private void playSound(int id){
        mediaPlayer = MediaPlayer.create(this, id);
        mediaPlayer.start();
    }

    // menu create
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    // menu selection handler
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_mammals:
                selection = 0;
                Toast.makeText(this, "Chosen: Mammals", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_birds:
                selection = 1;
                Toast.makeText(this, "Chosen: Birds", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        // update animals
        loadAnimals(selection);

        return super.onOptionsItemSelected(item);
    }


}
