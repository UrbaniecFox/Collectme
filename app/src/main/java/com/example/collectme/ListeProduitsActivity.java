package com.example.collectme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.collectme.Entity.Produit;
import com.example.collectme.Managers.ProduitManager;

import java.util.ArrayList;

public class ListeProduitsActivity extends AppCompatActivity {


    private Spinner sp_listproduit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produits);
        init();
        getAllproduit();
    }
    public void init(){
        sp_listproduit = findViewById(R.id.sp_listeproduit);
    }
    public void getAllproduit(){
        ProduitManager pm =  new ProduitManager();
        pm.getAllProduit(this, "ListeProduitsActivity");
    }
    public void getAllProduitComplete(ArrayList<Produit> listProduits){

        remplirSpinner(listProduits);
    }
    public void remplirSpinner(ArrayList<Produit> listProduits){
        ArrayList<String> listesproduitsNom = new ArrayList<>();

        //On crée une liste de chaine de caratère pour plus facilement l'associer au spinner
        for (Produit unProduit:listProduits) {
            Log.d("listeProduits", unProduit.toString());
            listesproduitsNom.add(unProduit.getNomProduit());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,listesproduitsNom);
        sp_listproduit.setAdapter(adapter);

    }
}