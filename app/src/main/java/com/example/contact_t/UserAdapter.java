package com.example.contact_t;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static int TYPE_USER_ONE = 1;
    private static int TYPE_USER_TWO = 2;
    private List<User> mListUser;

    public void setData(List<User> list){
        this.mListUser = list;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (TYPE_USER_ONE == viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_one,parent,false);
            return new UserFeaturedViewHolder(view);
        }else if (TYPE_USER_TWO == viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_two,parent,false);
            return new UserNormalFeatured(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = mListUser.get(position);
        if (user == null){
            return;
        }

        if (TYPE_USER_ONE == holder.getItemViewType()){
           UserFeaturedViewHolder userFeaturedViewHolder = (UserFeaturedViewHolder) holder;
           userFeaturedViewHolder.imgUserOne.setImageResource(user.getResourceId());
           userFeaturedViewHolder.tvUserOne.setText(user.getName());
        }else if (TYPE_USER_TWO == holder.getItemViewType()){
            UserNormalFeatured userNormalFeatured = (UserNormalFeatured) holder;
            userNormalFeatured.imgUserTwo.setImageResource(user.getResourceId());
            userNormalFeatured.tvUserTwo.setText(user.getName());
        }
    }

    @Override
    public int getItemCount() {
        if (mListUser !=null){
            return mListUser.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        User user = mListUser.get(position);
        if (user.isFeatured()){
            return TYPE_USER_ONE;
        }else {
            return TYPE_USER_TWO;
        }
    }

    public class UserFeaturedViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgUserOne;
        private TextView tvUserOne;

        public UserFeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUserOne = itemView.findViewById(R.id.img_user_one);
            tvUserOne = itemView.findViewById(R.id.tv_user_one);
        }
    }

    public class UserNormalFeatured extends RecyclerView.ViewHolder{
        private ImageView imgUserTwo;
        private TextView tvUserTwo;
        private TextView tvUser;

        public UserNormalFeatured(@NonNull View itemView) {
            super(itemView);
            imgUserTwo = itemView.findViewById(R.id.img_user_two);
            tvUserTwo = itemView.findViewById(R.id.tv_user_two);
            tvUser = itemView.findViewById(R.id.textview2);
        }
    }

}
