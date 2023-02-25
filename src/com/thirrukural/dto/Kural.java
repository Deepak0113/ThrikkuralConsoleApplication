package com.thirrukural.dto;

public class Kural {
    private final String number;
    private final String tamilLine1;
    private final String tamilLine2;
    private final String tamilExplanation;
    private final String englishTranslation;
    private final String englishExplanation;
    private final String paulName;
    private final String iyalName;
    private final String adikaramName;

    public Kural(String number, String tamilLine1, String tamilLine2, String tamilExplanation, String englishTranslation, String englishExplanation, String paulName, String iyalName, String adikaramName) {
        this.number = number;
        this.tamilLine1 = tamilLine1;
        this.tamilLine2 = tamilLine2;
        this.tamilExplanation = tamilExplanation;
        this.englishTranslation = englishTranslation;
        this.englishExplanation = englishExplanation;
        this.paulName = paulName;
        this.iyalName = iyalName;
        this.adikaramName = adikaramName;
    }


    @Override
    public String toString() {
        String br = "\n----------------------------------------------------------------------\n";
        String number = this.number + " வது திருக்குறள்\n";
        String adikaramStr = "அதிகாரம்: "+adikaramName+"\n";
        String paulStr = "பால்: "+paulName+"\n";
        String iyalStr = "இயல்: "+iyalName+"\n";
        String langTamil = "தமிழ்\n\n";
        String line1Str = "\033[1;33m"+tamilLine1+"\n";
        String line2Str = "\033[1;33m"+tamilLine2+"\n";
        String tamilMeaning = "\n\033[0;97mபொருள்: "+tamilExplanation+"\n";
        String langEng = "English\n\n";
        String engStr = "\033[1;33m"+englishTranslation+"\n";
        String engMeaning = "\n\033[0;97mExplanation: "+englishExplanation;

        return br
                + number + adikaramStr + paulStr + iyalStr
                + br
                + langTamil + line1Str + line2Str + tamilMeaning
                + br
                + langEng + engStr + engMeaning;
    }
}