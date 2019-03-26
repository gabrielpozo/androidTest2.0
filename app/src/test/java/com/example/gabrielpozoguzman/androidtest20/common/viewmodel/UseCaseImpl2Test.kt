package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.common.pagelist.ResultState
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import com.nhaarman.mockitokotlin2.mock
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.hamcrest.CoreMatchers.nullValue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.mockito.Mockito.*
import retrofit2.Call
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class UseCaseImpl2Test {

    // region test constants
    lateinit var result: Result<List<Category>>
    // endregion constants

    // region helper fields
    private val coroutinesManager: DefaultCoroutines = DefaultCoroutines()
    private val mobgenApiMock: MobgenApi = mock()
    //end region helper fields


    private val SUT by lazy { UseCaseImpl2(mobgenApiMock) }

    @Before
    fun setup() {
        success()
    }

    // fetchCategories - success - success Returned
    @Test
    fun fetchCategories_success_successReturned() {
        //act
        SUT.fetchCategories {
            result = it
        }
        assertThat(result.resultState, `is`(ResultState.SUCCESS))
    }

    //fetchCategories - success - categories returned
    @Test
    fun fetchCategories_success_categoriesReturned() {
        //act
        SUT.fetchCategories {
            result = it
        }
        //assert
        assertThat(result.data, `is`(getCategories()))
    }

    // fetchCategories - fails - generalError returned
    @Test
    fun fetchCategories_fails_generalError() {
        //arrange
        general_error()

        SUT.fetchCategories {
            result = it
        }
        assertThat(result.resultState, `is`(ResultState.ERROR))
    }

    // fetchCategories - fails - categories equal null

    @Test
    fun fetchCategories_fails_nullCategories() {
        //arrange
        general_error()

        SUT.fetchCategories {
            result = it
        }
        assertThat(result.data, `is`(nullValue()))
    }

    // fetchCategories - network fails - network error returned
    @Test
    fun fetchCategories_networkFails_netWorkErrorReturned() {
        //arrange
        netWork_error()

        SUT.fetchCategories {
            result = it
        }
        assertThat(result.data, `is`(nullValue()))
    }
// fetch Categories - network fails - categories null

    @Test
    fun fetchCategories_networkFails_nullCategoriesReturned() {
        //arrange
        netWork_error()

        SUT.fetchCategories {
            result = it
        }
        assertThat(result.resultState, `is`(ResultState.NETWORK_ERROR))
    }


    // region helper methods
    private fun success() {
        var call: Call<List<Category>> = mock()
        var response: Response<List<Category>> = Response.success(getCategories())
        `when`(mobgenApiMock.getCategories()).thenReturn(call)
        `when`(call.execute()).thenReturn(response)
    }

    private fun general_error() {
        val call: Call<List<Category>> = mock()
        val responseBody: ResponseBody = ResponseBody.create(MediaType.parse("string"), "contentType")
        val response: Response<List<Category>> = Response.error(404, responseBody)
        `when`(mobgenApiMock.getCategories()).thenReturn(call)
        `when`(call.execute()).thenReturn(response)
    }

    private fun netWork_error() {
        val call: Call<List<Category>> = mock()
        val responseBody: ResponseBody = ResponseBody.create(MediaType.parse("string"), "contentType")
        val response: Response<List<Category>> = Response.error(500, responseBody)
        `when`(mobgenApiMock.getCategories()).thenReturn(call)
        `when`(call.execute()).thenReturn(response)
    }

    private fun getCategories(): List<Category>? {
        var categories = arrayListOf<Category>()
        categories.add(Category(1, "title", "href"))

        return categories
    }

// end region helper methods

}