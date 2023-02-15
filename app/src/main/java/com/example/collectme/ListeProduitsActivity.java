package com.example.collectme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.collectme.Adapter.ProduitAdapter;
import com.example.collectme.Entity.Produit;
import com.example.collectme.Managers.ProduitManager;

import java.util.ArrayList;

public class ListeProduitsActivity extends AppCompatActivity {

    //initialisation des composants
    private Spinner sp_listproduit;
    private RecyclerView rv_listeproduit;
    private ProduitAdapter produitAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produits);
        init();
        getAllproduit();
    }
    public void init(){
        //on récupère depuis la vue les composant pour pouvoir intéragir avec.
        sp_listproduit = findViewById(R.id.sp_listeproduit);
        rv_listeproduit = findViewById(R.id.rv_listeProduits);
    }
    public void getAllproduit(){
        ProduitManager pm =  new ProduitManager();
        pm.getAllProduit(this, "ListeProduitsActivity");
    }
    public void getAllProduitComplete(ArrayList<Produit> listProduits){

        remplirSpinner(listProduits);
        remplirRecyclerView(listProduits);
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
    public void remplirRecyclerView(ArrayList<Produit> listProduits){
        // Gestion du recylerView
        //on renseigne la liste des produits à notre Adapter
        produitAdapter = new ProduitAdapter(listProduits);

        layoutManager = new LinearLayoutManager(this);
        rv_listeproduit.setLayoutManager(layoutManager);

        //On relie l'adapter au re
        rv_listeproduit.setAdapter(produitAdapter);


    }
}