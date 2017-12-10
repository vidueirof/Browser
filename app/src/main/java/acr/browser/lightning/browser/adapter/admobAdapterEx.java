package acr.browser.lightning.browser.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.List;

import acr.browser.lightning.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class admobAdapterEx extends RecyclerView.Adapter<admobAdapterEx.MyViewHolder> {

    public List<String> IDsList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adds_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AdView adView = holder.addView;
        AdRequest adRequest = new AdRequest.Builder().build();
        //adView.setAdUnitId("ca-app-pub-7981205089259397/3311923894");
        //adView.setAdSize(AdSize.BANNER);
        adView.loadAd(adRequest);
    }

    @Override
    public int getItemCount() {
        return IDsList.size();
    }

    /*
        LinearLayout adContainer = <container>;
        AdView adView = new AdView(activity)
    adView.setAdSize(AdSize.SMART_BANNER);
    adView.setAdUnitId(<your-publisher-id>);

        // Initiate a generic request to load it with an ad
        AdRequest adRequest = new AdRequest();
    adRequest.addTestDevice(AdRequest.TEST_EMULATOR);
    adView.loadAd(adRequest);

        // Place the ad view.
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    adContainer.addView(adView, params);
    */
    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ad_browser)
        AdView addView;
        //AdView add;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            //add = itemView.findViewById(R.id.ad_browser);
        }
    }

}