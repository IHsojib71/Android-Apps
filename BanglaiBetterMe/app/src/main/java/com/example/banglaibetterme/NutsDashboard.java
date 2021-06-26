package com.example.banglaibetterme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.banglaibetterme.fruits.Apple;
import com.example.banglaibetterme.nuts.ChinaBadam;
import com.example.banglaibetterme.nuts.Coconuts;
import com.example.banglaibetterme.nuts.Hijli_badam;
import com.example.banglaibetterme.nuts.KajuBadam;

public class NutsDashboard extends AppCompatActivity implements View.OnClickListener {
    private View kaju_badam, china_badam, hijli_badam, coconut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuts_dashboard);

        kaju_badam = findViewById(R.id.kajuBadam);
        china_badam = findViewById(R.id.chinaBadam);
        hijli_badam = findViewById(R.id.hijliBadam);
        coconut = findViewById(R.id.coconut);

        kaju_badam.setOnClickListener(this);
        china_badam.setOnClickListener(this);
        hijli_badam.setOnClickListener(this);
        coconut.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kajuBadam:
                Intent intent = new Intent(NutsDashboard.this, KajuBadam.class);
                startActivity(intent);
                break;
            case R.id.chinaBadam:
                 intent = new Intent(NutsDashboard.this, ChinaBadam.class);
                startActivity(intent);
                break;
            case R.id.hijliBadam:
                intent = new Intent(NutsDashboard.this, Hijli_badam.class);
                startActivity(intent);
                break;
            case R.id.coconut:
                intent = new Intent(NutsDashboard.this, Coconuts.class);
                startActivity(intent);
                break;
        }
    }
}