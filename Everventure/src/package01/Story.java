package package01;

import package02.*;

import javax.swing.*;

public class Story {

    Game game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();
    Monster monster;

    int silverRing;

    public Story(Game g, UI Interface, VisibilityManager visibilityManager) {

        game = g;
        ui = Interface;
        vm = visibilityManager;

    }

    public void defaultSetup() {

        player.hp = 15;
        ui.healthBar.setValue(player.hp);
        player.currrentWeapon = new Weapon_Knife();
        ui.weaponNameLabel.setText(player.currrentWeapon.name + " (" + player.currrentWeapon.damage + ")");

        silverRing = 0;

    }

    public void selectPosition(String nextPosition) {
        switch (nextPosition) {
            case "townGate" -> townGate();
            case "talkGuard" -> talkGuard();
            case "attackGuard" -> attackGuard();
            case "crossRoad" -> crossRoad();
            case "north" -> north();
            case "east" -> east();
            case "south" -> south();
            case "fight" -> fight();
            case "playerAttack" -> playerAttack();
            case "monsterAttack" -> monsterAttack();
            case "win" -> win();
            case "lose" -> lose();
            case "toTitle" -> toTitle();
            case "townGate_2" -> townGate_2();
        }
    }

    public void townGate() {

        ui.image = new ImageIcon(".//img//towngate4.jpg");
        ui.imageLabel.setIcon(ui.image);

        ui.choiceButtonPanel.setVisible(false);

        ui.text = "You are approaching the entrance of a town.\n Suddenly, you meet a guard. \n\nWhat do you do?";
        ui.prepareText();
        ui.choice1.setText("Talk to this guard");
        ui.choice2.setText("Attack this guard");
        ui.choice3.setText("Leave");
        ui.choice4.setText("");

        game.nextPosition1 = "talkGuard";
        game.nextPosition2 = "attackGuard";
        game.nextPosition3 = "crossRoad";
        game.nextPosition4 = "";



    }
    public void townGate_2() {

        ui.image = new ImageIcon(".//img//towngate4.jpg");
        ui.imageLabel.setIcon(ui.image);

        ui.choiceButtonPanel.setVisible(false);

        ui.text = "You return to the town and you notice the same guard standing there.\nWhat do you do?";
        ui.prepareText();
        ui.choice1.setText("Talk to this guard");
        ui.choice2.setText("Attack this guard");
        ui.choice3.setText("Leave");
        ui.choice4.setText("");

        game.nextPosition1 = "talkGuard";
        game.nextPosition2 = "attackGuard";
        game.nextPosition3 = "crossRoad";
        game.nextPosition4 = "";
    }

    public void talkGuard() {
        ui.image = new ImageIcon(".//img//townguard2.jpg");
        ui.imageLabel.setIcon(ui.image);

        if(silverRing==0)
        {
            ui.choiceButtonPanel.setVisible(false);
            ui.text = "Guard: \nHello, unfamiliar face. \nUnfortunately, you have to be wearing a silver ring in order to enter this town.\n";
            ui.prepareText();
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "townGate";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
        else
        {
            ending();
        }

    }

    public void attackGuard() {
        ui.image = new ImageIcon(".//img//townguard2.jpg");
        ui.imageLabel.setIcon(ui.image);
        ui.choiceButtonPanel.setVisible(false);
        ui.text = "Guard: \n You really want to do this? \n\nThe guard attacked you. \nYou receive 4 damage";
        ui.prepareText();
        player.hp = player.hp - 4;
        ui.healthBar.setValue(player.hp);

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "townGate";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void crossRoad() {
        ui.image = new ImageIcon(".//img//crossroad.jpg");
        ui.imageLabel.setIcon(ui.image);
        if(silverRing == 0) {
            ui.choiceButtonPanel.setVisible(false);
            ui.text = "You are at a crossroad.\n Go west and you will be back to the town.";
            ui.prepareText();
            ui.choice1.setText("Go north");
            ui.choice2.setText("Go east");
            ui.choice3.setText("Go south");
            ui.choice4.setText("Go west");

            game.nextPosition1 = "north";
            game.nextPosition2 = "east";
            game.nextPosition3 = "south";
            game.nextPosition4 = "townGate_2";
        }
        else
        {
            ui.choiceButtonPanel.setVisible(false);
            ui.text = "Since you have found the silver ring, you should go west ( Back to the town ).";
            ui.prepareText();
            ui.choice1.setText("Go north");
            ui.choice2.setText("Go east");
            ui.choice3.setText("Go south");
            ui.choice4.setText("Go west");

            game.nextPosition1 = "north";
            game.nextPosition2 = "east";
            game.nextPosition3 = "south";
            game.nextPosition4 = "townGate_2";

        }

    }

    public void north() {
        ui.image = new ImageIcon(".//img//river.jpg");
        ui.imageLabel.setIcon(ui.image);
        ui.choiceButtonPanel.setVisible(false);
        ui.text = "You find a river and you drink the water from it. In addition, you rest at the riverside.\n\n(Your HP recovered by 2)";
        ui.prepareText();
        player.hp = player.hp + 2;
        player.hp = Math.min(player.hp, 15);
        ui.healthBar.setValue(player.hp);
        ui.choice1.setText("Go south");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");


        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void east() {
        ui.image = new ImageIcon(".//img//longsword.jpg");
        ui.imageLabel.setIcon(ui.image);

        if(player.currrentWeapon.name.equals("Knife"))
        {
            ui.choiceButtonPanel.setVisible(false);
            ui.text = "You walked across this huge plain and found an abandoned Long Sword!\n\n(You got a Long Sword)";
            ui.prepareText();
            player.currrentWeapon = new Weapon_LongSword();
            ui.weaponNameLabel.setText(player.currrentWeapon.name + " (" + player.currrentWeapon.damage + ")");
        }
        else
        {
            ui.choiceButtonPanel.setVisible(false);
            ui.text = "It seems you have found another " + player.currrentWeapon.name + " but you already have one.";
            ui.prepareText();
        }
        ui.choice1.setText("Go west");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void south() {
        int k = 0;
        char ch;
        char[] vowels = {'A','E','I','O','U'};
        int i = new java.util.Random().nextInt(100) + 1;

        if(i< 90){
            ui.image = new ImageIcon(".//img//orc.jpg");
            ui.imageLabel.setIcon(ui.image);
            monster = new Monster_Orc();
        }
        else
        {
            ui.image = new ImageIcon(".//img//wizard.jpg");
            ui.imageLabel.setIcon(ui.image);
            monster = new Monster_Wizard();
        }
        ch = monster.name.charAt(0);
        for(int j = 0 ; j < 5 ; j++)
        {
            if(ch==vowels[j])
            {
                k++;
                break;
            }

        }
        if(k==0 && player.currrentWeapon.name.equals("Knife"))
        {
            ui.choiceButtonPanel.setVisible(false);
            ui.text = "You encounter a " + monster.name + "! A " + player.currrentWeapon.name + " will not be enough to deal with it.";
            ui.prepareText();
        }
        else if(k==0 && !player.currrentWeapon.name.equals("Knife"))
        {
            ui.choiceButtonPanel.setVisible(false);
            ui.text = "You encounter a " + monster.name + "!";
            ui.prepareText();
        }
        else if( k!=0 && player.currrentWeapon.name.equals("Knife"))
        {
            ui.choiceButtonPanel.setVisible(false);
            ui.text = "You encounter an " + monster.name + "! A " + player.currrentWeapon.name + " will not be enough to deal with it.";
            ui.prepareText();
        }
        else
        {
            ui.choiceButtonPanel.setVisible(false);
            ui.text = "You encounter an " + monster.name + "!";
            ui.prepareText();
        }

        ui.choice1.setText("Fight");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "fight";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void fight() {

        ui.choiceButtonPanel.setVisible(false);
        ui.text = monster.name + ": " + monster.hp + "\n\nWhat will you do?";
        ui.prepareText();
        ui.choice1.setText("Attack");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "playerAttack";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void playerAttack() {

        ui.choiceButtonPanel.setVisible(false);

        int playerDamage = new java.util.Random().nextInt(player.currrentWeapon.damage);

        if ( playerDamage != 0) {
            ui.text = "You dealt " + playerDamage + " damage to the " + monster.name + "!";
            ui.prepareText();
        }
        else
        {
            ui.text = "The " + monster.name + " completely parried your hit.";
            ui.prepareText();
        }

        monster.hp = monster.hp - playerDamage;

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (monster.hp > 0) {
            game.nextPosition1 = "monsterAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else {
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }
        public void monsterAttack () {

            ui.choiceButtonPanel.setVisible(false);

            int monsterDamage = new java.util.Random().nextInt(monster.attack);

            if(monsterDamage != 0) {
                ui.text = monster.attackMessage + "\nYou received " + monsterDamage + " damage!";
                ui.prepareText();
            }
            else
            {
                ui.text = "The " + monster.name + " tried to attack you, but you parried that successfully.";
                ui.prepareText();
            }

            player.hp = player.hp - monsterDamage;
            player.hp = Math.max(0, player.hp);

            ui.healthBar.setValue(player.hp);

            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            if (player.hp > 0) {
                game.nextPosition1 = "fight";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            } else {
                game.nextPosition1 = "lose";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }


        }

        public void win () {
        ui.image = new ImageIcon(".//img//silverring.jpg");
        ui.imageLabel.setIcon(ui.image);

            ui.choiceButtonPanel.setVisible(false);
            if(silverRing == 0)
                ui.text = "You have defeated the " + monster.name + " and you obtained a ring! \n\n ( You obtained a Silver Ring! ) ";
            else
                ui.text = "You have defeated the " + monster.name + ", but, unfortunately, you cannot equip another ring.";

            ui.prepareText();

            silverRing = 1;

            ui.choice1.setText("Go west");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "crossRoad";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        }
    public void lose(){

        ui.choiceButtonPanel.setVisible(false);
        ui.text = "YOU DIED!";
        ui.prepareText();

        ui.choice1.setText("To the title screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }
    public void ending() {
        ui.image = new ImageIcon(".//img//ending.jpg");
        ui.imageLabel.setIcon(ui.image);

        ui.choiceButtonPanel.setVisible(false);
        ui.text = "Guard: Wow, what is this? A silver ring?\n I thought there were no silver rings left in our lands!\nI am honored to welcome you to our town."+
                "\n\n<LAAT>.";
        ui.prepareText();
        ui.choice1.setText("E");
        ui.choice2.setText("N");
        ui.choice3.setText("D");
        ui.choice4.setText("!");
    }

    public void toTitle() {

        defaultSetup();
        vm.showTitleScreen();
    }


}
