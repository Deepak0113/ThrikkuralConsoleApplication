package com.thirrukural.home;

import com.thirrukural.adhigarangal.AdhigarangalView;
import com.thirrukural.dailykural.DailyKuralView;
import com.thirrukural.kural.KuralView;

import java.util.Scanner;

public class HomeView implements HomeViewCallback {
    private HomeViewControllerCallback homeController;
    private final Scanner scanner = new Scanner(System.in);

    public HomeView() {
        homeController = new HomeController(this);
    }

    public void startHome(){
        System.out.println("\n\n\033[1;34m\t\t\tதிருக்குறள் விண்ணப்பத்திற்கு வரவேற்கிறோம்\n");
        System.out.println("\033[0;97m1. திருக்குறளைத் எண் வாரியாக தேட");
        System.out.println("\033[0;97m2. திருக்குறள் அதிகாரங்கள் வாரியாக பார்க்க");
        System.out.println("\033[0;97m3. அன்றைய திருக்குறள் பார்க்க");
        System.out.print("\033[0;97mவிருப்பத்தை தேர்வு: ");
        homeController.getApiDate();
        String option = scanner.nextLine();

        homeController.chooseOption(option);
    }

    @Override
    public void gotoAdhigarangalModule() {
        AdhigarangalView adhigarangalView = new AdhigarangalView();
        adhigarangalView.startAdhigarangalModule();
    }

    @Override
    public void gotoKuralModule() {
        KuralView kuralView = new KuralView();
        kuralView.startKuralView();
    }

    @Override
    public void gotoDailyKuralModule() {
        DailyKuralView dailyKuralView = new DailyKuralView();
        dailyKuralView.startDailyKuralModule();
    }

    @Override
    public void invalidOption() {
        System.out.println("");
    }
}