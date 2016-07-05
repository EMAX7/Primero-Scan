package com.example.ernesto.primero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button btnScan, btnCart, btnHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnScan = (Button) findViewById(R.id.btnScan2);
        btnCart = (Button) findViewById(R.id.btnCart);
        btnHistory = (Button) findViewById(R.id.btnHistory);

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = 0;
                startActivity(new Intent(MainActivity.this, com.example.ernesto.primero.ScanActivity.class));

            }
        });

        btnCart.setOnClickListener(new View.OnClickListener(){;

            @Override
            public void onClick(View v) {
                startActivity( new Intent(MainActivity.this, com.example.ernesto.primero.CartActivity.class));
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener(){;

            @Override
            public void onClick(View v) {
                startActivity( new Intent(MainActivity.this, com.example.ernesto.primero.HistoryActivity.class));
            }
        });
    }
}
