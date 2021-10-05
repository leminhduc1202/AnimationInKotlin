package com.mdapp.animationinkotlin

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.mdapp.animationinkotlin.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNextBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btPrevious.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        binding.btNext.setOnClickListener {
            val intent = Intent(this,FinalActivity::class.java)
            startActivity(intent)
        }

        binding.btAnimation.setOnClickListener {
            YoYo.with(Techniques.Tada).duration(700).repeat(5).playOn(binding.tvAnimations)
        }

        binding.btShowSpeed.setOnClickListener {

            // Connectivity Manager
            val cm =
                applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            // Network Capabilities of Active Network
            val nc = cm.getNetworkCapabilities(cm.activeNetwork)

            // DownSpeed in MBPS
            val downSpeed = (nc?.linkDownstreamBandwidthKbps)?.div(1000)

            // UpSpeed  in MBPS
            val upSpeed = (nc?.linkUpstreamBandwidthKbps)?.div(1000)

            // TextView to Display DownSpeed and UpSpeed

            binding.tvSpeedNetwork.setText("Speed down: $downSpeed Mbps \n Speed up: $upSpeed Mbps")
        }

    }
}