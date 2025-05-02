package com.campus.spendless.autentication.presentation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.campus.spendless.autentication.domain.GetUserUseCase

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RegistrationViewModel(
   private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(RegistrationState())
    val state = _state.asStateFlow()

    private val _eventChannel = Channel<RegistrationEvent>()
    val event = _eventChannel.receiveAsFlow()

    fun onAction(action: RegistrationAction) {
        when (action) {
            RegistrationAction.OnAlreadyHaveAnAccountClicked -> navigateToLoginScreen()
            RegistrationAction.OnNextClicked -> handleNextClicked()
            is RegistrationAction.OnUsernameChanged -> updateUsername(action.username)
        }
    }

    private fun navigateToLoginScreen() {
        viewModelScope.launch {
            _eventChannel.send(RegistrationEvent.NavigateToLoginScreen)
        }
    }

    private fun updateUsername(username: String) {
        _state.update {
            it.copy(
                username = username,
                isNextEnabled = username.isNotEmpty()
            )
        }
    }

    private fun handleNextClicked() {
        viewModelScope.launch {
            val username = _state.value.username
            try {
                if (getUserUseCase.execute(username) == null) {
                    _eventChannel.send(RegistrationEvent.NavigateToPinScreen(username))
                }
            } catch (e: Exception) {
                _eventChannel.send(RegistrationEvent.UsernameTaken)
            }

        }
    }

//    private fun resetState() {
//        _state.update {
//            it.copy("", false)
//        }
//    }
}