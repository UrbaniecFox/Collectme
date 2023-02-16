package com.example.collectme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collectme.Entity.Produit;

public class DetailProduitactivity extends AppCompatActivity {

    private TextView tv_nom, tv_description, tv_prixHT, tv_Prix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datail_produitactivity);
        init();

        Intent intent = getIntent();
        Produit leProduit = intent.getParcelableExtra("produit");

        Toast.makeText(this,leProduit.toString(), Toast.LENGTH_SHORT).show();

        this.tv_nom.setText("Nom : " + leProduit.getNomProduit());
        tv_description.setText("description " + leProduit.getDescriptionProduit());
        tv_prixHT.setText("prixHT : " + String.valueOf( leProduit.getPrixHt()));
        tv_Prix.setText("prix ttc : " + String.valueOf(leProduit.getPrixTtc()));

    }
    public void init(){
        tv_nom = findViewById(R.id.tv_detail_nom);
        tv_description =findViewById(R.id.tv_detail_description);
        tv_prixHT = findViewById(R.id.tv_detail_prixHT);
        tv_Prix = findViewById(R.id.tv_detail_prixTTC);
    }
}