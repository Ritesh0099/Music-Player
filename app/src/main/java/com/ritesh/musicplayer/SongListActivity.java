package com.ritesh.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class SongListActivity extends AppCompatActivity {

    ListView listView;
    MediaPlayer mediaPlayer;

    String[] songs = {"xyz", "abc", "lol"};
    int[] songFiles = {R.raw.xyz, R.raw.abc, R.raw.lol};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        listView = findViewById(R.id.songListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.song_item, R.id.songText, songs);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (mediaPlayer != null) mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(this, songFiles[position]);
            if (mediaPlayer != null) {
                mediaPlayer.start();
                Toast.makeText(this, "Playing " + songs[position], Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Unable to play song", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) mediaPlayer.release();
        super.onDestroy();
    }
}
