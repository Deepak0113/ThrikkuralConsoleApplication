package com.thirrukural.dailykural;

import com.thirrukural.dto.Kural;
import com.thirrukural.repository.Repository;
import org.json.simple.JSONObject;

public class DailyKuralModel implements DailyKuralModelCallback {
    DailyKuralModelControllerCallback dailyKuralController;

    DailyKuralModel(DailyKuralModelControllerCallback dailyKuralController) {
        this.dailyKuralController = dailyKuralController;
    }

    @Override
    public void dailyKural() {
        JSONObject jsonObject = Repository.getInstance().getDailyKural();

        dailyKuralController.viewDailyKural(new Kural(
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
}