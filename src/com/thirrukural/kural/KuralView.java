package com.thirrukural.kural;

import com.thirrukural.dto.Kural;
import com.thirrukural.home.HomeView;

import java.util.Scanner;

public class KuralView implements KuralViewCallback {
    private KuralViewControllerCallback kuralController;
    private final Scanner scanner = new Scanner(System.in);

    public KuralView() {
        kuralController = new KuralController(this);
    }

    public static void main(String[] args) {
        new KuralView().startKuralView();
    }

    public void startKuralView(){
        System.out.println("\nதிருக்குறள் எண் வாரியான தேடலை தேர்ந்தெடுத்துள்ளீர்கள்");
        System.out.println("திருக்குறள் எண்ணை(1-1330) உள்ளிடவும்");
        System.out.print("திருக்குறள் எண்: ");
        String option = scanner.nextLine();

        kuralController.chooseOption(option);
    }

    @Override
    public void getKural(int parseInt) {
        kuralController.getKural(parseInt);
    }

    @Override
    public void getKuralSuccess(Kural kural) {
        System.out.println("controller->view");
        System.out.println(kural);

        HomeView homeView = new HomeView();
        homeView.startHome();
    }

    @Override
    public void invalidOption() {
        System.out.println("");
    }
}