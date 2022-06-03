import kotlinext.js.jso
import kotlin.js.Promise

fun getStores(): Promise<AxiosResponse<StoreResponse>> {
    return axios<StoreResponse>(jso {
        url = "http://localhost:9090/api/stores/"
        timeout = 3000
    })
}

data class StoreResponse (
    val storeId: Number,
    val storeName: String,
    val address: String,
    val petList: List<Pet>
)

data class Pet (
    val petId: Number,
    val name: String,
    val availablePets: Number,
    val tags: String,
    val petTypeId: Number,
    val storeId: Number
)