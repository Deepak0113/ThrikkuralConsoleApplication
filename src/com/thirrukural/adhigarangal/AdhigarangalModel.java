package com.thirrukural.adhigarangal;

import com.thirrukural.dto.Kural;
import com.thirrukural.repository.Repository;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AdhigarangalModel implements AdhigarangalModelCallback {
    AdhigarangalModelControllerCallback adhigarangalController;

    AdhigarangalModel(AdhigarangalModelControllerCallback adhigarangalController) {
        this.adhigarangalController = adhigarangalController;
    }

    @Override
    public void getAdigarangal(int parseInt) {
        List<JSONObject> array = Repository.getInstance().getAdigarangalKural(parseInt);
        List<Kural> kuralList = new ArrayList<>();

        for(JSONObject jsonObject: array){
            kuralList.add(new Kural(
                    jsonObject.get("Number").toString(),
                    jsonObject.get("Line1").toString(),
                    jsonObject.get("Line2").toString(),
                    jsonObject.get("mv").toString(),
                    jsonObject.get("Translation").toString(),
                    jsonObject.get("explanation").toString(),
                    jsonObject.get("paul_name").toString(),
                    jsonObject.get("iyal_name").toString(),
                    jsonObject.get("adikaram_name").toString()
            ));
        }

        adhigarangalController.adhigarangalKural(kuralList);
    }
}