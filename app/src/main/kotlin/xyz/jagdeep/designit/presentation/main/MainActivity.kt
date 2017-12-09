package xyz.jagdeep.designit.presentation.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.firebase.ui.auth.AuthUI
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import xyz.jagdeep.designit.R
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        val navigationIds: IntArray = intArrayOf(
                R.id.navigation_home,
                R.id.navigation_explore,
                R.id.navigation_profile)
        private val RC_SIGN_IN = 123
    }

    private var mCurrentUser: FirebaseUser? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val position = navigationIds.indexOf(item.itemId)
        viewPager_main.currentItem = position
        if (mCurrentUser != null && position == 2) {
            profile_logout.visibility = View.VISIBLE
        } else {
            profile_logout.visibility = View.INVISIBLE
        }
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
        mCurrentUser = FirebaseAuth.getInstance().currentUser
        FirebaseAnalytics.getInstance(this)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        navigation_main.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        profile_logout.setOnClickListener {
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener({
                        recreate()
                        viewPager_main.currentItem = 0
                    })
        }

        setup()
    }

    private fun setup() {
        viewPager_main.adapter = MainPagerAdapter(supportFragmentManager)
        viewPager_main.addOnPageChangeListener(mOnPageChangeListener)
        viewPager_main.offscreenPageLimit = 2
    }

    fun login() {
        // Choose authentication providers
        val providers = Arrays.asList(
                AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()
        )

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setIsSmartLockEnabled(false)
                        .setLogo(R.drawable.logo)
                        .build(),
                RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN && resultCode == Activity.RESULT_OK) {
            recreate()
        }
    }
}
