package xyz.jagdeep.designit.presentation.explore.dummy

import java.util.*

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object CategoryDummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEM_CATEGORIES: MutableList<CategoryDummyItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    private val ITEM_MAP_CATEGORY: MutableMap<String, CategoryDummyItem> = HashMap()

    private var pos = 0

    init {
        addItem(createDummyItem("Fashion", "http://theurbanhousewife.com/wp-content/uploads/2013/01/More-Fashionable-with-Luxury-Winter-Outfits-for-Mens-and-Women-by-Burberry.jpg", 2))
        addItem(createDummyItem("Paintings", "http://www.tallahasseearts.org/wp-content/uploads/sites/www.tallahasseearts.org/images/2016/09/primary-6-Week-Beginners-Painting-Class-1475009608.jpeg", 1))
        addItem(createDummyItem("Photography", "https://udemy-images.udemy.com/course/750x422/394968_538b_7.jpg", 1))
        addItem(createDummyItem("Home Decor", "http://onyoustore.com/wp-content/uploads/2017/11/diy-rustic-home-decor-ideas-magnificent-decoration-manificent-best-20-18.jpg", 2))
        addItem(createDummyItem("Accessories", "http://inspomag-1025.kxcdn.com/wp-content/uploads/2016/05/Fashion-Accessories-1.jpg", 3))
    }

    private fun addItem(itemCategory: CategoryDummyItem) {
        ITEM_CATEGORIES.add(itemCategory)
        ITEM_MAP_CATEGORY.put(itemCategory.id, itemCategory)
    }

    private fun createDummyItem(content: String, imageUrl: String, spanCount: Int): CategoryDummyItem {
        return CategoryDummyItem(pos++.toString(), content, imageUrl, spanCount)
    }

    class CategoryDummyItem(val id: String, val content: String, val imageUrl: String, val spanCount: Int) {

        override fun toString(): String {
            return content
        }
    }
}
