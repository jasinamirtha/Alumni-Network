package com.example.sanjeev.alumninetwork.discussion_forum;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sanjeev.alumninetwork.R;
import com.example.sanjeev.alumninetwork.peopleList.database;
import com.example.sanjeev.alumninetwork.profileInfo.projectAdd;
import com.mikhaellopez.circularimageview.CircularImageView;

public class postAdapter  extends BaseAdapter {
    private Context context;
    private final String[] posts;
    private final String[] comments;
    private final String[] times;
    private final String[] names;
    private final Bitmap[] dps;
    private final int[] ids;
    public postAdapter(Context context, int[] id, String[] post, String [] comment, String[] time, String[] names, Bitmap[] dp  ) {
        this.context = context;
        this.posts = post;
        this.comments = comment;
        this.times = time;
        this.names = names;
        this.dps = dp;
        this.ids = id;
    }
    TextView name;
    TextView time;
    TextView post;
    CircularImageView profile_pic;
    ImageView like;
    CircularImageView unlike;
    ImageView comment;
    TextView comment_1;
    TextView comment_2;
    Button load_more;
    @Override
    public int getCount() {
        return posts.length;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.post_page, parent, false);
        name = (TextView)rowView.findViewById(R.id.name);
        time = (TextView)rowView.findViewById(R.id.time);
        post = (TextView)rowView.findViewById(R.id.post);
        profile_pic = (CircularImageView)rowView.findViewById(R.id.profile_pic);
        like = (ImageView)rowView.findViewById(R.id.like_btn);
        comment = (ImageView)rowView.findViewById(R.id.comment_btn);
        profile_pic.setImageBitmap(dps[position]);
        time.setText(times[position]);
        post.setText(posts[position]);
        name.setText(names[position]);
        comment.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                database.current_post_id_mine = ids[position];
                Log.e("POSITION OF SELECTED", position+"");
                Intent intent = new Intent(context, commentsByPeople.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        return rowView;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



}