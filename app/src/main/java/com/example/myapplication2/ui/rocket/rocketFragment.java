package com.example.myapplication2.ui.rocket;
import com.example.myapplication2.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import android.view.View.OnClickListener;
import android.widget.MediaController;

import com.example.myapplication2.databinding.FragmentHomeBinding;
import com.example.myapplication2.databinding.FragmentRocketBinding;

public class rocketFragment extends Fragment {

    private FragmentRocketBinding binding;
    private Button button;
    private Button button2;
    private Button pause1;
    private Button pause2;
    private Button pause3;
    private Button fullscreenButton;
    private Button fullscreenButton2;
    private Button fullscreenButton3;
    private int originalWidth;
    private int originalHeight;
    private int getOriginalWidth2;
    private int getOriginalHeight2;
    private int getOriginalWidth3;
    private int getOriginalHeight3;
    private boolean isFullscreen = false;
    private ImageView backgroundImage;
    private Button imageButton1;
    private Button imageButton2;
    private Button imageButton3;
    private ImageView thumbnail;
    private ImageView thumbnail2;
    private ImageView thumbnail3;
    private Button bigPause1;
    private Button bigPause2;
    private Button bigPause3;
    private Button bigFullscreen1;
    private Button bigFullscreen2;
    private Button bigFullscreen3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_rocket, container, false);

        // Hide the navigation bar
        View decorView = getActivity().getWindow().getDecorView();
        int flags = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(flags);

        backgroundImage = rootView.findViewById(R.id.backgroundImage);

        VideoView videoView1 = rootView.findViewById(R.id.videoView1);
        VideoView videoView2 = rootView.findViewById(R.id.videoView2);
        VideoView videoView3 = rootView.findViewById(R.id.videoView3);

        backgroundImage.setImageResource(R.drawable.backgroundimageeight);

        String videoPath1 = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.rockettwo;
        String videoPath2 = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.rocketone;
        String videoPath3 = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.rocketthree;

        videoView1.setVideoURI(Uri.parse(videoPath1));
        videoView2.setVideoURI(Uri.parse(videoPath2));
        videoView3.setVideoURI(Uri.parse(videoPath3));

        // Start the videos automatically or control this programmatically

        Button fullscreenButton = rootView.findViewById(R.id.fullScreenButton);
        Button fullscreenButton2 = rootView.findViewById(R.id.fullScreenButton2);
        Button fullscreenButton3 = rootView.findViewById(R.id.fullScreenButton3);
        Button imageButton1 = rootView.findViewById(R.id.transparent);
        Button imageButton2 = rootView.findViewById(R.id.transparent2);
        Button imageButton3 = rootView.findViewById(R.id.transparent3);
        ImageView thumbnail = rootView.findViewById(R.id.thumbnailone);
        ImageView thumbnail2 = rootView.findViewById(R.id.thumbnailtwo);
        ImageView thumbnail3 = rootView.findViewById(R.id.thumbnailthree);
        Button pause1 = rootView.findViewById(R.id.pause);
        Button pause2 = rootView.findViewById(R.id.pause2);
        Button pause3 = rootView.findViewById(R.id.pause3);
        Button bigPause1 = rootView.findViewById(R.id.bigPause1);
        Button bigPause2 = rootView.findViewById(R.id.bigPause2);
        Button bigPause3 = rootView.findViewById(R.id.bigPause3);
        Button bigFullscreen1 = rootView.findViewById(R.id.bigFullscreen1);
        Button bigFullscreen2 = rootView.findViewById(R.id.bigFullscreen2);
        Button bigFullscreen3 = rootView.findViewById(R.id.bigFullscreen3);


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                originalWidth = videoView1.getWidth();
                originalHeight = videoView1.getHeight();
                thumbnail.setVisibility(thumbnail.INVISIBLE);
                imageButton1.setVisibility(imageButton1.INVISIBLE);
                fullscreenButton.setVisibility(fullscreenButton.VISIBLE);
                pause1.setVisibility(pause1.VISIBLE);
                imageButton2.setVisibility(imageButton2.INVISIBLE);
                imageButton3.setVisibility(imageButton3.INVISIBLE);
                videoView1.start();

            }
        });
        bigPause1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView1.pause();
                bigPause1.setVisibility(bigPause1.INVISIBLE);
                thumbnail.setVisibility(thumbnail.VISIBLE);
                imageButton1.setVisibility(imageButton1.VISIBLE);
                imageButton2.setVisibility(imageButton2.VISIBLE);
                imageButton3.setVisibility(imageButton3.VISIBLE);
                pause1.setVisibility(pause1.INVISIBLE);
                fullscreenButton.setVisibility(fullscreenButton.INVISIBLE);
                thumbnail2.setVisibility(thumbnail2.VISIBLE);
                thumbnail3.setVisibility(thumbnail3.VISIBLE);
                bigFullscreen1.setVisibility(bigFullscreen1.INVISIBLE);

                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) videoView1.getLayoutParams();
                params.width = originalWidth;
                params.height =originalHeight;
                videoView1.setLayoutParams(params);
                isFullscreen = false;



            }
        });



        bigFullscreen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Exit fullscreen
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) videoView1.getLayoutParams();
                params.width = originalWidth;
                params.height =originalHeight;
                videoView1.setLayoutParams(params);
                bigFullscreen1.setVisibility(bigFullscreen1.INVISIBLE);
                fullscreenButton.setVisibility(fullscreenButton.VISIBLE);
                videoView1.setLayoutParams(params);
                isFullscreen = false;
                thumbnail2.setVisibility(thumbnail2.VISIBLE);
                thumbnail3.setVisibility(thumbnail3.VISIBLE);
                bigPause1.setVisibility(bigPause1.INVISIBLE);
                pause1.setVisibility(pause1.VISIBLE);
                if(videoView1.isPlaying()){
                    imageButton2.setVisibility(imageButton2.INVISIBLE);
                    imageButton3.setVisibility(imageButton3.INVISIBLE);
                }
                else {
                    imageButton2.setVisibility(imageButton2.VISIBLE);
                    imageButton3.setVisibility(imageButton3.VISIBLE);
                }

            }

        });

        fullscreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                // Enter fullscreen
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) videoView1.getLayoutParams();
                params.width = ConstraintLayout.LayoutParams.MATCH_PARENT;
                params.height = ConstraintLayout.LayoutParams.MATCH_PARENT;
                videoView1.setLayoutParams(params);
                isFullscreen = true;
                pause1.setVisibility(pause1.INVISIBLE);
                fullscreenButton3.setVisibility(fullscreenButton3.INVISIBLE);
                fullscreenButton2.setVisibility(fullscreenButton2.INVISIBLE);
                imageButton2.setVisibility(imageButton2.INVISIBLE);
                imageButton3.setVisibility(imageButton3.INVISIBLE);
                thumbnail2.setVisibility(thumbnail2.INVISIBLE);
                thumbnail3.setVisibility(thumbnail3.INVISIBLE);
                bigFullscreen1.setVisibility(bigFullscreen1.VISIBLE);
                bigPause1.setVisibility(bigPause1.VISIBLE);
                fullscreenButton.setVisibility(fullscreenButton.INVISIBLE);
            }

        });





        pause1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView1.pause();
                thumbnail.setVisibility(thumbnail.VISIBLE);
                imageButton1.setVisibility(imageButton1.VISIBLE);
                imageButton2.setVisibility(imageButton2.VISIBLE);
                imageButton3.setVisibility(imageButton3.VISIBLE);
                pause1.setVisibility(pause1.INVISIBLE);
                fullscreenButton.setVisibility(fullscreenButton.INVISIBLE);
                thumbnail2.setVisibility(thumbnail2.VISIBLE);
                thumbnail3.setVisibility(thumbnail3.VISIBLE);
                bigFullscreen1.setVisibility(bigFullscreen1.INVISIBLE);



            }
        });

        //DR YAZMINA

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOriginalWidth2 = videoView2.getWidth();
                getOriginalHeight2 = videoView2.getHeight();
                thumbnail2.setVisibility(thumbnail2.INVISIBLE);
                imageButton2.setVisibility(imageButton2.INVISIBLE);
                fullscreenButton2.setVisibility(fullscreenButton2.VISIBLE);
                pause2.setVisibility(pause2.VISIBLE);
                imageButton1.setVisibility(imageButton1.INVISIBLE);
                imageButton3.setVisibility(imageButton3.INVISIBLE);

                videoView2.start();

            }
        });



        bigPause2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView2.pause();
                bigPause2.setVisibility(bigPause2.INVISIBLE);
                thumbnail2.setVisibility(thumbnail2.VISIBLE);
                imageButton1.setVisibility(imageButton1.VISIBLE);
                imageButton2.setVisibility(imageButton2.VISIBLE);
                imageButton3.setVisibility(imageButton3.VISIBLE);
                pause2.setVisibility(pause2.INVISIBLE);
                fullscreenButton2.setVisibility(fullscreenButton2.INVISIBLE);
                thumbnail.setVisibility(thumbnail.VISIBLE);
                thumbnail3.setVisibility(thumbnail3.VISIBLE);
                bigFullscreen2.setVisibility(bigFullscreen2.INVISIBLE);

                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) videoView2.getLayoutParams();
                params.width = getOriginalWidth2;
                params.height = getOriginalHeight2;
                videoView2.setLayoutParams(params);
                isFullscreen = false;
                videoView1.setVisibility(videoView1.VISIBLE);
                videoView3.setVisibility(videoView3.VISIBLE);


            }
        });


        bigFullscreen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Exit fullscreen
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) videoView2.getLayoutParams();
                params.width = getOriginalWidth2;
                params.height = getOriginalHeight2;
                bigFullscreen2.setVisibility(bigFullscreen2.INVISIBLE);
                fullscreenButton2.setVisibility(fullscreenButton2.VISIBLE);
                videoView2.setLayoutParams(params);
                isFullscreen = false;
                thumbnail.setVisibility(thumbnail.VISIBLE);
                thumbnail3.setVisibility(thumbnail3.VISIBLE);
                bigPause2.setVisibility(bigPause2.INVISIBLE);
                pause2.setVisibility(pause2.VISIBLE);
                videoView1.setVisibility(videoView1.VISIBLE);
                videoView3.setVisibility(videoView3.VISIBLE);
                if(videoView2.isPlaying()){
                    imageButton1.setVisibility(imageButton1.INVISIBLE);
                    imageButton3.setVisibility(imageButton3.INVISIBLE);
                }
                else {
                    imageButton1.setVisibility(imageButton1.VISIBLE);
                    imageButton3.setVisibility(imageButton3.VISIBLE);
                }

            }

        });



        fullscreenButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Enter fullscreen
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) videoView2.getLayoutParams();
                params.width = ConstraintLayout.LayoutParams.MATCH_PARENT;
                params.height = ConstraintLayout.LayoutParams.MATCH_PARENT;
                videoView2.setLayoutParams(params);
                isFullscreen = true;
                pause2.setVisibility(pause2.INVISIBLE);
                fullscreenButton3.setVisibility(fullscreenButton3.INVISIBLE);
                fullscreenButton.setVisibility(fullscreenButton.INVISIBLE);
                imageButton1.setVisibility(imageButton1.INVISIBLE);
                imageButton3.setVisibility(imageButton3.INVISIBLE);
                thumbnail.setVisibility(thumbnail.INVISIBLE);
                thumbnail3.setVisibility(thumbnail3.INVISIBLE);
                bigFullscreen2.setVisibility(bigFullscreen2.VISIBLE);
                bigPause2.setVisibility(bigPause2.VISIBLE);
                fullscreenButton2.setVisibility(fullscreenButton2.INVISIBLE);
                videoView1.setVisibility(videoView1.INVISIBLE);
                videoView3.setVisibility(videoView3.INVISIBLE);
            }

        });


        pause2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView2.pause();
                thumbnail2.setVisibility(thumbnail2.VISIBLE);
                imageButton2.setVisibility(imageButton2.VISIBLE);
                imageButton3.setVisibility(imageButton3.VISIBLE);
                imageButton1.setVisibility(imageButton1.VISIBLE);
                pause2.setVisibility(pause2.INVISIBLE);
                fullscreenButton2.setVisibility(fullscreenButton2.INVISIBLE);
                thumbnail.setVisibility(thumbnail.VISIBLE);
                thumbnail3.setVisibility(thumbnail3.VISIBLE);
                bigFullscreen2.setVisibility(bigFullscreen2.INVISIBLE);
                videoView1.setVisibility(videoView1.VISIBLE);
                videoView3.setVisibility(videoView3.VISIBLE);



            }
        });

        // DR MAGAN (Continuation)


        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOriginalWidth3 = videoView3.getWidth();
                getOriginalHeight3 = videoView3.getHeight();
                thumbnail3.setVisibility(thumbnail3.INVISIBLE);
                imageButton3.setVisibility(imageButton3.INVISIBLE);
                fullscreenButton3.setVisibility(fullscreenButton3.VISIBLE);
                pause3.setVisibility(pause3.VISIBLE);
                imageButton1.setVisibility(imageButton1.INVISIBLE);
                imageButton2.setVisibility(imageButton2.INVISIBLE);
                videoView3.start();


            }
        });



        bigPause3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView3.pause();
                videoView1.setVisibility(videoView1.VISIBLE);
                videoView2.setVisibility(videoView2.VISIBLE);
                bigPause3.setVisibility(bigPause3.INVISIBLE);
                thumbnail3.setVisibility(thumbnail3.VISIBLE);
                imageButton1.setVisibility(imageButton1.VISIBLE);
                imageButton2.setVisibility(imageButton2.VISIBLE);
                imageButton3.setVisibility(imageButton3.VISIBLE);
                pause3.setVisibility(pause3.INVISIBLE);
                fullscreenButton3.setVisibility(fullscreenButton3.INVISIBLE);
                thumbnail.setVisibility(thumbnail.VISIBLE);
                thumbnail2.setVisibility(thumbnail2.VISIBLE);
                bigFullscreen3.setVisibility(bigFullscreen3.INVISIBLE);

                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) videoView3.getLayoutParams();
                params.width = getOriginalWidth3;
                params.height = getOriginalHeight3;

                videoView3.setLayoutParams(params);
                isFullscreen = false;



            }
        });


        bigFullscreen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Exit fullscreen
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) videoView3.getLayoutParams();
                params.width = getOriginalWidth3;
                params.height = getOriginalHeight3;
                bigFullscreen3.setVisibility(bigFullscreen3.INVISIBLE);
                fullscreenButton3.setVisibility(fullscreenButton3.VISIBLE);
                videoView3.setLayoutParams(params);
                isFullscreen = false;
                thumbnail.setVisibility(thumbnail.VISIBLE);
                thumbnail2.setVisibility(thumbnail2.VISIBLE);
                bigPause3.setVisibility(bigPause3.INVISIBLE);
                pause3.setVisibility(pause3.VISIBLE);
                videoView1.setVisibility(videoView1.VISIBLE);
                videoView2.setVisibility(videoView2.VISIBLE);
                videoView3.setVisibility(videoView3.VISIBLE);
                if(videoView3.isPlaying()){
                    imageButton1.setVisibility(imageButton1.INVISIBLE);
                    imageButton2.setVisibility(imageButton2.INVISIBLE);
                }
                else {
                    imageButton1.setVisibility(imageButton1.VISIBLE);
                    imageButton2.setVisibility(imageButton2.VISIBLE);
                }

            }

        });


        fullscreenButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Enter fullscreen
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) videoView3.getLayoutParams();
                params.width = ConstraintLayout.LayoutParams.MATCH_PARENT;
                params.height = ConstraintLayout.LayoutParams.MATCH_PARENT;
                videoView3.setLayoutParams(params);
                isFullscreen = true;
                pause3.setVisibility(pause3.INVISIBLE);
                fullscreenButton2.setVisibility(fullscreenButton2.INVISIBLE);
                fullscreenButton.setVisibility(fullscreenButton.INVISIBLE);
                imageButton2.setVisibility(imageButton2.INVISIBLE);
                imageButton1.setVisibility(imageButton1.INVISIBLE);
                thumbnail.setVisibility(thumbnail.INVISIBLE);
                thumbnail2.setVisibility(thumbnail2.INVISIBLE);
                bigFullscreen3.setVisibility(bigFullscreen3.VISIBLE);
                bigPause3.setVisibility(bigPause3.VISIBLE);
                fullscreenButton3.setVisibility(fullscreenButton3.INVISIBLE);
                videoView1.setVisibility(videoView1.INVISIBLE);
                videoView2.setVisibility(videoView2.INVISIBLE);
            }

        });






        pause3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView3.pause();
                thumbnail3.setVisibility(thumbnail3.VISIBLE);
                imageButton2.setVisibility(imageButton2.VISIBLE);
                imageButton1.setVisibility(imageButton1.VISIBLE);
                imageButton3.setVisibility(imageButton3.VISIBLE);
                pause3.setVisibility(pause3.INVISIBLE);
                fullscreenButton3.setVisibility(fullscreenButton3.INVISIBLE);
                thumbnail.setVisibility(thumbnail.VISIBLE);
                bigFullscreen3.setVisibility(bigFullscreen3.INVISIBLE);
                thumbnail3.setVisibility(thumbnail3.VISIBLE);
                videoView1.setVisibility(videoView1.VISIBLE);
                videoView2.setVisibility(videoView2.VISIBLE);

            }
        });

        return rootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

