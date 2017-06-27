package com.example.shashank.kotlin_tutorial;

/**
 * Created by shashank on 23-06-2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {

    private Context mContext;
    private List<Card> CardList;
    FragmentManager mFragmentManager;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            //overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    public CardAdapter(Context mContext, List<Card> albumList) {
        this.mContext = mContext;
        this.CardList = albumList;
        mFragmentManager=((FragmentActivity)mContext).getSupportFragmentManager();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Card card =  CardList.get(position);
        holder.title.setText(card.getName());

        holder.count.setText(card.getNumOfchapters() + "chapters");
        // loading album cover using Glide library
        Glide.with(mContext).load(card.getThumbnail()).into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              switch (position)
              {
                  case 0:
                      Intent in0=new Intent(mContext,Listshow.class);
                      in0.putExtra("value",0);
                      mContext.startActivity(in0);
                      break;
                  case 1:
                      Intent in1=new Intent(mContext,Listshow.class);
                      in1.putExtra("value",1);
                      mContext.startActivity(in1);
                      break;
                  case 2:
                      Intent in2=new Intent(mContext,Listshow.class);
                      in2.putExtra("value",2);
                      mContext.startActivity(in2);
                      break;
                  case 3:
                      Intent in3=new Intent(mContext,Listshow.class);
                      in3.putExtra("value",3);
                      mContext.startActivity(in3);
                      break;
                  case 4:
                      Intent in4=new Intent(mContext,Listshow.class);
                      in4.putExtra("value",4);
                      mContext.startActivity(in4);
                      break;
                  case 5:
                      Intent in5=new Intent(mContext,Listshow.class);
                      in5.putExtra("value",5);
                      mContext.startActivity(in5);
                      break;
                  case 6:
                      Intent in6=new Intent(mContext,Listshow.class);
                      in6.putExtra("value",6);
                      mContext.startActivity(in6);
                      break;
                  case 7:
                      Intent in7=new Intent(mContext,Listshow.class);
                      in7.putExtra("value",7);
                      mContext.startActivity(in7);
                      break;
                  case 8:
                      Intent in8=new Intent(mContext,Listshow.class);
                      in8.putExtra("value",8);
                      mContext.startActivity(in8);
                      break;
                  case 9:
                      Intent in9=new Intent(mContext,Listshow.class);
                      in9.putExtra("value",9);
                      mContext.startActivity(in9);
                      break;
              }
            }
        });


       /* holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });*/
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
   /* private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }*/

    /**
     * Click listener for popup menu items
     */
    /*class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }*/

    @Override
    public int getItemCount() {
        return  CardList.size();
    }
}

