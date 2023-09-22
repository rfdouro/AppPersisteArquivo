package br.org.unisales.apppersistearquivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class AcShared extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_shared);

        String corLida = getSharedPreferences("app_prefs", MODE_PRIVATE).getString("cor", null);
        ((EditText) findViewById(R.id.edtCor)).setText(corLida);
        if(corLida!=null){
            try {
                ((LinearLayout) findViewById(R.id.layoutshared)).setBackgroundColor(Color.parseColor(corLida));
            }catch(Exception ex){

            }
        }


        ((Button) findViewById(R.id.btnSalvacor)).setOnClickListener(view -> {
            String cor = ((EditText) findViewById(R.id.edtCor)).getText().toString();
            SharedPreferences prefs = getSharedPreferences("app_prefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("cor", cor);
            editor.commit();
        });
    }
}