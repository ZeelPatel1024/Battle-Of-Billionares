package com.example.demo;

import java.util.ArrayList;

public class Abilities {
    private String typeOfAbility;
    private int healthDamageOfAbility;
    private int armyDamage;
    //impact on ego
    //impact on tolerance
    //impact on defence

    public Abilities(String ability, int hDamage, int aD){

        typeOfAbility = ability;
        healthDamageOfAbility = hDamage;
        armyDamage = aD;

    }

    public int getArmyDamage() {
        return armyDamage;
    }

    public void setArmyDamage(int armyDamage) {
        this.armyDamage = armyDamage;
    }

    public int getHealthDamageOfAbility() {
        return healthDamageOfAbility;
    }

    public void setHealthDamageOfAbility(int healthDamageOfAbility) {
        this.healthDamageOfAbility = healthDamageOfAbility;
    }

    public String getTypeOfAbility() {
        return typeOfAbility;
    }

    public void setTypeOfAbility(String typeOfAbility) {
        this.typeOfAbility = typeOfAbility;
    }
}
