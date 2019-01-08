package com.example.gabrielpozoguzman.androidtest20.screens.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.R
import com.example.gabrielpozoguzman.androidtest20.categories.CategoriesUseRepository
import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoriesUseCase2
import com.example.gabrielpozoguzman.androidtest20.repository.database.CategoriesRoomDatabase
import com.example.gabrielpozoguzman.androidtest20.screens.categories.CategoriesActivity
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BaseActivity
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
            val intent = Intent(applicationContext, CategoriesActivity::class.java)
            scope.launch {
                fetchCategoriesUseCase2.execute()
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        getPresentationComponent().inject(this)

        //Initialize the Handler
        mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)

    }

    public override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        fetchCategoriesUseCase2.cleanup()
        parentJob.cancel()
        super.onDestroy()
    }
}