package com.example.collectme.Entity;

// unProduit.getNom();
//unProduit.setNom();
public class Produit {
   private String id;
   private String nomProduit;
    private String descriptionProduit;
   private float prixHt;
   private float prixTtc;

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

    public float getPrixHt() {
        return prixHt;
    }

    public void setPrixHt(float prixHt) {
        if(prixHt > 1000.0f){
            this.prixHt = 1000.0f;
        }else{
            this.prixHt = prixHt;
        }

    }

    public float getPrixTtc() {
        return prixTtc;
    }

    public void setPrixTtc(float prixTtc) {
        this.prixTtc = prixTtc;
    }

    public String getDescriptionProduit() {
        return descriptionProduit;
    }

    public void setDescriptionProduit(String descriptionProduit) {
        this.descriptionProduit = descriptionProduit;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id='" + id + '\'' +
                ", nomProduit='" + nomProduit + '\'' +
                ", descriptionProduit='" + descriptionProduit + '\'' +
                ", prixHt=" + prixHt +
                ", prixTtc=" + prixTtc +
                '}';
    }
}
