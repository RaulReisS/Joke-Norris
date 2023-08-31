package br.com.raulreis.jokenorris.presentation

import br.com.raulreis.jokenorris.data.JokeCallback
import br.com.raulreis.jokenorris.data.JokeRemoteDataSource
import br.com.raulreis.jokenorris.model.Joke
import br.com.raulreis.jokenorris.view.JokeFragment

class JokePresenter(
    private val view: JokeFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) :  JokeCallback{

    fun findBy(categoryName: String) {
        view.showProgress()
        dataSource.findBy(categoryName, this)
    }

    override fun onSuccess(response: Joke) {
        view.showJoke(response)
    }

    override fun onError(message: String) {
        view.showFailure(message)
    }

    override fun onComplete() {
        view.hideProgress()
    }
}