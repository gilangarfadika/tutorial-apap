# Tutorial APAP
git
## Authors

* **Gilang Arfadika Hanania** - *2006596951* - *A* 

## Tutorial 1
### What I have learned today
_(Masukkan pertanyaan yang diikuti jawaban di setiap nomor, contoh seperti dibawah. Anda juga boleh menambahkan catatan apapun di bagian ini)_
### GitLab
__1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?__
   Issue Tracker adalah fitur dari Gitlab yang berfungsi untuk menanggulangi dan mengatasi masalah-masalah bug dan manajemen proyek 
   yang bisa muncul pada proyek-proyek di Gitlab. Issue Tracker dapat digunakan untuk melacak,mengidentifikasi bug,error, dan masalah-masalah kode pemrograman lainnya yang muncul pada proyek Gitlab. Issue Tracker juga dapat digunakan untuk mempermudah manajemen _task_ atau penugasan yang harus dilakukan oleh tiap elemen tim proyek. 
   (https://docs.gitlab.com/ee/user/project/issues/)

__2. Apa perbedaan dari git merge dan git merge --squash?__
   Git Merge pada umumnya dilakukan untuk menyatukan sautu branch proyek dengan proyek lainnya. Git Merge --Squash juga memiliki kesamaan fungsi dengan command Git Merge. Akan tetapi, tidak seperti Git Merge yang juga menambahkan sejarah perubahan atau commit dari tiap proyek ketika kedua proyek tersebut berhasil disatukan, Git Merge --Squash menggabungkan semua sejarah perubahan atau commit dari suatu proyek menjadi satu perubahan atau commit gabungan sehingga mengurangi kompleksitas yang muncul saat menggabungkan proyek-proyek tersebut.

   _Sebagai Contoh, terdapat dua proyek yaitu proyek A dan B. jika proyek B disatukan dengan proyek A menggunakan command Git Merge maka log commmit dari proyek B juga akan disatukan dengan log dari proyek A. Akan tetapi, jika proyek B disatukan dengan proyek A menggunakan command Git Merge --Squash maka log commit  dari proyek B akan disatukan menjadi satu sejarah perubahan atau commit gabungan dengan log commit dari proyek A_
   
   (https://levelup.gitconnected.com/do-you-know-how-to-use-git-merge-squash-7d96c1191fd5)

   
__3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?__
 Version Control merupakan fitur dari Gitlab yang berfungsi untuk mempermudah pengaturan dan perekaman tiap sejarah perubahan yang terjadi pada satu proyek. fungsi dari Version Control ini dapat digunakan oleh elemen tim proyek untuk mendapatkan informasi yang relevan terkait sejarah perubahan dan perkembangan yang terjadi di dalam suatu proyek Gitlab. Version Control juga dapat digunakan untuk mempermudah kolaborasi antara tiap elemen tim proyek dalam mengembangkan proyek. Selain itu, fungsionalitas dari Version Control dapat dimanafaatkan untuk melakukan pengembangan proyek secara bercabang atau paralel yang dapat keleluasaan kepada tim proyek untuk bereksperimen secara independen tanpa mempengaruhi sistem proyek utama yang sedang dibuat.   

 (https://www.atlassian.com/git/tutorials/what-is-version-control#:~:text=non%2Dsoftware%20projects.-,Benefits%20of%20version%20control%20systems,scales%20to%20include%20more%20developers)


### Spring
4. Apa itu library & dependency?
Library adalah kompilasi kode-kode pemrograman berupa _class object, functions_,dll  yang telah disediakan oleh Spring. Library pada umumnya digunakan untuk mengurangi tingkat kompleksitas pemrograman yang dihadapi  para pengguna spring dengan menyediakan kode-kode pemrograman yang _reuseable_ . Lmeningkatkan modularitas dari kode-kode pemrograman yang banyak digunakan oleh para pengguna Spring. Sebagai _framework_ dari Java, Spring menyediakan beberapa library yang dapat digunakan dalam pengembangan aplikasi seperti Spring MVC, Spring Data,Simple Flat Mapper,dll.

Dependensi adalah komponen-komponen eksternal atau komponen-komponen pihak ketiga yang dibutuhkan agar suatu kode pemrograman atau aplikasi dapat berjalan dengan lancar. Dependensi-dependensi yang digunakan oleh suatu aplikasi dapat berupa komponen-komponen pihak ketiga tertentu seperti framework,library,package,dll. Di dalam Spring, 

(https://happycoding.io/tutorials/java/libraries)
(https://www.educba.com/spring-boot-dependencies/#:~:text=As%20we%20know%20that%20spring%20boot%20dependency%20used%20to%20provide%20support%20to%20the%20application%2C%20we%20have%20a%20basic%20syntax%20for%20this%20which%20can%20be%20followed%20according%20to%20the%20build%20tool.%20we%20are%20using%20here%20one%20maven%20pom.xml%20file.%20how%20we%20can%20define%20dependencies%20there%20for%20beginners%20to%20understand%20see%20below%3B)

5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
maven adalah _open-souce build tool or software_ yang dipublikasi oleh perusahaan Apache Group untuk membantu para pengembang aplikasi dalam membuat,mempublikasi, dan men-_deploy_ beberapa proyek aplikasi berbahasa Java. Dengan Maven, para pengembang aplikasi dapat mengatur manajemen proyek dengan lebih baik serta mempermudah pembangunan dan pengdokumentasian _lifecycle framework_ dari proyek tersebut. Selain Maven, para pengguna Spring juga dapat menggunakan _build automation software_ lainnya seperti GCC, Gradle, Grunt,PackageCloud,dll. 

(https://www.simplilearn.com/tutorials/maven-tutorial/what-is-maven#:~:text=Maven%20is%20a%20popular%20open%2Dsource%20build%20tool%20developed%20by%20the%20Apache%20Group%20to%20build%2C%20publish%2C%20and%20deploy%20several%20projects%20at%20once%20for%20better%20project%20management.%20The%20tool%20provides%20allows%20developers%20to%20build%20and%20document%20the%20lifecycle%20framework.%C2%A0)

(https://blog.packagecloud.io/what-is-maven-and-maven-alternatives/)

6. Jelaskan bagaimana alur ketika kita menjalankan http://localhost:8080/celsius-converter/90 sampai dengan muncul keluarannya di browser!
- Link dari alamat http tersebut akan diterima oleh Controller dari aplikasi celsiusConverter melalui fungsi celsiusConverterWithPathVariable dan ditembak ke fungsi getCelsiusConverterPage untuk dianalisis apakah masukan _http request_ sesuai dengan ketentuan aplikasi celsiusConverter. Jika _http request_ ditolak maka Controller akan mengirimkan pesan permintaan untuk memasukan input angka yang benar ke View dari aplikasi celsiusConverter. Jika _http request_ diterima, maka Controller akan memanggil model dari aplikasi celsiusConverter untuk menghitung suhu fahrenheit,kelvin,dll dan mengirimkan hasil-hasil konversi suhu tersebut pada View dari aplikasi celsiusConverter. Controller akan mengirimkan balasan atas _http request_ ke template view bernama celsiusConverterPage.html di mana template view tersebut akan ditampilkan pada web browser pengirim dari _http request_ tersebut.

(https://www.javatpoint.com/spring-mvc-tutorial#:~:text=Model%20%2D%20A%20model,Spring%20MVC%20application.)




7. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
framework Spring dapat digunakan untuk membuat aplikasi enterprise dan aplikasi yang berfokus pada pengolahan data seperti Big Data.
(Sumber: https://socs.binus.ac.id/2017/10/04/framework-spring-java/#:~:text=Dengan%20menggunakan%20Spring%20Framework%2C%20developer,dapa%20tberjalan%20pada%20JVM%20manapun.)

8. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?

@RequestParam pada umumnya bekerja dengan memasukkan nilai/kunci ke dalam string query dan ter-_encode_ .
@PathVariable pada umumnya bekerja dengan membuat suatu pola tertentu dalam path URI lalu mengambil nilai dan memasukannya ke dalam path URI. Berbeda dengan @RequestParam, PathVariable tidak ter-_encode_.


RequestParam lebih baik digunakan dalam pengaplikasian web tradisional dimana data lebih banyak dikirimkan dala parameter query, sedangkan PathVariable lebih tepat digunakan pada web yang menerapkan arsitektur REST karena menggunakan URL.
https://www.baeldung.com/spring-requestparam-vs-pathvariable
https://stackoverflow.com/questions/13715811/requestparam-vs-pathvariable#:~:text=2)%20%40RequestParam%20is%20more%20useful,services%20where%20URL%20contains%20values.

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat mencentang apabila Anda sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya harus belajar APAP? 
- [x] Kenapa?
   Karena …

Saya masih kurang mengerti dari bagaimana alur cari Controller,View, dan Model bekerja. 

(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu lebih dalam tentang penulisan README.md di GitLab pada link [berikut](https://help.github.com/en/articles/basic-writing-and-formatting-syntax)) 

