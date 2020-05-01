package com.yannfigueiredo.brigaentreirmaos.Adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yannfigueiredo.brigaentreirmaos.Modelo.Registro;
import com.yannfigueiredo.brigaentreirmaos.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<String> listaRegistro;
    public Adapter(List<String> lista){
        this.listaRegistro = lista;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String registro = listaRegistro.get(position);
        holder.Info.setText(registro);
    }

    @Override
    public int getItemCount() {
        return this.listaRegistro.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Info;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.Info = itemView.findViewById(R.id.textInfo);
        }
    }
}
