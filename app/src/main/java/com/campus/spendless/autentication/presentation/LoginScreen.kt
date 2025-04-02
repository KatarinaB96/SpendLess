package com.campus.spendless.autentication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.campus.spendless.R

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 36.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.icon_spendless),
            contentDescription = stringResource(R.string.icon_spendLess),
        )
        Spacer(Modifier.height(20.dp))
        Text(
            style = MaterialTheme.typography.headlineMedium,
            text = stringResource(R.string.welcome_back),
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(8.dp))

        Text(
            style = MaterialTheme.typography.bodyMedium,
            text = stringResource(R.string.enter_you_login_details),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(Modifier.height(36.dp))

        LoginInputField(
            stringResource(R.string.username_login), stringResource(R.string.username_login), isPassword = false,
            onValueChange = {}
        )
        Spacer(Modifier.height(16.dp))
        LoginInputField(stringResource(R.string.pin), stringResource(R.string.pin), isPassword = true, onValueChange = {})
        Spacer(Modifier.height(24.dp))

        FilledTonalButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Log in",
                    style = MaterialTheme.typography.titleMedium
                        .copy(color = MaterialTheme.colorScheme.onPrimary)
                )
            }
        }
        Spacer(Modifier.height(28.dp))
        Text(
            style = MaterialTheme.typography.titleMedium,
            text = stringResource(R.string.new_to_spendless),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun LoginInputField(
    text: String,
    hint: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false,
) {
    OutlinedTextField(
        value = "",
        onValueChange = onValueChange,
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            color = MaterialTheme.colorScheme.onSurface,
        ),
        placeholder = {
            Text(
                text = hint,
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant),
            )
        },
        visualTransformation = if (isPassword) PasswordVisualTransformation()
        else VisualTransformation.None, // Mask input if isPassword is true
        keyboardOptions = if (isPassword) {
            KeyboardOptions(keyboardType = KeyboardType.NumberPassword)
        } else {
            KeyboardOptions.Default
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(48.dp),
        shape = RoundedCornerShape(16.dp)
    )
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFF5)
fun LoginScreenPreview() {
    LoginScreen()
}
