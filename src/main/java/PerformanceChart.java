import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PerformanceChart {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("График производительности");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            XYSeries series = new XYSeries("Производительность");

            try (BufferedReader reader = new BufferedReader(new FileReader("minmaxtest1kk.txt"))) {
                String line = reader.readLine();
                if (line != null) {
                    StringTokenizer tokenizer = new StringTokenizer(line);
                    int count = 0;
                    long start = System.currentTimeMillis();

                    while (tokenizer.hasMoreTokens()) {
                        tokenizer.nextToken();
                        count++;
                        if (count % 1000 == 0) {
                            long time = System.currentTimeMillis() - start;
                            series.add(count, time);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            XYSeriesCollection dataset = new XYSeriesCollection(series);
            JFreeChart chart = ChartFactory.createXYLineChart(
                    "График производительности функции считывания чисел из файла",
                    "Количество чисел",
                    "Затрачиваемое время (миллисекунды)",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true, true, false);

            ChartPanel chartPanel = new ChartPanel(chart);
            frame.setContentPane(chartPanel);
            frame.setVisible(true);
        });
    }
}
