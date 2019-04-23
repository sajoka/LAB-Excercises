package e.wonka.lab3_4_eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TimerCountdownActivity extends AppCompatActivity {

    private long seconds = 0;
    private TextView txtCountdown;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_countdown);

        mediaPlayer = MediaPlayer.create(this, R.raw.ring);

        // get the entered seconds from the other activity
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            seconds = extras.getInt("seconds");
        }

        txtCountdown = findViewById(R.id.txt_countdown);

        CountDownTimer countDownTimer = new CountDownTimer(seconds * 1000, 1000) {
            @Override
            public void onTick(long l) {
                txtCountdown.setText(String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                // start ringing
                txtCountdown.setText("*ALARM*");
                mediaPlayer.start();

                // Second Timer which waits 5 seconds before closing activity
                CountDownTimer countDownTimer1 = new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long l) {
                    }

                    @Override
                    public void onFinish() {
                        mediaPlayer.stop();
                        finish();
                    }
                }.start();
            }
        }.start();

    }
}
