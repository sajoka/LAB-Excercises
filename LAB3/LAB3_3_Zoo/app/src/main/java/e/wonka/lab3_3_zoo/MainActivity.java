package e.wonka.lab3_3_zoo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // value for selection [0 = mammals, 1 = birds]
    private int selection = 0;

    private ImageView topLeft, topRight, bottomLeft, bottomRight;
    private Bird huuhkaja, peippo, peukaloinen, punatulkku;
    private Mammal bear, wolf, elephant, lamb;


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

        createAnimals();
    }

    // Create my animals
    private void createAnimals(){
        huuhkaja = new Bird("Huuhkaja", R.drawable.huuhkaja, R.raw.huuhkaja_norther_eagle_owl);
        peippo = new Bird("Peippo", R.drawable.peippo, R.raw.peippo_chaffinch);
        peukaloinen = new Bird("Peukaloinen", R.drawable.peukaloinen, R.raw.peukaloinen_wren);
        punatulkku = new Bird("Punatulkku", R.drawable.punatulkku, R.raw.punatulkku_northern_bullfinch);
        bear = new Mammal("Bear", R.drawable.bear, R.raw.bear);
        wolf = new Mammal("Wolf", R.drawable.wolf, R.raw.wolf);
        elephant = new Mammal("Elephant", R.drawable.elephant, R.raw.elephant);
        lamb = new Mammal("Lamb", R.drawable.lamb, R.raw.lamb);
    }

    // Load animals to the view
    private void loadAnimals(int i){
        switch (i){
            case 0:
                bear.setImageView(topLeft);
                wolf.setImageView(topRight);
                elephant.setImageView(bottomLeft);
                lamb.setImageView(bottomRight);
                break;
            case 1:
                huuhkaja.setImageView(topLeft);
                peippo.setImageView(topRight);
                peukaloinen.setImageView(bottomLeft);
                punatulkku.setImageView(bottomRight);
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
                    bear.makeNoise(this);
                    break;
                case R.id.top_right:
                    wolf.makeNoise(this);
                    break;
                case R.id.bottom_left:
                    elephant.makeNoise(this);
                    break;
                case R.id.bottom_right:
                    lamb.makeNoise(this);
                    break;
                    default:
                        break;
            }
        } else {
            switch(view.getId()){
                case R.id.top_left:
                    huuhkaja.makeNoise(this);
                    break;
                case R.id.top_right:
                    peippo.makeNoise(this);
                    break;
                case R.id.bottom_left:
                    peukaloinen.makeNoise(this);
                    break;
                case R.id.bottom_right:
                    punatulkku.makeNoise(this);
                    break;
                default:
                    break;
            }

        }
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
