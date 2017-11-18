package xyz.jagdeep.designit.presentation.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import xyz.jagdeep.designit.R


class MainActivity : AppCompatActivity() {

    companion object {
        val navigationIds: IntArray = intArrayOf(
                R.id.navigation_home,
                R.id.navigation_explore,
                R.id.navigation_profile)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        viewPager_main.currentItem = navigationIds.indexOf(item.itemId)
        return@OnNavigationItemSelectedListener true
    }

    private val mOnPageChangeListener = object : ViewPager.OnPageChangeListener {

        override fun onPageScrollStateChanged(state: Int) {}

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

        override fun onPageSelected(position: Int) {
            navigation_main.selectedItemId = navigationIds[position]
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
        viewPager_main.offscreenPageLimit = 2
    }
}
