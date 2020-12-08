package com.company.DataRacerChart;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Scanner;

public class BarChartRacer {
    public static void main(String[] args){
        //reading argument values from terminal, args[0] = txt file, args[1] = line count "consider using 12"
        int count = Integer.parseInt(args[1]);
        //initialize local scanner from library
        Scanner in = initScanner(args[0]);

        // reading from the input source.
        String title = in.nextLine();
        String xAxis = in.nextLine();
        String source = in.nextLine();

        //calling our barchart object
        com.company.DataRacerChart.BarChart chart = new BarChart(title, xAxis, source);

        //create window, set width and height
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1000, 700);

        //for every line in our file ->
        while (in.hasNextLine()) {

            StdDraw.clear();
            //this code only reads next line, assignment of the string is redundant.
            String s = in.nextLine();
            int n = Integer.parseInt(in.nextLine());

            //create "n" amount of values from file and assigns it into our bar array
            Bar[] bar = new Bar[n];

            //for every record in our source, do ->
            for (int i = 0; i < n; i++) {
                String line = in.nextLine(); //call next line
                String[] arr = line.split(","); //split values whenever value is equal to ","
                String v = arr[3]; //assign 3rd argument, contains date field mostly in files
                int value = Integer.parseInt(v); //cast value as integer
                bar[i] = new Bar(arr[1], value, arr[4]);  // creating new bar for each line.
                System.out.println(" a " + arr[1] + " b " + value + " c " + arr[4]);
                chart.setCaption(arr[0]);//set caption

            } //end of loop

            Arrays.sort(bar);  //Sort array by collection values

            //display bars which greater than zero
            if (bar[bar.length-count].getValue() > 0) {

            //add every single bar to chart object
            for (int i = (bar.length - 1); i >= (bar.length - count); i--) {
                chart.add(bar[i].getName(), bar[i].getValue(), bar[i].getCategory());
            }

            // Output display.
            chart.draw();
            StdDraw.show();
            StdDraw.pause(50);
            chart.reset();

          }
        }
    }

    private static Scanner initScanner(String arg){
        //scanner initializer taken from the default constructor of Scanner
        Scanner scanner = null;
        if (arg == null)
            throw new IllegalArgumentException("argument is null");

        try {
            File file = new File(arg);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis));
                return scanner;
            }

            URL url = BarChartRacer.class.getResource(arg);

            if (url == null) {
                url = BarChartRacer.class.getClassLoader().getResource(arg);
            }

            if (url == null) {
                url = new URL(arg);
            }

            URLConnection site = url.openConnection();

            InputStream is     = site.getInputStream();
            scanner            = new Scanner(new BufferedInputStream(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scanner;
    }

}
