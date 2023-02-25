package com.thirrukural.repository;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Repository {
    private static Repository repository;
    private JSONObject kural;
    private JSONObject adhigarangal;
    private JSONObject dailyKural;

    public static Repository getInstance(){
        if(repository == null){
            repository = new Repository();
            repository.initSetup();
        }

        return repository;
    }

    private void initSetup(){
        try {
            URL kuralUrl = new URL("https://deepak0113.github.io/ThirukkuralAPI/thirukkural.json");
            URL adikaramUrl = new URL("https://deepak0113.github.io/ThirukkuralAPI/thrikkural_adikaram.json");

            this.kural = getData(kuralUrl);
            this.adhigarangal = getData(adikaramUrl);

            this.dailyKural = getKural(ThreadLocalRandom.current().nextInt(0,1330));
        } catch (MalformedURLException e) {
        }
    }

    private JSONObject getData(URL url){
        JSONObject jsonObject = null;
        HttpURLConnection httpURLConnection = null;

        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();

            JSONParser jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(response.toString());
        } catch (ParseException | IOException e) {
        } finally {
            if(httpURLConnection!=null) httpURLConnection.disconnect();
        }

        return jsonObject;
    }

    public JSONObject getKural(int kuralNum) {
        JSONArray jsonArray = (JSONArray) kural.get("kural");
        return (JSONObject) jsonArray.get(kuralNum - 1);
    }

    public List<JSONObject> getAdigarangalKural(int adigaramNum) {
        JSONArray jsonArray = (JSONArray) adhigarangal.get("adhigarangal");
        String adhikaram = (String) jsonArray.get(adigaramNum-1);
        JSONObject object = (JSONObject) adhigarangal.get("kural");

        return (List<JSONObject>) object.get(adhikaram);
    }

    public JSONObject getDailyKural(){
        return dailyKural;
    }
}
