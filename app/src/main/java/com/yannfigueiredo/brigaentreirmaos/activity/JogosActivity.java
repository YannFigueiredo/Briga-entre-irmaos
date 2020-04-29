package com.yannfigueiredo.brigaentreirmaos.activity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.yannfigueiredo.brigaentreirmaos.R;
import com.yannfigueiredo.brigaentreirmaos.fragment.CaraCoroaFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class JogosActivity extends AppCompatActivity {

    private CaraCoroaFragment cara_coroa_fragment = new CaraCoroaFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogos);

        Bundle bundle = new Bundle();
        Bundle envolvidos = getIntent().getExtras();
        bundle.putString("pessoa1", envolvidos.getString("pessoa1"));
        bundle.putString("pessoa2", envolvidos.getString("pessoa2"));

        cara_coroa_fragment.setArguments(bundle);

        FragmentManager transaction = getSupportFragmentManager();
        transaction.beginTransaction().replace(R.id.frameConteudo, cara_coroa_fragment).commit();

        FloatingActionButton fab = findViewById(R.id.fabHistorico);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /*public void acessarJogo(View view){

    }*/

    public void determinarEscolha(){
        int escolha = new Random().nextInt(1);
        TextView textEscolha = findViewById(R.id.textEscolha);
        textEscolha.setText("Caralhoooo");
    }

}
