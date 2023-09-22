package br.org.unisales.apppersistearquivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter a = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Arrays.asList("Shared", "File", "Nitrite"));
        ListView lo = findViewById(R.id.listaopcoes);
        lo.setAdapter(a);
        lo.setOnItemClickListener((adapterView, view, i, l) -> {
            //Toast.makeText(this, " "+ i + " " + l, Toast.LENGTH_LONG).show();
            Class classe = null;
            switch (i) {
                case 0:
                    classe = AcShared.class;
                    break;
                case 1:
                    classe = AcFiles.class;
                    break;
            }
            if (classe != null)
                startActivity(new Intent(this, classe));
        });
    }
}