package mx.edu.utng.orders.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mx.edu.utng.orders.R;
import mx.edu.utng.orders.model.Title;

/**
 * Created by ulises on 23/02/2017.
 */

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.TitleViewHolder> implements View.OnClickListener{

    List<Title> titles;
    View.OnClickListener listener;

    public TitleAdapter(List<Title> titles ){
        this.titles = titles;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }


    @Override
    public TitleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout2,parent,false);

        TitleViewHolder holder = new TitleViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }



    @Override
    public void onBindViewHolder(TitleAdapter.TitleViewHolder holder, int position) {
        holder.tvTitleTitle.setText(titles.get(position).getTitle());
        holder.tvTitleFromDate.setText(titles.get(position).getFromDate());
        holder.tvTitleToDate.setText(titles.get(position).getToDate());
        holder.ivTitle.setImageResource(R.mipmap.ic_launcher);
        holder.setListener(this);

    }

    @Override
    public int getItemCount() {

        return titles.size();
    }

    @Override
    public void onClick(View v) {
        if(listener!= null){
            listener.onClick(v);
        }

    }

    public static class TitleViewHolder extends  RecyclerView.ViewHolder  implements View.OnClickListener{

        CardView cvTitle;
        TextView tvTitleTitle;
        TextView tvTitleFromDate;
        TextView tvTitleToDate;
        ImageView ivTitle;
        ImageButton btEditTitle;
        ImageButton btDeleteTitle;
        View.OnClickListener listener;



        public TitleViewHolder(View itemView) {
            super(itemView);
            cvTitle = (CardView) itemView.findViewById(R.id.cv_title);
            ivTitle = (ImageView) itemView.findViewById(R.id.iv_title);
            tvTitleTitle = (TextView) itemView.findViewById(R.id.tv_title_title);
            tvTitleFromDate = (TextView) itemView.findViewById(R.id.tv_title_from_date);
            tvTitleToDate = (TextView) itemView.findViewById(R.id.tv_title_to_date);
            btEditTitle = (ImageButton) itemView.findViewById(R.id.bt_edit_title);
            btDeleteTitle = (ImageButton) itemView.findViewById(R.id.bt_delete_title);
            btEditTitle.setOnClickListener(this);
            btDeleteTitle.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(listener!=null){
                listener.onClick(v);
            }

        }

        public void setListener(View.OnClickListener listener) {
            this.listener = listener;
        }
    }
}



