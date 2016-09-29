package quiz.com.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Chanpreet on 11-08-2016.
 */
public class result extends AppCompatActivity {

    private TextView score1;
    private Button exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        score1 = (TextView) findViewById(R.id.score);
        exit = (Button) findViewById(R.id.exit);

        Intent intent2 = new Intent();
        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("score");
        String sco= ""+score;

        score1.setText(sco);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
