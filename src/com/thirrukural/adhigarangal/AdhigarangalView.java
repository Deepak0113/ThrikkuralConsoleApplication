package com.thirrukural.adhigarangal;

import com.thirrukural.dto.Kural;
import com.thirrukural.home.HomeView;

import java.util.List;
import java.util.Scanner;

public class AdhigarangalView implements AdhigarangalViewCallback {
    private AdhigarangalViewControllerCallback adhigarangalController;
    private final Scanner scanner = new Scanner(System.in);

    public AdhigarangalView() {
        adhigarangalController = new AdhigarangalController(this);
    }

    public void startAdhigarangalModule(){
        System.out.println("\nஅதிகாரம் வாரியான தேடலை தேர்ந்தெடுத்துள்ளீர்கள்");
        System.out.println("அதிகாரம் எண்ணை(1-133) உள்ளிடவும்");
        System.out.print("அதிகாரம் எண்: ");
        String option = scanner.nextLine();

        adhigarangalController.chooseOption(option);
    }

    @Override
    public void adhigarangalKural(List<Kural> kuralList) {
        for(Kural kural: kuralList){
            System.out.println(kural);
        }

        HomeView homeView = new HomeView();
        homeView.startHome();
    }
}