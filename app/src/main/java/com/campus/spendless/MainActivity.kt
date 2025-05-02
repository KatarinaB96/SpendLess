package com.campus.spendless

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.campus.spendless.autentication.presentation.PINScreen
import com.campus.spendless.autentication.presentation.PINScreenRoot
import com.campus.spendless.autentication.presentation.registration.RegistrationScreenRoot
import com.campus.spendless.autentication.presentation.registration.RegistrationViewModel
import com.campus.spendless.core.ui.theme.SpendLessTheme
import com.campus.spendless.core.utils.Route
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpendLessTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Route.SpendLessGraph
                ) {
                    navigation<Route.SpendLessGraph>(startDestination = Route.RegistrationScreen) {
                        composable<Route.RegistrationScreen>(
                            exitTransition = { slideOutHorizontally() },
                            popEnterTransition = { slideInHorizontally() }
                        ) {
                            val viewModel = koinViewModel<RegistrationViewModel>()
                            RegistrationScreenRoot(viewModel,
                                onNextClick = {
                                    navController.navigate(Route.PinScreen)
                                })
                        }
                        composable<Route.PinScreen>(
                            exitTransition = { slideOutHorizontally() },
                            popEnterTransition = {
                                slideInHorizontally()
                            }
                        ) {
                            PINScreenRoot(
                            )
                        }
                    }
                }

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
