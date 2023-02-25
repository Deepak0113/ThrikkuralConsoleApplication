package com.thirrukural.home;

import com.thirrukural.repository.Repository;

public class HomeModel implements HomeModelCallback {
    HomeModelControllerCallback homeController;

    HomeModel(HomeModelControllerCallback homeController) {
        this.homeController = homeController;
    }

    @Override
    public void getApiData() {
        Repository.getInstance();
    }
}