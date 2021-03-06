package au.appxperts.ga.mapsurvey.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import au.appxperts.ga.mapsurvey.R;

public class StartSurveyActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_survey);
        setMTitle("Start Survey");
        findViewById(R.id.back).setOnClickListener(backClick);

        findViewById(R.id.buttonOk).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonOk:

                startActivity(getMIntent(getString(R.string.start_survey),StartSurveyInChoices.class));

                break;
        }
    }
}
