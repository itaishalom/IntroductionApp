package com.example.itai.introductionapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import pl.droidsonroids.gif.GifImageView;

import static com.example.itai.introductionapp.SwipingAdapter.NUM_OF_PAGE;

public class PageFragment extends android.support.v4.app.Fragment {
    public PageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        Bundle bundle = getArguments();
        final Activity activity = this.getActivity();
        View view = null;
        switch (bundle.getInt(NUM_OF_PAGE)) {
            case 0:
                view = loadMainGif(container, inflater, R.layout.fragment_page_1);
                break;
            case 1:
                view = handlePage2(container, inflater, activity, R.layout.fragment_page_2, true);
                break;
            case 2:
                view = handlePage3(container, inflater, activity, R.layout.fragment_page_3, true);
                break;
            case 3:
                view = handlePage4(container, inflater, activity, R.layout.fragment_page_4);
                break;
        }
        return view;
    }

    private ImageView loadBlinkingImage(View view, String uri, int id, Activity activity) {
        ImageView image = (ImageView) view.findViewById(id);
        int imageResource = getResources().getIdentifier(uri, null, activity.getPackageName());
        image.setImageResource(imageResource);
        return image;
    }

    private View loadMainGif(ViewGroup container, LayoutInflater inflater, int layout) {
        View view = inflater.inflate(layout, container, false);
        GifImageView image = (GifImageView) view.findViewById(R.id.android);
        image.setImageResource(R.drawable.android);
        return view;
    }

    private View handlePage2(ViewGroup container, LayoutInflater inflater, Activity activity,
                             int layout, boolean fromMain) {
        View view = loadMainGif(container, inflater, layout);
        ImageView img = loadBlinkingImage(view, "@drawable/first_image", R.id.image1, activity);
        if (fromMain) {
            IntroductionActivity.idToImage.put(2, img);
        }
        return view;
    }

    private View handlePage3(ViewGroup container, LayoutInflater inflater, Activity activity,
                             int layout, boolean fromMain) {
        View view = handlePage2(container, inflater, activity, layout, false);
        ImageView img = loadBlinkingImage(view, "@drawable/on_tool_bar", R.id.image4, activity);
        if (fromMain) {
            IntroductionActivity.idToImage.put(3, img);
        }
        return view;
    }

    private View handlePage4(ViewGroup container, LayoutInflater inflater, final Activity activity,
                             int layout) {
        View view = loadMainGif(container, inflater, layout);
        Button button = (Button) view.findViewById(R.id.ok_got_it);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent returnIntent = new Intent(activity, MainActivity.class);
                startActivity(returnIntent);
                activity.finish();
            }
        });
        return view;
    }
}