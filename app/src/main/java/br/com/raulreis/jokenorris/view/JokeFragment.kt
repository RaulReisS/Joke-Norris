package br.com.raulreis.jokenorris.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import br.com.raulreis.jokenorris.R
import br.com.raulreis.jokenorris.model.Joke
import br.com.raulreis.jokenorris.presentation.JokePresenter
import br.com.raulreis.jokenorris.presentation.JokesFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class JokeFragment : Fragment(), JokesFragment {

    private lateinit var progressBar: ProgressBar
    private lateinit var textView: TextView
    private lateinit var imgJoke : ImageView

    private lateinit var presenter: JokePresenter

    companion object {
        const val CATEGORY_KEY = "category"
        const val COLOR_KEY = "color"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = JokePresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryName = arguments?.getString(CATEGORY_KEY)!!
        val color = arguments?.getLong(COLOR_KEY)!!



        activity?.findViewById<Toolbar>(R.id.toolbar)?.title = categoryName
        progressBar = view.findViewById(R.id.progressJoke)
        textView = view.findViewById(R.id.txvJoke)
        imgJoke = view.findViewById(R.id.imgJoke)


        view.findViewById<FrameLayout>(R.id.containerImg).setBackgroundColor(color.toInt())

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            presenter.findBy(categoryName)
        }

        presenter.findBy(categoryName)
    }

    override fun showJoke(joke: Joke) {
        textView.text = joke.text
        Picasso.get().load(joke.iconUrl).into(imgJoke)
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}