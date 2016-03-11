package com.example.chakir.animatie;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;

public class animatiemain extends AppCompatActivity {
    ImageView peterImg;
    ImageView turkeyImg;

    boolean isPeter;
    long duurAnimatie;
    SeekBar seekBar;
    RadioButton translateButton;
    RadioButton fadeButton;
    RadioButton rotateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animatiemain);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        peterImg = (ImageView) findViewById(R.id.peterImg);
        turkeyImg = (ImageView) findViewById(R.id.turkeyImg);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                duurAnimatie = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        fadeButton = ()RadioButton) findViewById(R.id.fadeRadioButton);
        fadeButton.setOnClickListener(new View.OnClickListener(){
                                        public void onClick(View v){

                                        }
                                      });
        translateButton = ()RadioButton) findViewById(R.id.translateRadioButton);
        rotateButton = ()RadioButton) findViewById(R.id.rotateRadioButton);

        isPeter = true;
        duurAnimatie = 2000l;
        seekBar.setProgress((int)duurAnimatie);
        //turkeyImg.animate().translationX(-1000).setDuration(0l);
        turkeyImg.animate()
                .scaleX(0f)
                .scaleY(0f)
                .setDuration(1l);
    }
    public void animate(View view){
        //fade();
        //rotate();
        rotateAndScale();
        isPeter = !isPeter;
    }
    private void fade() {
        if (isPeter) {
            peterImg.animate().alpha(0f).setDuration(2000l);
            turkeyImg.animate().alpha(1f).setDuration(2000l);

        }else {
            peterImg.animate().alpha(1f).setDuration(2000l);
            turkeyImg.animate().alpha(0f).setDuration(2000l);
        }

    }
    private void rotate() {
        if (isPeter) {
            peterImg.animate()
                    .translationX(1400l)
                    .setDuration(duurAnimatie);
            turkeyImg.animate()
                    .translationX(0f)
                    .setDuration(duurAnimatie);
        }else{
            peterImg.animate()
                    .translationX(0l)
                    .setDuration(duurAnimatie);
            turkeyImg.animate()
                    .translationX(-1400f)
                    .setDuration(duurAnimatie);
        }
    }

    private void rotateAndScale(){
        if (isPeter) {
            peterImg.animate()
                    .rotation(720f)
                    .scaleX(0f)
                    .scaleY(0f)
                    .setDuration(duurAnimatie);
            turkeyImg.animate()
                    .rotation(-720f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(duurAnimatie);
        }else{
            peterImg.animate()
                    .rotation(-720f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(duurAnimatie);
            turkeyImg.animate()
                    .rotation(720f)
                    .scaleX(0f)
                    .scaleY(0f)
                    .setDuration(duurAnimatie);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_animatiemain, menu);
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
}
