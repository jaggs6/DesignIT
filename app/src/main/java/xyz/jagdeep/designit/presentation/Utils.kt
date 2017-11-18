package xyz.jagdeep.designit.presentation

import android.databinding.BindingAdapter
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions

class Utils {
    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl", "isCircle", requireAll = false)
        fun loadImage(iv: ImageView, imageUrl: String, isCircle: Boolean) {
            var request = Glide.with(iv.context)
                    .load(imageUrl)
            if (isCircle) {
                request = request.apply(RequestOptions.bitmapTransform(CircleCrop()))
            }
            request.into(iv)
        }

        @JvmStatic
        @BindingAdapter("htmlText")
        fun formatText(tv: TextView, text: String) {
            tv.text = Html.fromHtml(text)
        }
    }
}