package br.com.raulreis.jokenorris.presentation

import android.os.Handler
import android.os.Looper
import br.com.raulreis.jokenorris.model.Category
import br.com.raulreis.jokenorris.view.HomeFragment

class HomePresenter(private val view: HomeFragment) {

    fun findAllCategories() {
        view.showProgress()
        fakeRequest()
    }

    fun onSuccess(response: List<String>) {
        /*
        val categories = mutableListOf<CategoryItem>()

        for (category in response) {
            categories.add(CategoryItem(category))
        }
         */

        val categories = response.map{ Category(it, 0xFFFF0000) }

        view.showCategories(categories)
    }

    fun onError(message: String) {
        view.showFailure(message)
    }

    fun onComplete() {
        view.hideProgress()
    }
    // Simular uma requisição HTTP
    private fun fakeRequest() {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                "Categoria 1",
                "Categoria 2",
                "Categoria 3",
                "Categoria 4",
                "Categoria 5",
            )

            // Aqui a lista já está pronta (response)
            onSuccess(response)
            //onError("FALHA NA CONEXÃO. TENTE NOVAMENTE MAIS TARDE!")

            onComplete()
        }, 4000)
    }
}