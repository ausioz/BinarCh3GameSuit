package com.ausioz.binarch3gamesuit.landingpage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ausioz.binarch3gamesuit.GameModeActivity
import com.ausioz.binarch3gamesuit.databinding.FragmentLandingPageThreeBinding


class LandingPageThree : Fragment() {

    private var _binding: FragmentLandingPageThreeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLandingPageThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        _binding?.landingPageNext?.setOnClickListener {
            val intent = Intent(activity, GameModeActivity::class.java)
            val playerName = _binding?.landingPageEditText3?.text.toString()
            intent.putExtra(PLAYER_NAME, playerName)
            Log.d("player name", playerName)
            startActivity(intent)
        }

    }

    companion object {
        const val PLAYER_NAME = "name"
    }
}