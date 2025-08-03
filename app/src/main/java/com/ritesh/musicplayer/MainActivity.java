package com.ritesh.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    String[] folderNames = {
            "Classical", "Hip Hop", "Lo-Fi", "Love Songs",
            "Sleep", "Chill", "Vintage Road Trip", "Instrumental"
    };

    int[] folderImages = {
            R.drawable.classical, R.drawable.hiphop, R.drawable.lofi,
            R.drawable.lovesongs, R.drawable.sleep, R.drawable.chill,
            R.drawable.vintage, R.drawable.instrumental
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        FolderAdapter adapter = new FolderAdapter(this, folderNames, folderImages);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, SongListActivity.class);
            intent.putExtra("folderName", folderNames[position]);
            intent.putExtra("folderIndex", position); // optional
            startActivity(intent);
        });
    }
}
