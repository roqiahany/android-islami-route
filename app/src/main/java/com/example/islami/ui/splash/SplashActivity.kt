package com.example.islami.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.islami.ui.home.HomeActivity
import com.example.islami.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper())
            .postDelayed({
                StartHomeActivity();
            }, 1000);
    }

    fun StartHomeActivity() {
        val intent =  Intent(this, HomeActivity::class.java)
        startActivity(intent);
        finish()

    }
}