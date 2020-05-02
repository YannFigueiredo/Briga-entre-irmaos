package com.yannfigueiredo.brigaentreirmaos.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yannfigueiredo.brigaentreirmaos.R;


public class MainActivity extends AppCompatActivity {

    private TextView teste1, teste2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void acessarJogos(View view){
        EditText editPessoa1 = findViewById(R.id.editPessoa1);
        EditText editPessoa2 = findViewById(R.id.editPessoa2);

        if((editPessoa1.getText().toString()).length()>12 || (editPessoa2.getText().toString()).length()>12){
            Toast.makeText(getApplicationContext(),"O nome precisa ter no máximo 12 caracteres!", Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(this, JogosActivity.class);
            intent.putExtra("pessoa1", editPessoa1.getText().toString());
            intent.putExtra("pessoa2", editPessoa2.getText().toString());
            startActivity(intent);
        }
    }
}
