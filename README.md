![image](https://github.com/user-attachments/assets/5026514c-0cb6-45bc-89ab-d10782b90e03)
![image](https://github.com/user-attachments/assets/88a8407a-c52e-43d8-928d-106c0586637a)
![image](https://github.com/user-attachments/assets/629fc42e-6adf-4dd3-9eb0-d3efd03abff9)

Fitur yang ditambahkan yaitu Fonts dari Google Fonts dengan cara :

Siapkan File Font

-Unduh font yang ingin Anda gunakan, misalnya my_custom_font.ttf.

-Buat Folder font di dalam res

-Masukkan File Font

-Salin file font (my_custom_font.ttf) ke folder res/font.

-lalu terapkan di jetpack compose : 
val CustomFontFamily = FontFamily(
    Font(R.font.poppins_bold, FontWeight.Normal)
)

Mmebuat Bottom Navigation memakai Row dan COlumn  : 

-horizontalAlignment = Alignment.CenterHorizontally: Menyelaraskan ikon dan teks di tengah secara horizontal.

-verticalArrangement = Arrangement.Center: Menyelaraskan ikon dan teks di tengah secara vertikal dalam Column.

-modifier = Modifier.clickable { onClick() }: Membuat item menjadi dapat diklik. Saat diklik, fungsi onClick yang diberikan akan dipanggil.

contoh : 
@Composable
fun BottomNavItem(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable { onClick() }
    ) {
        Icon(imageVector = icon, contentDescription = label)
        Text(text = label, style = MaterialTheme.typography.bodySmall)
    }
}
