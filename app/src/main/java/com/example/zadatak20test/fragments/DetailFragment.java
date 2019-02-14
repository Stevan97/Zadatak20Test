package com.example.zadatak20test.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.zadatak20test.R;
import com.example.zadatak20test.model.Filmovi;
import com.example.zadatak20test.model.Glumac;
import com.example.zadatak20test.provider.GlumacProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DetailFragment extends Fragment {

    private static boolean landscape = false;

    private int position = 0;

    public interface OnSpinnerSelected {
        void OnSpinnerClicked(int position);
    }

    OnSpinnerSelected listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            listener = (OnSpinnerSelected) activity;
        } catch (ClassCastException e) {
            e.toString();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.detail_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity().findViewById(R.id.detail_landscape_view) != null) {
            landscape = true;
            new DetailAsyncTask().execute();
        } else if (landscape == false) {
            new DetailAsyncTask().execute();
        }


        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position");
        }

        final List<String> imenaGlumci = GlumacProvider.getGlumciNames();
        Spinner spinner = getView().findViewById(R.id.spinner);
        SpinnerAdapter adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, imenaGlumci);
        spinner.setAdapter(adapter);
        spinner.setSelection(position);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                listener.OnSpinnerClicked(position);
                final List<Filmovi> listaUloga = GlumacProvider.getFilmByGlumacId(position);
                final ListView listView = getView().findViewById(R.id.filmoviUloge);
                ArrayAdapter<Filmovi> adapter1 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listaUloga);
                listView.setAdapter(adapter1);

                final TextView textView = getView().findViewById(R.id.podaci_O_glumcu);
                textView.setText(GlumacProvider.getCeoGlumacById(position).toString());
                final ImageView imageView = getView().findViewById(R.id.slika_glumca);

                try {
                    InputStream is = getActivity().getAssets().open(GlumacProvider.getCeoGlumacById(position).getSlika());
                    Drawable drawable = Drawable.createFromStream(is, null);
                    imageView.setImageDrawable(drawable);
                } catch (IOException e) {
                    e.toString();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void setContent(final int position) {
        this.position = position;
    }

    public void updateContent(final int position) {
        this.position = position;


        final List<String> imenaGlumci = GlumacProvider.getGlumciNames();
        Spinner spinner = getView().findViewById(R.id.spinner);
        SpinnerAdapter adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, imenaGlumci);
        spinner.setAdapter(adapter);
        spinner.setSelection(position);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                listener.OnSpinnerClicked(position);
                final List<Filmovi> listaUloga = GlumacProvider.getFilmByGlumacId(position);
                final ListView listView = getView().findViewById(R.id.filmoviUloge);
                ArrayAdapter<Filmovi> adapter1 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listaUloga);
                listView.setAdapter(adapter1);

                final TextView textView = getView().findViewById(R.id.podaci_O_glumcu);
                textView.setText(GlumacProvider.getCeoGlumacById(position).toString());
                final ImageView imageView = getView().findViewById(R.id.slika_glumca);

                try {
                    InputStream is = getActivity().getAssets().open(GlumacProvider.getCeoGlumacById(position).getSlika());
                    Drawable drawable = Drawable.createFromStream(is, null);
                    imageView.setImageDrawable(drawable);
                } catch (IOException e) {
                    e.toString();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public class DetailAsyncTask extends AsyncTask<Void, Void, List<Glumac>> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(DetailFragment.this.getActivity());
            progressDialog.setMessage("Loading Information about Actor, please wait!");
            progressDialog.show();

        }

        @Override
        protected List<Glumac> doInBackground(Void... voids) {


            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return GlumacProvider.getGlumci(); // ** or return null; - does the same.?
        }

        @Override
        protected void onPostExecute(List<Glumac> glumacs) {
            super.onPostExecute(glumacs);
            if (progressDialog != null) {
                progressDialog.dismiss();

            }
            if (glumacs != null) {
                 // Snackbar.make(getActivity().findViewById(R.id.master_view),"Details About Actors Loaded!",Snackbar.LENGTH_LONG).show();
                GlumacProvider.getGlumci();
            }

        }


    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("position", position);

    }
}
