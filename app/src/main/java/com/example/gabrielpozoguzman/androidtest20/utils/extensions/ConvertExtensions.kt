package com.example.gabrielpozoguzman.androidtest20.utils.extensions

import com.example.gabrielpozoguzman.androidtest20.categories.*

fun List<CategoryDetailSchemaItem>.convertToCategoryDetailModel(categoryId: String): List<CategoryDetailType> {
    val categoryDetailType: MutableList<CategoryDetailType> = ArrayList()
    when (categoryId) {
        CategoryDetailType.BOOK -> {
            forEach {
                categoryDetailType.add(CategoryBook((it as CategorySchemaBook).authors, it.country, it.isbn, it.name, it.mediaType, it.numberPages, it.released))
            }
        }
        CategoryDetailType.HOUSE -> {
            forEach {
                categoryDetailType.add(CategoryHouse((it as CategorySchemaHouse).id, it.name, it.region, it.title))
            }
        }
        CategoryDetailType.CHARACTER -> {
            forEach {
                categoryDetailType.add(CategoryCharacter((it as CategorySchemaCharacter).aliases, it.titles, it.playedBy, it.name, it.id, it.gender))
            }
        }
        else -> {
            forEach {
                categoryDetailType.add(CategoryBook((it as CategorySchemaBook).authors, it.country, it.isbn, it.name, it.mediaType, it.numberPages, it.released))
            }
        }
    }
    return categoryDetailType
}
