package xyz.jagdeep.designit.presentation.profile

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import xyz.jagdeep.designit.presentation.BlankFragment

class ProfilePagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    // Returns total number of pages
    override fun getCount(): Int {
        return NUM_TABS
    }

    // Returns the fragment to display for that page
    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> BlankFragment.newInstance("Selling")
            1 -> BlankFragment.newInstance("Wishlist")
            2 -> BlankFragment.newInstance("Purchased")
            else -> null
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Selling"
            1 -> "Wishlist"
            2 -> "Purchases"
            else -> ""
        }
    }

    companion object {
        private val NUM_TABS = 3
    }

}
