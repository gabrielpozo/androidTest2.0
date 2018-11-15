package com.example.gabrielpozoguzman.androidtest20.networking;

import com.google.gson.annotations.SerializedName;

import com.techyourchance.mvc.networking.questions.CategoriesSchema;
import java.util.List;

public class CategoriesResponseSchema {

	@SerializedName("")
	private final List<CategoriesSchema> mCategories;

	public CategoriesResponseSchema(List<CategoriesSchema> categories) {
		mCategories = categories;
	}

	public List<CategoriesSchema> getCategories() {
		return mCategories;
	}
}
