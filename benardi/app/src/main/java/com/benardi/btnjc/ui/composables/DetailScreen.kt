import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.benardi.btnjc.models.Laptop
import com.benardi.btnjc.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(laptop: Laptop,navController: NavController) {
    Column(


        content = {
            TopAppBar(title = {
                Text("Detail Laptop")
            },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_ack),
                            contentDescription = "Back"
                        )
                    }
                }
            )
            Surface(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    androidx.compose.foundation.Image(
                        painter = painterResource(id = laptop.imageResId),
                        contentDescription = null,
                        modifier = Modifier
                            .height(350.dp)
                            .clip(AlertDialogDefaults.shape),
                    )
                    Text(text = "Brand: ${laptop.brand}")
                    Text(text = "Model: ${laptop.model}")
                    Text(text = "Processor: ${laptop.processor}")
                    Text(text = "RAM Size: ${laptop.ramSizeGB} GB")
                    Text(text = "Storage Size: ${laptop.storageSizeGB} GB")
                }
            }
        }
    )
}
