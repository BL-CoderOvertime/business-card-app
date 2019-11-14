package com.example.businesscardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var gso: GoogleSignInOptions
    private lateinit var googleClient: GoogleSignInClient
    private var  account: GoogleSignInAccount? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        googleSignInInit()

        //TODO: Change this when Google Signin is setup
        btn_google_signin.setOnClickListener { loginBypass() }
    }

    override fun onStart() {
        super.onStart()
        checkForSignedIn()
    }

    private fun googleSignInInit(){
       gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
           .requestEmail()
           .build()

       googleClient = GoogleSignIn.getClient(this, gso)
   }

    private fun checkForSignedIn(){
        account = GoogleSignIn.getLastSignedInAccount(this)
        updateUI(account)
    }

    private fun updateUI(account: GoogleSignInAccount?){
        if(account == null){
            container_btn_google_signin.visibility = View.VISIBLE
        }else{
            auth()
            //ToDo: Login
        }
    }

    private fun auth(){
        //TODO:Setup auth
    }

    private fun loginBypass(){
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
