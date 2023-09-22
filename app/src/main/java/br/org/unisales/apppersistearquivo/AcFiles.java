package br.org.unisales.apppersistearquivo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.org.unisales.apppersistearquivo.model.Pessoa;

public class AcFiles extends AppCompatActivity {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_files);

        try {
            FileInputStream fis = openFileInput("dadospessoa");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Pessoa p = (Pessoa) ois.readObject();
            ((EditText) findViewById(R.id.edtNome)).setText(p.nome);
            ((EditText) findViewById(R.id.edtCpf)).setText("" + p.cpf);
            ((EditText) findViewById(R.id.edtNasc)).setText(sdf.format(p.nasc));
            ois.close();
            fis.close();
        } catch (Exception ex) {
        }


        ((Button) findViewById(R.id.btnSalvapessoafile)).setOnClickListener(view -> {
            try {
                Pessoa p = new Pessoa();
                p.nome = ((EditText) findViewById(R.id.edtNome)).getText().toString();
                p.cpf = Integer.parseInt(((EditText) findViewById(R.id.edtCpf)).getText().toString());
                p.nasc = sdf.parse(((EditText) findViewById(R.id.edtNasc)).getText().toString());
                FileOutputStream fos = openFileOutput("dadospessoa", MODE_PRIVATE);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(p);
                oos.close();
                fos.close();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        });
    }
}