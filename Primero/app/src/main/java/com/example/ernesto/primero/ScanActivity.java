package com.example.ernesto.primero;



import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class ScanActivity extends AppCompatActivity {

    TextView resultText;
    Button btnScan;
    SqlOpenHelper mDbHelper;
    SQLiteDatabase db;
    Context mContext;
    private static final String TABLE_NAME = "Carrito";
    private static final String COLUMN_NAME_COD_BARRA = "cod_barra";

    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);


        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        //Si el escaner devuelve un resultado
        if (resultCode == -1) {

            String contents = intent.getStringExtra("SCAN_RESULT");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (null,'" + contents + "', 'estefi')");
            Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
            c.moveToPosition(1);
            resultText.setText(c.getString(1));
            }
        //Si el escaner no encuentra nada (presionar back)
            else
            if (resultCode == 0) {
                // Handle cancel
                resultText.setText("Ud no encontro un carajo");

            }

        }



            //String cod = scanResult.toString();
            //ContentValues values2 = new ContentValues();
            //values2.put("cod_barra",cod);
            //values2.put("detalle","hola hola");
            //bd.insertOrThrow("cod_barra", null, values2);
       // }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        mContext = this;
        mDbHelper = new SqlOpenHelper(mContext);
        db = mDbHelper.getWritableDatabase();

        resultText =  (TextView) findViewById(R.id.textViewScanResult);
        btnScan = (Button) findViewById(R.id.btnScan2);

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(ScanActivity.this);
                integrator.initiateScan();

            }
        });
    }

}