package com.example.gabrielpozoguzman.androidtest20.utils.extensions

import com.example.gabrielpozoguzman.androidtest20.categories.CategoryBook
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

private var job: Job = Job()
 val coroutineContext: CoroutineContext
    get() = Dispatchers.Main + job
lateinit var client: Deferred<Response<List<CategoryBook>>>

/***
fun getCategorieBooks() = networkCall<List<CategoryBook>, InfoResponse<CategoryBookInfoResponse, List<CategoryBook>>> {
client = mobgenApi.getCategoryListBook()
infoResponse = CategoryBookInfoResponse()
}

fun fetchCategoriesDetailsAndNotify(): LiveData<CategoryBookInfoResponse> {

val result = MutableLiveData<CategoryBookInfoResponse>()

try {
launch {
val postListResponse = mobgenApi.getCategoryListBook().awaitResult().getOrThrow()
Log.d("Gabriel", "after the call!, ${postListResponse[1].name}]")
result.value = CategoryBookInfoResponse(Status.SUCCESS, postListResponse)
}
} catch (e: HttpException) {
result.value = CategoryBookInfoResponse(Status.ERROR_EXCEPTION)
} catch (e: Throwable) {
result.value = CategoryBookInfoResponse(Status.ERROR_EXCEPTION)
}
return result

}
}
fun <RESPONSE : Any, DATA : InfoResponse<*, RESPONSE>> networkCall(block: CallHandler<RESPONSE, DATA>.() -> Unit):
MutableLiveData<DATA> {

return CallHandler<RESPONSE, DATA>().apply(block).makeCall()
}

class CallHandler<RESPONSE : Any, DATA : Any> : CoroutineScope {
private var job: Job = Job()
override val coroutineContext: CoroutineContext
get() = job + Dispatchers.Main

lateinit var client: Call<RESPONSE>
lateinit var infoResponse: DATA

fun makeCall(): MutableLiveData<DATA> {
val result = MutableLiveData<DATA>()
launch {
try {
val postListResponse = client.awaitResult().getOrThrow()
(infoResponse as InfoResponse<*, *>).status = Status.SUCCESS
(infoResponse as InfoResponse<*, RESPONSE>).successType = postListResponse
result.value = infoResponse

} catch (e: HttpException) {
(infoResponse as InfoResponse<*, *>).status = Status.ERROR
result.value = infoResponse
} catch (e: Throwable) {
(infoResponse as InfoResponse<*, *>).status = Status.ERROR_EXCEPTION
result.value = infoResponse
}
}

return result
}

 **/