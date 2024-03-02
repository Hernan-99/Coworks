package com.example.coworks;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coworks.ui.CardDetallesActivity;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private Context context;
    private ArrayList<CardModel> cardModelArrList;

    public CardAdapter(Context context, ArrayList<CardModel> cardModelArrList) {
        this.context = context;
        this.cardModelArrList = cardModelArrList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardModel cardModel = cardModelArrList.get(position);
        holder.bind(cardModel);
    }

    @Override
    public int getItemCount() {
        return cardModelArrList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView bannerIv;
        /*private TextView tituloTv;
        private TextView descripcionTv;
        private TextView precioTv;*/

        public CardViewHolder(@NonNull View itemView){
            super(itemView);
            bannerIv = itemView.findViewById(R.id.banner);
            /*tituloTv = itemView.findViewById(R.id.titulo);
            descripcionTv = itemView.findViewById(R.id.descripcion);
            precioTv = itemView.findViewById(R.id.precio);*/
        }

        public void bind(final CardModel cardModel){
            /*tituloTv.setText(cardModel.getTitulo());
            descripcionTv.setText(cardModel.getDescripcion());
            precioTv.setText(cardModel.getPrecio());*/
            bannerIv.setImageResource(cardModel.getImg());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //cambiar logica para cuando se haga un touch en la card mostremos una vista
                    // que muestre los datos de esa card en base a un get por id

                    Intent intent = new Intent(context, CardDetallesActivity.class);
                    context.startActivity(intent);


                    Toast.makeText(context, "redireccionamos", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
