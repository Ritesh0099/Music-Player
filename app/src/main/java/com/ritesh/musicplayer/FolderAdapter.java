package com.ritesh.musicplayer;

import android.content.Context;
import android.view.*;
import android.widget.*;

public class FolderAdapter extends BaseAdapter {
    private final Context context;
    private final String[] folderNames;
    private final int[] folderImages;

    public FolderAdapter(Context context, String[] folderNames, int[] folderImages) {
        this.context = context;
        this.folderNames = folderNames;
        this.folderImages = folderImages;
    }

    @Override
    public int getCount() {
        return folderNames.length;
    }

    @Override
    public Object getItem(int position) {
        return folderNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.folder_item, parent, false);

        ImageView image = view.findViewById(R.id.folderImage);
        TextView name = view.findViewById(R.id.folderName);

        name.setText(folderNames[position]);

        if (position < folderImages.length)
            image.setImageResource(folderImages[position]);
        else
            image.setImageResource(R.drawable.default_folder); // fallback

        return view;
    }
}
