package app.medrx.MedrxApp.retrofit



import cz.utb.fai.opennews.model.News
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    /*
    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("auth/signup")
    fun register(
        @Field("username")username: String,
        @Field("email")email: String,
        @Field("phone_number")phone_number: String,
        @Field("password")password: String,
        @Field("password_confirmation")password_confirmation: String
    ) : Call<User>


    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("auth/activate")
    fun activate(
        @Header("Authorization")token: String,
        @Field("code")code: String,
        @Field("phone")phone: String
    ) : Call<OtpToken>


    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("auth/signin")
    fun login(
                    @Field("loginField")loginField: String,
                    @Field("password")password: String,
                    @Field("token")token: String,
                    @Field("device_id")device_id: String,
                    @Field("device_type")device_type: String
    ) : Call<ServicesSetterGetter>
    */

    @Headers(
        "Accept: application/json",
    )
    @GET("news?category=science")
    fun news():Call<News>


    /*
    @Headers(
        "Accept: application/json",
    )

    @GET("v1/unit/jaguar_warrior")
    fun uniqueUnit():Call<UnitModel>
    */


    /*
    @Headers(
        "Accept: application/json",
    )
    @GET("order-details/{id}")
    fun orderdetails(
        @Header("Authorization") token: String?,
        @Path("id") id: String
    ):Call<OrderDetails>


    @Headers(
        "Accept: application/json",
    )
    @GET("prescriptions")
    fun prescriptions(@Header("Authorization") token:String?):Call<Prescription>


    @Headers(
        "Accept: application/json",
    )
    @GET("pharmacy/all")
    fun pharmacies(@Header("Authorization") token:String?):Call<Pharmacy>


    @Headers(
        "Accept: application/json",
    )
    @Multipart
    @POST("upload-prescription")
    fun  uploadPrescription(
        @Header("Authorization") token: String?,
        @Part file: MultipartBody.Part,
        @Part("latitude") latitude: RequestBody,
        @Part("longitude") longitude: RequestBody,
        @Part("location") location: RequestBody
    ):Call<UploadResponse>



    @Headers(
        "Accept: application/json",
    )
    @GET("pharmacy/{id}")
    fun getPharmaciesFromProduct(
        @Header("Authorization") token: String?,
        @Path("id") id: String
    ):Call<ProductPharmacies>


    @Headers(
        "Accept: application/json",
    )
    @GET("notifications")
    fun getNotifications(@Header("Authorization") token:String?):Call<Notification>



    @Headers(
        "Accept: application/json",
    )
    @GET("pharmacy-products/{id}")
    fun getPharmacyProducts(
        @Header("Authorization") token: String?,
        @Path("id") id: String
    ):Call<PharmacyDrugObject>


    @Headers(
        "Accept: application/json"
    )
    @GET("category/{id}")
    fun getProductByCategory(
        @Header("Authorization") token: String?,
        @Path("id") id: String
    ):Call<ProductCategory>


    @Headers(
        "Accept: application/json"
    )
    @GET("auth/user")
    fun getUserProfile(
        @Header("Authorization") token: String?,
        @Query("token") fcm_token:String,
        @Query("device_id") device_id:String,
        @Query("device_type") device_type:String
    ):Call<UserX>

    */

}
