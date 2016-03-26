package application.view.charts;

import application.model.body.BodyHistory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Michał on 17.03.2016.
 */
public class LineChart extends JFrame {

    private BodyHistory bodyHistory;

    public LineChart(final String title, BodyHistory bodyHistory){
        super(title);

        this.bodyHistory = bodyHistory;
        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);

        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 800));
        setContentPane(chartPanel);
    }


    private XYDataset createDataset() {

        final XYSeries weight = new XYSeries("Weight");
        final XYSeries height = new XYSeries("Height");
        final XYSeries neck = new XYSeries("Neck");
        final XYSeries chest = new XYSeries("Chest");
        final XYSeries biceps = new XYSeries("biceps");
        final XYSeries waist = new XYSeries("waist");
        final XYSeries abdomen = new XYSeries("Abdomen");
        final XYSeries hips = new XYSeries("Hips");
        final XYSeries thigh = new XYSeries("Thigh");
        final XYSeries calf = new XYSeries("Calf");

        for(int i=0; i< bodyHistory.getBodyHistory().size(); i++){
            weight.add(i, bodyHistory.getBodyHistory().get(i).getWeight());
            height.add(i, bodyHistory.getBodyHistory().get(i).getHeight());
            neck.add(i, bodyHistory.getBodyHistory().get(i).getNeckCircuit());
            chest.add(i, bodyHistory.getBodyHistory().get(i).getChestCircuit());
            biceps.add(i, bodyHistory.getBodyHistory().get(i).getBicepsCircuit());
            waist.add(i, bodyHistory.getBodyHistory().get(i).getWaistCircuit());
            abdomen.add(i, bodyHistory.getBodyHistory().get(i).getAbdomenCircuit());
            hips.add(i, bodyHistory.getBodyHistory().get(i).getHipsCircuit());
            thigh.add(i, bodyHistory.getBodyHistory().get(i).getThighCircuit());
            calf.add(i, bodyHistory.getBodyHistory().get(i).getCalfCircuit());
        }

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(weight);
        dataset.addSeries(height);
        dataset.addSeries(neck);
        dataset.addSeries(chest);
        dataset.addSeries(biceps);
        dataset.addSeries(waist);
        dataset.addSeries(abdomen);
        dataset.addSeries(hips);
        dataset.addSeries(thigh);
        dataset.addSeries(calf);

        return dataset;
    }

    private JFreeChart createChart(final XYDataset dataset) {

        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Body Dimension History",      // chart title
                "Measurments",                      // x axis label
                "values",                      // y axis label
                dataset,                  // data
                PlotOrientation.VERTICAL,
                true,                     // include legend
                true,                     // tooltips
                false                     // urls
        );

        chart.setBackgroundPaint(Color.white);


        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.blue);
        plot.setRangeGridlinePaint(Color.blue);
        plot.setBackgroundAlpha(0.5f);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesShapesVisible(1, false);

        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        return chart;

    }

}
