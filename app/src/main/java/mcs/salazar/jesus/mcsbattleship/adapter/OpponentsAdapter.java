package mcs.salazar.jesus.mcsbattleship.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import mcs.salazar.jesus.mcsbattleship.activity.NewGameMenuActivity;
import mcs.salazar.jesus.mcsbattleship.R;

/**
 * Created by berekethaile on 2/28/18.
 */

public class OpponentsAdapter extends RecyclerView.Adapter<OpponentsAdapter.OpponentsViewHolder> {

    ArrayList<String> opponents;


    public OpponentsAdapter(ArrayList<String> opponents, Context context) {
        this.opponents = opponents;
    }

    @Override
    public OpponentsAdapter.OpponentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.opponents_list,parent,false);
        OpponentsViewHolder viewHolder = new OpponentsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OpponentsAdapter.OpponentsViewHolder holder, int position) {
        holder.mTextView.setText(opponents.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return opponents.size();
    }

    public static class OpponentsViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public OpponentsViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.opponent_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), NewGameMenuActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
