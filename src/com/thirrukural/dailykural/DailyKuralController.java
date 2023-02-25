package com.thirrukural.dailykural;

import com.thirrukural.dto.Kural;

public class DailyKuralController implements DailyKuralViewControllerCallback, DailyKuralModelControllerCallback {
    private DailyKuralViewCallback dailyKuralView;
    private DailyKuralModelCallback dailyKuralModel;

    DailyKuralController(DailyKuralViewCallback dailyKuralView) {
        this.dailyKuralView = dailyKuralView;
        dailyKuralModel = new DailyKuralModel(this);
    }

    @Override
    public void dailyKural() {
        dailyKuralModel.dailyKural();
    }

    @Override
    public void viewDailyKural(Kural kural) {
        dailyKuralView.viewDailyKural(kural);
    }
}