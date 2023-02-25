package com.thirrukural.kural;

import com.thirrukural.dto.Kural;

public interface KuralViewCallback {

    void invalidOption();

    void getKural(int parseInt);

    void getKuralSuccess(Kural kural);
}