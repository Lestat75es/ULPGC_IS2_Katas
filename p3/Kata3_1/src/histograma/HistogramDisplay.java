package histograma;

import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame {

    public HistogramDisplay() {
        super("HISTOGRAM");
        setContentPane(createPanel());
        pack();
    }

    private ChartPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500, 400));
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                null,
                "Dominios",
                "Nº de EMails",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
        return chart;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(7, "ENE", "ulpgc.es");
        dataset.addValue(5, "ENE", "hotmail.com");
        dataset.addValue(10, "ENE", "gmail");
        dataset.addValue(8, "FEB", "ulpgc.es");
        dataset.addValue(6, "FEB", "hotmail.com");
        dataset.addValue(11, "FEB", "gmail");
        return dataset;
    }

    public void execute() {
        setVisible(true);
    }
}
