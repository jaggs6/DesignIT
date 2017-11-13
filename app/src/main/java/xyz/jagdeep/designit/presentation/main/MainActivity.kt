package xyz.jagdeep.designit.presentation.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import xyz.jagdeep.designit.R


class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                viewPager_main.currentItem = 0
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_explore -> {
                viewPager_main.currentItem = 1
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                viewPager_main.currentItem = 2
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private val mOnPageChangeListener = object : ViewPager.OnPageChangeListener {

        override fun onPageScrollStateChanged(state: Int) {}

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

        override fun onPageSelected(position: Int) {
            when (position) {
                0 -> navigation_main.selectedItemId = R.id.navigation_home
                1 -> navigation_main.selectedItemId = R.id.navigation_explore
                2 -> navigation_main.selectedItemId = R.id.navigation_profile
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        navigation_main.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        viewPager_main.adapter = MainPagerAdapter(supportFragmentManager)
        viewPager_main.addOnPageChangeListener(mOnPageChangeListener)
    }
}
