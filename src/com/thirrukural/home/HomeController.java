package com.thirrukural.home;

public class HomeController implements HomeViewControllerCallback, HomeModelControllerCallback {
    private HomeViewCallback homeView;
    private HomeModelCallback homeModel;

    HomeController(HomeViewCallback homeView) {
        this.homeView = homeView;
        homeModel = new HomeModel(this);
    }

    @Override
    public void chooseOption(String option) {
        switch(option){
            case "1" -> homeView.gotoKuralModule();
            case "2" -> homeView.gotoAdhigarangalModule();
            case "3" -> homeView.gotoDailyKuralModule();
            case "9" -> System.exit(0);
            default -> homeView.invalidOption();
        }
    }

    @Override
    public void getApiDate() {
        homeModel.getApiData();
    }
}