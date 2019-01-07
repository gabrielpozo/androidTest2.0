package com.example.gabrielpozoguzman.androidtest20.common

import com.example.gabrielpozoguzman.androidtest20.common.coroutines.CoroutinesManager


abstract class MobgenPresenter<ViewMvcType : Any>(coroutinesManager: CoroutinesManager) : CoroutinesManager by coroutinesManager, IMobgenPresenter<ViewMvcType> {
    lateinit var mViewMvc: ViewMvcType
    abstract override fun onStart()
    abstract override fun onStop()
    abstract override fun onDestroy()
    override fun bindView(viewMvc: ViewMvcType) {
        mViewMvc = viewMvc
    }

}