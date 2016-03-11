package com.example.chakir.boterkaasspel;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int spelerActief;
    int[] spelVerloop = {0,0,0,0,0,0,0,0,0};
    int [][] winners = {
        {0,1,2},
        {3,4,5},
        {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
                {2,4,6},
                {0,4,8},
    };
    int spelerGewonnen;
    boolean spelAfgelopen;
    TextView eindeSpelTextView;
    Button nieuwSpelButton;
    LinearLayout eindeSpelLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        spelerActief = 1;
        spelerGewonnen = 0;
        eindeSpelTextView = (TextView) findViewById(R.id.eindeSpelTextView);
        nieuwSpelButton = (Button) findViewById(R.id.nieuwSpelButton);
        eindeSpelLayout = (LinearLayout) findViewById(R.id.eindeSpelLayout);



    }

    public void setImg(View view){
        ImageView imageView = (ImageView) view;
        int index = Integer.parseInt(imageView.getTag().toString());

        if (spelVerloop[index] == 0) {
            spelVerloop[index] = spelerActief;
            if (spelerActief == 1) {
                imageView.setTranslationY(-1000f);
                imageView.setImageResource(R.drawable.kruisje);
                imageView.animate().translationY(0f).setDuration(300);
                checkEindeSpel();
                spelerActief = 2;
            } else {
                imageView.setTranslationY(-1000f);
                imageView.setImageResource(R.drawable.rondje);
                imageView.animate().translationY(0f).setDuration(300);
                checkEindeSpel();
                spelerActief = 1;
            }

            if (spelAfgelopen){
                eindeSpel();
            }
        }
    }
private void checkEindeSpel(){
        for(int[] winner: winners){
            boolean isWinner = true;
            for (int i: winner){
                if (spelVerloop[i] != spelerActief){
                    isWinner = false;
                    break;
                }
            }
            if (isWinner){
                spelerGewonnen = spelerActief;
                spelAfgelopen = true;
            }
            //gelijkspel
            if (spelerGewonnen == 0){
                spelAfgelopen = true;
                for (int i: spelVerloop) {
                    if (i == 0){
                        spelAfgelopen = false;
                        break;
                    }
                }
            }
        }
    }

    private void eindeSpel(){
        switch (spelerGewonnen){
            case 0:
                eindeSpelTextView.setText("Gelijk spel, Opnieuw spelen?");
                break;
            case 1:
                eindeSpelTextView.setText("Speler 1 heeft gewonnen, Opnieuw spelen?");
                break;
            case 2:
                eindeSpelTextView.setText("Speler 2 heeft gewonnen, Opnieuw spelen?");
                break;
        }
        eindeSpelLayout.setVisibility(View.VISIBLE);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void nieuwSpel(View view){
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for (int i = 0; i < spelVerloop.length; i++){
            spelVerloop[i]  = 0;
            ImageView imageView = (ImageView) gridLayout.getChildAt(i);
            imageView.setImageResource(0);

        }
        spelerActief    = 1;
        spelAfgelopen = false;
        spelerGewonnen = 0;
        eindeSpelLayout.setVerticalGravity(View.GONE);

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
