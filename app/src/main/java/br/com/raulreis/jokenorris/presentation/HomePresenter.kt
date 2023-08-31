package br.com.raulreis.jokenorris.presentation

import android.graphics.Color
import android.os.Handler
import android.os.Looper
import br.com.raulreis.jokenorris.data.CategoryRemoteDataSource
import br.com.raulreis.jokenorris.data.ListCategoryCallback
import br.com.raulreis.jokenorris.model.Category
import br.com.raulreis.jokenorris.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
    ) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }

    override fun onSuccess(response: List<String>) {
        val start = 40.0f // H - matiz
        val end = 190.0f
        val diff = (end - start) / response.size


        val categories = response.mapIndexed{ index, s ->
            val hsv = floatArrayOf(start + (diff*index),100.0f, 100.0f)
            Category(s, Color.HSVToColor(hsv).toLong())
        }

        view.showCategories(categories)
    }

    override fun onError(message: String) {
        view.showFailure(message)
    }

    override fun onComplete() {
        view.hideProgress()
    }
}