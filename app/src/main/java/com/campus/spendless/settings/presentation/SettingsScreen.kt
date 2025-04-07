package com.campus.spendless.settings.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.campus.spendless.ui.theme.SpendLessTheme

@Composable

fun SettingsScreenRoot(

   // viewModel: SettingsViewModel = org.koin.androidx.compose.koinViewModel()

) {

    SettingsScreenRootScreen(

     //   state = viewModel.state,

       // onAction = viewModel::onAction

    )

}

@Composable

private fun SettingsScreenRootScreen(

  //  state: SettingsState,

    //onAction: (SettingsAction) -> Unit

) {



}

@Preview

@Composable

private fun SettingsScreenRootScreenPreview() {

    SpendLessTheme {

        SettingsScreenRootScreen(

        //    state = SettingsState(),

          //  onAction = {}

        )

    }

}