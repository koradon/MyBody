package application.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.controler.FormController;
import application.model.Body;
import application.model.BodyHistory;
import application.view.charts.LineChart;
import org.jfree.ui.RefineryUtilities;


/**
 * Created by Michał on 17.03.2016.
 */
public class AddBodyDataWindow extends JFrame {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    private int DEFAULT_WIDTH = screenSize.width;
    private int DEFAULT_HEIGHT = screenSize.height;

    @Override
    public void setSize(int width, int height) {
        super.setSize(DEFAULT_WIDTH/2, DEFAULT_HEIGHT/2);
    }

    public AddBodyDataWindow(){
        final JTextField weightTF = new JTextField();
        final JTextField heightTF = new JTextField();
        final JTextField neckTF = new JTextField();
        final JTextField chestTF = new JTextField();
        final JTextField bicepsTF = new JTextField();
        final JTextField waistTF = new JTextField();
        final JTextField abdomenTF = new JTextField();
        final JTextField hipsTF = new JTextField();
        final JTextField thighTF = new JTextField();
        final JTextField calfTF = new JTextField();


        JPanel centerPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel southPanel = new JPanel();
        final JPanel eastPanel = new JPanel();


        centerPanel.setLayout(new GridLayout(10, 2));
        centerPanel.add(new JLabel("Weight: ", SwingConstants.RIGHT));
        centerPanel.add(weightTF);
        centerPanel.add(new JLabel("Height: ", SwingConstants.RIGHT));
        centerPanel.add(heightTF);
        centerPanel.add(new JLabel("Neck Circuit: ", SwingConstants.RIGHT));
        centerPanel.add(neckTF);
        centerPanel.add(new JLabel("Chest Circuit: ", SwingConstants.RIGHT));
        centerPanel.add(chestTF);
        centerPanel.add(new JLabel("Biceps Circuit: ", SwingConstants.RIGHT));
        centerPanel.add(bicepsTF);
        centerPanel.add(new JLabel("Waist Circuit: ", SwingConstants.RIGHT));
        centerPanel.add(waistTF);
        centerPanel.add(new JLabel("Abdomen Circuit: ", SwingConstants.RIGHT));
        centerPanel.add(abdomenTF);
        centerPanel.add(new JLabel("Hips Circuit: ", SwingConstants.RIGHT));
        centerPanel.add(hipsTF);
        centerPanel.add(new JLabel("Thigh Circuit: ", SwingConstants.RIGHT));
        centerPanel.add(thighTF);
        centerPanel.add(new JLabel("Calf Circuit: ", SwingConstants.RIGHT));
        centerPanel.add(calfTF);



        northPanel.add(new JLabel("Please fill your dimensions", SwingConstants.CENTER));


        eastPanel.setVisible(false);




        JButton saveButton = new JButton("Save");
        southPanel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(FormController.saveBodyData(new Body(Double.parseDouble(weightTF.getText()),
                                              Double.parseDouble(heightTF.getText()),
                                              Double.parseDouble(neckTF.getText()),
                                              Double.parseDouble(chestTF.getText()),
                                              Double.parseDouble(bicepsTF.getText()),
                                              Double.parseDouble(waistTF.getText()),
                                              Double.parseDouble(abdomenTF.getText()),
                                              Double.parseDouble(hipsTF.getText()),
                                              Double.parseDouble(thighTF.getText()),
                                              Double.parseDouble(calfTF.getText())))){
                    System.out.println("Saved");
                }

            }
        });

        JButton showPlotButton = new JButton("Show Plot");
        southPanel.add(showPlotButton);
        showPlotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LineChart chart = new LineChart("Body Dimension History",
                                                FormController.getBodyHistory());
                chart.pack();
                RefineryUtilities.centerFrameOnScreen(chart);
                chart.setVisible(true);
                //eastPanel.setVisible(true);
            }
        });

        add(centerPanel, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);



        pack();
        //setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }


}
