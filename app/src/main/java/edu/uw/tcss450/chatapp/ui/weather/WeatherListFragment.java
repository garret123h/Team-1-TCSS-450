package edu.uw.tcss450.chatapp.ui.weather;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.uw.tcss450.chatapp.R;
import edu.uw.tcss450.chatapp.databinding.FragmentWeatherListBinding;
import edu.uw.tcss450.chatapp.model.UserInfoViewModel;

/**
 * A simple {@link Fragment} subclass.

 */
public class WeatherListFragment extends Fragment {
    private WeatherListViewModel mModel;
    private List<WeatherPost> listItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_list, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentWeatherListBinding binding = FragmentWeatherListBinding.bind(getView());
        //create dummy data for hourly weather
        List<WeatherPost> listItemsHourly = new ArrayList<>();
        for(int i = 0; i<= 23; i++){
            WeatherPost listItem = new WeatherPost(
                    "03:00 am", "66",
                    "Tacoma", "Sunny", "56", "75", "05/13/2021");
            listItemsHourly.add(listItem);
        }
        //create dummy data for daily weather
        List<WeatherPost> listItemsDaily = new ArrayList<>();
        for(int i = 0; i<= 9; i++){
            WeatherPost listItem = new WeatherPost(
                    "03:00 am", "66",
                    "Tacoma", "Sunny", "56", "75", "05/13/2021");
            listItemsDaily.add(listItem);
        }

        binding.hourlyListRoot.setAdapter(new WeatherHourlyRecyclerViewAdapter(listItemsHourly));
        binding.dailyListRoot.setAdapter(new WeatherDailyRecyclerViewAdapter(listItemsDaily));


        binding.buttonZipcodeSearch.setOnClickListener(button ->
                Navigation.findNavController(getView()).navigate(
                        WeatherListFragmentDirections.actionNavigationWeatherToWeatherMapFragment())
        );
        binding.buttonMap.setOnClickListener(button ->
                Navigation.findNavController(getView()).navigate(
                        WeatherListFragmentDirections.actionNavigationWeatherToWeatherMapFragment())
        );



    }


}