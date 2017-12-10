package xyz.jagdeep.designit.presentation.explore

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xyz.jagdeep.designit.R
import xyz.jagdeep.designit.presentation.explore.dummy.CategoryDummyContent
import xyz.jagdeep.designit.presentation.explore.dummy.CategoryDummyContent.CategoryDummyItem


class CategoryFragment : Fragment() {

    // TODO: Customize parameters
    private val mColumnCount = 3

    private var mListener: OnCategoryFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_category_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            val context = view.getContext()
            view.layoutManager = GridLayoutManager(context, mColumnCount)
            view.adapter = CategoryAdapter(CategoryDummyContent.ITEM_CATEGORIES, mListener)

            (view.layoutManager as GridLayoutManager).spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return CategoryDummyContent.ITEM_CATEGORIES[position].spanCount
                }
            }
            view.itemAnimator = DefaultItemAnimator()
            view.setHasFixedSize(true)
        }
        return view
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnCategoryFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnCategoryFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnCategoryFragmentInteractionListener {
        fun onCategoryFragmentInteraction(itemCategory: CategoryDummyItem)
    }
}
