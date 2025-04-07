@file:OptIn(ExperimentalMaterial3Api::class)

package com.campus.spendless.settings.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.campus.spendless.R
import com.campus.spendless.ui.theme.SpendLessTheme

@Composable
fun SettingsScreenRoot(

    // viewModel: SettingsViewModel = org.koin.androidx.compose.koinViewModel()

) {

    SettingsScreen(

        //   state = viewModel.state,

        // onAction = viewModel::onAction

    )

}

@Composable

private fun SettingsScreen(

    //  state: SettingsState,

    //onAction: (SettingsAction) -> Unit

) {

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                navigationIcon = {

                },
                title = { Text(stringResource(R.string.settings)) }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            SettingsItemsCard(
                content = {
                    Column {
                        SettingsItemRow(
                            title = stringResource(R.string.preferences),
                            icon = {
                                Icon(
                                    Icons.Default.Settings,
                                    contentDescription = stringResource(R.string.preferences)

                                )
                            }
                        )

                        SettingsItemRow(
                            title = stringResource(R.string.security),
                            icon = {
                                Icon(
                                    Icons.Default.Lock,
                                    contentDescription = stringResource(R.string.security)

                                )
                            }
                        )

                    }
                })
            Spacer(modifier = Modifier.height(8.dp))
            SettingsItemsCard(
                content = {
                    SettingsItemRow(
                        title = stringResource(R.string.logout),
                        icon = {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = stringResource(R.string.logout)

                            )
                        }
                    )
                }
            )
        }
    }
}


@Composable
fun SettingsItemsCard(content: @Composable () -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
    ) {
        content()
    }
}

@Composable
private fun SettingsItemRow(
    title: String,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.height(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Text(
            text = title,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview

@Composable

private fun SettingsScreenRootPreview() {

    SpendLessTheme {

        SettingsScreen(

            //    state = SettingsState(),

            //  onAction = {}

        )

    }

}