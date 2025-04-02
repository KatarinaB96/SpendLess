package com.campus.spendless

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.campus.spendless.autentication.presentation.LoginPINErrorScreen
import com.campus.spendless.autentication.presentation.PINScreen
import com.campus.spendless.autentication.presentation.RegistrationScreen
import com.campus.spendless.ui.theme.SpendLessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpendLessTheme {
                LoginPINErrorScreen("Katarina", "Nono", {}, {}, {}, {}, true)
//                RegistrationScreen()
//                CreatePINScreen({}) { }
            }
        }
    }
}

@Composable
fun CreatePINScreen(onNumberClick: (Int) -> Unit, onDeleteClick: () -> Unit) {
    PINScreen(
        title = stringResource(R.string.create_pin),
        description = stringResource(R.string.use_pin_to_login_to_your_account),
        onNumberClick = onNumberClick,
        onDeleteClick = onDeleteClick
    )
}

@Composable
fun RepeatPINScreen(onNumberClick: (Int) -> Unit, onDeleteClick: () -> Unit) {
    PINScreen(
        title = stringResource(R.string.repeat_your_pin),
        description = stringResource(R.string.enter_your_pin_again),
        onNumberClick = onNumberClick,
        onDeleteClick = onDeleteClick
    )
}

//@Composable
//fun LoginPINScreen(onNumberClick: (Int) -> Unit, onDeleteClick: () -> Unit) {
//    PINScreen(
//        title = stringResource(R.string.repeat_your_pin),
//        description = stringResource(R.string.enter_your_pin_again),
//        onNumberClick = onNumberClick,
//        onDeleteClick = onDeleteClick
//    )
//}
