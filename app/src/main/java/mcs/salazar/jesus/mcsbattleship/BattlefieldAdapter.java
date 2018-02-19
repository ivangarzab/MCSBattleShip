package mcs.salazar.jesus.mcsbattleship;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import mcs.salazar.jesus.mcsbattleship.view.BattlefieldView;

public class BattlefieldAdapter extends BaseAdapter {

    private Context mContext;

    // Adapter should have access to this number somehow!
    private int mBattlefieldSize;

    public BattlefieldAdapter(Context context, int size) {
        mContext = context;
        mBattlefieldSize = size;
    }

    public int getCount() {
        return BattlefieldView.mThumbImages.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        // if there is a ship in this position
        if (BattlefieldView.mGrid[position / mBattlefieldSize][position % mBattlefieldSize]) {
            imageView.setImageResource(R.drawable.sample_1);
        }
        // else, set default/random background image
        else {
            imageView.setImageResource(BattlefieldView.mThumbImages[position]);
        }

        return imageView;
    }
}
