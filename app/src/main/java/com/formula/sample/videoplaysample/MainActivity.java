package com.formula.sample.videoplaysample;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import com.formula.sample.videoplaysample.util.ResourcesUtil;

public class MainActivity extends AppCompatActivity {

    VideoController vc = null;
    ImageView im = null;
    Button bt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vc = new VideoController();
        vc.addVideoView((VideoView) findViewById(R.id.videoView));
        vc.addVideoFile("sample.mp4");
        im = (ImageView) findViewById(R.id.imageView);
        im.setImageURI(ResourcesUtil.getResUri("bg.png", ResourcesUtil.RES_TYPE_DRAWABLE));
        bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(App.LOGTAG, "onClick enter");
                if (vc.isPlaying()) {
                    vc.stop();
                    bt.setText("Start");
                } else {
                    vc.start();
                    bt.setText("Stop");
                }
                Log.d(App.LOGTAG, "onClick leave");
            }
        });
    }
}
