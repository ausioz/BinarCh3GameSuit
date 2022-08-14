package com.ausioz.binarch3gamesuit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MediatorLiveData
import androidx.viewpager2.widget.ViewPager2
import com.ausioz.binarch3gamesuit.databinding.ActivityLandingPageBinding
import com.ausioz.binarch3gamesuit.databinding.ActivityMainBinding
import com.ausioz.binarch3gamesuit.landingpage.*
import com.google.android.material.tabs.TabLayoutMediator
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class LandingPageActivity : AppCompatActivity() {
    private var _binding: ActivityLandingPageBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        _binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(_binding?.root)


        val pagerAdapter = LandingPagerAdapter(fragmentActivity = this)

        _binding?.layoutViewPager?.adapter = pagerAdapter
        _binding?.dotIndicator?.attachTo(_binding?.layoutViewPager!!)

        pagerAdapter.setFragments(
            listOf(
                LandingPage_One(),
                LandingPageTwo(),
                LandingPageThree(),
            )
        )
    }
}