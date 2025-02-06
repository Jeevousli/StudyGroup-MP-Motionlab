![image](https://github.com/user-attachments/assets/7ccef908-88e7-4a64-b1e2-bee15cf778e9)
![image](https://github.com/user-attachments/assets/e887670d-52c5-453c-94c4-c4669e3f9a28)
![image](https://github.com/user-attachments/assets/c3add23e-f21f-48c2-a15e-ecc15ed41efe)

Fitur :
Tambah Favorite: Memungkinkan pengguna untuk menyimpan data ke daftar Favorite.
Lihat Favorite: Menampilkan daftar Favorite yang telah disimpan.
Hapus Favorite: Memungkinkan pengguna untuk menghapus data dari daftar Favorite.


Jika user teken tanda Love di samping kanan atas maka akan menampilkna daftar favorite.

Implememtasi Room
![image](https://github.com/user-attachments/assets/c1edbd2d-bcca-4e38-a2a1-7f3926986f8c)
`FavoriteDao` adalah interface DAO (Data Access Object) di Room Database yang mengelola operasi pada tabel **favorites**. Menggunakan **@Insert** dengan `OnConflictStrategy.REPLACE`, metode `addFavorite` menambahkan atau menggantikan data favorit yang sudah ada. Metode `deleteFavorite` menggunakan **@Delete** untuk menghapus entri favorit tertentu.
Sementara itu, `getAllFavorites` dengan **@Query** mengembalikan daftar favorit dalam bentuk `Flow<List<FavoriteEntity>>`, memungkinkan pemantauan perubahan data secara real-time menggunakan Kotlin Coroutines.

![image](https://github.com/user-attachments/assets/62b3c6ae-d08e-4dbb-a48f-2d4eb6a7470f)
`Room.databaseBuilder(...)` digunakan untuk membangun database dengan nama `"favorite_database"`. Setelah dibuat, instance tersebut disimpan ke dalam variabel `INSTANCE`, sehingga tidak perlu membuat ulang setiap kali database diakses.

![image](https://github.com/user-attachments/assets/fde5b34f-a866-47d9-9ed5-2682c0c3933f)
