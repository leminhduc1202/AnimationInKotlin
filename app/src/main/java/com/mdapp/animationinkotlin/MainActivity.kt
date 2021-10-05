package com.mdapp.animationinkotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.mdapp.animationinkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btFadeIn.setOnClickListener {
            binding.tvAnimations.visibility = View.VISIBLE
            val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            binding.tvAnimations.startAnimation(animationFadeIn)
        }

        binding.btFadeOut.setOnClickListener {
            val animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            binding.tvAnimations.startAnimation(animationFadeOut)
            Handler().postDelayed({
                binding.tvAnimations.visibility = View.GONE
            }, 500)
        }
        binding.btZoomIn.setOnClickListener {
            val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
            binding.tvAnimations.startAnimation(animationZoomIn)
        }
        binding.btZoomOut.setOnClickListener {
            val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
            binding.tvAnimations.startAnimation(animationZoomOut)
        }
        binding.btSlideIn.setOnClickListener {
            val animationSlideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down)
            binding.tvAnimations.startAnimation(animationSlideDown)
        }
        binding.btSlideOut.setOnClickListener {
            val animationSlideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
            binding.tvAnimations.startAnimation(animationSlideUp)
        }
        binding.btBounce.setOnClickListener {
            val animationBounce = AnimationUtils.loadAnimation(this, R.anim.bounce)
            binding.tvAnimations.startAnimation(animationBounce)
        }
        binding.btRotate.setOnClickListener {
            val animationRotate = AnimationUtils.loadAnimation(this, R.anim.rotate)
            binding.tvAnimations.startAnimation(animationRotate)
        }

        binding.btNext.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }

    }
}