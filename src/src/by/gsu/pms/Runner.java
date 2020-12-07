package src.by.gsu.pms;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.management.BufferPoolMXBean;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import src.by.gsu.pms.GsonFromJsonParser;

import static src.by.gsu.pms.GsonFromJsonParser.jsonToMap;


public class Runner {
    public static void main(String[] args) {

        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Phoenix&appid=989ed7064d6beb849e12cefd56865c94");
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            //System.out.println(result);

            Map<String, Object> respMap = jsonToMap(result.toString());
            Object city = respMap.get("name");
            List<Object> weatherList = (List<Object>) respMap.get("weather");
            Map<String, Object> weatherMap = (Map<String, Object>) weatherList.get(0);
            String icon = String.valueOf(weatherMap.get("icon"));

            Map<String, Object> cloudsMap = jsonToMap(respMap.get("clouds").toString());
            Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
            Map<String, Object> sysMap = jsonToMap(respMap.get("sys").toString());
            Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());

            try {
                FileWriter widget = new FileWriter("index.html");
                widget.write(
                        "<html>" +
                                "<head>" +
                                "<title>Погода</title>" +
                                "</head>" +
                                "<body>" +
                                "<p>• Название города: " + respMap.get("name") + "</p>" +
                                "<p>• Код страны в котором он расположен: " + sysMap.get("id") + "</p>" +
                                "<p>• Иконка с отображением текущей погоды: " + weatherMap.get("icon") + "</p>" +
                                "<p>• Краткое и расширенное описание погоды: " + weatherMap.get("main") + ", " + weatherMap.get("description") + "</p>" +
                                "<p>• Текущая температура: " + mainMap.get("temp") + "</p>" +
                                "<p>• Давление в мм ртутного столба: " + mainMap.get("pressure") + "</p>" +
                                "<p>• Влажность в процентах: " + mainMap.get("humidity") + "</p>" +
                                "<p>• Минимальная и максимальная температура за сегодня: " + mainMap.get("temp_min") + ", " + mainMap.get("temp_max") + "</p>" +
                                "<p>• Скорость и направление ветра : " + windMap.get("speed") + ", " + windMap.get("deg") + "</p>" +
                                "<p>• Облачность в процентах: " + cloudsMap.get("all") + "</p>" +
                                "</body>" +
                                "</html>"
                );
                widget.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

