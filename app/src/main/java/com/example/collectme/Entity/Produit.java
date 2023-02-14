package com.example.collectme.Entity;

// unProduit.getNom();
//unProduit.setNom();
public class Produit {
   private String id;
   private String nomProduit;
   private float prixht;
   private float prixttc;

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getPrixht() {
        return prixht;
    }

    public void setPrixht(float prixht) {
        if(prixht > 1000.0f){
            this.prixht = 1000.0f;
        }else{
            this.prixht = prixht;
        }

    }

    public float getPrixttc() {
        return prixttc;
    }

    public void setPrixttc(float prixttc) {
        this.prixttc = prixttc;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id='" + id + '\'' +
                ", nomProduit='" + nomProduit + '\'' +
                ", prixht=" + prixht +
                ", prixttc=" + prixttc +
                '}';
    }
}
