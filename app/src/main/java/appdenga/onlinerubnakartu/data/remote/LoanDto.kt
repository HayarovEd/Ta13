package appdenga.onlinerubnakartu.data.remote


import com.google.gson.annotations.SerializedName

data class LoanDto(
    @SerializedName("age")
    val age: String,
    @SerializedName("days_info")
    val daysInfo: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("percent")
    val percent: String,
    @SerializedName("sum_one")
    val sumOne: String,
    @SerializedName("url")
    val url: String
)