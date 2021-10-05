package com.mdapp.animationinkotlin

import android.content.Intent
import android.os.Bundle
import android.transition.TransitionManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.mdapp.animationinkotlin.databinding.ActivityFinalBinding

class FinalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this,R.anim.bounce)
            binding.imgView.startAnimation(animation)
        }

        val animation = AnimationUtils.loadAnimation(this, R.anim.animation)
        val animation1 = AnimationUtils.loadAnimation(this, R.anim.animation1)

        binding.imgView.startAnimation(animation)
        binding.linearLayout2.startAnimation(animation1)
        binding.linearLayout3.startAnimation(animation1)
        binding.linearLayout4.startAnimation(animation1)

        binding.btBackHome.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}