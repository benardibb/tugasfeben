package com.benardi.btnjc.ui.composables.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.benardi.btnjc.R

/**
 * Composable function that represents the profile screen of the application.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {

    Column {
        TopAppBar(title = {
            Text(stringResource(id = R.string.profile))
        })
        androidx.compose.foundation.Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = null,
            modifier = Modifier
                .height(350.dp)
                .clip(AlertDialogDefaults.shape),
        )
        Text(text = "Nama: Benardi Denoprio ")
        Text(text = "Email: benardidenopriobb@gmail.com")
        Text(text = "Asal Perguruan Tinggi: Universitas Brawijaya")
        Text(text = "Jurusan: sistem informasi")
    }
}