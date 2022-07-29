package com.welcomeleviqx.feathershoecaretips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.welcomeleviqx.feathershoecaretips.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    // переменная под ViewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // интеграция ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Проверка содержимого массива
        val tipList = resources.getStringArray(R.array.tipStrings)
        for (i in tipList.indices) {
            Log.wtf("devx", tipList[i])
        }

        binding.viewPager.adapter = ViewPagerAdapter(tipList.toList())

        // Логика показа навигационных стрелок:
        // на первой нет <
        // на последней нет >
        binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                when (binding.viewPager.currentItem) {
                    binding.viewPager.adapter?.itemCount?.minus(1) -> binding.icEnd.visibility = View.INVISIBLE
                    0 -> binding.icStart.visibility = View.INVISIBLE
                    else -> {
                        binding.icStart.visibility = View.VISIBLE
                        binding.icEnd.visibility = View.VISIBLE
                    }
                }
            }
        })

    }

}