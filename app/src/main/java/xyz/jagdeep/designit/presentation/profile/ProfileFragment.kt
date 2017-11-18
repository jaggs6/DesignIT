package xyz.jagdeep.designit.presentation.profile


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xyz.jagdeep.designit.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val profileBinding = FragmentProfileBinding.inflate(inflater!!, container, false)

        profileBinding.model = ProfileModel(
                "Racheal Green",
                "http://lorempixel.com/200/200/people/9",
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
