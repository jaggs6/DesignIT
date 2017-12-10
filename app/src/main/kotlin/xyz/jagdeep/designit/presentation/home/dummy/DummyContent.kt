package xyz.jagdeep.designit.presentation.home.dummy

import java.util.*

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    private val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    private var pos: Int = 0

    init {
        addItem(createDummyItem("https://images.fineartamerica.com/images/artworkimages/mediumlarge/1/corner-of-jackson-square-diane-millsap.jpg"))
        addItem(createDummyItem("https://i.pinimg.com/736x/dc/a2/a6/dca2a62ead9e3918731e868874832ad7--mens-fashion-styles-fashion-blogs.jpg"))
        addItem(createDummyItem("http://cdn3.yoox.biz/cloud/mcqwp/uploads/2017/12/McQ_DECEMBER_WK2_ROW1-1.jpg"))
        addItem(createDummyItem("https://ae01.alicdn.com/kf/HTB1dxa6JpXXXXXjaXXXq6xXFXXXJ/Luxury-bride-wedding-shoes-crystal-bridal-wedding-shoes-rhinestone-ultra-high-heels-pumps-with-platform-heel.jpg"))
        addItem(createDummyItem("http://www.thefashionconnector.com/bags/niarvi/tulips_big.jpg"))
        addItem(createDummyItem("http://blog.folksy.com/wp-content/uploads/2015/09/distsy-blue-Roses-and-Blackberries-Bracelet.jpg"))
        addItem(createDummyItem("https://isv-loveknitting.freetls.fastly.net/index.php/v1/images/6ee182093a49d9a2577b75751d1252fb/5d46d576-3c27-4aec-aaea-75a7ac3d7d83.jpg/0/-/1000x1000"))
        addItem(createDummyItem("http://s3.weddbook.com/t4/2/5/0/2503348/vintage-hankie-blue-embroidered-hankies-white-bridal-something-blue-thinking-of-you-mother-of-the-bride-gift-get-well-cotton-linen-1.jpg"))
        addItem(createDummyItem("http://spanosart.com/wp-content/uploads/2011/07/sunflower-2-spanos-600.jpg"))
        addItem(createDummyItem("https://ae01.alicdn.com/kf/HTB1rUN2LFXXXXXrXpXXq6xXFXXXb/White-Flower-Lace-Platform-Bridal-Shoes-Beautiful-Women-High-Heels-Handmade-Lace-Wedding-Dress-Shoes-Girl.jpg"))
        addItem(createDummyItem("https://i.pinimg.com/736x/64/2f/05/642f05a22795f00b6bfb506277bad67c--handmade-purses-handmade-handbags.jpg"))
        addItem(createDummyItem("http://designwrld.com/wp-content/uploads/2016/05/Mythology-Inspired-Polygonal-Animal-Sculptures-By-Paul-Cummings-06.jpg"))
        addItem(createDummyItem("https://cdn.shopify.com/s/files/1/1156/8442/products/3M_socks_pink_1024x1024.png?v=1502907105"))
        addItem(createDummyItem("https://ae01.alicdn.com/kf/HTB1T6dhIXXXXXarXFXXq6xXFXXXH/Modern-Design-Flowers-100-Cotton-Embroidery-Sofa-Cushion-Covers-White-Trendy-Designer-Interior-Decoration-Home-Textile.jpg"))
        addItem(createDummyItem("http://2.bp.blogspot.com/-uILuxaqqk4M/VD-LHjVECcI/AAAAAAAAWwg/IVgcOzhyFWk/s1600/Cardio1.jpg"))
        addItem(createDummyItem("https://img1.etsystatic.com/075/0/9448190/il_570xN.816611501_3wuc.jpg"))
        addItem(createDummyItem("https://img1.etsystatic.com/075/0/5889830/il_570xN.820474893_62vg.jpg"))
        addItem(createDummyItem("https://cs1.livemaster.ru/storage/85/9a/758739bdb287d7443fa9b480a9--odezhda-barhatnoe-plate.jpg"))
        addItem(createDummyItem("http://1.bp.blogspot.com/-PO42OKalWxo/U5zR4AjtgnI/AAAAAAAADko/QzKyNAs78Hg/s1600/booandboofactory-handmade-fashion-jewelry-2.jpg"))
        addItem(createDummyItem("http://sewcaroline.com/wp-content/uploads/2013/12/IMG_9878.jpg"))
        addItem(createDummyItem("https://i.pinimg.com/736x/77/b0/75/77b0756fa7f4eba0b03d2820782ad0a4--cable-knit-sweaters-mens-sweaters.jpg"))
        addItem(createDummyItem("https://cdn.shopify.com/s/files/1/2216/0939/products/trendy-geometric-design-handmade-wooden-bow-ties-for-men-mens-accessories_grande.jpg?v=1510535420"))
    }

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEMS.shuffle()
        ITEM_MAP.put(item.id, item)
    }

    private fun createDummyItem(imageUrl: String): DummyItem {
        return DummyItem(pos++.toString(), imageUrl)
    }

    /**
     * A dummy item representing a piece of imageUrl.
     */
    class DummyItem(val id: String, val imageUrl: String) {

        override fun toString(): String {
            return imageUrl
        }
    }
}
