package com.example.delgram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.delgram.databinding.ActivityLoginBinding
import com.example.delgram.databinding.ActivitySignUpBinding
import com.example.delgram.databinding.ActivitySplashBinding

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val ActivitySignUpBinding: ActivitySignUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(ActivitySignUpBinding.root)

        val tvLogin = ActivitySignUpBinding.login
        tvLogin.setOnClickListener {
            val intent: Intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}