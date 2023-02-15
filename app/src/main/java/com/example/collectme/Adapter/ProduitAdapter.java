package com.example.collectme.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collectme.Entity.Produit;
import com.example.collectme.R;

import java.util.ArrayList;

public class ProduitAdapter extends RecyclerView.Adapter<ProduitAdapter.ProduitViewHolder> {

    private ArrayList<Produit> listProduits;
    private OnItemClickListener onClickLigneProduit;

    public ProduitAdapter(ArrayList<Produit> listProduits) {
        this.listProduits = listProduits;
    }

    @NonNull
    @Override
    public ProduitAdapter.ProduitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /// On va crée une vue qui à besoin du context ici : ListeProduitActivity, pour "gonfler" c'est à dire
        //Ajouter un composant qui n'est pas encore définit dans notre vue. Pour cela il a besoin de la vue que l'on souhaite ajouté et du
        // parent donc du recyclerview
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_produit,parent,false);
        ProduitViewHolder produitViewHolder = new ProduitViewHolder(v,onClickLigneProduit);
        return produitViewHolder;
    }
    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnClickLigneProduit(OnItemClickListener listener){
        onClickLigneProduit = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ProduitAdapter.ProduitViewHolder holder, int position) {
        //on récupére le produit de la ligne concerné (postion), et on set les composants avec les bonne données
        Produit produitEncours = listProduits.get(position);
        holder.tv_nomArticle.setText(produitEncours.getNomProduit());
        holder.tv_descriptionArticle.setText(produitEncours.getDescriptionProduit());
        holder.tv_prixHT.setText(String.valueOf(produitEncours.getPrixHt() + " €"));
        holder.tv_prixTTC.setText(String.valueOf(produitEncours.getPrixTtc()+ " €"));
    }

    @Override
    public int getItemCount() {
        // on renseigne le nombre de ligne pour qu'il puisse les gérées
        return listProduits.size();
    }

    public class ProduitViewHolder extends RecyclerView.ViewHolder {
        //On initialise les composants de la ligne
        public TextView tv_nomArticle;
        public TextView tv_descriptionArticle;
        public TextView tv_prixHT;
        public TextView tv_prixTTC;
        public TextView bt_test;
        public ProduitViewHolder(@NonNull View itemView,OnItemClickListener listener) {
            super(itemView);
            //On récupérer les composants de la ligne
            tv_nomArticle = itemView.findViewById(R.id.tv_nomArticle);
            tv_descriptionArticle = itemView.findViewById(R.id.tv_description);
            tv_prixHT = itemView.findViewById(R.id.tv_prixHt);
            tv_prixTTC = itemView.findViewById(R.id.tv_prixTTC);
            bt_test= itemView.findViewById(R.id.bt_test);
            bt_test.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position  = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                                listener.onItemClick(position);
                        }
                    }
                }
            });
            //Ici on pourra ajouter l'evenement onclick sur la ligne
        }
    }
}
