package com.yannfigueiredo.brigaentreirmaos.activity;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.yannfigueiredo.brigaentreirmaos.R;
import com.yannfigueiredo.brigaentreirmaos.fragment.CaraCoroaFragment;
import com.yannfigueiredo.brigaentreirmaos.fragment.JokenpoFragment;
import com.yannfigueiredo.brigaentreirmaos.fragment.ParImparFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class JogosActivity extends AppCompatActivity {

    private CaraCoroaFragment cara_coroa_fragment = new CaraCoroaFragment();
    private ParImparFragment par_impar_fragment = new ParImparFragment();
    private JokenpoFragment jokenpo_fragment = new JokenpoFragment();
    private Button buttonCaraCoroa, buttonParImpar, buttonJokenpo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogos);

        this.buttonCaraCoroa = findViewById(R.id.buttonCaraCoroa);
        this.buttonParImpar = findViewById(R.id.buttonParImpar);
        this.buttonJokenpo = findViewById(R.id.buttonJokenpo);

        Bundle bundle = new Bundle();
        Bundle envolvidos = getIntent().getExtras();
        bundle.putString("pessoa1", envolvidos.getString("pessoa1"));
        bundle.putString("pessoa2", envolvidos.getString("pessoa2"));

        cara_coroa_fragment.setArguments(bundle);

        FragmentManager transaction = getSupportFragmentManager();
        transaction.beginTransaction().replace(R.id.frameConteudo, cara_coroa_fragment).commit();

        this.destacarButton("CaraCoroa");

        FloatingActionButton fab = findViewById(R.id.fabHistorico);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void acessarJogo(View view){
        if(view.getId()==R.id.buttonCaraCoroa){
            FragmentManager transaction = getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.frameConteudo, cara_coroa_fragment).commit();
            destacarButton("CaraCoroa");
        }else if(view.getId()==R.id.buttonParImpar){
            FragmentManager transaction = getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.frameConteudo, par_impar_fragment).commit();
            destacarButton("ParImpar");
        }else if(view.getId()==R.id.buttonJokenpo){
            FragmentManager transaction = getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.frameConteudo, jokenpo_fragment).commit();
            destacarButton("Jokenpo");
        }
    }

    public void determinarEscolha(){
        int escolha = new Random().nextInt(1);
        TextView textEscolha = findViewById(R.id.textEscolha);
        textEscolha.setText("Caralhoooo");
    }

    public void destacarButton(String buttonDestacado){
        if(buttonDestacado.equals("CaraCoroa")){
            buttonCaraCoroa.setBackgroundResource(R.drawable.button_destacado);
            buttonParImpar.setBackgroundResource(R.drawable.button_nao_destacado);
            buttonJokenpo.setBackgroundResource(R.drawable.button_nao_destacado);
        }else if(buttonDestacado.equals("ParImpar")){
            buttonParImpar.setBackgroundResource(R.drawable.button_destacado);
            buttonCaraCoroa.setBackgroundResource(R.drawable.button_nao_destacado);
            buttonJokenpo.setBackgroundResource(R.drawable.button_nao_destacado);
        }else{
            buttonJokenpo.setBackgroundResource(R.drawable.button_destacado);
            buttonCaraCoroa.setBackgroundResource(R.drawable.button_nao_destacado);
            buttonParImpar.setBackgroundResource(R.drawable.button_nao_destacado);
        }
    }

}
