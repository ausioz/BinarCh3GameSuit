package com.ausioz.binarch3gamesuit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ausioz.binarch3gamesuit.databinding.ActivityGameModeBinding
import com.ausioz.binarch3gamesuit.landingpage.LandingPageThree

class GameModeActivity : AppCompatActivity() {
    private var _binding: ActivityGameModeBinding? = null
    private var gameModeId = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_mode)

        _binding = ActivityGameModeBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        val playerName = intent.getStringExtra(LandingPageThree.PLAYER_NAME)

        _binding?.gameModeTxtVsPlayer?.text = playerName + " vs Pemain2"
        _binding?.gameModeTxtVsCom?.text = playerName + " vs CPU"

        _binding?.gameModeImgVsPlayer?.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            gameModeId = 1
            intent.putExtra(GAME_MODE_ID, gameModeId)
            intent.putExtra(LandingPageThree.PLAYER_NAME, playerName)
            Log.d("game mode",gameModeId.toString())
            startActivity(intent)
        }

        _binding?.gameModeImgVsCom?.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            gameModeId = 2
            intent.putExtra(GAME_MODE_ID, gameModeId)
            intent.putExtra(LandingPageThree.PLAYER_NAME, playerName)
            Log.d("game mode",gameModeId.toString())
            startActivity(intent)
        }

    }

    companion object {
        const val GAME_MODE_ID = "id"
    }
}