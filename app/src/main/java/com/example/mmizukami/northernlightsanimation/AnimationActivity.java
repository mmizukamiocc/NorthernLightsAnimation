package com.example.mmizukami.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    private ImageView lightsImageView;

    private AnimationDrawable frameAnim;
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation customAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);

    }

    public void toggleFrameAnim(View view)
    {
        // 1) Programmatically set the background of the image view to @drawable/lights1
        lightsImageView.setBackgroundResource(R.drawable.frame_anim);

        // 2) Associate the frameAnim with the animation to XML
        frameAnim = (AnimationDrawable) lightsImageView.getBackground();

        if(frameAnim.isRunning())
            frameAnim.stop();
        else
            frameAnim.start();
    }

    public void toggleRotateAnim(View view)
    {
        rotateAnim = AnimationUtils.loadAnimation(this,R.anim.rotate_anim);

        if(rotateAnim.hasStarted()) {
            lightsImageView.clearAnimation();
            rotateAnim = null;
        }
        else
            lightsImageView.startAnimation(rotateAnim);



    }

    public void toggleShakeAnim(View view)
    {
        shakeAnim = AnimationUtils.loadAnimation(this,R.anim.shake_anim);

        if(shakeAnim.hasStarted()) {
            lightsImageView.clearAnimation();
            shakeAnim = null;
        }
        else
            lightsImageView.startAnimation(shakeAnim);



    }
    public void toggleCustomAnim(View view)
    {
        customAnim = AnimationUtils.loadAnimation(this,R.anim.custom_anim);

        if(customAnim.hasStarted()) {
            lightsImageView.clearAnimation();
            customAnim = null;
        }
        else
            lightsImageView.startAnimation(customAnim);



    }


}
