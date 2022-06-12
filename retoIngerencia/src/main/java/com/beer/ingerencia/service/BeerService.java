package com.beer.ingerencia.service;

import com.beer.ingerencia.model.Beer;
import com.beer.ingerencia.model.Data;
import com.beer.ingerencia.model.Information;
import com.beer.ingerencia.model.Ingredient;
import com.beer.ingerencia.model.Method;
import com.beer.ingerencia.model.Temp;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class BeerService {
    @Value("${service.url1}")
    private String urlBeers;
    @Value("${service.url2}")
    private String urlBeersRandom;

    public List<Beer> findAllBeers(){
        //Se agrego lo siguiente al link para que se puedan mostrar las 80 cervezas de la primera pagina
        String newURL = urlBeers + "?page=1&per_page=80";
        List<Beer> listBeer = new ArrayList<>();
        try
        { //Se realiza la conexion con la api externa
            URL url = new URL(newURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Se llama al metodo privado para realizar la conexion
            JSONArray array = connection(conn);
            int lengthArray = array.length();
            for(int i=0; i<lengthArray; i++){
                //Object posee el json recibido, ahora solo se necesita llenar uno por uno los datos al objeto beer
                JSONObject object = array.getJSONObject(i);
                Beer beer = new Beer();
                fillBeer(object, beer);
                listBeer.add(beer);
            }
            conn.disconnect();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return listBeer;
    }

    public List<Beer> findBeersByName(String name){
        //Se agrego lo siguiente al link para que se pueda utilizar la busqueda documentada en la api
        String newURL = urlBeers + "?beer_name=" + name;
        List<Beer> listBeer = new ArrayList<>();
        try
        { //Se realiza la conexion con la api externa
            URL url = new URL(newURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Se llama al metodo privado para realizar la conexion
            JSONArray array = connection(conn);
            int lengthArray = array.length();
            for(int i=0; i<lengthArray; i++){
                //Object posee el json recibido, ahora solo se necesita llenar uno por uno los datos al objeto beer
                JSONObject object = array.getJSONObject(i);
                Beer beer = new Beer();
                fillBeer(object, beer);
                listBeer.add(beer);
            }
            conn.disconnect();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return listBeer;
    }

    public Beer findBeerRandom(){
        Beer beer = new Beer();
        try
        { //Se realiza la conexion con la api externa
            URL url = new URL(urlBeersRandom);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Se llama al metodo privado para realizar la conexion
            JSONArray array = connection(conn);
            JSONObject object = array.getJSONObject(0);
            //Object posee el json recibido, ahora solo se necesita llenar los datos al objeto beer
            fillBeer(object, beer);
            conn.disconnect();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return beer;
    }

    private JSONArray connection(HttpURLConnection conn) throws IOException {
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = br.read()) != -1)
        {
            sb.append((char) cp);
        }
        String output = sb.toString();
        JSONArray array = new JSONArray(output);
        return array;
    }

    //Este metodo privado se utiliza unicamente para convertir los datos recibidos al tipo de dato Beer
    //por lo que las 3 apis implementadas hacen uso de este metodo
    private void fillBeer(JSONObject object, Beer beer){
        //Se llena el objeto beer con los datos del json enviado de manera secuencial
        beer.setIdBeer(object.getInt("id"));
        beer.setName(object.getString("name"));
        beer.setTagline(object.getString("tagline"));
        beer.setFirst_brewed(object.getString("first_brewed"));
        beer.setDescription(object.getString("description"));
        if(object.get("image_url")!=JSONObject.NULL) beer.setImage_url(object.getString("image_url"));
        if(object.get("abv")!=JSONObject.NULL) beer.setAbv(object.getDouble("abv"));
        if(object.get("ibu")!=JSONObject.NULL) beer.setIbu(object.getDouble("ibu"));
        if(object.get("target_fg")!=JSONObject.NULL) beer.setTarget_fg(object.getDouble("target_fg"));
        if(object.get("target_og")!=JSONObject.NULL) beer.setTarget_og(object.getDouble("target_og"));
        if(object.get("ebc")!=JSONObject.NULL) beer.setEbc(object.getDouble("ebc"));
        if(object.get("srm")!=JSONObject.NULL) beer.setSrm(object.getDouble("srm"));
        if(object.get("ph")!=JSONObject.NULL) beer.setPh(object.getDouble("ph"));
        if(object.get("attenuation_level")!=JSONObject.NULL) beer.setAttenuation_level(object.getDouble("attenuation_level"));

        //Se llena volume
        Data d = new Data();
        if(object.getJSONObject("volume").get("value")!=JSONObject.NULL) d.setValue(object.getJSONObject("volume").getDouble("value"));
        if(object.getJSONObject("volume").get("unit")!=JSONObject.NULL) d.setUnit(object.getJSONObject("volume").getString("unit"));
        beer.setVolume(d);

        //Se llena boil_volume
        Data d2 = new Data();
        if(object.getJSONObject("volume").get("value")!=JSONObject.NULL) d2.setValue(object.getJSONObject("boil_volume").getDouble("value"));
        if(object.getJSONObject("volume").get("unit")!=JSONObject.NULL) d2.setUnit(object.getJSONObject("boil_volume").getString("unit"));
        beer.setBoil_volume(d2);

        //Se llena method
        List<Temp> listTemp = new ArrayList<>();
        int lengthTemp = object.getJSONObject("method").getJSONArray("mash_temp").length();
        for(int i=0; i<lengthTemp; i++) {
            Temp temp = new Temp();
            Data data = new Data();
            if(object.getJSONObject("method").getJSONArray("mash_temp").getJSONObject(i).getJSONObject("temp").get("value")!=JSONObject.NULL)
                data.setValue(object.getJSONObject("method").getJSONArray("mash_temp").getJSONObject(i).getJSONObject("temp").getDouble("value"));
            if(object.getJSONObject("method").getJSONArray("mash_temp").getJSONObject(i).getJSONObject("temp").get("unit")!=JSONObject.NULL)
                data.setUnit(object.getJSONObject("method").getJSONArray("mash_temp").getJSONObject(i).getJSONObject("temp").getString("unit"));
            temp.setTemp(data);
            if(object.getJSONObject("method").getJSONArray("mash_temp").getJSONObject(i).get("duration") != JSONObject.NULL){
                temp.setDuration(object.getJSONObject("method").getJSONArray("mash_temp").getJSONObject(i).getDouble("duration"));
            }
            listTemp.add(temp);
        }
        Temp temp = new Temp();
        Data d4 = new Data();
        if(object.getJSONObject("method").getJSONObject("fermentation").getJSONObject("temp").get("value")!=JSONObject.NULL)
            d4.setValue(object.getJSONObject("method").getJSONObject("fermentation").getJSONObject("temp").getDouble("value"));
        if(object.getJSONObject("method").getJSONObject("fermentation").getJSONObject("temp").get("unit")!=JSONObject.NULL)
            d4.setUnit(object.getJSONObject("method").getJSONObject("fermentation").getJSONObject("temp").getString("unit"));
        temp.setTemp(d4);
        Method m = new Method();
        m.setMash_temp(listTemp);
        m.setFermentation(temp);
        if(object.getJSONObject("method").get("twist") != JSONObject.NULL){
            m.setTwist(object.getJSONObject("method").getString("twist"));
        }
        beer.setMethod(m);

        //Se llena ingredients
        List<Information> listInformation = new ArrayList<>();
        int lengthInformation = object.getJSONObject("ingredients").getJSONArray("malt").length();
        for(int i=0; i<lengthInformation; i++) {
            Information information = new Information();
            information.setName(object.getJSONObject("ingredients").getJSONArray("malt").getJSONObject(i).getString("name"));
            Data data = new Data();
            if(object.getJSONObject("ingredients").getJSONArray("malt").getJSONObject(i).getJSONObject("amount").get("value")!=JSONObject.NULL)
                data.setValue(object.getJSONObject("ingredients").getJSONArray("malt").getJSONObject(i).getJSONObject("amount").getDouble("value"));
            if(object.getJSONObject("ingredients").getJSONArray("malt").getJSONObject(i).getJSONObject("amount").get("unit")!=JSONObject.NULL)
                data.setUnit(object.getJSONObject("ingredients").getJSONArray("malt").getJSONObject(i).getJSONObject("amount").getString("unit"));
            information.setAmount(data);
            listInformation.add(information);
        }
        List<Information> listInformation2 = new ArrayList<>();
        int lengthInformation2 = object.getJSONObject("ingredients").getJSONArray("hops").length();
        for(int i=0; i<lengthInformation2; i++) {
            Information information = new Information();
            information.setName(object.getJSONObject("ingredients").getJSONArray("hops").getJSONObject(i).getString("name"));
            Data data = new Data();
            if(object.getJSONObject("ingredients").getJSONArray("hops").getJSONObject(i).getJSONObject("amount").get("value")!=JSONObject.NULL)
                data.setValue(object.getJSONObject("ingredients").getJSONArray("hops").getJSONObject(i).getJSONObject("amount").getDouble("value"));
            if(object.getJSONObject("ingredients").getJSONArray("hops").getJSONObject(i).getJSONObject("amount").get("unit")!=JSONObject.NULL)
                data.setUnit(object.getJSONObject("ingredients").getJSONArray("hops").getJSONObject(i).getJSONObject("amount").getString("unit"));
            information.setAmount(data);
            information.setAdd(object.getJSONObject("ingredients").getJSONArray("hops").getJSONObject(i).getString("add"));
            information.setAttribute(object.getJSONObject("ingredients").getJSONArray("hops").getJSONObject(i).getString("attribute"));
            listInformation2.add(information);
        }
        Ingredient ingredients = new Ingredient();
        ingredients.setMalt(listInformation);
        ingredients.setHops(listInformation2);
        ingredients.setYeast(object.getJSONObject("ingredients").getString("yeast"));
        beer.setIngredients(ingredients);

        //Se llena food_pairing
        List<String> food_pairing = new ArrayList<>();
        int lengthFood = object.getJSONArray("food_pairing").length();
        for(int i=0; i<lengthFood; i++) {
            food_pairing.add(object.getJSONArray("food_pairing").getString(i));
        }
        beer.setFood_pairing(food_pairing);
        beer.setBrewers_tips(object.getString("brewers_tips"));
        beer.setContributed_by(object.getString("contributed_by"));
    }
}
