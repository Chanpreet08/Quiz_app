package quiz.com.quiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Chanpreet on 10-08-2016.
 */


public class splash extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);



        Thread timer = new Thread(){
          public void run(){
              try{
                  sleep(500);
              }
              catch(Exception e){
                  e.printStackTrace();
              }
              finally {
                  Intent intent = new Intent("quiz.com.quiz.main");
                  startActivity(intent);
                  finish();
              }
          }

        };
          timer.start();
    }
}
