package com.thirrukural.adhigarangal;

import com.thirrukural.dto.Kural;

import java.util.List;

public class AdhigarangalController implements AdhigarangalViewControllerCallback, AdhigarangalModelControllerCallback {
    private AdhigarangalViewCallback adhigarangalView;
    private AdhigarangalModelCallback adhigarangalModel;

    AdhigarangalController(AdhigarangalViewCallback adhigarangalView) {
        this.adhigarangalView = adhigarangalView;
        adhigarangalModel = new AdhigarangalModel(this);
    }

    @Override
    public void chooseOption(String option) {
        adhigarangalModel.getAdigarangal(Integer.parseInt(option));
    }

    @Override
    public void adhigarangalKural(List<Kural> kuralList) {
        adhigarangalView.adhigarangalKural(kuralList);
    }
}