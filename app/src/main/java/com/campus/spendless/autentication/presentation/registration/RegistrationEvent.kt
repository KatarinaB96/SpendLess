package com.campus.spendless.autentication.presentation.registration

sealed interface RegistrationEvent {
    data object UsernameTaken: RegistrationEvent
//    data object IncorrectUsername: RegistrationEvent
    data class NavigateToPinScreen(val username:String):RegistrationEvent
    data object NavigateToLoginScreen : RegistrationEvent
}