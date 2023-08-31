package br.com.raulreis.jokenorris.data

import br.com.raulreis.jokenorris.model.Joke

interface JokeCallback {

    fun onSuccess(response: Joke)

    fun onError(message: String)

    fun onComplete()
}