package package01;

public class VisibilityManager {

    UI ui;
    public VisibilityManager(UI userInterface){
        ui = userInterface;

    }
    public void showTitleScreen(){

        //Show the title screen
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        //Hide the game screen
        ui.healthBarPanel.setVisible(false);
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.imagePanel.setVisible(false);

    }
    public void titleToTown(){
        //Hide the title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);

        //Show the game screen
        ui.imagePanel.setVisible(true);
        ui.healthBarPanel.setVisible(true);
        ui.mainTextPanel.setVisible(true);
        ui.playerPanel.setVisible(true);

    }
}
