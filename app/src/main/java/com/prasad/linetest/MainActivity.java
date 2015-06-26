package com.prasad.linetest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity implements View.OnTouchListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView iv = (ImageView) findViewById(R.id.ImageView);

        Button fade = (Button) findViewById(R.id.fade);
        fade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fade out
                //ObjectAnimator.ofFloat(v, "alpha",0f).setDuration(2000).start();
                //--or--
                float fade = iv.getAlpha() == 0 ? 1: 0;
                iv.animate().alpha(fade).setDuration(2000);

            }
        });

        Button move = (Button) findViewById(R.id.move);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = iv.getX() == 0 ? ((getWindowManager().getDefaultDisplay().getWidth()/2) - (iv.getWidth()/2)) : 0;
                float y = iv.getY() == 0 ? ((getWindowManager().getDefaultDisplay().getHeight()/2) - (iv.getHeight()/2)) : 0;

                //move
                iv.animate().x(x).y(y);

                /*ObjectAnimator animX = ObjectAnimator.ofFloat(v, "x", 0f);
                ObjectAnimator animY = ObjectAnimator.ofFloat(v, "y", 0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animX, animY);
                animatorSet.setDuration(2500);
                animatorSet.start();*/

                /*PropertyValuesHolder pvX = PropertyValuesHolder.ofFloat("x",0f);
                PropertyValuesHolder pvY = PropertyValuesHolder.ofFloat("y",0f);
                ObjectAnimator.ofPropertyValuesHolder(v, pvX, pvY).setDuration(3000).start();*/
            }
        });

        Button rotate = (Button) findViewById(R.id.rotate);
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.animate().rotation(360);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
