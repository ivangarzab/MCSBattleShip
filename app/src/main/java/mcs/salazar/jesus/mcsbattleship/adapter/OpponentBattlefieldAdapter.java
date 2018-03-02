package mcs.salazar.jesus.mcsbattleship.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;

import mcs.salazar.jesus.mcsbattleship.R;

public class OpponentBattlefieldAdapter extends BaseAdapter {

    private Context mContext;

    public boolean[][] mGrid;

    // Adapter should have access to this number somehow!
    private int mBattlefieldSize;

    public OpponentBattlefieldAdapter(Context context, int size, boolean[][] grid) {
        this.mContext = context;
        this.mBattlefieldSize = size;
        this.mGrid = grid;
    }

    public int getCount() {
        //return BattlefieldView.mThumbImages.length;
        return mGrid.length * mBattlefieldSize;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        //TODO: ClickListener / element!
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    (int) parent.getResources().getDimension(R.dimen.cell_size)));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setBackground(new ColorDrawable(parent.getResources()
                    .getColor(R.color.colorPrimaryDark)));
        } else {
            imageView = (ImageView) convertView;
        }

        // This spot has been shot
        if (mGrid[position / mBattlefieldSize][position % mBattlefieldSize]) {
            imageView.setImageResource(R.drawable.sample_1);
        }

        imageView.setOnClickListener(getOnClickListener());

        return imageView;
    }

    public View.OnClickListener getOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ImageView) view).setImageResource(R.drawable.sample_1);
            }
        };
    }
}
