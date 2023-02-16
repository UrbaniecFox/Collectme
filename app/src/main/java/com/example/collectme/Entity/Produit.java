package com.example.collectme.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

// unProduit.getNom();
//unProduit.setNom();
public class Produit implements Parcelable {
   private String id;
   private String nomProduit;
    private String descriptionProduit;
   private float prixHt;
   private float prixTtc;

    public Produit() {
    }


    protected Produit(Parcel in) {
        id = in.readString();
        nomProduit = in.readString();
        descriptionProduit = in.readString();
        prixHt = in.readFloat();
        prixTtc = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nomProduit);
        dest.writeString(descriptionProduit);
        dest.writeFloat(prixHt);
        dest.writeFloat(prixTtc);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Produit> CREATOR = new Creator<Produit>() {
        @Override
        public Produit createFromParcel(Parcel in) {
            return new Produit(in);
        }

        @Override
        public Produit[] newArray(int size) {
            return new Produit[size];
        }
    };

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
