package com.example.growigh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

class OnboardActivity : AppCompatActivity() {


    private lateinit var imageIntro : ImageView
    private lateinit var introtext : TextView
    private lateinit var pgbar : ProgressBar
    private lateinit var introbtn : ImageView

    private val images = arrayOf(R.drawable.intro1, R.drawable.intro2, R.drawable.intro3)
    private val introTexts = arrayOf("About Us", "Our Mission", "Our Vision")

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)

        pgbar = findViewById(R.id.progress_bar)
        pgbar.visibility = View.INVISIBLE
        introbtn = findViewById(R.id.intro_home)
        introtext = findViewById(R.id.introText)
        imageIntro = findViewById(R.id.ImageIntro)

        // Set initial image and intro text
        updateIntroPage()

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
//        val adapter = IntroPagerAdapter(supportFragmentManager)
//        viewPager.adapter = adapter


        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                val progress = when (position) {
                    0 -> (positionOffset * 50).toInt()
                    1 -> 50 + (positionOffset * 25).toInt()
                    2 -> 75 + (positionOffset * 25).toInt()
                    else -> 100
                }
                pgbar.progress = progress
            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })



        introbtn.setOnClickListener {
            // Increment index and reset if it exceeds array size
            currentIndex++
            if (currentIndex > 2) {
                startActivity(Intent(this,WelcomeActivity::class.java))
            }
            // Update image and intro text
            updateIntroPage()
        }


    }

    private fun updateIntroPage() {
        if (currentIndex < images.size && currentIndex < introTexts.size) {
            // Set image and intro text based on current index
            imageIntro.setImageResource(images[currentIndex])
            introtext.text = introTexts[currentIndex]
        } else {
            // Handle the case when the currentIndex is out of bounds
            // You can choose to show a default image or text, or handle it in any other way
        }
    }


}
//class IntroPagerAdapter(fragmentManager: FragmentManager) :
//    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
//
//    override fun getItem(position: Int): Fragment {
//        // Return the appropriate fragment based on the position
//        // Example: return IntroFragment.newInstance(position)
//    }
//
//    override fun getCount(): Int {
//        // Return the total number of pages
//    }
//}