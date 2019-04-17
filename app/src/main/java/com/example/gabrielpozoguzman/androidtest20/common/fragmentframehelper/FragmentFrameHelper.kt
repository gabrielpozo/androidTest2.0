package com.example.gabrielpozoguzman.androidtest20.common.fragmentframehelper

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

class FragmentFrameHelper(val activity: FragmentActivity, val mFragmentFrameWrapper: FragmentFrameWrapper, private val mFragmentManager: FragmentManager) {


    fun replaceFragmentAndDontAddBackStack(newFragment: Fragment) {
        replaceFragment(newFragment, false, false)
    }

    fun replaceFragmentAndCleanBackStack(newFragment: Fragment) {
        replaceFragment(newFragment, false, true)
    }

    fun replaceFragment(newFragment: Fragment) {
        replaceFragment(newFragment, true, false)
    }

    fun navigateUp() {
        //Some calls can be "lost" if they happen after the state has been saved
        if (mFragmentManager.isStateSaved) {
            return
        }
        val currentFragment = getCurrentFragment()


        if (mFragmentManager.backStackEntryCount > 0) {
            removeCurrentFragment()

            if (mFragmentManager.popBackStackImmediate()) {
                return // navigated up in fragment back-stack

            }
        }


    }

    private fun removeCurrentFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun getCurrentFragment(): Any? {
        return null
    }


    fun replaceFragment(newFragment: Fragment, addBackStack: Boolean, clearBackStack: Boolean) {
        if (clearBackStack) {
            if (mFragmentManager.isStateSaved) {
                // if the state is saved we can't clear the back stack. Simply not doing this, but
                // still replacing fragment is bad idea. Therefore we abort the entire operation
                return
            }
            // we clear here the back-stack immediately
            mFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }

        val ft = mFragmentManager.beginTransaction()

        if (addBackStack)// QuestionList won't be added
            ft.addToBackStack(null)

        // it means the new fragment will replace the one it was upfront before if there was one before...
        // it there wasn't, then it will be added indeed
        ft.replace(getFragmentId(), newFragment, null)

        if (mFragmentManager.isStateSaved) {//it means the activity is on save and restore flow -- the host already saved the state of the fragment Manager --> -> it is under rotation for example
            // no operation should not be performed here because it might throw an exception if we commit here
            // BUT with the method below we avoid exceptions
            ft.commitAllowingStateLoss()// it wont be commit anything if it happens after onStop()
        } else {
            ft.commit()
        }
    }

    private fun getFragmentId(): Int {
        return mFragmentFrameWrapper.getFragmentFrame().id
    }

}