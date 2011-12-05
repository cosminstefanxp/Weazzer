package weazzer.gui;

import java.util.ArrayList;

import weazzer.weather.WeatherForecast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class WeatherForecastAdapter extends BaseAdapter {
 private static ArrayList<WeatherForecast> forecast;
 
 private LayoutInflater mInflater;

 public WeatherForecastAdapter(Context context, ArrayList<WeatherForecast> results) {
  forecast = results;
  mInflater = LayoutInflater.from(context);
 }

 public int getCount() {
  return forecast.size();
 }

 public Object getItem(int position) {
  return forecast.get(position);
 }

 public long getItemId(int position) {
  return position;
 }

 public View getView(int position, View convertView, ViewGroup parent) {
  ViewHolder holder;
  if (convertView == null) {
   convertView = mInflater.inflate(R.layout.custom_row_view, null);
   holder = new ViewHolder();
   holder.forecastDate = (TextView) convertView.findViewById(R.id.forecastDate);   
   holder.tempMax = (TextView) convertView.findViewById(R.id.tempMax);
   holder.windSpeed = (TextView) convertView.findViewById(R.id.windSpeed);
   holder.tempMin = (TextView) convertView.findViewById(R.id.tempMin);
   holder.windDirection = (TextView) convertView.findViewById(R.id.windDirection);
   holder.weatherCondition = (TextView) convertView.findViewById(R.id.weatherCondition);

   convertView.setTag(holder);
  } else {
   holder = (ViewHolder) convertView.getTag();
  }
  
  holder.forecastDate.setText(forecast.get(position).getForecastDate().getTime().getDay()+"/"+forecast.get(position).getForecastDate().getTime().getMonth());
  holder.tempMax.setText(forecast.get(position).getTempMax().toString());
  holder.windSpeed.setText(forecast.get(position).getWindSpeed().toString());
  holder.tempMin.setText(forecast.get(position).getTempMin().toString());
  holder.windDirection.setText(forecast.get(position).getWindDirection().toString());
  holder.weatherCondition.setText(forecast.get(position).getWeatherCondition().toString());
  return convertView;
 }

 static class ViewHolder {
  TextView forecastDate; 
  TextView tempMax;
  TextView tempMin;
  TextView windSpeed;
  TextView windDirection;
  TextView weatherCondition;
 }
}