package edu.uw.tcss450.chatapp.ui.weather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import edu.uw.tcss450.chatapp.R;
import edu.uw.tcss450.chatapp.databinding.FragmentWeatherDailyCardBinding;

public class WeatherDailyRecyclerViewAdapter extends
        RecyclerView.Adapter<WeatherDailyRecyclerViewAdapter.WeatherViewHolder> {
    private final List<WeatherData> mWeathers;
    private final Map<WeatherData, Boolean> mExpandedFlags;

    public WeatherDailyRecyclerViewAdapter(List<WeatherData> items) {
        this.mWeathers = items;
        mExpandedFlags = mWeathers.stream()
                .collect(Collectors.toMap(Function.identity(), weather -> false));
    }

    @NonNull
    @Override
    public WeatherDailyRecyclerViewAdapter.WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WeatherDailyRecyclerViewAdapter.WeatherViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.fragment_weather_hourly_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        holder.setWeather(mWeathers.get(position));


    }

    @Override
    public int getItemCount() {
        return mWeathers.size();

    }
    /**
     * Objects from this class represent an Individual row View from the List
     * of rows in the Blog Recycler View.
     */
    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public FragmentWeatherDailyCardBinding binding;
        private WeatherData mWeather;

        public WeatherViewHolder(View view) {
            super(view);
            mView = view;
            binding = FragmentWeatherDailyCardBinding.bind(view);
        }


        /**
         * Helper used to determine if the preview should be displayed or not.
         */

        void setWeather(final WeatherData weather) {
            mWeather = weather;
        }
    }
}
