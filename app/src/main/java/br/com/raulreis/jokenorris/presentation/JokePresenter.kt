package br.com.raulreis.jokenorris.presentation

import br.com.raulreis.jokenorris.data.JokeCallback
import br.com.raulreis.jokenorris.data.JokeRemoteDataSource
import br.com.raulreis.jokenorris.model.Joke

class JokePresenter(
    private val view: JokesFragment,
    private val dataSource: JokeRemoteDataSource = JokeRemoteDataSource()
) :  JokeCallback{

    fun findBy(categoryName: String) {
        view.showProgress()
        dataSource.findBy(categoryName, this)
    }

    fun getJoke() {
        view.showProgress()
        dataSource.getJoke(this)
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