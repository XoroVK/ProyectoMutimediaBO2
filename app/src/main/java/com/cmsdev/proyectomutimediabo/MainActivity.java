package com.cmsdev.proyectomutimediabo;

import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;
import android.net.Uri;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    private ImageView imageView;
    private MediaPlayer mediaPlayer;
    private Button btnAudio, btnAnimacion;
    private View customView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Imagen
        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.ic_launcher_foreground);
        //Audio
        btnAudio = findViewById(R.id.btnAudio);
        mediaPlayer = MediaPlayer.create(this,R.raw.audio);
        btnAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
                else{
                    mediaPlayer.start();
                }
            }
        });
        //Video
        videoView = findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://"+ getPackageName()+"/"+ R.raw.video));
        videoView.start();
        //Animacion
        btnAnimacion = findViewById(R.id.btnAnimacion);
        customView = findViewById(R.id.customView);
        //object animator
        btnAnimacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(customView, "rotation", 0f,720f);
                animator.setDuration(10000);
                animator.start();
            }
        });
        };
    }
