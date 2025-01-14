![image](https://github.com/user-attachments/assets/0ddacdbf-f913-4f35-b1f8-c5e8a85a97d0)![image](https://github.com/user-attachments/assets/16297bed-1df7-4215-9a9e-7316cac59b54)
![image](https://github.com/user-attachments/assets/92d8d04e-b06b-49db-b840-306934097bd8)
![image](https://github.com/user-attachments/assets/57d53dfd-3d4e-4740-a240-e16bcad55ad1)
![image](https://github.com/user-attachments/assets/de3dac96-2c6a-42a2-9281-a28fe62b5875)
Penjelasan:
1. NavHost:
   - Mengelola navigasi dengan mendefinisikan layar awal (`Route.Login.name`) dan rute lainnya.
   - Output: Berpindah antar layar secara dinamis berdasarkan aksi navigasi.
   `composable:
   - Mewakili satu layar dalam aplikasi.
   - Contoh: `LoginScreen`, `SignUpScreen`.
   - Output: Menampilkan UI yang sesuai dan menangani aksi navigasi.
3. navController.navigate:
   - Menavigasi ke layar yang ditentukan.
   - Contoh: `navController.navigate(Route.Home.name)` berpindah ke layar `Home`.
4. popUpTo`:
   - Menghapus stack navigasi hingga rute yang ditentukan.
   - Contoh: Menghapus `Login` dari stack setelah berpindah ke `Home`.
5. launchSingleTop:
   - Memastikan hanya satu instance dari layar target yang ada di stack.
   - Output: Mencegah duplikasi layar saat berpindah berulang kali.
  ![image](https://github.com/user-attachments/assets/46dcd2bc-d7d8-4013-8f02-3c82137e26d1)
![image](https://github.com/user-attachments/assets/32a6ca3f-6040-419f-bda2-861853cc657f)

- Cara mendefinisikan route
 Gunakan kelas sealed untuk mengelola rute:
- Mendefinisikan rute (atau layar) dalam aplikasi, masing-masing dengan nama unik.
- Output: Organisasi yang jelas dan referensi mudah ke rute di seluruh aplikasi.
- ![image](https://github.com/user-attachments/assets/fd561d8b-f038-4a4a-8eee-166bf74380a2)

