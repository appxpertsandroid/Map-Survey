package au.appxperts.ga.mapsurvey.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import au.appxperts.ga.mapsurvey.R;
import au.appxperts.ga.mapsurvey.adapters.DisplayDataBundleAdapter;
import au.appxperts.ga.mapsurvey.adapters.ImportDataBundleAdapter;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class DisplayDataBundleActivity extends BaseActivity implements View.OnClickListener{

    private RecyclerView mRecyclerView;
    private DisplayDataBundleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data_bundle);
        setMTitle(getIntent().getExtras().getString("title"));
        findViewById(R.id.back).setOnClickListener(backClick);
        findViewById(R.id.buttonBack).setOnClickListener(backClick);
        findViewById(R.id.deleteData).setOnClickListener(this);


        mRecyclerView = (RecyclerView) findViewById(R.id.bundles);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        adapter = new DisplayDataBundleAdapter(this, getList());
        mRecyclerView.setAdapter(adapter);


    }


    public List<String> getList(){
        int i = 0;
        List<String> strings = new ArrayList<>();
        strings.add("data1 "+ ++i);
        strings.add("data1 "+ ++i);
        strings.add("data1 "+ ++i);
        strings.add("data1 "+ ++i);
        strings.add("data1 "+ ++i);
        strings.add("data1 "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);
        strings.add("data "+ ++i);



        return  strings;
    }



    public void showDeleteDialog(){
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Won't be able to recover this file!")
                .setCancelText("No,cancel plx!")
                .setConfirmText("Yes,delete it!")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.cancel();
                    }
                })
                .show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.deleteData:

                showDeleteDialog();

                break;
        }
    }
}
