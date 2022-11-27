package com.example.demo;

import java.util.ArrayList;

public class ArmyStats {
    private int armyBattleImpact;
    private int armyHealth;
    private int armyMorale;

    public ArmyStats(int armBaIm,int armHeal,int armMoral){

        armyBattleImpact = armBaIm;
        armyHealth = armHeal;
        armyMorale = armMoral;

    }

    public int getArmyBattleImpact() {
        return armyBattleImpact;
    }

    public void setArmyBattleImpact(int armyBattleImpact) {
        this.armyBattleImpact = armyBattleImpact;
    }

    public int getArmyHealth() {
        return armyHealth;
    }

    public void setArmyHealth(int armyHealth) {
        this.armyHealth = armyHealth;
    }

    public int getArmyMorale() {
        return armyMorale;
    }

    public void setArmyMorale(int armyMorale) {
        this.armyMorale = armyMorale;
    }


}
