package quiz.com.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView question;
    private RadioButton aopt;
    private RadioButton bopt;
    private RadioButton copt;
    private Button next;

    private int qid=0;
    private int score=0;
    List<Questions> qlist;
    Questions q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        question = (TextView) findViewById(R.id.question);
        aopt = (RadioButton)  findViewById(R.id.opta);
        bopt = (RadioButton) findViewById(R.id.optb);
        copt=  (RadioButton) findViewById(R.id.optc);
        next = (Button) findViewById(R.id.next);

        dbhelper helper = new dbhelper(this);
        qlist = helper.getquestions();
        q= qlist.get(qid);
        setQuestions();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup grp = (RadioGroup) findViewById(R.id.radiogrp);
                RadioButton answer = (RadioButton)findViewById(grp.getCheckedRadioButtonId());

                if(q.getAnswer().equals(answer.getText().toString()))
                {
                    score++;
                }
                if(qid<6) {
                    answer.setChecked(false);
                    q = qlist.get(qid);
                    setQuestions();
                }
                else{
                    Intent intent1 = new Intent("quiz.com.quiz.result");
                    Bundle bundle = new Bundle();
                    bundle.putInt("score",score);
                    intent1.putExtras(bundle);
                    startActivity(intent1);
                    finish();
                }
            }
        });
    }


    private void setQuestions()
    {
        question.setText(q.getQuestions());
        aopt.setText(q.getOpta());
        bopt.setText(q.getOptb());
        copt.setText(q.getOptc());
        qid++;
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
}
