package com.yannfigueiredo.brigaentreirmaos.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.yannfigueiredo.brigaentreirmaos.R;


public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.clickbotao);
    }

    public void acessarJogos(View view){
        EditText editPessoa1 = findViewById(R.id.editPessoa1);
        EditText editPessoa2 = findViewById(R.id.editPessoa2);

        if(mediaPlayer != null) {
            mediaPlayer.start();
        }

        if(((editPessoa1.getText().toString()).length()>10 || (editPessoa2.getText().toString()).length()>10)||((editPessoa1.getText().toString()).length()<1 || (editPessoa2.getText().toString()).length()<1)){
            Toast.makeText(getApplicationContext(),"O nome precisa ter no mínimo 1 e no máximo 10 caracteres!", Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(this, JogosActivity.class);
            intent.putExtra("pessoa1", editPessoa1.getText().toString());
            intent.putExtra("pessoa2", editPessoa2.getText().toString());
            startActivity(intent);
        }
    }
}
