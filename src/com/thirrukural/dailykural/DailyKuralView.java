package com.thirrukural.dailykural;

import com.thirrukural.dto.Kural;
import com.thirrukural.home.HomeView;

public class DailyKuralView implements DailyKuralViewCallback {
    private DailyKuralViewControllerCallback dailyKuralController;

    public DailyKuralView() {
        dailyKuralController = new DailyKuralController(this);
    }

    public void startDailyKuralModule(){
        dailyKuralController.dailyKural();
    }

    @Override
    public void viewDailyKural(Kural kural) {
        System.out.println(kural);

        HomeView homeView = new HomeView();
        homeView.startHome();
    }
}