package com.yannfigueiredo.brigaentreirmaos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void acessarJogos(View view){
        EditText editPessoa1 = findViewById(R.id.editPessoa1);
        EditText editPessoa2 = findViewById(R.id.editPessoa2);
        Intent intent = new Intent(getApplicationContext(), JogosActivity.class);
        intent.putExtra("pessoa1", editPessoa1.getText().toString());
        intent.putExtra("pessoa2", editPessoa2.getText().toString());
        startActivity(intent);
    }
}
