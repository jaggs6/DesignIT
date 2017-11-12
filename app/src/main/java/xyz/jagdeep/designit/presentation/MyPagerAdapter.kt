package xyz.jagdeep.designit.presentation

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MyPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    // Returns total number of pages
    override fun getCount(): Int {
        return NUM_ITEMS
    }

    // Returns the fragment to display for that page
    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> ProfileFragment()
            1 -> ProfileFragment()
            2 -> ProfileFragment()
            else -> null
        }
    }

    companion object {
        private val NUM_ITEMS = 3
    }

}
