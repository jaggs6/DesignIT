package xyz.jagdeep.designit.presentation.explore

import android.annotation.SuppressLint
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_category.view.*
import xyz.jagdeep.designit.R
import xyz.jagdeep.designit.presentation.explore.CategoryFragment.OnCategoryFragmentInteractionListener
import xyz.jagdeep.designit.presentation.explore.dummy.CategoryDummyContent.CategoryDummyItem

class CategoryAdapter(private val mValues: List<CategoryDummyItem>, private val mListener: OnCategoryFragmentInteractionListener?) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItemCategory = mValues[position]
        holder.mContentView.text = mValues[position].content

        Glide.with(holder.mImageView)
                .applyDefaultRequestOptions(RequestOptions().centerCrop())
                .load(mValues[position].imageUrl)
                .into(holder.mImageView)

        holder.mView.setOnClickListener {
            mListener?.onCategoryFragmentInteraction(holder.mItemCategory!!)
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mImageView: AppCompatImageView = mView.image_list_category
        val mContentView: TextView = mView.name_list_category
        var mItemCategory: CategoryDummyItem? = null

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
