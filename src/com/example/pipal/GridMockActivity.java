package com.example.pipal;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;

public class GridMockActivity extends Activity {
    GridView gv1;
    
    int[] images = new int[] {R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m
    };
    Gallery g[] = new Gallery[10];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gv1 = (GridView)findViewById(R.id.grid_view1);
        gv1.setAdapter(new HAdapter());

       for (int i = 0; i < g.length; i++) {
            g[i] = new Gallery(this);
            g[i].setAdapter(new VAdapter());
            g[i].setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1,
                        int arg2, long arg3) {
                    Intent intent = new Intent(GridMockActivity.this, DisplayActivity.class);
                    intent.putExtra("Image Int", images[arg2]);
                    startActivity(intent);
                    
                }
            });
            g[i].setOnTouchListener(new OnTouchListener() {
                @Override 
                public boolean onTouch(View arg0, MotionEvent ev) {
                    if (ev.getAction() == MotionEvent.ACTION_UP) {
                        for (int j = 0; j < g.length; j++) {
                            g[j].setSelection(((AdapterView)arg0).getSelectedItemPosition());
                        }
                    }
                    return false;
                }
            });
        }
    }

    private class HAdapter extends BaseAdapter {
        public HAdapter() {}
        @Override public int getCount() {return g.length;}
        @Override public Object getItem(int pos) {return pos;}
        @Override public long getItemId(int pos) {return pos;}
        @Override public View getView(final int pos, View convertView, ViewGroup parent) {
            g[pos].setLayoutParams(new GridView.LayoutParams(gv1.getWidth(), gv1.getHeight()/3));
            return g[pos];
        }

    }

    private class VAdapter extends BaseAdapter {
        
        public VAdapter() {}
        @Override public int getCount() {return images.length;}
        @Override public Object getItem(int pos) {return pos;}
        @Override public long getItemId(int pos) {return pos;}
        @Override public View getView(final int pos, View convertView, ViewGroup parent) {
            ImageView mImage = new ImageView(GridMockActivity.this);
            mImage.setBackgroundResource(images[pos]);
            mImage.setLayoutParams(new Gallery.LayoutParams(gv1.getWidth()/ 3, gv1.getHeight()/3));
            mImage.setAdjustViewBounds(true);
            return mImage;
        }
    }
}