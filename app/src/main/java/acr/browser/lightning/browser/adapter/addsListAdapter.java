package acr.browser.lightning.browser.adapter;

import acr.browser.lightning.R;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.mopub.mobileads.MoPubView;

import java.util.List;

/**
 * Created by Marcos on 04/10/2017.
 */

public class addsListAdapter extends RecyclerView.Adapter {

    @NonNull
    private final Context mContext;
    private boolean bIsVertical;

    public List<String> adds;
    //private MoPubView moPubView;

    public addsListAdapter(@NonNull Context context, boolean isVertical) {
        this.mContext = context;
        this.bIsVertical = isVertical;
    }

    public int getCount() {
        return adds.size();
    }

    /*public Object getItem(int i) {
        return adds.get(i);
    }*/

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adds_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        if (!this.bIsVertical)
            v.getLayoutParams().width = (int) (getScreenWidth() / 3); /// THIS LINE WILL DIVIDE OUR VIEW INTO NUMBERS OF PARTS
        else
            v.getLayoutParams().height = (int) (getScreenHeight() / 10); /// THIS LINE WILL DIVIDE OUR VIEW INTO NUMBERS OF PARTS

        MyViewHolder vh = new MyViewHolder(v) {
            @Override
            public String toString() {
                return super.toString();
            }
        };
        return vh;
    }

    public int getScreenWidth() {

        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size.x;
    }

    public int getScreenHeight() {

        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size.y;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        //((MyViewHolder) holder).add.setAdUnitId(this.adds.get(position)); // Enter your Ad Unit ID from www.mopub.com
        //((MyViewHolder) holder).add.loadAd();
        //((MyViewHolder) holder).add.setClickable(true);
        AdRequest adRequest = new AdRequest.Builder().build();
        ((MyViewHolder) holder).add.loadAd(adRequest);
        //((MyViewHolder) holder).add.setClickable(true);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return adds.size();
    }

    /*public View getView(int i, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null)
        {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(R.layout.adds_list_item, parent, false);
        }

        moPubView = view.findViewById(R.id.adview);
        moPubView.setAdUnitId(this.adds.get(i)); // Enter your Ad Unit ID from www.mopub.com
        moPubView.loadAd();

        return view;
    }*/

    class MyViewHolder extends RecyclerView.ViewHolder {

        //MoPubView add;
        AdView add;

        public MyViewHolder(View itemView) {
            super(itemView);

            //add = itemView.findViewById(R.id.adview);//change Here
            add = itemView.findViewById(R.id.ad_browser);
            /*add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "ad número" + getAdapterPosition(), Toast.LENGTH_SHORT);
                }
            });*/
        }
    }
}
