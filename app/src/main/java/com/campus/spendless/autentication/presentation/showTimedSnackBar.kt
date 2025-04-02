package com.campus.spendless.autentication.presentation

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun CoroutineScope.showTimedSnackBar(
    snackBarHostState: SnackbarHostState,
    message: String,
    durationMillis: Long = 2000
) {
    launch {
        snackBarHostState.currentSnackbarData?.dismiss()
        val job = launch {
            snackBarHostState.showSnackbar(
                message = message,
                duration = SnackbarDuration.Indefinite
            )
        }
        delay(durationMillis)
        job.cancel()
        snackBarHostState.currentSnackbarData?.dismiss()
    }
}