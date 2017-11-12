package xyz.jagdeep.designit.presentation


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_profile.view.*
import xyz.jagdeep.designit.R
import java.security.SecureRandom


class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val contentView = inflater!!.inflate(R.layout.fragment_profile, container, false)
        contentView.message.text = "Hello " + SecureRandom().nextInt()
        return contentView
    }

}
