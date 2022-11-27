package com.example.demo;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Character {
    private String characterName;
    private int healthMoney;
    private int bonusPoints;

    private int armyNum;
    private String nameOfArmy;
    private int armyBattleImpact;
    private int armyHealth;
    private int armyMorale;

    private int experience;

    private String linkImg;
    private String linkImgHB;

    private String armyGood;
    private String armyDead;

    private String kingdom;

    //Specific Ability vars
    //Name of the specific ability
//    private String nameSA;
//    private int healthDamSA;
//    private int armyDamSA;


    //defence ability
    //ego level
    //tolerance level

    private ArrayList<ArmyStats> myArmy = new ArrayList<>();
    private ArrayList<Abilities> specialAbilities = new ArrayList<>();
//    private ArrayList<Abilities> mySpecifcAbility = new ArrayList<>();


    public Character(String cN, int hM, int bP, int aN, String nOA, int armyBattleImp, int armHealth, int armMorale, int exp,String link,String link2,String aG, String aD,String k){

        characterName = cN;
        healthMoney = hM;
        bonusPoints = bP;


        armyNum = aN;
        nameOfArmy = nOA;


        armyBattleImpact = armyBattleImp;
        armyHealth = armHealth;
        armyMorale = armMorale;

        experience = exp;

        linkImg = link;
        linkImgHB = link2;

        armyGood = aG;
        armyDead = aD;

        kingdom = k;

//
//        nameSA = nameSa;
//        healthDamSA = healthDamSa;
//        armyDamSA = armyDamSa;

//        mySpecifcAbility.add(new Abilities(nameSa,healthDamSa,armyDamSa));

        myArmy.add(new ArmyStats(armyBattleImp,armHealth,armMorale));



//        cAN = abilityName;
//        cAHD = abilityHD;
//        cAAD = abilityAD;
//
//        myAbility.add(new Abilities(abilityName, abilityHD,abilityAD));
//        myAbility.add(new Abilities("Army Taunt", 0,5));


    }

    public void setSpecialAbilities(String name, int healthDam, int armyDam) {
        specialAbilities.add(new Abilities(name,healthDam,armyDam));
    }

    public ArrayList<Abilities> getSpecialAbilities() {
        return specialAbilities;
    }

    public String getKingdom() {
        return kingdom;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public String getLinkImgHB() {
        return linkImgHB;
    }

    public String getArmyGood() {
        return armyGood;
    }

    public String getArmyDead() {
        return armyDead;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience += experience;
    }

    public ArrayList<ArmyStats> getMyArmy() {
        return myArmy;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public int getArmyNum() {
        return armyNum;
    }

    public void setArmyNum(int armyNum) {
        this.armyNum = armyNum;
    }

    public int getHealthMoney() {
        return healthMoney;
    }


    public void setHealthMoney(int healthMoney) {
        this.healthMoney = healthMoney;
    }


    public void setArmyBattleImpact(int armyBattleImpact) {
        this.armyBattleImpact = armyBattleImpact;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getNameOfArmy() {
        return nameOfArmy;
    }

    public void setNameOfArmy(String nameOfArmy) {
        this.nameOfArmy = nameOfArmy;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints += bonusPoints;
    }
}
