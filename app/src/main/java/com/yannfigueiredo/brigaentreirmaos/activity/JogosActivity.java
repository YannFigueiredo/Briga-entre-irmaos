package com.yannfigueiredo.brigaentreirmaos.activity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.yannfigueiredo.brigaentreirmaos.R;
import com.yannfigueiredo.brigaentreirmaos.fragment.CaraCoroaFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;

public class JogosActivity extends AppCompatActivity {

    private CaraCoroaFragment cara_coroa_fragment = new CaraCoroaFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogos);

        getSupportActionBar().setElevation(0);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConteudo, cara_coroa_fragment);
        transaction.commit();

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

}