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
        String loopResponse, firstIn, lastIn;
        double hours, rate, totalPay;
        Scanner input = new Scanner(in);

        try {
            //Begin program loop:

            do {
                out.println("######################");
                out.print("# Hi employee, input your first name: ");
                firstIn = input.next();

                out.print("# Hi employee, input your last name: ");
                lastIn = input.next();

                //Hours worked request:
                out.print("\n# How many hours did you work? \nEnter here: ");
                hours = input.nextDouble();


                //Wage request:
                out.print("\nHow much do you make per hour?\nEnter here: ");
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
                        "worked above 40 hours.\n# Have a great week " + firstIn + " " + lastIn);

                //Loop query
                out.println("Would the next employee like to run the program?\nY = Run again\nN = Exit");
                loopResponse = input.next();
                if (loopResponse.equalsIgnoreCase("y")) {
                    out.println("\n\nThanks, we'll run it again, " + firstIn + " " + lastIn + "!\n");
                }
                else {
                    if (loopResponse.equalsIgnoreCase("n")) {
                        out.println("\n\nThank you for using this application!"
                                +"\n######################");

                    }
                    else {
                        out.println("\n\n\tImproper response!");
                    }
                    break;
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
