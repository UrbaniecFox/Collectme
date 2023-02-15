package com.example.collectme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.collectme.Entity.Produit;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;
import java.util.Date;

// Page de connexion
public class ConnexionActivity extends AppCompatActivity {
    //firebase
    private FirebaseAuth mAuth;
    private EditText et_mail, et_mdp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        init();

        Produit unProduit = new Produit();
        unProduit.setId("id1");
        unProduit.setNomProduit("nouveau jeu trop bien");
        unProduit.setPrixHt(9.99f);
        unProduit.setPrixTtc(unProduit.getPrixHt()*1.2f);
        Log.d("objet_Produit", unProduit.toString());

        unProduit = new Produit();
        Log.d("objet_Produit", unProduit.toString());

        Date currentTime = Calendar.getInstance().getTime();
        Log.d("objet_Produit", String.valueOf(currentTime));


        //Produit unProduit2 =  new Produit("id2", "Pomme", 0.50f);
        //Log.d("objet_Produit", unProduit2.toString());

    }

    public void init(){
        et_mail = findViewById(R.id.et_form_connexion_mail);
        et_mdp = findViewById(R.id.et_form_connexion_mdp);

        mAuth = FirebaseAuth.getInstance();
    }

    public void onClickConnexion(View view) {
        String email = et_mail.getText().toString();
        String mdp = et_mdp.getText().toString();



        /*Toast.makeText(this, email +", " + mdp,Toast.LENGTH_LONG).show();
        Toast.makeText(this, R.string.inscription_reussite,Toast.LENGTH_LONG).show();*/
        connexionFirebase(email, mdp);

    }
    public void onClickAllerAInscription(View view){
        Intent inscriptionIntent = new Intent(ConnexionActivity.this, InscriptionActivity.class);
        startActivity(inscriptionIntent);
        finish();
    }
    public void connexionFirebase(String p_email, String p_mdp){
        mAuth.signInWithEmailAndPassword(p_email, p_mdp)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("connexionTest", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("connexionTest", "signInWithEmail:failure", task.getException());
                            Toast.makeText(ConnexionActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });



    }

    private void updateUI(FirebaseUser user) {
        if(user != null){
            String email = user.getEmail();
            String uid = user.getUid();
            Toast.makeText(this, email + " "+  uid, Toast.LENGTH_LONG).show();
            //Toast.makeText(this, R.string.connexion_reussite, Toast.LENGTH_LONG).show();
            Intent listeProduitActivityIntent = new Intent(this, ListeProduitsActivity.class);
            startActivity(listeProduitActivityIntent);
            finish();

        }else{
            Toast.makeText(this, R.string.connexion_echec, Toast.LENGTH_LONG).show();
        }

    }
}