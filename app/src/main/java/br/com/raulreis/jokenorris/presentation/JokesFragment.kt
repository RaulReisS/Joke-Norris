package br.com.raulreis.jokenorris.presentation

import br.com.raulreis.jokenorris.model.Joke


interface JokesFragment {

    fun showJoke(joke: Joke)

    fun showProgress()

    fun hideProgress()

    fun showFailure(message: String)
}