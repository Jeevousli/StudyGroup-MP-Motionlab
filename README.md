git push
Mengunggah perubahan dari repository lokal ke repository remote (misalnya GitHub).

git pull
Mengambil dan menggabungkan perubahan terbaru dari repository remote ke repository lokal.

git reset
Menghapus perubahan dari staging area atau memutar ulang commit untuk kembali ke kondisi tertentu.

Membuat Branch Baru
Branch digunakan untuk mengerjakan fitur baru atau perbaikan tanpa memengaruhi branch utama.
Perintah : git branch #namabranch

Ganti Branch
Berpindah ke branch lain untuk mulai bekerja di branch tersebut.
perintah : git checkout #namabranch

git commit
Menyimpan save baru perubahan ke dalam repository lokal. Commit bersifat permanen kecuali diubah.
 
 
 Mengakses Repository dengan HTTPS
contoh : Clone Repository
Gunakan URL HTTPS untuk meng-clone repository:

- Pergi ke halaman repository GitHub.
- Klik tombol Code dan pilih HTTPS.
- jalankan perintah di terminal untuk meng-clone repository:
- Salin kode :
  git clone https://github.com/username/repository-name.git
