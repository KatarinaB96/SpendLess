package com.campus.spendless.autentication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.campus.spendless.R
import com.campus.spendless.ui.theme.OnPrimaryFixed
import com.campus.spendless.ui.theme.PrimaryFixed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PINScreen(
    title: String,
    description: String,
    onNumberClick: (Int) -> Unit,
    onDeleteClick: () -> Unit
) {
    Scaffold(modifier = Modifier.padding(top = 36.dp), topBar = {
        CenterAlignedTopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_back),
                        modifier = Modifier.padding(8.dp),
                        tint = MaterialTheme.colorScheme.onSurface,
                        contentDescription = stringResource(R.string.back),
                    )
                }
            }
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.icon_spendless),
                contentDescription = stringResource(R.string.icon_spendLess),
            )
            Spacer(Modifier.height(20.dp))
            Text(
                style = MaterialTheme.typography.headlineMedium,
                text = title,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(Modifier.height(8.dp))
            Text(
                style = MaterialTheme.typography.bodyMedium,
                text = description,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)
            ) {
                val unselectedColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.12f)
                val selectedColor = MaterialTheme.colorScheme.primary
                repeat(5) { index ->
                    Box(
                        modifier = Modifier
                            .size(18.dp)
                            .clip(CircleShape)
                            .background(if (index == 0) selectedColor else unselectedColor)
                    )
                }
            }
            Spacer(Modifier.height(32.dp))
            Numbers()
        }
    }
}

@Composable
fun Numbers() {
    Column(
        modifier = Modifier.widthIn(max = 400.dp)
            .padding(horizontal = 40.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        repeat(3) { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally)
            ) {
                repeat(3) { column ->
                    val number = row * 3 + column + 1
                    FilledTonalButton(
                        modifier = Modifier.size(88.dp),
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryFixed),
                        shape = RoundedCornerShape(32.dp)
                    ) {
                        Text(
                            text = number.toString(),
                            color = OnPrimaryFixed,
                            style = MaterialTheme.typography.headlineLarge
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally)
        ) {
            Box(
                modifier = Modifier.size(88.dp),
                contentAlignment = Alignment.Center
            ) {

            }
            FilledTonalButton(
                onClick = { },
                modifier = Modifier.size(88.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryFixed),
                shape = RoundedCornerShape(32.dp)
            ) {
                Text(
                    text = "0",
                    color = OnPrimaryFixed,
                    style = MaterialTheme.typography.headlineLarge
                )
            }

            FilledTonalButton(
                onClick = { },
                modifier = Modifier.size(88.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryFixed.copy(alpha = 0.3f)),
                shape = RoundedCornerShape(32.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_delete),
                    contentDescription = stringResource(R.string.delete),
                    tint = OnPrimaryFixed
                )
            }
        }
    }
}

@Preview
@Composable
fun NumbersPreview() {
    Numbers()
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFF2)
@Composable
fun PINScreenPreview() {
    PINScreen("Create PIN", "Enter your PIN again", {}, {})
}