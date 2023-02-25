package com.thirrukural.kural;

import com.thirrukural.dto.Kural;

public class KuralController implements KuralViewControllerCallback, KuralModelControllerCallback {
    private KuralViewCallback kuralView;
    private KuralModelCallback kuralModel;

    KuralController(KuralViewCallback kuralView) {
        this.kuralView = kuralView;
        kuralModel = new KuralModel(this);
    }

    @Override
    public void chooseOption(String option) {
        kuralView.getKural(Integer.parseInt(option));
    }

    @Override
    public void getKural(int parseInt) {
        kuralModel.getKural(parseInt);
    }

    @Override
    public void getKuralSuccess(Kural kural) {
        kuralView.getKuralSuccess(kural);
    }
}