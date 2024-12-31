import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SideMenu extends JPanel implements ActionListener {

    Dimension buttonSize;
    JButton arrowTower;
    JButton confuseTower;
    JButton bombTower;
    JButton tagTower;
    JButton iceTower;
    JButton magicTower;
    JButton alchemyTower;
    JButton superMonkey;
    JLabel coinCounter;
    JPanel panel;
    TowerLogic towerLogic;
    int currentCoin;
    public SideMenu(ArrayList<PlacedTowers> towers) {
        buttonSize = new Dimension(100, 50);
        currentCoin= 0;
        this.setLayout(new BorderLayout());
        coinCounter = new JLabel("0");
        coinCounter.setPreferredSize(new Dimension(200, 100));
        this.add(coinCounter, BorderLayout.NORTH);
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 500));
        panel.setLayout(new GridLayout(4, 1));
        arrowTower = new JButton("Arrow");
        confuseTower = new JButton("confuse");
        bombTower = new JButton("bomb");
        tagTower = new JButton("spike");
        iceTower = new JButton("ice");
        magicTower = new JButton("magic");
        alchemyTower = new JButton("alchemy");
        superMonkey = new JButton("super shoot");



        arrowTower.addActionListener(this);
        confuseTower.addActionListener(this);
        bombTower.addActionListener(this);
        tagTower.addActionListener(this);
        iceTower.addActionListener(this);
        magicTower.addActionListener(this);
        alchemyTower.addActionListener(this);
        superMonkey.addActionListener(this);

        panel.add(arrowTower);
        panel.add(confuseTower);
        panel.add(bombTower);
        panel.add(tagTower);
        panel.add(iceTower);
        panel.add(magicTower);
        panel.add(alchemyTower);
        panel.add(superMonkey);
        this.add(panel, BorderLayout.CENTER);

    }

    public void updateCoinCounter(int coins){
        currentCoin += coins;
        coinCounter.setText(currentCoin + "");
    }

    public int getCoins() {
        return Integer.parseInt(coinCounter.getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(arrowTower)) {
            if (Integer.parseInt(coinCounter.getText()) >= 100) {
                currentCoin -= 100;
                towerLogic.setTowerName("Arrow");
            }
        } else if (e.getSource().equals(bombTower)) {

        } else if (e.getSource().equals(tagTower)) {

        } else if (e.getSource().equals(magicTower)) {

        } else if (e.getSource().equals(alchemyTower)) {

        } else if (e.getSource().equals(iceTower)) {

        } else if (e.getSource().equals(confuseTower)) {

        } else if (e.getSource().equals(magicTower)) {

        }

    }

    public void setTowerLogic(TowerLogic towerLogic) {
        this.towerLogic = towerLogic;
    }
}
