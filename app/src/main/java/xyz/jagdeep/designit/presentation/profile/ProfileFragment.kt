package xyz.jagdeep.designit.presentation.profile


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_login.view.*
import xyz.jagdeep.designit.R
import xyz.jagdeep.designit.databinding.FragmentProfileBinding
import xyz.jagdeep.designit.presentation.main.LoginListener


class ProfileFragment : Fragment() {

    private var mCurrentUser: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mCurrentUser = FirebaseAuth.getInstance().currentUser
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        if (mCurrentUser == null) {
            val loginPage = inflater!!.inflate(R.layout.fragment_login, container, false)
            loginPage.profile_login.setOnClickListener { (activity as LoginListener).login() }
            return loginPage
        } else {
            val profileBinding = FragmentProfileBinding.inflate(inflater!!, container, false)
            profileBinding.model = ProfileModel(
                    mCurrentUser!!.displayName!!,
                    mCurrentUser!!.photoUrl.toString(),
                    10,
                    4.0f,
                    "Fashion Designer based in London",
                    10,
                    20)

            profileBinding.viewPagerProfile.adapter = ProfilePagerAdapter(activity.supportFragmentManager)
            profileBinding.viewPagerProfile.offscreenPageLimit = 2
            return profileBinding.root
        }
    }

}
