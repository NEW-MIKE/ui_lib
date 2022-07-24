package com.example.ui_demo_start.touptek.qqdelete;

import android.os.Bundle;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ui_demo_start.R;
import com.example.ui_demo_start.touptek.qqdelete.library.ItemTouchHelperExtension;

import java.util.ArrayList;

public class QQDeleteActivity extends AppCompatActivity {
    private ArrayList<String> mDatas = new ArrayList<>();
    private ItemTouchHelper mItemTouchHelper;
    private ItemTouchHelperExtension mItemTouchHelperExtension;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqdelete);

        generateDatas();
        final RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //线性布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        final QQDeleteAdapter adapter = new QQDeleteAdapter(this, mDatas);
        adapter.setOnBtnClickListener(new OnBtnClickListener() {
            @Override
            public void onDelete(QQDeleteAdapter.NormalHolder holder) {
                Toast.makeText(QQDeleteActivity.this,"点击delete",Toast.LENGTH_SHORT).show();
                /**
                 * 使用ItemTouchHelperExtension实现
                 */
                mDatas.remove(holder);
                adapter.notifyItemRemoved(holder.getAdapterPosition());
            }

            @Override
            public void onRefresh(QQDeleteAdapter.NormalHolder holder) {
                Toast.makeText(QQDeleteActivity.this,"点击refresh",Toast.LENGTH_SHORT).show();
                /**
                 * 使用ItemTouchHelperExtension实现
                 */
                mItemTouchHelperExtension.closeOpened();
            }
        });
        mRecyclerView.setAdapter(adapter);

        /**
         * 使用ItemTouchHelper实现
         */
//        mItemTouchHelper = new ItemTouchHelper(new QQDeleteTouchHelperCallBack(mDatas,adapter));
//        mItemTouchHelper.attachToRecyclerView(mRecyclerView);

        /**
         * 使用ItemTouchHelperExtension实现
         */
        mItemTouchHelperExtension = new ItemTouchHelperExtension(new QQDeleteTouchHelperCallBack(mDatas,adapter));
        mItemTouchHelperExtension.attachToRecyclerView(mRecyclerView);
    }

    private void generateDatas() {
        for (int i = 0; i < 200; i++) {
            mDatas.add("第 " + i + " 个item");
        }
    }
}
