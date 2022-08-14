package com.ausioz.binarch3gamesuit

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.core.view.isVisible
import com.ausioz.binarch3gamesuit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val textTitle = (R.string.app_title_text)
    private var _binding: ActivityMainBinding? = null
    private val pilihanSuit = arrayOf("Batu", "Gunting", "Kertas")
    private var pemain1: String? = null
    private var pemain2: String? = null
    private var status: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        _binding?.textTitle?.text = (getText(textTitle))
        _binding?.textTerminal?.text = "VS"

        // 0: Batu      1: Gunting      2:Kertas
        _binding?.playerBtnBatu?.setOnClickListener {
            refreshPickP1()
            activePickBatu()
            pemain1 = pilihanSuit[0]
            Log.d("Pemain 1 Input", pemain1!!)
        }
        _binding?.playerBtnGunting?.setOnClickListener {
            refreshPickP1()
            activePickGunting()
            pemain1 = pilihanSuit[1]
            Log.d("Pemain 1 Input", pemain1!!)
        }
        _binding?.playerBtnKertas?.setOnClickListener {
            refreshPickP1()
            activePickKertas()
            pemain1 = pilihanSuit[2]
            Log.d("Pemain 1 Input", pemain1!!)
        }

        fun player2Mode() {
            _binding?.comBtnBatu?.setOnClickListener {
                refreshPickP2()
                activePickBatuP2()
                pemain2 = pilihanSuit[0]
                Log.d("Pemain 2 Input", pemain2!!)
            }
            _binding?.comBtnGunting?.setOnClickListener {
                refreshPickP2()
                activePickGuntingP2()
                pemain2 = pilihanSuit[1]
                Log.d("Pemain 2 Input", pemain2!!)
            }
            _binding?.comBtnKertas?.setOnClickListener {
                refreshPickP2()
                activePickKertasP2()
                pemain2 = pilihanSuit[2]
                Log.d("Pemain 2 Input", pemain2!!)
            }

        }
        _binding?.modeP2?.setOnClickListener {
            player2Mode()
            enablePickP1()
            refreshPickP1()
            refreshPickP2()
            doRule()
            _binding?.textTerminal?.text = "VS"
            _binding?.btnLockPick?.setOnClickListener {
                disablePickP1()
                refreshPickP1()
                inactivePickP1()
                enablePickP2()
            }
            _binding?.btnLockPick2?.setOnClickListener {
                disablePickP2()
                refreshPickP2()
                inactivePickP2()
                Log.d("Pemain 2 Input lock", pemain2!!)
            }
            _binding?.start?.setOnClickListener {
                doRule()
                Log.d("Pemain 2 Input lock", pemain2!!)
                Log.d("Pemain 2 Input lock", status!!)
                playTerminalP2mode()
            }
        }

        _binding?.modeCom?.setOnClickListener {
            enablePickP1()
            refreshPickP1()
            refreshPickP2()
            _binding?.textTerminal?.text = "VS"
            pemain2 = pilihanSuit.random()
            _binding?.btnLockPick?.setOnClickListener {
                disablePickP1()
            }
            _binding?.start?.setOnClickListener {
                doRule()
                playTerminalP1mode()
            }
        }

        _binding?.btnRefresh?.setOnClickListener {
            enablePickP1()
            enablePickP2()
            refreshPickP1()
            refreshPickP2()
            _binding?.textTerminal?.text = "VS"
        }

    }

    private fun doRule() {
//        pemain2 = pilihanSuit.random()
        // 0: Batu      1: Gunting      2:Kertas
        status = if (
            pemain1 == pilihanSuit[0] && pemain2 == pilihanSuit[1] ||
            pemain1 == pilihanSuit[1] && pemain2 == pilihanSuit[2] ||
            pemain1 == pilihanSuit[2] && pemain2 == pilihanSuit[0]
        ) {
            "Pemain 1 MENANG!"
        } else if (
            pemain1 == pilihanSuit[0] && pemain2 == pilihanSuit[2] ||
            pemain1 == pilihanSuit[1] && pemain2 == pilihanSuit[0] ||
            pemain1 == pilihanSuit[2] && pemain2 == pilihanSuit[1]
        ) {
            "Pemain 2 MENANG!"
        } else {
            "DRAW!"
        }
    }

    private fun activePickBatu() {
        _binding?.playerBtnBatu?.setBackgroundColor(resources.getColor(R.color.active))
        _binding?.playerBtnGunting?.setColorFilter(Color.LTGRAY)
        _binding?.playerBtnKertas?.setColorFilter(Color.LTGRAY)
        _binding?.btnLockPick?.isVisible = true
        _binding?.btnLockPick?.text = "Kunci Pilihan\nBatu"
    }

    private fun activePickBatuP2() {
        _binding?.comBtnBatu?.setBackgroundColor(resources.getColor(R.color.active))
        _binding?.comBtnGunting?.setColorFilter(Color.LTGRAY)
        _binding?.comBtnKertas?.setColorFilter(Color.LTGRAY)
        _binding?.btnLockPick2?.isVisible = true
        _binding?.btnLockPick2?.text = "Kunci Pilihan\nBatu"
    }

    private fun activePickGunting() {
        _binding?.playerBtnBatu?.setColorFilter(Color.LTGRAY)
        _binding?.playerBtnGunting?.setBackgroundColor(resources.getColor(R.color.active))
        _binding?.playerBtnKertas?.setColorFilter(Color.LTGRAY)
        _binding?.btnLockPick?.isVisible = true
        _binding?.btnLockPick?.text = "Kunci Pilihan\nGunting"
    }

    private fun activePickGuntingP2() {
        _binding?.comBtnBatu?.setColorFilter(Color.LTGRAY)
        _binding?.comBtnGunting?.setBackgroundColor(resources.getColor(R.color.active))
        _binding?.comBtnKertas?.setColorFilter(Color.LTGRAY)
        _binding?.btnLockPick2?.isVisible = true
        _binding?.btnLockPick2?.text = "Kunci Pilihan\nGunting"
    }

    private fun activePickKertas() {
        _binding?.playerBtnBatu?.setColorFilter(Color.LTGRAY)
        _binding?.playerBtnGunting?.setColorFilter(Color.LTGRAY)
        _binding?.playerBtnKertas?.setBackgroundColor(resources.getColor(R.color.active))
        _binding?.btnLockPick?.isVisible = true
        _binding?.btnLockPick?.text = "Kunci Pilihan\nKertas"
    }

    private fun activePickKertasP2() {
        _binding?.comBtnBatu?.setColorFilter(Color.LTGRAY)
        _binding?.comBtnGunting?.setColorFilter(Color.LTGRAY)
        _binding?.comBtnKertas?.setBackgroundColor(resources.getColor(R.color.active))
        _binding?.btnLockPick2?.isVisible = true
        _binding?.btnLockPick2?.text = "Kunci Pilihan\nKertas"
    }


    private fun inactivePickP1() {
        _binding?.playerBtnBatu?.setColorFilter(Color.LTGRAY)
        _binding?.playerBtnGunting?.setColorFilter(Color.LTGRAY)
        _binding?.playerBtnKertas?.setColorFilter(Color.LTGRAY)
    }

    private fun inactivePickP2() {
        _binding?.comBtnBatu?.setColorFilter(Color.LTGRAY)
        _binding?.comBtnGunting?.setColorFilter(Color.LTGRAY)
        _binding?.comBtnKertas?.setColorFilter(Color.LTGRAY)
    }

    private fun refreshPickP1() {
        _binding?.btnLockPick?.isVisible = false
        _binding?.playerBtnBatu?.setBackgroundColor(Color.TRANSPARENT)
        _binding?.playerBtnBatu?.colorFilter = null
        _binding?.playerBtnGunting?.setBackgroundColor(Color.TRANSPARENT)
        _binding?.playerBtnGunting?.colorFilter = null
        _binding?.playerBtnKertas?.setBackgroundColor(Color.TRANSPARENT)
        _binding?.playerBtnKertas?.colorFilter = null
        _binding?.textTerminal?.setTextColor(Color.BLACK)
    }

    private fun refreshPickP2() {
        _binding?.btnLockPick2?.isVisible = false
        _binding?.comBtnBatu?.setBackgroundColor(Color.TRANSPARENT)
        _binding?.comBtnBatu?.colorFilter = null
        _binding?.comBtnGunting?.setBackgroundColor(Color.TRANSPARENT)
        _binding?.comBtnGunting?.colorFilter = null
        _binding?.comBtnKertas?.setBackgroundColor(Color.TRANSPARENT)
        _binding?.comBtnKertas?.colorFilter = null
        _binding?.textTerminal?.setTextColor(Color.BLACK)
    }

    private fun disablePickP1() {
        _binding?.playerBtnBatu?.isClickable = false
        _binding?.playerBtnGunting?.isClickable = false
        _binding?.playerBtnKertas?.isClickable = false
        _binding?.btnLockPick?.isVisible = false
    }

    private fun disablePickP2() {
        _binding?.comBtnBatu?.isClickable = false
        _binding?.comBtnGunting?.isClickable = false
        _binding?.comBtnKertas?.isClickable = false
        _binding?.btnLockPick2?.isVisible = false
    }

    private fun enablePickP1() {
        _binding?.playerBtnBatu?.isClickable = true
        _binding?.playerBtnGunting?.isClickable = true
        _binding?.playerBtnKertas?.isClickable = true
    }

    private fun enablePickP2() {
        _binding?.comBtnBatu?.isClickable = true
        _binding?.comBtnGunting?.isClickable = true
        _binding?.comBtnKertas?.isClickable = true
    }

    fun pickRevealP1() {
        // 0: Batu      1: Gunting      2:Kertas
        when (pemain1) {
            pilihanSuit[0] -> {
                _binding?.playerBtnBatu?.setBackgroundColor(resources.getColor(R.color.active))
                _binding?.playerBtnBatu?.colorFilter = null
            }
            pilihanSuit[1] -> {
                _binding?.playerBtnGunting?.setBackgroundColor(resources.getColor(R.color.active))
                _binding?.playerBtnGunting?.colorFilter = null
            }
            else -> {
                _binding?.playerBtnKertas?.setBackgroundColor(resources.getColor(R.color.active))
                _binding?.playerBtnKertas?.colorFilter = null
            }
        }
    }

    fun pickRevealP2() {
        // 0: Batu      1: Gunting      2:Kertas
        when (pemain2) {
            pilihanSuit[0] -> {
                _binding?.comBtnBatu?.setBackgroundColor(resources.getColor(R.color.active))
                _binding?.comBtnBatu?.colorFilter = null
            }
            pilihanSuit[1] -> {
                _binding?.comBtnGunting?.setBackgroundColor(resources.getColor(R.color.active))
                _binding?.comBtnGunting?.colorFilter = null
            }
            else -> {
                _binding?.comBtnKertas?.setBackgroundColor(resources.getColor(R.color.active))
                _binding?.comBtnKertas?.colorFilter = null
            }
        }
    }

    fun terminalText() {
        when (status) {
            "Pemain 1 MENANG!" -> {
                _binding?.textTerminal?.setTextColor(resources.getColor(R.color.player_win))
            }
            "Pemain 2 MENANG!" -> {
                _binding?.textTerminal?.setTextColor(resources.getColor(R.color.com_win))
            }
            else -> {
                _binding?.textTerminal?.setTextColor(resources.getColor(R.color.draw))
            }
        }
    }

    private fun playTerminalP1mode() {
        inactivePickP2()
        val count: CountDownTimer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _binding?.textTerminal?.text = ((millisUntilFinished / 1000) + 1).toString()
                Log.d("Countdown", "playTerminal: ${((millisUntilFinished / 1000)) + 1}")
                _binding?.btnRefresh?.isClickable = false
                _binding?.btnRefresh?.isVisible = false
            }

            override fun onFinish() {
                _binding?.textTerminal?.text = status
                pickRevealP2()
                terminalText()
                Log.d("Pemain 2 Input", "$pemain2")
                Log.d("Hasil pertandingan,", "$status")
                _binding?.btnRefresh?.isClickable = true
                _binding?.btnRefresh?.isVisible = true
            }
        }
        count.start()
    }

    private fun playTerminalP2mode() {

        val count: CountDownTimer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _binding?.textTerminal?.text = ((millisUntilFinished / 1000) + 1).toString()
                Log.d("Countdown", "playTerminal: ${((millisUntilFinished / 1000)) + 1}")
                _binding?.btnRefresh?.isClickable = false
                _binding?.btnRefresh?.isVisible = false
            }

            override fun onFinish() {
                _binding?.textTerminal?.text = status
                pickRevealP2()
                pickRevealP1()
                terminalText()
                Log.d("Pemain 2 Input", "$pemain2")
                Log.d("Hasil pertandingan,", "$status")
                _binding?.btnRefresh?.isClickable = true
                _binding?.btnRefresh?.isVisible = true
            }
        }
        count.start()
    }

}