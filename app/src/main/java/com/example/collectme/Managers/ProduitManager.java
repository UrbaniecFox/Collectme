package com.example.collectme.Managers;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.collectme.Entity.Produit;
import com.example.collectme.ListeProduitsActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ProduitManager {
    private  FirebaseFirestore db;
    private final String NOM_TABLE_PRODUIT = "Produit";
    public ProduitManager() {
        this.db = FirebaseFirestore.getInstance();
    }
    public void getAllProduit(Context context, String nomContext){
        db.collection(NOM_TABLE_PRODUIT).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    ArrayList<Produit> listProduits = new ArrayList<Produit>();
                    List<DocumentSnapshot> result = task.getResult().getDocuments();
                    for (DocumentSnapshot document : result) {
                        Produit unProduit = new Produit();
                        unProduit.setId(document.getId());
                        unProduit.setNomProduit(document.get("libelleProduit").toString());
                        unProduit.setDescriptionProduit(document.get("descriptionProduit").toString());
                        unProduit.setPrixHt(Float.parseFloat(document.get("prixHt").toString()));
                        unProduit.setPrixTtc(Float.parseFloat(document.get("prixTtc").toString()));
                       //Finir de compléter
                        listProduits.add(unProduit);
                    }
                    switch (nomContext){
                        case "ListeProduitsActivity":
                            ((ListeProduitsActivity)context).getAllProduitComplete(listProduits);
                            break;
                        default:
                            Log.d("Warnnig", "Le nom du context n'est pas géré ");
                            break;
                    }

                } else {
                    Log.w("selectAll", "Error getting documents.", task.getException());
                }
            }
        });
    }


}
