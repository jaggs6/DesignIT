package xyz.jagdeep.designit.presentation.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_home.view.*
import xyz.jagdeep.designit.R
import xyz.jagdeep.designit.presentation.SquareImageView
import xyz.jagdeep.designit.presentation.home.HomeFragment.OnListFragmentInteractionListener
import xyz.jagdeep.designit.presentation.home.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class HomeAdapter(private val mValues: List<DummyItem>, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = mValues[position]

        Glide.with(holder.mContentView)
                .applyDefaultRequestOptions(RequestOptions().centerCrop())
                .load(mValues[position].imageUrl)
                .into(holder.mContentView)

        holder.mView.setOnClickListener {
            mListener?.onListFragmentInteraction(holder.mItem!!)
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mContentView: SquareImageView? = mView.image_list_product
        var mItem: DummyItem? = null
    }
}
