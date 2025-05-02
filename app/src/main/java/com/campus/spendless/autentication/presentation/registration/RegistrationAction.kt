package com.campus.spendless.autentication.presentation.registration

sealed interface RegistrationAction {
    data object OnAlreadyHaveAnAccountClicked : RegistrationAction
    data object OnNextClicked : RegistrationAction
    data class OnUsernameChanged(val username: String) : RegistrationAction
}
