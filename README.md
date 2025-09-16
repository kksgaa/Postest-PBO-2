# Manajemen Tiket Event Cosplay

Nama : Muhammad Fakhri Al-Kautsar

NIM  : 2409116081

Kelas: Sistem Informasi C'24 

**Deskripsi Program**

Program ini adalah aplikasi berbasis Java console untuk membantu panitia mengelola data tiket acara cosplay.
Aplikasi dibuat dengan prinsip CRUD (Create, Read, Update, Delete), menggunakan ArrayList sebagai penyimpanan data dinamis, serta dipisahkan dalam packages sesuai fungsinya (MVC sederhana).

Fitur yang tersedia:

- Menambah data tiket baru (Create)
- Melihat semua tiket (Read)
- Mengubah data tiket (Update)
- Menghapus tiket (Delete)
- Mencari tiket berdasarkan id/nama/tanggal/jenis/status (Search)
- Validasi input agar data tidak kosong dan input menu aman dari huruf

## MVC

Program ini menggunakan pola MVC (Model – View – Controller) sederhana untuk memisahkan fungsi utama aplikasi:

<img width="238" height="57" alt="image" src="https://github.com/user-attachments/assets/d13e401b-5f30-48d0-ab42-3133fd857149" />

Model berada di Ticket.java. File ini hanya mendefinisikan bentuk data tiket, yaitu id, nama, tanggal, jenis, dan status. Semua atribut dibuat private dan diakses lewat getter dan setter. Dengan cara ini, data lebih aman dan hanya bisa dimodifikasi lewat method yang disediakan.

<img width="411" height="222" alt="image" src="https://github.com/user-attachments/assets/8baf0799-b374-448d-9620-e23f8e974181" />

View adalah bagian yang ditampilkan kepada user di console. Contohnya ada di App.java saat program menampilkan menu utama atau daftar tiket. Semua System.out.println(...) yang mencetak teks ke layar termasuk ke dalam view.

<img width="240" height="49" alt="image" src="https://github.com/user-attachments/assets/4a79945d-6e8d-4a32-a21b-c6f0f52beaf5" />

Controller juga ada di App.java. Controller bertugas membaca input dari user, menentukan pilihan menu, lalu memanggil fungsi yang sesuai di service. Misalnya saat user memilih menu tambah tiket, controller akan membaca data dari keyboard dan memanggil service.add(...) untuk menyimpan tiket.

<img width="260" height="59" alt="image" src="https://github.com/user-attachments/assets/4518f881-5e8c-4459-8165-47b394b1e171" />

Service ada di TicketService.java. Service ini berisi logika utama CRUD. Ia tahu bagaimana menambah tiket baru, menampilkan daftar tiket, memperbarui data tiket, menghapus tiket, serta melakukan pencarian. Service bekerja langsung dengan model Ticket dan mengembalikan hasil ke contr#oller.

## Validasi Input

Program ini menerapkan validasi input agar lebih aman digunakan dan tidak mudah error. Validasi dilakukan di dua bagian utama:

<img width="350" height="350" alt="image" src="https://github.com/user-attachments/assets/9d10ba77-325e-45d8-8888-fdb6c25e28df" />

Validasi menu ada di App.java melalui method readInt(...). Input dari user selalu dibaca sebagai string, lalu dicoba diubah ke angka dengan Integer.parseInt(...). Jika user salah mengetik, misalnya huruf atau simbol, program tidak akan crash. Sebaliknya, program menampilkan pesan “Input harus angka. Coba lagi.” lalu meminta ulang sampai user benar-benar memasukkan angka.

<img width="450" height="450" alt="image" src="https://github.com/user-attachments/assets/36e789eb-73ba-4c45-b810-274ece78e273" />

Validasi field tiket ada di TicketService.java melalui method mustNotBlank(...). Setiap kali user menambah tiket baru, semua field seperti nama, tanggal, jenis, dan status diperiksa. Jika ada yang kosong, maka akan dilempar error dengan pesan seperti “Nama tidak boleh kosong.” atau “Jenis tiket tidak boleh kosong.” Dengan cara ini, semua tiket yang tersimpan pasti memiliki data yang lengkap.

Dengan adanya validasi ini, program tetap stabil meskipun user salah mengetik menu atau mencoba menyimpan tiket tanpa data yang lengkap.

## Fitur Search

Program ini menyediakan fitur pencarian tiket agar panitia bisa menemukan data dengan cepat tanpa harus menampilkan seluruh daftar.

<img width="380" height="350" alt="image" src="https://github.com/user-attachments/assets/f78206fc-1e27-4ffa-bb89-232dfa13dd37" />

Fitur ini diimplementasikan di TicketService.java melalui method search(String keyword). Kata kunci yang dimasukkan user akan dibandingkan dengan semua atribut tiket, yaitu id, nama, tanggal, jenis, dan status. Pencarian dilakukan dengan cara case-insensitive, sehingga huruf besar atau kecil tidak memengaruhi hasil.

Contohnya, jika user mengetikkan kata kunci vip, maka semua tiket dengan jenis VIP akan muncul. Begitu juga jika mengetik belum, program akan menampilkan semua tiket dengan status “Belum Masuk”.

<img width="450" height="451" alt="image" src="https://github.com/user-attachments/assets/05f2c0d9-6a1a-47d0-ad5c-fcce00d23704" />

Dari sisi controller, di App.java ada method doSearch(...). Method ini akan meminta user mengetik kata kunci, kemudian memanggil service.search(...), dan akhirnya menampilkan daftar tiket yang cocok. Jika tidak ada data yang sesuai, program akan menampilkan pesan “Tidak ada data yang cocok.”

Dengan fitur ini, panitia dapat lebih mudah mengelola data karena bisa langsung mencari tiket tertentu berdasarkan id, nama pembeli, tanggal beli, jenis tiket, maupun status tiket.
