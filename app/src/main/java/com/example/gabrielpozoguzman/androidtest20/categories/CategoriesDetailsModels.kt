package com.example.gabrielpozoguzman.androidtest20.categories


open class CategoryDetailType(val categoryType: String = "book") {
    companion object Type {
        const val BOOK = "book"
        const val HOUSE = "house"
        const val CHARACTER = "character"
    }
}

interface CategoryDetailSchemaItem {
}

/**BOOKs*/
data class CategorySchemaBook(val authors: List<String>,
                              val country: String,
                              val isbn: String,
                              val name: String,
                              val mediaType: String,
                              val numberPages: Int,
                              val released: String) : CategoryDetailSchemaItem {}

data class CategoryBook(val authors: List<String>,
                        val country: String,
                        val isbn: String,
                        val name: String,
                        val mediaType: String,
                        val numberPages: Int,
                        val released: String) : CategoryDetailType(BOOK) {}

/**HOUSES*/
data class CategorySchemaHouse(val id: String,
                               val name: String,
                               val region: String,
                               val title: String) : CategoryDetailSchemaItem {}

data class CategoryHouse(val id: String,
                         val name: String,
                         val region: String,
                         val title: String) : CategoryDetailType(HOUSE) {

}

/**CHARACTERS*/
data class CategorySchemaCharacter(var aliases: List<String>? = null,
                                   var titles: List<String>? = null,
                                   var playedBy: List<String>? = null,
                                   var name: String? = null,
                                   var id: String? = null,
                                   var gender: String? = null) : CategoryDetailSchemaItem {}

data class CategoryCharacter(var aliases: List<String>? = null,
                             var titles: List<String>? = null,
                             var playedBy: List<String>? = null,
                             var name: String? = null,
                             var id: String? = null,
                             var gender: String? = null) : CategoryDetailType(CHARACTER) {
}