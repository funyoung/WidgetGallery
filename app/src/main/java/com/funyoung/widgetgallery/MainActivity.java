package com.funyoung.widgetgallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.scrollView).setOnClickListener(this);
        findViewById(R.id.recyclerView).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scrollView:
                startBenchMarch(true);
                break;
            case R.id.recyclerView:
                startBenchMarch(false);
                break;
            default:
                break;
        }
    }

    private void startBenchMarch(boolean useScrollView) {
        BenchMarchActivity.start(this, useScrollView);
        finish();
    }
}
