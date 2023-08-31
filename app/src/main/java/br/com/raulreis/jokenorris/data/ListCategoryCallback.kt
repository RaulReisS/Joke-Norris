package br.com.raulreis.jokenorris.data

interface ListCategoryCallback {

    fun onSuccess(response: List<String>)

    fun onError(message: String)

    fun onComplete()
}