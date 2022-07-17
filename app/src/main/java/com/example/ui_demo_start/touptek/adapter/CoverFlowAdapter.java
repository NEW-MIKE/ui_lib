package com.example.ui_demo_start.touptek.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView.*;

import com.example.ui_demo_start.R;

import java.util.ArrayList;


public class CoverFlowAdapter extends Adapter<ViewHolder> {

    private Context mContext;
    private ArrayList<String> mDatas;
    private int mCreatedHolder=0;
    public CoverFlowAdapter(Context context, ArrayList<String> datas) {
        mContext = context;
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mCreatedHolder++;
        Log.d("qijian", "onCreateViewHolder num:"+mCreatedHolder);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new NormalHolder(inflater.inflate(R.layout.item_coverflow, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("qijian", "onBindViewHolder");
        NormalHolder normalHolder = (NormalHolder) holder;
        normalHolder.mTV.setText(mDatas.get(position));

    }
    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class NormalHolder extends ViewHolder {
        public TextView mTV;
        public ImageView mImg;

        public NormalHolder(View itemView) {
            super(itemView);

            mTV = (TextView) itemView.findViewById(R.id.choosetv);
            mTV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, mTV.getText(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
