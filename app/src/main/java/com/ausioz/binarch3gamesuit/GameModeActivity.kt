package com.ausioz.binarch3gamesuit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ausioz.binarch3gamesuit.databinding.ActivityGameModeBinding
import com.ausioz.binarch3gamesuit.landingpage.LandingPageThree

class GameModeActivity : AppCompatActivity() {
    private var _binding: ActivityGameModeBinding? = null
    var gameModeId :Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_mode)

        _binding = ActivityGameModeBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        val playerName = intent.getStringExtra(LandingPageThree.PLAYER_NAME)


        _binding?.gameModeTxtVsPlayer?.text = playerName + " vs Pemain2"
        _binding?.gameModeTxtVsCom?.text = playerName + " vs CPU"


        _binding?.gameModeImgVsPlayer?.setOnClickListener {
            // TODO:
            gameModeId = 1
        }

        _binding?.gameModeImgVsCom?.setOnClickListener {
            // TODO:
            gameModeId = 2
        }

    }
}