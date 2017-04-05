package com.example.david.examplemvp.findJoke.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.david.examplemvp.R;
import com.example.david.examplemvp.entities.Joke;
import com.example.david.examplemvp.findJoke.MainPresenter;
import com.example.david.examplemvp.findJoke.MainPresenterImpl;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    @Bind(R.id.chuckJoke)
    TextView chuckJoke;
    @Bind(R.id.findJoke)
    Button findJoke;
    @Bind(R.id.name)
    EditText name;
    @Bind(R.id.lastName)
    EditText lastName;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenterImpl(this);
        presenter.onCreate();
    }

    @OnClick(R.id.findJoke)
    public void findJoke() {

        String nameText = name.getText().toString();
        String lastNameText = lastName.getText().toString();

        presenter.findJoke(nameText, lastNameText);
    }

    @Override
    public void jokeSuccess(Joke joke) {
        chuckJoke.setText(joke.getJoke());
    }

    @Override
    public void jokeError() {

    }
}
