package xyz.jagdeep.designit.presentation.profile


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import kotlinx.android.synthetic.main.fragment_profile.view.*
import xyz.jagdeep.designit.R


class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val contentView = inflater!!.inflate(R.layout.fragment_profile, container, false)
        Glide.with(this)
                .load("http://lorempixel.com/200/200/people/9")
                .apply(bitmapTransform(CircleCrop()))
                .into(contentView.photo_profile)

        contentView.viewPager_profile.adapter = ProfilePagerAdapter(fragmentManager)
        return contentView
    }

}
