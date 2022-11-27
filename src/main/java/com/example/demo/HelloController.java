//I think that I should get an A for this project because not only did I abstract my code to the best of my abilities
//but I also added alot of my creativity into this game and tried to make it very interactive and instead of using
//just one format for battling per level, in my 3 levels I have 3 different equations which output a differnet
//range of numbers.
//I did not get any help at all from anyone but only got advice from my peers about my UI.

package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloController {

    int level = 1;
    int randInd;

    int useApplyChange = 0;

    int multValue = 1;

    boolean resultWon = true;

    int maxHealth = 0;
    int maxArmyHealth = 0;

    int newHealthEqHero1 = 0;
    int newHealthEqHeroArmy1 = 0;

    int newHealthEqVillen = 0;
    int newHealthEqVillenArmy = 0;

    int randChose;

    int levelThreeNumWins = 0;
    int randWin = (int)((Math.random()*3));

    @FXML
    private Label label1;
    @FXML
    private Label lblStoryLine;

    @FXML
    private Label lblHeroStats;

    @FXML
    private Label lblWhosTurn;

    @FXML
    private Label lblActionDisplay;

    @FXML
    private Label lblHeroAction;

    @FXML
    private Label lblResultOfEqu;

    @FXML
    private Label lblShowLevel;

    @FXML
    private ImageView imgArrow;



    @FXML
    private TextField text1;

    @FXML
    private ListView lstCharacterStats;

    @FXML
    private ListView lstArmyDescription;

    @FXML
    private ListView lstNewHeroStats;

    @FXML
    private ListView lstNewEnemyStats;

//    @FXML
//    private Button butHeroMove;


    @FXML
    private ImageView imgPic;
    @FXML
    private ImageView imgPic2;
    @FXML
    private ImageView imgPic3;
    @FXML
    private ImageView imgPic4;
    @FXML
    private ImageView imgPic5;
    @FXML
    private ImageView imgPic6;

    @FXML
    private ImageView imgHero;
    @FXML
    private ImageView imgVillen;

    //CC
    @FXML
    private Button butApplyChanges;

    @FXML
    private Tab tabCC;

    @FXML
    private ImageView imgMyHeroCC;
    @FXML
    private ImageView imgMyArmyCC;

    @FXML
    private ListView lstShowDefaultStatsCC;
    @FXML
    private ListView lstShowUpdatedStatsCC;

    @FXML
    private TextField txtChangeName;
    @FXML
    private TextField txtChangeArmyName;
    @FXML
    private TextField txtChangeArmyHealth;
    @FXML
    private TextField txtChangeHealthPoints;
    @FXML
    private TextField txtChangeNumTroopsInArmy;
    @FXML
    private TextField txtChangeArmyMorale;

    //Battle Buttons

    @FXML
    private Button butIDStartBattle;

    boolean startBattle = false;
    @FXML
    private Button lblButEnemyTaunt;
    @FXML
    private Button butIDMoneySteal;
    @FXML
    private Button butIDComboEffect;
    @FXML
    private Button butIDBlockAttack;
    @FXML
    private Button butIDMoveOn;

    @FXML
    private Button butIDReplayLVL;

    @FXML
    private ImageView imgHeroArmy;
    @FXML
    private ImageView imgVillenArmy;

    @FXML
    private ImageView imgShowAttackHero;
    @FXML
    private ImageView imgShowAttackVillen;
    @FXML
    private ImageView imgShowWinner;
    @FXML
    private ImageView imgShowLoser;

    //shop

    @FXML
    private ListView lstSpecialAbility;

    @FXML
    private TextField txtCosCodeAttack;

    @FXML
    private Button butCCAA;

    @FXML
    private Tab tabShop;

    @FXML
    private Label lblBonusPoints;

    @FXML
    private Label idShowForShop;

    //special ability buttons
    @FXML
    private Button butSPOne;
    @FXML
    private Button butSATwo;
    @FXML
    private Button butSAThree;

    @FXML
    private Label lblNumKeysFound;

    @FXML
    private Tab tabEnd;
    @FXML
    private Label lblDoorChoose;
    @FXML
    private Label lblResultOfClickingOnDoors;



    private ArrayList<Character> characters = new ArrayList<>();
    private ArrayList<Abilities> characAbility = new ArrayList<>();
    private ArrayList<Character> hero = new ArrayList<>();
    private ArrayList<Character> opponent = new ArrayList<>();
    private ArrayList<Character> villens = new ArrayList<>();

    private ArrayList<String> cCSaveAndLoadString = new ArrayList<>();
    private ArrayList<Integer> cCSaveAndLoadInts = new ArrayList<>();

    @FXML
    public void handleStart() {

        //charcaters: name STR, healthMoney Int, bonus points InT, armyNumber Int, army Name Str, armyBattle Impact int, army Health int, army Morale int, experince int (between 1 tp 10)
        //Have this set like it is, add more abilities and add in the user Inputs.
        characters.add(new Character("Jeffery Bezos", (int)((Math.random()*200)+150),0,100,"Bezoz Bears",2,300,5,0,"src/main/resources/pics/Jeffery Bezoz.jpg","src/main/resources/pics/GWSBezos.jpg","src/main/resources/pics/Bezos Bears.jpg","src/main/resources/pics/Dead Bear.jpg","Amazonia"));
        characters.add(new Character("Mark Zukerburg", (int)((Math.random()*200)+150),0,100,"Zukerburg Zombies",2,300,3,0,"src/main/resources/pics/Mark Zukerberg.jpg","src/main/resources/pics/GWSZukerburg.jpg","src/main/resources/pics/Zukerburg Zombies.jpg","src/main/resources/pics/Dead Zombie.jpg","Facebookitopia"));
        characters.add(new Character("Warren Buffet", (int)((Math.random()*200)+150),0,100,"Buffet Beasts",3,300,6,0,"src/main/resources/pics/Warren Buffet.jpg","src/main/resources/pics/GWSBuffet.jpg","src/main/resources/pics/Buffet Beasts.jpg","src/main/resources/pics/Dead Beast.jpg","Berkshiriland"));
        characters.add(new Character("Bill Gates", (int)((Math.random()*200)+150),0,100,"Gates Goblins",1,300,4,0,"src/main/resources/pics/Bill Gates.jpg","src/main/resources/pics/GWSGates.jpg","src/main/resources/pics/Gate Goblins.jpg","src/main/resources/pics/Dead Goblins.jpg","Micromainia"));
        characters.add(new Character("Mukesh Ambani", (int)((Math.random()*200)+150),0,100,"Ambani Aleins",5,300,8,0,"src/main/resources/pics/Mukesh Ambani.jpg","src/main/resources/pics/GTSAmbani.jpg","src/main/resources/pics/Ambani Aliens.jpg","src/main/resources/pics/Ambani Aliens.jpg","Reliania"));
        characters.add(new Character("Elon Musk", (int)((Math.random()*200)+150),0,100,"Musks Minions",3,300,9,0,"src/main/resources/pics/Elon Musk.jpg","src/main/resources/pics/GWSMusk.jpg","src/main/resources/pics/Musk Minions.jpg","src/main/resources/pics/Dead Minion.jpg","Teslatopia"));

        //name, health damage, army damage
        //common from 0 - 3;
        characAbility.add(new Abilities("Enemy Taunt",(int)(Math.random()*20),(int)(Math.random()*10)));
        characAbility.add(new Abilities("Money Steal",(int)(Math.random()*20),(int)(Math.random()*10)));
        characAbility.add(new Abilities("Combo Effect",(int)(Math.random()*20),(int)(Math.random()*10)));
        characAbility.add(new Abilities("Direct Attack!",2,3));

        //Bezoz
        characters.get(0).setSpecialAbilities("BEAR ATTACK!!",(int)((Math.random()*20)+50),(int)((Math.random()*10)+50));
        characters.get(0).setSpecialAbilities("Code Attack -- Bezos Style",10,10);
        characters.get(0).setSpecialAbilities("The Amazon Flex",(int)((Math.random()*30)+50),(int)((Math.random()*20)+50));

        //Zukerburg
        characters.get(1).setSpecialAbilities("Zombie Stampede!",(int)((Math.random()*20)+50),(int)((Math.random()*10)+50));
        characters.get(1).setSpecialAbilities("Code Attack -- Zukerburg Style",10,10);
        characters.get(1).setSpecialAbilities("The Facebook Boomer Attack!",(int)((Math.random()*30)+50),(int)((Math.random()*20)+50));

        //Buffet
        characters.get(2).setSpecialAbilities("The Beast Warrior Attack!",(int)((Math.random()*20)+50),(int)((Math.random()*10)+50));
        characters.get(2).setSpecialAbilities("Code Attack -- Buffet Style",10,10);
        characters.get(2).setSpecialAbilities("The Berkshire Lawyer Attack!",(int)((Math.random()*30)+50),(int)((Math.random()*20)+50));

        //Gates
        characters.get(3).setSpecialAbilities("The Goblin Barrels",(int)((Math.random()*20)+50),(int)((Math.random()*10)+50));
        characters.get(3).setSpecialAbilities("Code Attack -- Gates Style",10,10);
        characters.get(3).setSpecialAbilities("Microsoft Valley EarthQuake!",(int)((Math.random()*30)+50),(int)((Math.random()*20)+50));

        //Ambani
        characters.get(4).setSpecialAbilities("Raging Alien Rain!",(int)((Math.random()*20)+50),(int)((Math.random()*10)+50));
        characters.get(4).setSpecialAbilities("Code Attack -- Ambani Style",10,10);
        characters.get(4).setSpecialAbilities("The Relience Reflector!",(int)((Math.random()*30)+50),(int)((Math.random()*20)+50));

        //Musk
        characters.get(5).setSpecialAbilities("The Minions Assemble!",(int)((Math.random()*20)+50),(int)((Math.random()*10)+50));
        characters.get(5).setSpecialAbilities("Code Attack -- Musk Style",10,10);
        characters.get(5).setSpecialAbilities("The Space Flex!",(int)((Math.random()*30)+50),(int)((Math.random()*20)+50));

    }

    @FXML
    public void clickOnJeff() {
        showCharacterDefaultStats(0);

    }
    @FXML
    public void clickOnMark() {

        showCharacterDefaultStats(1);

    }
    @FXML
    public void clickOnWarren() {

        showCharacterDefaultStats(2);

    }
    @FXML
    public void clickOnBill() {
        showCharacterDefaultStats(3);

    }
    @FXML
    public void clickOnAmbani() {
        showCharacterDefaultStats(4);

    }
    @FXML
    public void clickOnElon() {
        showCharacterDefaultStats(5);

    }

    public void showCharacterDefaultStats(int ind){
        lstCharacterStats.getItems().clear();

//        characters.get(ind).setHealthMoney(300);

        lstCharacterStats.getItems().add("Name: " + characters.get(ind).getCharacterName());
        lstCharacterStats.getItems().add("Kingdom Ruled: " + characters.get(ind).getKingdom());
        lstCharacterStats.getItems().add("Amount of Money: " + characters.get(ind).getHealthMoney());
        lstCharacterStats.getItems().add("Amount of Experience: " + characters.get(ind).getExperience());
        lstCharacterStats.getItems().add("Amount of Points: " + characters.get(ind).getBonusPoints());

        lstArmyDescription.getItems().add("Army Name: " + characters.get(ind).getNameOfArmy());
        lstArmyDescription.getItems().add("Total Army: " + characters.get(ind).getArmyNum());
        lstArmyDescription.getItems().add("Army Health: " + characters.get(ind).getMyArmy().get(0).getArmyHealth());
        lstArmyDescription.getItems().add("Army Morale: " + characters.get(ind).getMyArmy().get(0).getArmyMorale());

//        lstCharacterStats.getItems().add("Ability 1 " + characAbility.get());

        lblHeroStats.setText(characters.get(ind).getCharacterName() + " Stats");

        System.out.println("Clicked On Jeff");
//        System.out.println("Name: " + characters.get(ind).getCharacterName() + " Has abilities: " + characters.get(ind).getMyAbility().get(0).getTypeOfAbility());

    }

    public void disableImages(){
        lstCharacterStats.getItems().clear();

        imgPic.setDisable(true);
        imgPic2.setDisable(true);
        imgPic3.setDisable(true);
        imgPic4.setDisable(true);
        imgPic5.setDisable(true);
        imgPic6.setDisable(true);
    }

    public void findTheHeroStart(int ind2){
        hero.add(characters.get(ind2));
        characters.remove(ind2);

        for (int i = 0; i < characters.size(); i++){
            villens.add(characters.get(i));
        }

        System.out.println("Hero: " + hero.get(0).getCharacterName());

        for (int i = 0; i < villens.size(); i++){
            System.out.println("Villens: " + villens.get(i).getCharacterName());
        }

        System.out.println("Rand Ind VIl: " + villens.get(randInd).getCharacterName());//rand ind is currently 0

    }

    public int chooseEnemyStart(){
        randInd = (int)(Math.random()*villens.size()-1);
        System.out.println("The Villen Your Battling Is: " + villens.get(randInd).getCharacterName());

        for (int i = 0; i < villens.size(); i++){
            if (villens.get(randInd).getCharacterName().equals(villens.get(i).getCharacterName())){
                try {
                    FileInputStream input = new FileInputStream(villens.get(i).getLinkImg());
                    imgVillen.setImage(new Image(input));
                    FileInputStream input2 = new FileInputStream(villens.get(i).getArmyGood());
                    imgVillenArmy.setImage(new Image(input2));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }


        return randInd;

    }

    public void showStory(int enemy){

        opponent.add(villens.get(enemy));

        lblStoryLine.setText("Once upon the great land of Megamard thrived 6 honorary kings \n who not only were billionares but ruled their own kingdoms. \n Every start of a decade, a competition holds place on who will be \n crowned the most richest kind in all the lands! \n The winner not only gets to rule the land but live in the mountains \n of the Billionare Hills, in the famous Golden Villa. \n The Villa has been the home to many top billionares in history. \n This year came victorus the ruler " + hero.get(0).getCharacterName() +  " \n So to celebrate, " + hero.get(0).getCharacterName() + " threw an extravagent feast where he invited \n all of his competors. \n But enraged by his defeat " + villens.get(enemy).getCharacterName() + " had plotted a plan to take over \n the kingdoms! So he added a brainwashing postion in the drinks when \n when " + hero.get(0).getCharacterName() + " went out of the dining room for a meeting. \n Reluntantly, " + hero.get(0).getCharacterName() + " wasnt effected. Looking at for his chance " +
                "\n " + villens.get(enemy).getCharacterName() + " called his army, " + villens.get(enemy).getNameOfArmy() + ", and the take over started! \n When " + hero.get(0).getCharacterName() +  " came back he saw the brainwashing potion but \n was chased out of the Villa before he could think. \n " + hero.get(0).getCharacterName() +  " remembered that he has the antedote to the brainwashing potion \n but it is in the top floor of the Villa!!! \n Help " + hero.get(0).getCharacterName() +  " fight past the armys of the kings and retreve the antedote \n before it is too late!");

        lstNewHeroStats.getItems().add("Name: " + hero.get(0).getCharacterName());
        lstNewHeroStats.getItems().add("Amount of Money: " + hero.get(0).getHealthMoney());
        lstNewHeroStats.getItems().add("Army Name: " + hero.get(0).getNameOfArmy());
        lstNewHeroStats.getItems().add("Total Army: " + hero.get(0).getArmyNum());
        lstNewHeroStats.getItems().add("Army Health: " + hero.get(0).getMyArmy().get(0).getArmyHealth());
        lstNewHeroStats.getItems().add("Army Morale: " + hero.get(0).getMyArmy().get(0).getArmyMorale());

        lstNewEnemyStats.getItems().add("Name: " + opponent.get(0).getCharacterName());
        lstNewEnemyStats.getItems().add("Amount of Money: " + opponent.get(0).getHealthMoney());
        lstNewEnemyStats.getItems().add("Army Name: " + opponent.get(0).getNameOfArmy());
        lstNewEnemyStats.getItems().add("Total Army: " + opponent.get(0).getArmyNum());
        lstNewEnemyStats.getItems().add("Army Health: " + opponent.get(0).getMyArmy().get(0).getArmyHealth());
        lstNewEnemyStats.getItems().add("Army Morale: " + opponent.get(0).getMyArmy().get(0).getArmyMorale());

    }

    public void showForEachCharacterStart(int pos){
        disableImages();
        showCharacterDefaultStats(pos);
        findTheHeroStart(pos);
        showStory(chooseEnemyStart());
        villens.remove(randInd);
        characAbility.get(1).setHealthDamageOfAbility(hero.get(0).getMyArmy().get(0).getArmyMorale()*2);

        System.out.println("OP: " + opponent.get(0).getCharacterName());
        System.out.println("VIL: " + villens.get(randInd).getCharacterName());
    }

    @FXML
    public void butClickOnChoseJeff() {

        codeExecutedWhenButClickOnCharactersIsPressed(0);


    }
    @FXML
    public void butClickOnChoseMark() {

        codeExecutedWhenButClickOnCharactersIsPressed(1);

    }
    @FXML
    public void butClickChoseWarren() {

        codeExecutedWhenButClickOnCharactersIsPressed(2);

    }
    @FXML
    public void butClickChoseBill() {

        codeExecutedWhenButClickOnCharactersIsPressed(3);

    }
    @FXML
    public void butClickChoseMukesh() {

        codeExecutedWhenButClickOnCharactersIsPressed(4);

    }
    @FXML
    public void butClickChoseElon() {

        codeExecutedWhenButClickOnCharactersIsPressed(5);

    }

    public void codeExecutedWhenButClickOnCharactersIsPressed(int spot){
        seperateCharacterInfoIntoArraysSL(spot);
        saveData();

        showForEachCharacterStart(spot);
        tabCC.setDisable(false);
        lblShowLevel.setText(level + "");

        lstShowDefaultStatsCC.getItems().clear();

        lstShowDefaultStatsCC.getItems().add("Name: " + hero.get(0).getCharacterName());
        lstShowDefaultStatsCC.getItems().add("Amount of Money: " + hero.get(0).getHealthMoney());
        lstShowDefaultStatsCC.getItems().add("Army Name: " + hero.get(0).getNameOfArmy());
        lstShowDefaultStatsCC.getItems().add("Total Army: " + hero.get(0).getArmyNum());

        lstShowDefaultStatsCC.getItems().add("Army Health: " + hero.get(0).getMyArmy().get(0).getArmyHealth());
        lstShowDefaultStatsCC.getItems().add("Army Morale: " + hero.get(0).getMyArmy().get(0).getArmyMorale());

        try {
//            FileInputStream input = new FileInputStream("src/main/resources/pics/Elon Musk.jpg");
            FileInputStream input = new FileInputStream(hero.get(0).getLinkImg());
            FileInputStream input2 = new FileInputStream(hero.get(0).getLinkImg());
            FileInputStream input3 = new FileInputStream(hero.get(0).getArmyGood());
            FileInputStream input4 = new FileInputStream(hero.get(0).getArmyGood());
            imgHero.setImage(new Image(input));
            imgMyHeroCC.setImage(new Image(input2));
            imgMyArmyCC.setImage(new Image(input3));
            imgHeroArmy.setImage(new Image(input4));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void seperateCharacterInfoIntoArraysSL(int ind){
        //charcaters: name STR, healthMoney Int, bonus points InT, armyNumber Int, army Name Str, armyBattle Impact int,
        // army Health int, army Morale int, experince int (between 1 tp 10)

        //str 0, int 1, int 2, int 3, str 4, int 5, int 6, int 7, int 8

        cCSaveAndLoadInts.add(characters.get(ind).getHealthMoney());
        cCSaveAndLoadInts.add(characters.get(ind).getBonusPoints());
        cCSaveAndLoadInts.add(characters.get(ind).getArmyNum());
        cCSaveAndLoadInts.add(characters.get(ind).getMyArmy().get(0).getArmyBattleImpact());
        cCSaveAndLoadInts.add(characters.get(ind).getMyArmy().get(0).getArmyHealth());
        cCSaveAndLoadInts.add(characters.get(ind).getMyArmy().get(0).getArmyMorale());
        cCSaveAndLoadInts.add(characters.get(ind).getExperience());


        cCSaveAndLoadString.add(characters.get(ind).getCharacterName());
        cCSaveAndLoadString.add(characters.get(ind).getNameOfArmy());

    }

    public void saveData(){

        String outFile ="src/main/resources/txtStuff.txt";
        try{
            PrintWriter out = new PrintWriter(outFile);
            /*This is where you would save your data.  Each time you
            run the line out.println(______) you will save a line of data
            in the text file.
             */
            for(Integer x: cCSaveAndLoadInts){
                out.println(x);
            }
            //you don't need a loop.  Just type the line below as many times as you want
            //out.println();
            out.close();
        }catch(FileNotFoundException var1){
            System.out.println("no file");
        }

        String outFile2 ="src/main/resources/txtStuff2.txt";
        try{
            PrintWriter out = new PrintWriter(outFile2);
            /*This is where you would save your data.  Each time you
            run the line out.println(______) you will save a line of data
            in the text file.
             */
            for(String x: cCSaveAndLoadString){
                out.println(x);
            }
            //you don't need a loop.  Just type the line below as many times as you want
            //out.println();
            out.close();
        }catch(FileNotFoundException var1){
            System.out.println("no file");
        }

    }

    @FXML
    public void butSimuStartBattle() {

        butIDMoveOn.setDisable(true);
        butIDReplayLVL.setDisable(true);

        try {
            FileInputStream input = new FileInputStream("src/main/resources/pics/questionMark.jpg");
            imgShowWinner.setImage(new Image(input));
            FileInputStream input2 = new FileInputStream("src/main/resources/pics/questionMark.jpg");
            imgShowLoser.setImage(new Image(input2));
            FileInputStream input3 = new FileInputStream("src/main/resources/pics/questionMark.jpg");
            imgShowAttackHero.setImage(new Image(input3));
            FileInputStream input4 = new FileInputStream("src/main/resources/pics/questionMark.jpg");
            imgShowAttackVillen.setImage(new Image(input4));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (resultWon == true){
            startBattle = true;
            butIDMoveOn.setDisable(true);
            if (level == 1){
                lblButEnemyTaunt.setDisable(false);
                butIDBlockAttack.setDisable(false);
            }else if (level == 2){
                lblButEnemyTaunt.setDisable(false);
                butIDMoneySteal.setDisable(false);
                butIDComboEffect.setDisable(false);
                butIDBlockAttack.setDisable(false);
            }else if (level == 3){
                lblButEnemyTaunt.setDisable(false);
                butIDMoneySteal.setDisable(false);
                butIDComboEffect.setDisable(false);
                butIDBlockAttack.setDisable(false);
            }
        }
    }

    //get the ///hero health, ///number of army, //army battle impact, ///army battle heatlth and army morale
    // and use them in the equation with the stats for enemy taunt
    //enemy taunt stats are //health damage of it and //army damage of it.

    // the greater the health of the person and health of army and number of army, the more they can withstand
    //the greater the army morale and army battle impact the more imapct the opponent gets.
    //the enemy taunt healh damage and army damage take points off from the opponents health and army health

    //enemy taunt health damage impacts oponents health
    //enemy taunt army damage impacts the opponents army health

    //take the army morale of the person and subtract it from the other persons morale.
    //the army battle imapact removes from the opponents army health
    //
    public void runBattleSequenceForLevel1(int abilityPos){
        int level1Output = (int)(Math.random()*2);

        //when the oponent attacks
        if (abilityPos != 3){
            if (level1Output == 0){
                newHealthEqHero1 =  hero.get(0).getHealthMoney() - (int)(Math.sqrt((characAbility.get(abilityPos).getHealthDamageOfAbility()*multValue)));
                newHealthEqHeroArmy1 = hero.get(0).getMyArmy().get(0).getArmyHealth() - (int)(Math.sqrt((opponent.get(0).getMyArmy().get(0).getArmyBattleImpact() * opponent.get(0).getMyArmy().get(0).getArmyMorale()) - (characAbility.get(abilityPos).getArmyDamage()*multValue)));
                lblActionDisplay.setText("Villen Used " + characAbility.get(0).getTypeOfAbility());

                try {
                    FileInputStream input = new FileInputStream("src/main/resources/pics/EnemyTanut.jpg");
                    imgShowAttackVillen.setImage(new Image(input));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }else if (level1Output == 1 && level == 1){
                newHealthEqHero1 =  hero.get(0).getHealthMoney() - (int)(Math.sqrt((characAbility.get(3).getHealthDamageOfAbility()*multValue)));
                newHealthEqHeroArmy1 = hero.get(0).getMyArmy().get(0).getArmyHealth() - (int)(Math.sqrt((opponent.get(0).getMyArmy().get(0).getArmyBattleImpact() * opponent.get(0).getMyArmy().get(0).getArmyMorale())- (characAbility.get(3).getArmyDamage()*multValue)));
                lblActionDisplay.setText("Villen Used Direct Attack");

                try {
                    FileInputStream input = new FileInputStream("src/main/resources/pics/Direct Attack.jpg");
                    imgShowAttackVillen.setImage(new Image(input));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }


        //when hero attacks

        if (abilityPos == 3){
            newHealthEqVillen =  opponent.get(0).getHealthMoney() - (int)(Math.sqrt(newHealthEqHero1));
            newHealthEqVillenArmy = opponent.get(0).getMyArmy().get(0).getArmyHealth() - (int)(Math.sqrt(newHealthEqHeroArmy1));

        }else{
            newHealthEqVillen =  opponent.get(0).getHealthMoney() - (int)(Math.sqrt(((characAbility.get(0).getHealthDamageOfAbility()*multValue)+ hero.get(0).getExperience())));
            newHealthEqVillenArmy = opponent.get(0).getMyArmy().get(0).getArmyHealth() - (int)(Math.sqrt((hero.get(0).getMyArmy().get(0).getArmyBattleImpact() * hero.get(0).getMyArmy().get(0).getArmyMorale()) - (characAbility.get(abilityPos).getArmyDamage()*multValue)+ hero.get(0).getExperience()*multValue));

        }

        System.out.println("newHealthEqHero " + newHealthEqHero1);
        System.out.println("newHealthEqHeroArmy " + newHealthEqHeroArmy1);

        System.out.println("newHealthEqVillen " + newHealthEqVillen);
        System.out.println("newHealthEqVillenArmy " + newHealthEqVillenArmy);



        displaySetAndCheckForDeathForSimulations();

        multValue++;

        System.out.println(multValue);
    }

    public void dispAttackPicture(){
        if (characAbility.get(randChose).getTypeOfAbility() == "Enemy Taunt"){
            try {
                FileInputStream input = new FileInputStream("src/main/resources/pics/EnemyTanut.jpg");
                imgShowAttackVillen.setImage(new Image(input));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else if (characAbility.get(randChose).getTypeOfAbility() == "Money Steal"){
            try {
                FileInputStream input = new FileInputStream("src/main/resources/pics/Money Steal.jpg");
                imgShowAttackVillen.setImage(new Image(input));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else if (characAbility.get(randChose).getTypeOfAbility() == "Combo Effect"){
            try {
                FileInputStream input = new FileInputStream("src/main/resources/pics/ComboPower.jpg");
                imgShowAttackVillen.setImage(new Image(input));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void runBattleSeqenceForLevel2(int abilityPos){

        lblActionDisplay.setText("Enemy Used: " + characAbility.get(randChose).getTypeOfAbility());

        //When Opponent Attacks

        if (abilityPos != 3){
            newHealthEqHero1 = hero.get(0).getHealthMoney() - (characAbility.get(randChose).getHealthDamageOfAbility()*opponent.get(0).getMyArmy().get(0).getArmyMorale())/2;
            newHealthEqHeroArmy1 = hero.get(0).getMyArmy().get(0).getArmyHealth() - (characAbility.get(randChose).getArmyDamage()*opponent.get(0).getMyArmy().get(0).getArmyMorale())/2;
        }


        dispAttackPicture();

        //When Hero Attacks

        if (abilityPos == 3){
            newHealthEqVillen =  opponent.get(0).getHealthMoney() - (int)(Math.sqrt(newHealthEqHero1));
            newHealthEqVillenArmy = opponent.get(0).getMyArmy().get(0).getArmyHealth() - (int)(Math.sqrt(newHealthEqHeroArmy1));

        }else{
            newHealthEqVillen = opponent.get(0).getHealthMoney() - (int)(Math.sqrt((characAbility.get(abilityPos).getHealthDamageOfAbility()*hero.get(0).getMyArmy().get(0).getArmyMorale()+ hero.get(0).getExperience()/2)));
            newHealthEqVillenArmy = opponent.get(0).getMyArmy().get(0).getArmyHealth() - (int)(Math.sqrt((characAbility.get(abilityPos).getArmyDamage()*opponent.get(0).getMyArmy().get(0).getArmyMorale()+ hero.get(0).getExperience()/2)));

        }

        displaySetAndCheckForDeathForSimulations();

    }

    @FXML
    public void butUseEnemyTaunt() {

        lblHeroAction.setText("You used Enemy Taunt");

        try {
            FileInputStream input = new FileInputStream("src/main/resources/pics/EnemyTanut.jpg");
            imgShowAttackHero.setImage(new Image(input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (startBattle == true){

            if (level == 1){
                runBattleSequenceForLevel1(0);
            }else if (level == 2){
                randChose = (int)(Math.random()*3);
                runBattleSeqenceForLevel2(0);
            }else if (level == 3){
                int oppAbilityUse = (int)(Math.random()*3);
                runBattleSeqenceForLevel3(false,1,oppAbilityUse,0);
            }
        }


    }
    @FXML
    public void butUseMoneySteal() {

        lblHeroAction.setText("You used Money Steal");

        try {
            FileInputStream input = new FileInputStream("src/main/resources/pics/Money Steal.jpg");
            imgShowAttackHero.setImage(new Image(input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (startBattle == true){
            if (level == 2){
                randChose = (int)(Math.random()*3);
                runBattleSeqenceForLevel2(1);
            }else if (level == 3){
                randChose = (int)(Math.random()*3);
                int oppAbilityUse = (int)(Math.random()*3);
                runBattleSeqenceForLevel3(false,1,oppAbilityUse,1);
            }
        }


    }
    @FXML
    public void butUseComboEffect() {
        lblHeroAction.setText("You used Combo Effect");

        try {
            FileInputStream input = new FileInputStream("src/main/resources/pics/ComboPower.jpg");
            imgShowAttackHero.setImage(new Image(input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (startBattle == true){
            if (level == 2){
                randChose = (int)(Math.random()*3);
                runBattleSeqenceForLevel2(2);
            }else if (level == 3){
                randChose = (int)(Math.random()*3);
                int oppAbilityUse = (int)(Math.random()*3);
                runBattleSeqenceForLevel3(false,1,oppAbilityUse,2);
            }
        }


    }
    @FXML
    public void butUseBlockAttack() {
        lblHeroAction.setText("You blocked and counter reflected the attack!");

        try {
            FileInputStream input = new FileInputStream("src/main/resources/pics/army-of-lawyers.jpg");
            imgShowAttackHero.setImage(new Image(input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (startBattle == true){
            if (level == 1){
//                randChose = (int)(Math.random()*3);
                runBattleSequenceForLevel1(3);
            }else if (level == 2){
                randChose = (int)(Math.random()*3);
                runBattleSeqenceForLevel2(3);
            }else if (level == 3){
                randChose = (int)(Math.random()*3);
                int oppAbilityUse = (int)(Math.random()*3);
                runBattleSeqenceForLevel3(false,1,oppAbilityUse,3);
            }
        }
    }

    @FXML
    public void butClickReplayLevel() {
        try {
            FileInputStream input = new FileInputStream("src/main/resources/pics/questionMark.jpg");
            imgShowWinner.setImage(new Image(input));
            FileInputStream input2 = new FileInputStream("src/main/resources/pics/questionMark.jpg");
            imgShowLoser.setImage(new Image(input2));
            FileInputStream input3 = new FileInputStream("src/main/resources/pics/questionMark.jpg");
            imgShowAttackHero.setImage(new Image(input3));
            FileInputStream input4 = new FileInputStream("src/main/resources/pics/questionMark.jpg");
            imgShowAttackVillen.setImage(new Image(input4));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (level == 1){
            lblButEnemyTaunt.setDisable(false);
            butIDBlockAttack.setDisable(false);

            opponent.get(0).setHealthMoney((int)((Math.random()*200)+150));
            opponent.get(0).getMyArmy().get(0).setArmyHealth(300);
            showResultOfEquationsCheck();

            startBattle = true;
            butIDMoveOn.setDisable(false);


            }else if (level == 2){
                lblButEnemyTaunt.setDisable(false);
                butIDMoneySteal.setDisable(false);
                butIDComboEffect.setDisable(false);
                butIDBlockAttack.setDisable(false);
                opponent.get(0).setHealthMoney((int)((Math.random()*200)+150));
                opponent.get(0).getMyArmy().get(0).setArmyHealth(300);
                showResultOfEquationsCheck();

                startBattle = true;
                butIDMoveOn.setDisable(false);
            }else if (level == 3){
            lblButEnemyTaunt.setDisable(false);
            butIDMoneySteal.setDisable(false);
            butIDComboEffect.setDisable(false);
            butIDBlockAttack.setDisable(false);
            butSPOne.setDisable(false);
            butSATwo.setDisable(false);
            butSAThree.setDisable(false);

            try {
                FileInputStream input3 = new FileInputStream(opponent.get(0).getArmyGood());
                imgVillenArmy.setImage(new Image(input3));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            opponent.get(0).setHealthMoney((int)((Math.random()*200)+150));
            opponent.get(0).getMyArmy().get(0).setArmyHealth(300);
            showResultOfEquationsCheck();

            startBattle = true;
            butIDMoveOn.setDisable(false);
        }

        }

    @FXML
    public void butMoveOnToNextLevel() {

        try {
            FileInputStream input = new FileInputStream("src/main/resources/pics/questionMark.jpg");
            imgShowWinner.setImage(new Image(input));
            FileInputStream input2 = new FileInputStream("src/main/resources/pics/questionMark.jpg");
            imgShowLoser.setImage(new Image(input2));
            FileInputStream input3 = new FileInputStream("src/main/resources/pics/questionMark.jpg");
            imgShowAttackHero.setImage(new Image(input3));
            FileInputStream input4 = new FileInputStream("src/main/resources/pics/questionMark.jpg");
            imgShowAttackVillen.setImage(new Image(input4));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        level += 1;
        imgArrow.setY(imgArrow.getY() - 50);
        lblShowLevel.setText(level+"");

        butIDStartBattle.setDisable(false);
        lblHeroAction.setText("_____");
        lblActionDisplay.setText("_____");
        lblResultOfEqu.setText("_____");

        int randPos = chooseEnemyStart();
        opponent.remove(0);
        opponent.add(villens.get(randPos));
        villens.remove(randPos);

        for (int i = 0; i < villens.size();i++){
            System.out.println("...: " + villens.get(i).getCharacterName());
        }

        showResultOfEquationsCheck();

        if (level == 1){
            lblButEnemyTaunt.setDisable(false);
        }else if (level == 2){
            lblButEnemyTaunt.setDisable(false);
            butIDMoneySteal.setDisable(false);
            butIDComboEffect.setDisable(false);
            butIDBlockAttack.setDisable(false);
        }else if (level == 3){
            lblButEnemyTaunt.setDisable(false);
            butIDMoneySteal.setDisable(false);
            butIDComboEffect.setDisable(false);
            butIDBlockAttack.setDisable(false);
            butSPOne.setDisable(false);
            butSATwo.setDisable(false);
            butSAThree.setDisable(false);
            butCCAA.setDisable(false);
            butSPOne.setText(hero.get(0).getSpecialAbilities().get(0).getTypeOfAbility());
            butSATwo.setText(hero.get(0).getSpecialAbilities().get(1).getTypeOfAbility());
            butSAThree.setText(hero.get(0).getSpecialAbilities().get(2).getTypeOfAbility());
            updateSpecialAbilityListInfo();
        }

        butIDReplayLVL.setDisable(false);

    }

    public void updateSpecialAbilityListInfo(){
        lstSpecialAbility.getItems().clear();

        lstSpecialAbility.getItems().add("Ability 1: " + hero.get(0).getSpecialAbilities().get(0).getTypeOfAbility());
        lstSpecialAbility.getItems().add("   Health Damage: " + hero.get(0).getSpecialAbilities().get(0).getHealthDamageOfAbility());
        lstSpecialAbility.getItems().add("   Army Damage: " + hero.get(0).getSpecialAbilities().get(0).getArmyDamage());

        lstSpecialAbility.getItems().add("Ability 2: " + hero.get(0).getSpecialAbilities().get(1).getTypeOfAbility());
        lstSpecialAbility.getItems().add("   Health Damage: " + hero.get(0).getSpecialAbilities().get(1).getHealthDamageOfAbility());
        lstSpecialAbility.getItems().add("   Army Damage: " + hero.get(0).getSpecialAbilities().get(1).getArmyDamage());

        lstSpecialAbility.getItems().add("Ability 3: " + hero.get(0).getSpecialAbilities().get(2).getTypeOfAbility());
        lstSpecialAbility.getItems().add("   Health Damage: " + hero.get(0).getSpecialAbilities().get(2).getHealthDamageOfAbility());
        lstSpecialAbility.getItems().add("   Army Damage: " + hero.get(0).getSpecialAbilities().get(2).getArmyDamage());
    }

    @FXML
    public void butCostomCodeAttackAbi() {

        Integer inpChange = Integer.parseInt(txtCosCodeAttack.getText());

        int randRange = (int)(Math.random()+inpChange);

        hero.get(0).getSpecialAbilities().get(1).setHealthDamageOfAbility(randRange);
        hero.get(0).getSpecialAbilities().get(1).setArmyDamage(randRange);

        updateSpecialAbilityListInfo();

        butCCAA.setDisable(true);

    }

//whenever you click on the battle tab button the stats get shows again for both sides! This way the stats are refreshed
    //after a visit from the shop.

    public void checkForDeath(){
        if (hero.get(0).getHealthMoney() <= 0 || hero.get(0).getMyArmy().get(0).getArmyHealth() <= 0){

            hero.get(0).setHealthMoney(0);
            hero.get(0).getMyArmy().get(0).setArmyHealth(0);
            showResultOfEquationsCheck();

            lblResultOfEqu.setText("The enemy stole all of the money from you!! Game over!!");
            resultWon = false;
            lblButEnemyTaunt.setDisable(true);
            butIDMoneySteal.setDisable(true);
            butIDComboEffect.setDisable(true);
            butIDBlockAttack.setDisable(true);

            butIDReplayLVL.setDisable(false);

            try {
                FileInputStream input = new FileInputStream(opponent.get(0).getLinkImg());
                imgShowWinner.setImage(new Image(input));
                FileInputStream input2 = new FileInputStream(hero.get(0).getLinkImgHB());
                imgShowLoser.setImage(new Image(input2));
                FileInputStream input3 = new FileInputStream(hero.get(0).getArmyDead());
                imgHeroArmy.setImage(new Image(input3));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }else if (opponent.get(0).getHealthMoney() <= 0 || opponent.get(0).getMyArmy().get(0).getArmyHealth() <= 0){

            butIDReplayLVL.setDisable(false);
            butIDMoveOn.setDisable(false);
            butIDStartBattle.setDisable(false);

            try {
                FileInputStream input = new FileInputStream(hero.get(0).getLinkImg());
                imgShowWinner.setImage(new Image(input));
                FileInputStream input2 = new FileInputStream(opponent.get(0).getLinkImgHB());
                imgShowLoser.setImage(new Image(input2));
                FileInputStream input3 = new FileInputStream(opponent.get(0).getArmyDead());
                imgVillenArmy.setImage(new Image(input3));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            opponent.get(0).setHealthMoney(0);
            opponent.get(0).getMyArmy().get(0).setArmyHealth(0);
            showResultOfEquationsCheck();

            lblResultOfEqu.setText("You stole all of the money from the villen!! YOU WON!!");


            if (level == 3){

                System.out.println("Rand Win: " + randWin);

                levelThreeNumWins++;
                lblNumKeysFound.setText(levelThreeNumWins + " ");

                opponent.get(0).setArmyNum(opponent.get(0).getArmyNum() - 30);

                lblResultOfEqu.setText("You stole all of the money from the villen!! YOU WON THIS ROUND!! You have " + Math.abs(levelThreeNumWins-3));

                if (levelThreeNumWins >= 3){
                    tabEnd.setDisable(false);
                    lblDoorChoose.setText(hero.get(0).getCharacterName() + " forgot that he added an extra security feature to his final floor. \n Choose one of these doors. One holds the antidote and if that one is chosen you win! If not, then you lose!!");

                    butIDStartBattle.setDisable(true);
                    butIDMoveOn.setDisable(true);
                    butIDReplayLVL.setDisable(true);

                    lblResultOfEqu.setText("YOU WON THIS BOSS BATTLE! GO TO END TAB TO FINISH GAME!");

                }

            }

            hero.get(0).setBonusPoints(100);
            hero.get(0).setExperience(1);
            resultWon = true;
            lblButEnemyTaunt.setDisable(true);
            butIDMoneySteal.setDisable(true);
            butIDComboEffect.setDisable(true);
            butIDBlockAttack.setDisable(true);

            butIDReplayLVL.setDisable(false);


            //Shop Stuff
            butIDMoveOn.setDisable(false);
            butIDStartBattle.setDisable(true);
            tabShop.setDisable(false);

            lblBonusPoints.setText(hero.get(0).getBonusPoints() + "");

        }else if (opponent.get(0).getHealthMoney() <= 0 && opponent.get(0).getMyArmy().get(0).getArmyHealth() <= 0 || hero.get(0).getHealthMoney() <= 0 && hero.get(0).getMyArmy().get(0).getArmyHealth() <= 0){

//            try {
//                FileInputStream input = new FileInputStream(hero.get(0).getLinkImg());
//                imgShowWinner.setImage(new Image(input));
//                FileInputStream input2 = new FileInputStream(opponent.get(0).getLinkImgHB());
//                imgShowLoser.setImage(new Image(input2));
//                FileInputStream input3 = new FileInputStream(opponent.get(0).getArmyDead());
//                imgVillenArmy.setImage(new Image(input3));
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }

            opponent.get(0).setHealthMoney(0);
            villens.get(0).getMyArmy().get(0).setArmyHealth(0);

            hero.get(0).setHealthMoney(0);
            hero.get(0).getMyArmy().get(0).setArmyHealth(0);
            showResultOfEquationsCheck();
            lblResultOfEqu.setText("It's a tie!!");
            resultWon = true;
            lblButEnemyTaunt.setDisable(true);
            butIDMoneySteal.setDisable(true);
            butIDComboEffect.setDisable(true);
            butIDBlockAttack.setDisable(true);

            butIDMoveOn.setDisable(false);
            butIDStartBattle.setDisable(true);

        }
    }

    @FXML
    public void butCheatLVL1() {

        opponent.get(0).setHealthMoney(0);
        opponent.get(0).getMyArmy().get(0).setArmyHealth(0);
        hero.get(0).setHealthMoney(300);
        hero.get(0).getMyArmy().get(0).setArmyHealth(300);
        checkForDeath();
    }

    //level 2, choose new villen, have the opponent refeul and regain health

    public void showResultOfEquationsCheck(){

        lblBonusPoints.setText(hero.get(0).getBonusPoints()+"");

        lstNewHeroStats.getItems().clear();

        lstNewHeroStats.getItems().add("Name: " + hero.get(0).getCharacterName());
        lstNewHeroStats.getItems().add("Amount of Money: " + hero.get(0).getHealthMoney());
        lstNewHeroStats.getItems().add("Army Name: " + hero.get(0).getNameOfArmy());
        lstNewHeroStats.getItems().add("Total Army: " + hero.get(0).getArmyNum());

        lstNewHeroStats.getItems().add("Army Health: " + hero.get(0).getMyArmy().get(0).getArmyHealth());
        lstNewHeroStats.getItems().add("Army Morale: " + hero.get(0).getMyArmy().get(0).getArmyMorale());

        lstNewEnemyStats.getItems().clear();

        lstNewEnemyStats.getItems().add("Name: " + opponent.get(0).getCharacterName());
        lstNewEnemyStats.getItems().add("Amount of Money: " + opponent.get(0).getHealthMoney());
        lstNewEnemyStats.getItems().add("Army Name: " + opponent.get(0).getNameOfArmy());
        lstNewEnemyStats.getItems().add("Total Army: " + opponent.get(0).getArmyNum());

        lstNewEnemyStats.getItems().add("Army Health: " + opponent.get(0).getMyArmy().get(0).getArmyHealth());
        lstNewEnemyStats.getItems().add("Army Morale: " + opponent.get(0).getMyArmy().get(0).getArmyMorale());

    }

    public void runBattleSeqenceForLevel3(boolean special, int abilityPos, int enemyAbility, int oldSpot){

        if (special == true){
            //When Opponent Attacks

            lblActionDisplay.setText("Enemy Used: " + opponent.get(0).getSpecialAbilities().get(enemyAbility).getTypeOfAbility());



            newHealthEqHero1 = hero.get(0).getHealthMoney() - (opponent.get(0).getSpecialAbilities().get(enemyAbility).getHealthDamageOfAbility()*opponent.get(0).getMyArmy().get(0).getArmyMorale())/((int)(Math.sqrt(opponent.get(0).getSpecialAbilities().get(enemyAbility).getHealthDamageOfAbility())));
            newHealthEqHeroArmy1 = hero.get(0).getMyArmy().get(0).getArmyHealth() - (opponent.get(0).getSpecialAbilities().get(enemyAbility).getArmyDamage()*opponent.get(0).getMyArmy().get(0).getArmyMorale())/((int)(Math.sqrt(opponent.get(0).getSpecialAbilities().get(enemyAbility).getArmyDamage())));

            dispAttackPicture();

            //When Hero Attacks

            newHealthEqVillen = opponent.get(0).getHealthMoney() - (int)(Math.sqrt(hero.get(0).getMyArmy().get(0).getArmyMorale()+ hero.get(0).getExperience()/2)+(int)(Math.sqrt(hero.get(0).getSpecialAbilities().get(abilityPos).getHealthDamageOfAbility())));
            newHealthEqVillenArmy = opponent.get(0).getMyArmy().get(0).getArmyHealth() - (int)(Math.sqrt(opponent.get(0).getMyArmy().get(0).getArmyMorale()+ hero.get(0).getExperience()/2)+(int)(Math.sqrt(hero.get(0).getSpecialAbilities().get(abilityPos).getArmyDamage())));

        }else{

            lblActionDisplay.setText("Enemy Used: " + characAbility.get(enemyAbility).getTypeOfAbility());

            if (oldSpot == 3){//block attack
                //When Opponent Attacks

                int tempNewHealthEqHero1 = (characAbility.get(enemyAbility).getHealthDamageOfAbility()*opponent.get(0).getMyArmy().get(0).getArmyMorale())/((int)(Math.sqrt(characAbility.get(enemyAbility).getHealthDamageOfAbility())));
                int tempNewHealthEqHeroArmy1 =(characAbility.get(enemyAbility).getArmyDamage()*opponent.get(0).getMyArmy().get(0).getArmyMorale())/((int)(Math.sqrt(characAbility.get(enemyAbility).getHealthDamageOfAbility())));


                //when hero attacks
                newHealthEqVillen =  opponent.get(0).getHealthMoney() - (int)(Math.sqrt(tempNewHealthEqHero1));
                newHealthEqVillenArmy = opponent.get(0).getMyArmy().get(0).getArmyHealth() - (int)(Math.sqrt(tempNewHealthEqHeroArmy1));

                newHealthEqHero1 = hero.get(0).getHealthMoney();
                newHealthEqHeroArmy1 = hero.get(0).getMyArmy().get(0).getArmyHealth();
            }else{
                //When Opponent Attacks

                newHealthEqHero1 = hero.get(0).getHealthMoney() - (characAbility.get(enemyAbility).getHealthDamageOfAbility()*opponent.get(0).getMyArmy().get(0).getArmyMorale())/((int)(Math.sqrt(characAbility.get(enemyAbility).getHealthDamageOfAbility())));
                newHealthEqHeroArmy1 = hero.get(0).getMyArmy().get(0).getArmyHealth() - (characAbility.get(enemyAbility).getArmyDamage()*opponent.get(0).getMyArmy().get(0).getArmyMorale())/((int)(Math.sqrt(characAbility.get(enemyAbility).getHealthDamageOfAbility())));

                dispAttackPicture();

                //When Hero Attacks

                newHealthEqVillen = opponent.get(0).getHealthMoney() - (int)(Math.sqrt((characAbility.get(oldSpot).getHealthDamageOfAbility()*hero.get(0).getMyArmy().get(0).getArmyMorale()+ hero.get(0).getExperience()/2)/2));
                newHealthEqVillenArmy = opponent.get(0).getMyArmy().get(0).getArmyHealth() - (int)(Math.sqrt((characAbility.get(oldSpot).getArmyDamage()*opponent.get(0).getMyArmy().get(0).getArmyMorale()+ hero.get(0).getExperience()/2)/2));

            }

        }


        displaySetAndCheckForDeathForSimulations();

    }

    public void displaySetAndCheckForDeathForSimulations(){
        int damageToOpp = opponent.get(0).getHealthMoney() - newHealthEqVillen;
        int damageToArmyOpp = opponent.get(0).getMyArmy().get(0).getArmyHealth() - newHealthEqVillenArmy;

        lblResultOfEqu.setText("You did: " + damageToOpp + " damage to the opponents health \n and " + damageToArmyOpp + " points damage to the opponents army health");

        opponent.get(0).setHealthMoney(newHealthEqVillen);
        opponent.get(0).getMyArmy().get(0).setArmyHealth(newHealthEqVillenArmy);

        hero.get(0).setHealthMoney(newHealthEqHero1);
        hero.get(0).getMyArmy().get(0).setArmyHealth(newHealthEqHeroArmy1);

        showResultOfEquationsCheck();
        checkForDeath();
    }

    @FXML
    public void butSpeicalAbilityOne() {
        lblHeroAction.setText(hero.get(0).getCharacterName() + " used " + hero.get(0).getSpecialAbilities().get(0).getTypeOfAbility());

        int oppAbilityUse = (int)(Math.random()*3);
        runBattleSeqenceForLevel3(true,0,oppAbilityUse,0);

    }

    @FXML
    public void butSpecialAbilityTwo() {
        lblHeroAction.setText(hero.get(0).getCharacterName() + " used " + hero.get(0).getSpecialAbilities().get(1).getTypeOfAbility());

        int oppAbilityUse = (int)(Math.random()*3);
        runBattleSeqenceForLevel3(true,1,oppAbilityUse,0);

    }

    @FXML
    public void butSpeicalAbilityThree() {
        lblHeroAction.setText(hero.get(0).getCharacterName() + " used " + hero.get(0).getSpecialAbilities().get(2).getTypeOfAbility());

        int oppAbilityUse = (int)(Math.random()*3);
        runBattleSeqenceForLevel3(true,2,oppAbilityUse,0);

    }


    //COme back and work on this!! @ the end
    @FXML
    public void butResetUpdatedCharacters() {

        resetBackToDefaultStats();
        //This you need the save and load thing!!!

    }
    //apply changes (CC)
    @FXML
    public void butApplyCharacterStatChangesCC() {
        useApplyChange++;
        if (useApplyChange <= 3){
            String inpName = txtChangeName.getText();
            Integer changeHealthPoints = Integer.parseInt(txtChangeHealthPoints.getText());
            String inpChangeArmyName = txtChangeArmyName.getText();
            Integer changeNumTroopsInArmy = Integer.parseInt(txtChangeNumTroopsInArmy.getText());
            Integer changeArmyHealth = Integer.parseInt(txtChangeArmyHealth.getText());
            Integer changeArmyMorale = Integer.parseInt(txtChangeArmyMorale.getText());

            hero.get(0).setCharacterName(inpName);
            hero.get(0).setHealthMoney(changeHealthPoints);
            hero.get(0).setNameOfArmy(inpChangeArmyName);
            hero.get(0).setArmyNum(changeNumTroopsInArmy);

            hero.get(0).getMyArmy().get(0).setArmyHealth(changeArmyHealth);
            hero.get(0).getMyArmy().get(0).setArmyMorale(changeArmyMorale);

            lstShowUpdatedStatsCC.getItems().clear();

            lstShowUpdatedStatsCC.getItems().add("Name: " + hero.get(0).getCharacterName());
            lstShowUpdatedStatsCC.getItems().add("Amount of Money: " + hero.get(0).getHealthMoney());
            lstShowUpdatedStatsCC.getItems().add("Army Name: " + hero.get(0).getNameOfArmy());
            lstShowUpdatedStatsCC.getItems().add("Total Army: " + hero.get(0).getArmyNum());

            lstShowUpdatedStatsCC.getItems().add("Army Health: " + hero.get(0).getMyArmy().get(0).getArmyHealth());
            lstShowUpdatedStatsCC.getItems().add("Army Morale: " + hero.get(0).getMyArmy().get(0).getArmyMorale());

            showResultOfEquationsCheck();

        }else {
            butApplyChanges.setDisable(true);
            resetBackToDefaultStats();
        }

    }
    public void resetBackToDefaultStats(){
        int loadHealthMoney = -1;
        int loadBonusPts = -2;
        int loadArmyNumber = -3;
        int loadArmyBatt = -4;
        int loadArmyHealth = -5;
        int loadArmyMorale = -6;
        int loadExp = -7;
        String loadName = "blah";
        String lastLoadName = "balhduh";

        String loadArmyName = "blah2";
        String loadLastNameArmy = "biyleaf";

        String name = "hh";
        String armyName = "kk";
        //charcaters: name STR, healthMoney Int, bonus points InT, armyNumber Int, army Name Str, armyBattle Impact int,
        // army Health int, army Morale int, experince int (between 1 tp 10)

        //str 0, int 1, int 2, int 3, str 4, int 5, int 6, int 7, int 8

        try{
            FileReader reader = new FileReader("src/main/resources/txtStuff.txt");
            Scanner in = new Scanner(reader);

            loadHealthMoney = in.nextInt();
            loadBonusPts = in.nextInt();
            loadArmyNumber = in.nextInt();
            loadArmyBatt = in.nextInt();
            loadArmyHealth = in.nextInt();
            loadArmyMorale = in.nextInt();
            loadExp = in.nextInt();


        } catch (FileNotFoundException ex) {
            System.out.println("SOMETHING HAS GONE HORRIBLY WRONG WE'RE ALL GONNA DIE!");
        }

        try{
            FileReader reader2 = new FileReader("src/main/resources/txtStuff2.txt");
            Scanner in2 = new Scanner(reader2);

            loadName = in2.next();
            lastLoadName = in2.next();

            loadArmyName = in2.next();
            loadLastNameArmy = in2.next();



        } catch (FileNotFoundException ex) {
            System.out.println("SOMETHING HAS GONE HORRIBLY WRONG WE'RE ALL GONNA DIE!");
        }

        name = loadName + " " + lastLoadName;
        armyName = loadArmyName + " " + loadLastNameArmy;

        System.out.println("loadHealthMoney " + loadHealthMoney);
        System.out.println("loadBonusPts " + loadBonusPts);
        System.out.println("loadArmyNumber " + loadArmyNumber);
        System.out.println("loadArmyBatt " + loadArmyBatt);
        System.out.println("loadArmyHealth " + loadArmyHealth);
        System.out.println("loadArmyMorale " + loadArmyMorale);
        System.out.println("loadExp " + loadExp);

        System.out.println("name " + name);
        System.out.println("armyName " + armyName);

        //charcaters: name STR, healthMoney Int, bonus points InT, armyNumber Int, army Name Str, armyBattle Impact int,
        // army Health int, army Morale int, experince int (between 1 tp 10)

        //str 0, int 1, int 2, int 3, str 4, int 5, int 6, int 7, int 8

        hero.get(0).setCharacterName(name);
        hero.get(0).setHealthMoney(loadHealthMoney);
        hero.get(0).setBonusPoints(loadBonusPts);
        hero.get(0).setArmyNum(loadArmyNumber);
        hero.get(0).setNameOfArmy(armyName);
        hero.get(0).getMyArmy().get(0).setArmyBattleImpact(loadArmyBatt);
        hero.get(0).getMyArmy().get(0).setArmyHealth(loadArmyHealth);
        hero.get(0).getMyArmy().get(0).setArmyMorale(loadArmyMorale);
        hero.get(0).setExperience(loadExp);

        lstShowUpdatedStatsCC.getItems().clear();

        lstShowUpdatedStatsCC.getItems().add("Name: " + hero.get(0).getCharacterName());
        lstShowUpdatedStatsCC.getItems().add("Amount of Money: " + hero.get(0).getHealthMoney());
        lstShowUpdatedStatsCC.getItems().add("Army Name: " + hero.get(0).getNameOfArmy());
        lstShowUpdatedStatsCC.getItems().add("Total Army: " + hero.get(0).getArmyNum());

        lstShowUpdatedStatsCC.getItems().add("Army Health: " + hero.get(0).getMyArmy().get(0).getArmyHealth());
        lstShowUpdatedStatsCC.getItems().add("Army Morale: " + hero.get(0).getMyArmy().get(0).getArmyMorale());

        showResultOfEquationsCheck();

    }

    //SHOP STUFF

    //20
    @FXML
    public void butBuyHealthPotion() {
        if (hero.get(0).getBonusPoints() >= 20){
            hero.get(0).setBonusPoints(-20);
            hero.get(0).setHealthMoney(hero.get(0).getHealthMoney()+100);
            showResultOfEquationsCheck();
        }else{
            idShowForShop.setText("You dont have enough points");
        }
    }

    //20
    @FXML
    public void butButArmyHealthPotion() {
        if (hero.get(0).getBonusPoints() >= 20){
            hero.get(0).setBonusPoints(-20);
            hero.get(0).getMyArmy().get(0).setArmyHealth(hero.get(0).getMyArmy().get(0).getArmyHealth()+50);
            showResultOfEquationsCheck();
        }else{
            idShowForShop.setText("You dont have enough points");
        }
    }

    //50
    @FXML
    public void butBuyMotivationalSpeech() {
        if (hero.get(0).getBonusPoints() >= 50){
            hero.get(0).setBonusPoints(-50);
            hero.get(0).getMyArmy().get(0).setArmyMorale(hero.get(0).getMyArmy().get(0).getArmyMorale()+1);
            showResultOfEquationsCheck();
        }else{
            idShowForShop.setText("You dont have enough points");
        }
    }

    //50
    @FXML
    public void butBuyTrainArmy() {
        if (hero.get(0).getBonusPoints() >= 50){
            hero.get(0).setBonusPoints(-50);
            hero.get(0).getMyArmy().get(0).setArmyBattleImpact(hero.get(0).getMyArmy().get(0).getArmyBattleImpact()+1);
            showResultOfEquationsCheck();
        }else{
            idShowForShop.setText("You dont have enough points");
        }
    }

    @FXML
    public void onClickNoMoneyDoor() {
        randomChooseWinOrLose(0);
    }
    @FXML
    public void onClickedOnSomeMoneyDoor() {
        randomChooseWinOrLose(1);
    }

    @FXML
    public void onClickedOnLotsOfMoneyDoor() {
        randomChooseWinOrLose(2);
    }

    public void randomChooseWinOrLose(int rand){

        if (rand == randWin){
            lblResultOfClickingOnDoors.setText("YOU WON THE GAME! YOU CHOSE THE CORRECT DOOR! YOU FOUND THE ANTIDOTE!");
        }else{
            lblResultOfClickingOnDoors.setText("You choose wrong, you lost the game!!!");
        }


    }





    //Left to do....make UI better for when the player loses or wins. Have it where something happens after 3 times win
    //add graphics to the special abilites
    //add a revive button to revive in level 3 if the player dies.

}