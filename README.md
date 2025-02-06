![image](https://github.com/user-attachments/assets/55e02b3e-b628-4a62-b5e7-c8a8025ec067)![image](https://github.com/user-attachments/assets/adb0631f-3117-4001-8b67-324c8fee54d1)
![image](https://github.com/user-attachments/assets/c57af55e-7ab4-4f67-9e36-69fef86ac4b3)

Download Json To Kotlin
![image](https://github.com/user-attachments/assets/56c44f41-1592-4495-a31c-390fe450c3b1)

Disini saya menggunakan Weather Api dari WeatherApi.com

1. Menggunakan API
interface WeatherApi {


    @GET("/v1/current.json")
    suspend fun getWeather(
        @Query("key") apikey : String,
        @Query("q") city : String
    ) : Response<WeatherModel>

}
Kode ini digunakan dalam aplikasi Android untuk mengambil data cuaca menggunakan Retrofit, di mana aplikasi akan mengirim permintaan ke API cuaca dengan API key dan nama kota, lalu mendapatkan respons berupa WeatherModel. 

2. Permintaan ke API
   object RetrofitInstance {

    private const val baseUrl = "https://api.weatherapi.com";


    private fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val weatherApi : WeatherApi = getInstance().create(WeatherApi::class.java)

}
Kode ini membuat singleton RetrofitInstance yang berfungsi sebagai client Retrofit untuk melakukan permintaan API ke Weather API. Dengan ini, kita bisa langsung menggunakan RetrofitInstance.weatherApi.getWeather(...) di mana saja tanpa harus membuat ulang instance Retrofit.

3. Pengambilan data secara asinkron
   fun getData(city : String){
        _weatherResult.value = NetworkResponse.Loading
        viewModelScope.launch {
            try{
                val response = weatherApi.getWeather(Constant.apiKey,city)
                if(response.isSuccessful){
                    response.body()?.let {
                        _weatherResult.value = NetworkResponse.Success(it)
                    }
                }else{
                    _weatherResult.value = NetworkResponse.Error("Failed to load data")
                }
            }
            catch (e : Exception){
                _weatherResult.value = NetworkResponse.Error("Failed to load data")
            }

        }
    }
Fungsi `getData(city: String)` digunakan untuk mengambil data cuaca dari API secara asinkron dalam **ViewModel** menggunakan **coroutines**. Saat fungsi dipanggil, status awal diatur menjadi **"Loading"** untuk memberi indikasi bahwa proses pengambilan data sedang berlangsung.
Kemudian, permintaan API dilakukan melalui `weatherApi.getWeather(...)`, dengan menyertakan **API key** dan nama kota yang diminta. Jika respons dari API berhasil (`isSuccessful`), data cuaca yang diterima akan disimpan dalam **_weatherResult** dengan status **"Success"**.
Namun, jika respons gagal atau terjadi kesalahan saat request, status akan diubah menjadi **"Error"** dengan pesan **"Failed to load data"**. Dengan adanya **try-catch**, fungsi ini juga menangani error agar aplikasi tidak crash jika terjadi gangguan jaringan atau kesalahan lainnya. Hal ini memastikan pengambilan data dilakukan dengan aman, efisien, dan memberikan feedback yang jelas kepada pengguna. 🚀
