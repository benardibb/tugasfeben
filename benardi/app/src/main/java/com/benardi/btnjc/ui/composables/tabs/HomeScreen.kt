package com.benardi.btnjc.ui.composables.tabs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.benardi.btnjc.R
import com.benardi.btnjc.models.Laptop
import com.benardi.btnjc.ui.composables.MainDestinations

/**
 * Composable function that represents the home screen of the application.
 */

//val itemList = List(100) { index -> "Item ${index + 1}" }

val itemList = listOf(
    Laptop(
        brand = "Apple",
        model = "MacBook Air M2",
        processor = "Apple M2 Chip, CPU 8-Core and GPU 8-Core",
        ramSizeGB = 8,
        storageSizeGB = 256,
        screenSizeInches = 13.6,
        priceUSD = 0.0,
        imageResId = R.drawable.macbook_m2
    ),
    Laptop(
        brand = "Dell",
        model = "XPS 13 93155",
        processor = "Intel Core i7-10750H",
        ramSizeGB = 8,
        storageSizeGB = 512,
        screenSizeInches = 13.6,
        priceUSD = 0.0,
        imageResId = R.drawable.dell_xps_13
    ),
    Laptop(
        brand = "HP",
        model = "Dragonfly Pro Chromebook",
        processor = "Intel Core i5-1235U, 10-Core up to 4.4 GHz",
        ramSizeGB = 16,
        storageSizeGB = 256,
        screenSizeInches = 14.6,
        priceUSD = 1499.99,
        imageResId = R.drawable.hp_dragonfly
    ),
    Laptop(
        brand = "Apple",
        model = "MacBook Pro M2 2023",
        processor = "Apple M2 Chip, CPU 8-Core and GPU 8-Core",
        ramSizeGB = 8,
        storageSizeGB = 256,
        screenSizeInches = 16.2,
        priceUSD = 1499.99,
        imageResId = R.drawable.macbook_pro_m2
    ),
    Laptop(
        brand = "Acer",
        model = "Aspire 5 A514",
        processor = "Intel Core i5-1335U, 10-Core up to 4.6 GHz",
        ramSizeGB = 8,
        storageSizeGB = 512,
        screenSizeInches = 14.0,
        priceUSD = 1499.99,
        imageResId = R.drawable.acer_aspire
    ),
    Laptop(
        brand = "Asus",
        model = "ROG Strix G15",
        processor = "Intel Core i7-10750H",
        ramSizeGB = 16,
        storageSizeGB = 512,
        screenSizeInches = 15.6,
        priceUSD = 1499.99,
        imageResId = R.drawable.acer_3
    ),
    Laptop(
        brand = "Lenovo",
        model = "Yoga 9i",
        processor = "Intel Core i7-1195G7, Quad Core up to 5.0 GHz",
        ramSizeGB = 16,
        storageSizeGB = 1000,
        screenSizeInches = 14.0,
        priceUSD = 1499.99,
        imageResId = R.drawable.lenovo_yoga
    ),
    Laptop(
        brand = "Dell",
        model = "Alienware m18",
        processor = "Intel Core i9-13900HX, 24-Core up to 5.40 GHz",
        ramSizeGB = 32,
        storageSizeGB = 1000,
        screenSizeInches = 18.0,
        priceUSD = 1499.99,
        imageResId = R.drawable.dell_m18
    ),
    Laptop(
        brand = "Dell",
        model = "Gaming G15 5520",
        processor = "Intel Core i5-12500H, 12-Core up to 4.50 GHz",
        ramSizeGB = 16,
        storageSizeGB = 1000,
        screenSizeInches = 15.6,
        priceUSD = 1499.99,
        imageResId = R.drawable.dell_g15
    ),
    Laptop(
        brand = "Acer",
        model = "Swift 3 SF314",
        processor = "Intel Core i5-1240P, 12-Core up to 4.40 GHz",
        ramSizeGB = 16,
        storageSizeGB = 512,
        screenSizeInches = 14.0,
        priceUSD = 1499.99,
        imageResId = R.drawable.acer_3
    )

)

@Composable
fun getText(title: String){
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "$title")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    Column {
        CenterAlignedTopAppBar(title = {

            Text(stringResource(id = R.string.home))

        },
            actions = {
                IconButton(onClick = {
                    navController.navigate(MainDestinations.ABOUT_ROUTE)
                }) {
                    Icon(Icons.Filled.Person, contentDescription = null)
                }
            }

        )
        Text(text = "Lazy Row")

        LazyRow {
            items(itemList) { item ->
                Card(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable {
//                            Toast
//                                .makeText(context, "tess", Toast.LENGTH_SHORT)
//                                .show()
                            navController.navigate(
                                "${MainDestinations.DETAIL_ROUTE}/" +
                                        "${item.brand}/" +
                                        "${item.model}/" +
                                        "${item.processor}/" +
                                        "${item.ramSizeGB}/" +
                                        "${item.storageSizeGB}/" +
                                        "${item.screenSizeInches}/" +
                                        "${item.priceUSD}/" +
                                        "${item.imageResId}"
                            )
                        },
                    ){
                    androidx.compose.foundation.Image(
                        painter = painterResource(id = item.imageResId),
                        contentDescription = null,
                        modifier = Modifier
                            .height(120.dp)
                            .fillMaxWidth()
                            .clip(shape),
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = item.model,
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Black
                    )
                }
            }
        }
        Text(text = "Lazy Column")
        LazyColumn {
            items(itemList) { item ->
                Card(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(
                                "${MainDestinations.DETAIL_ROUTE}/" +
                                        "${item.brand}/" +
                                        "${item.model}/" +
                                        "${item.processor}/" +
                                        "${item.ramSizeGB}/" +
                                        "${item.storageSizeGB}/" +
                                        "${item.screenSizeInches}/" +
                                        "${item.priceUSD}/" +
                                        "${item.imageResId}"
                            )
                        },
                ){
                    androidx.compose.foundation.Image(
                        painter = painterResource(id = item.imageResId),
                        contentDescription = null,
                        modifier = Modifier
                            .height(120.dp)
                            .fillMaxWidth()
                            .clip(shape),
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = item.model,
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Black
                    )
                }
            }
        }

    }


}