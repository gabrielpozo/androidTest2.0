package com.example.gabrielpozoguzman.androidtest20.screens.common.dialogs

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.text.TextUtils

class DialogsManager(private var mFragmentManager: FragmentManager) {
    /**
     * Whenever a dialog is shown with non-empty "id", the provided id will be stored in
     * arguments Bundle under this key.
     */
    val ARGUMENT_DIALOG_ID = "ARGUMENT_DIALOG_ID"

    /**
     * In case Activity or Fragment that instantiated this DialogsManager are re-created (e.g.
     * in case of memory reclaim by OS, orientation change, etc.), we need to be able
     * to get a reference to dialog that might have been shown. This tag will be supplied with
     * all DialogFragment's shown by this DialogsManager and can be used to query
     * [FragmentManager] for last shown dialog.
     */
    private val DIALOG_FRAGMENT_TAG = "DIALOG_FRAGMENT_TAG"

    private var mCurrentlyShownDialog: DialogFragment? = null


    init {
        // there might be some dialog already shown
        val fragmentWithDialogTag = mFragmentManager.findFragmentByTag(DIALOG_FRAGMENT_TAG)
        if (fragmentWithDialogTag != null && DialogFragment::class.java.isAssignableFrom(fragmentWithDialogTag.javaClass)) {
            mCurrentlyShownDialog = fragmentWithDialogTag as DialogFragment?
        }
    }


    /**
     * @return a reference to currently shown dialog, or null if no dialog is shown.
     */
    fun getCurrentlyShownDialog(): DialogFragment? {
        return mCurrentlyShownDialog
    }

    /**
     * Obtain the id of the currently shown dialog.
     * @return the id of the currently shown dialog; empty string if no dialog is shown, or the currently
     * shown dialog has no id
     */
    fun getCurrentlyShownDialogId(): String? {
        return if (mCurrentlyShownDialog == null || mCurrentlyShownDialog!!.arguments == null ||
                !mCurrentlyShownDialog!!.arguments!!.containsKey(ARGUMENT_DIALOG_ID)) {
            ""
        } else {
            mCurrentlyShownDialog!!.arguments!!.getString(ARGUMENT_DIALOG_ID)
        }
    }

    /**
     * Check whether a dialog with a specified id is currently shown
     * @param id dialog id to query
     * @return true if a dialog with the given id is currently shown; false otherwise
     */
    fun isDialogCurrentlyShown(id: String): Boolean {
        val shownDialogId = getCurrentlyShownDialogId()
        return !TextUtils.isEmpty(shownDialogId) && shownDialogId == id
    }

    /**
     * Dismiss the currently shown dialog. Has no effect if no dialog is shown. Please note that
     * we always allow state loss upon dismissal.
     */
    fun dismissCurrentlyShownDialog() {
        if (mCurrentlyShownDialog != null) {
            mCurrentlyShownDialog!!.dismissAllowingStateLoss()
            mCurrentlyShownDialog = null
        }
    }

    /**
     * Show dialog and assign it a given "id". Replaces any other currently shown dialog.
     * @param dialog dialog to show
     * @param id string that uniquely identifies the dialog; can be null
     */
    fun showDialogWithId(dialog: DialogFragment, id: String?) {
        dismissCurrentlyShownDialog()
        setId(dialog, id)
        showDialog(dialog)
    }

    private fun setId(dialog: DialogFragment, id: String?) {
        val args = if (dialog.arguments != null) dialog.arguments else Bundle(1)
        args!!.putString(ARGUMENT_DIALOG_ID, id)
        dialog.arguments = args
    }

    private fun showDialog(dialog: DialogFragment) {
        mFragmentManager.beginTransaction()
                .add(dialog, DIALOG_FRAGMENT_TAG)
                .commitAllowingStateLoss()
        mCurrentlyShownDialog = dialog
    }
}