package com.example.gabrielpozoguzman.androidtest20.screens.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.gabrielpozoguzman.androidtest20.R
import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoriesUseCase2
import com.example.gabrielpozoguzman.androidtest20.screens.categories.CategoriesActivity
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BaseActivity
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SplashActivity : BaseActivity() {
    private var parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 1500 //1.5 seconds

    @Inject
    lateinit var fetchCategoriesUseCase2: FetchCategoriesUseCase2

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            scope.launch {
                fetchCategoriesUseCase2.fetchCategories(this@SplashActivity::fetchCategoriesComplete, this@SplashActivity::fetchCategoriesCompleteWithErrors)
            }
        }
    }

    private fun fetchCategoriesComplete() {
        val intent = Intent(applicationContext, CategoriesActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun fetchCategoriesCompleteWithErrors(t: Throwable) {
        TODO("Error screen not implemented yet")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        getPresentationComponent().inject(this)

        //Initialize the Handler
        mDelayHandler = Handler()
        //Navigate with delay
        mDelayHandler?.postDelayed(mRunnable, SPLASH_DELAY)

    }

    public override fun onDestroy() {
        mDelayHandler?.removeCallbacks(mRunnable)
        // fetchCategoriesUseCase2.cancelAllCoroutinesManager()
        parentJob.cancel()
        super.onDestroy()
    }
}

