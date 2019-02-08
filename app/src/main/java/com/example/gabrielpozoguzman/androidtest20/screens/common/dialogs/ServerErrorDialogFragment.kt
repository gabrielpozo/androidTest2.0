package com.example.gabrielpozoguzman.androidtest20.screens.common.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import com.example.gabrielpozoguzman.androidtest20.R

class ServerErrorDialogFragment : DialogFragment() {
    interface Listener {
        fun onRetryDialogRequest()
    }

    companion object {
        fun newInstance(): ServerErrorDialogFragment {
            return ServerErrorDialogFragment()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialogBuilder = AlertDialog.Builder(activity)

        alertDialogBuilder.setTitle(R.string.server_error_dialog_title)
        alertDialogBuilder.setMessage(R.string.server_error_dialog_message)
        alertDialogBuilder.setPositiveButton(
                R.string.server_error_dialog_button_caption
        ) { _, _
            ->
            dismiss()
        }

        return alertDialogBuilder.create()

    }
}