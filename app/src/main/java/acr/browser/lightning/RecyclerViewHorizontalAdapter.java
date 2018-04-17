package acr.browser.lightning;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mopub.mobileads.MoPubView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class RecyclerViewHorizontalAdapter extends RecyclerView.Adapter<RecyclerViewHorizontalAdapter.MoPubHolder> {

    private List<String> adsIDList;
    private boolean loadingAds = false;
    private Context context;

    public RecyclerViewHorizontalAdapter() {
        this.adsIDList = new ArrayList<>();
    }

    public void setAdsIDList(List<String> adsIDList) {
        this.adsIDList = adsIDList;
    }


    @Override
    public MoPubHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(acr.browser.lightning.R.layout.item_recycler_view_horizontal, parent, false);
        return new MoPubHolder(v);
    }

    @Override
    public void onBindViewHolder(MoPubHolder holder, int position) {
        holder.moPubView = new MoPubView(context);
        holder.moPubView.setAdUnitId(adsIDList.get(position));
        holder.moPubView.loadAd();
       /* if (loadingAds) {
            moPubView.loadAd();
        }*/
    }

    public void loadAds() {
       /* loadingAds = true;
        notifyDataSetChanged();*/
    }

    @Override
    public int getItemCount() {
        return adsIDList.size();
    }

    static class MoPubHolder extends RecyclerView.ViewHolder {
        @BindView(acr.browser.lightning.R.id.ad_view_recycler_horizontal_item)
        MoPubView moPubView;

        public MoPubHolder(View itemView) {
            super(itemView);
        }
    }
}
