package com.example.gabrielpozoguzman.androidtest20.common


abstract class MobgenPresenter<ViewMvcType : Any> : IMobgenPresenter<ViewMvcType> {
    lateinit var mViewMvc: ViewMvcType

    abstract override fun onStart()
    abstract override fun onStop()
    override fun bindView(viewMvc: ViewMvcType) {
        mViewMvc = viewMvc
    }

}