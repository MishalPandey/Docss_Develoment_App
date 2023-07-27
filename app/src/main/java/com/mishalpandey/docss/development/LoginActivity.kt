package com.mishalpandey.docss.development

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.fitnytech.influencerApp.development.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class LoginActivity : AppCompatActivity() {
    private lateinit var gsc : GoogleSignInClient
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        gsc = GoogleSignIn.getClient(this,gso)


    }

    private fun sigInGoogle() {
        startActivityForResult(gsc.signInIntent,13)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==13&& resultCode== RESULT_OK){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            val account = task.getResult(ApiException::class.java)!!
            firebaseAuthGoogle(account.idToken!!)

        }
    }

    private fun firebaseAuthGoogle(idToken: String) {
        val crad = GoogleAuthProvider.getCredential(idToken,null)
        auth.signInWithCredential(crad)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                }else{
                    Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
                }
            }
    }


    fun onClick(view: View) {
        sigInGoogle()
    }
//    override fun onStart() {
//
//        if(FirebaseAuth.getInstance().currentUser!=null){
//            startActivity(Intent(this,MainActivity::class.java))
//        }
//        super.onStart()
//    }
}