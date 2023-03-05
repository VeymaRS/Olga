package com.weymar87.base;

public enum SoilTypes {
    SAND("1", "Пески крупные и средней крупности"),
    FINESAND("2", "Пески мелкие и пылеватые"),
    SILT("3", "Супеси"),
    LEANCLAY("4", "Суглинки и глины");

    private String code;
    private String text;

    private SoilTypes(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public static SoilTypes getByCode(String genderCode) {
        for (SoilTypes g : SoilTypes.values()) {
            if (g.code.equals(genderCode)) {
                return g;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
