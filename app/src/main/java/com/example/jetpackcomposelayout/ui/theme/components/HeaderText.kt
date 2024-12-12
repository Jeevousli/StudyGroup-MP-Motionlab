import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposelayout.ui.theme.CustomFontFamily

@Composable
fun HeaderText(
    text: String,
    imageResId: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        // Teks
        Text(
            text = text,
            style = TextStyle(
                fontFamily = CustomFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.displayMedium.fontSize
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Gambar
        val image: Painter = painterResource(id = imageResId)
        Image(
            painter = image,
            contentDescription = "Header Image",
            modifier = Modifier.size(100.dp)
        )
    }
}

