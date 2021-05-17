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
import edu.uw.tcss450.chatapp.databinding.FragmentWeatherHourlyCardBinding;

public class WeatherHourlyRecyclerViewAdapter extends
        RecyclerView.Adapter<WeatherHourlyRecyclerViewAdapter.WeatherViewHolder> {
    private final List<WeatherData> mWeathers;

    public WeatherHourlyRecyclerViewAdapter(List<WeatherData> items) {
        this.mWeathers = items;
    }

    @NonNull
    @Override
    public WeatherHourlyRecyclerViewAdapter.WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WeatherHourlyRecyclerViewAdapter.WeatherViewHolder(LayoutInflater
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
     * of rows in the hourly Recycler View.
     */
    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public FragmentWeatherHourlyCardBinding binding;
        private WeatherData mWeather;

        public WeatherViewHolder(View view) {
            super(view);
            mView = view;
            binding = FragmentWeatherHourlyCardBinding.bind(view);
        }

        /**
         * helps to set the hourly weather components
         * @param weather
         */
        void setWeather(final WeatherData weather) {
            mWeather = weather;
            binding.textTemperature.setText(mWeather.getmTemperature());
            binding.textCondition.setText(mWeather.getmCondition());
            binding.textWeatherTime.setText(mWeather.getmTime());
        }
    }
}
