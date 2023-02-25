package com.thirrukural.kural;

import com.thirrukural.dto.Kural;
import com.thirrukural.repository.Repository;
import org.json.simple.JSONObject;

public class KuralModel implements KuralModelCallback {
    KuralModelControllerCallback kuralController;

    KuralModel(KuralModelControllerCallback kuralController) {
        this.kuralController = kuralController;
    }

    @Override
    public void getKural(int kuralNum) {
        JSONObject jsonObject = Repository.getInstance().getKural(kuralNum);

        Kural kural = new Kural(
                jsonObject.get("Number").toString(),
                jsonObject.get("Line1").toString(),
                jsonObject.get("Line2").toString(),
                jsonObject.get("mv").toString(),
                jsonObject.get("Translation").toString(),
                jsonObject.get("explanation").toString(),
                jsonObject.get("paul_name").toString(),
                jsonObject.get("iyal_name").toString(),
                jsonObject.get("adikaram_name").toString()
        );

        kuralController.getKuralSuccess(kural);
    }
}