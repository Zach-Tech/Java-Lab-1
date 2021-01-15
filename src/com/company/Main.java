//Zachary Childers CPT-236-A01
//Java Lab-1

//Imports
package com.company;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {





        //My Variables
        //Using doubles in case of rates
        //Such as $9.25 or Hours such as
        // 40.50
        String loopResponse, nameIn;
        double hours, rate, totalPay;
        Scanner input = new Scanner(in);


        try {
            //Begin program loop:
            do {
                //Name Request:
                out.println("######################");
                out.println("# Hi employee, input your name: ");
                nameIn = input.nextLine();

                //Hours worked request:
                out.println("# How many hours did you work? \nEnter here: ");
                hours = input.nextDouble();


                //Wage request:
                out.println("How much do you make per hour?\nEnter here: ");
                rate = input.nextDouble();


                //Begin Calculations:
                if (hours <= 40) {
                    totalPay = hours * rate;
                } else {
                    totalPay =
                            (40 * rate) +
                                    ((hours - 40) *
                                            (rate * 1.5));
                }

                //currency formatting + output
                out.print(NumberFormat.getCurrencyInstance(new Locale("en",
                        "US")).format(totalPay) + " is your weekly wage.\n# We calculated overtime if you " +
                        "worked above 40 hours.\n# Have a great week " + nameIn);
                //Loop query
                out.println("Would the next employee like to run the program?\nY = Run again\nN = Exit");
                loopResponse = input.next();
                if (loopResponse.equalsIgnoreCase("y")) {
                    out.println("\n\nHave a fantastic day, " + nameIn + "!");
                    out.println("Continuing.");
                }
                else {
                    if (loopResponse.equalsIgnoreCase("n")) {
                        out.println("\n\nThank you for using this application!");
                        break;}
                    else {
                        out.println("\n\n\tImproper response!");
                        break;
                    }
                }
            } while (loopResponse.equalsIgnoreCase("Y"));
        }
        catch (Exception e)
        {
            Main.infoBox("Unknown error in your response.\n" +
                    "Please answer the questions accordingly and correctly.", "Error!");
        }
    }

    private static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);

    }
}
