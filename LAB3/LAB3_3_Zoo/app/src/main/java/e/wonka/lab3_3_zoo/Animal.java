package e.wonka.lab3_3_zoo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.widget.ImageView;

public class Animal {

    private MediaPlayer mediaPlayer;
    private String species;
    private int soundSource;
    private int imageSource;

    // Constructor
    public Animal (String species, int image, int sound){
        this.species = species;
        this.imageSource = image;
        this.soundSource = sound;
    }

    public void makeNoise(Activity activity){
        mediaPlayer = MediaPlayer.create(activity, soundSource);
        mediaPlayer.start();
    }

    // Set the image to the ImageView
    public ImageView setImageView(ImageView imageView){
        imageView.setImageResource(imageSource);
        return imageView;
    }
}
