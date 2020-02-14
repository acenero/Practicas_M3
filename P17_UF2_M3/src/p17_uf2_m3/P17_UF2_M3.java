// author @josep garcia acenero
package p17_uf2_m3;
//imports

import java.text.DecimalFormat;
import java.util.Scanner;

public class P17_UF2_M3 {
//global declarations

    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        //variables
        int coin = 0, option;
        System.out.print("Input your coin value: ");
        coin = keyboard.nextInt();
        do {//start of menu
            usermenu();
            option = keyboard.nextInt();
            switch (option) {
                case 1:
                    float dollConv = intToFloat(coin);//call method
                    valuesPrint(option, coin, dollConv, 0.0, "", 0, 0, "");//call method
                    break;
                case 2:
                    double poundConv = intToDouble(coin);//call method
                    valuesPrint(option, coin, (float) 0.0, poundConv, "", 0, 0, "");//call method
                    break;
                case 3:
                    String yenConv = intToString(coin);//call method
                    valuesPrint(option, coin, (float) 0.0, 0.0, yenConv, 0, 0, "");//call method
                    break;
                case 4:
                    int bitConv = stringToInt(coin);//call method
                    valuesPrint(option, coin, (float) 0.0, 0.0, "", bitConv, 0, "");//call method
                    break;
                case 5:
                    int solesConv = floatToInt(coin);//call method
                    valuesPrint(option, coin, (float) 0.0, 0.0, "", 0, solesConv, "");//call method
                    break;
                case 6:
                    String pesosConv = floatToString(coin);
                    valuesPrint(option, coin, (float) 0.0, 0.0, "", 0, 0, pesosConv);//call method
                    break;
                case 7:
                    char letter;
                    System.out.print("Input letter: ");
                    letter = (keyboard.next()).charAt(0);
                    String binary = Integer.toBinaryString(letter);
                    int intConv = charToInt(letter);//call method
                    System.out.println("Letter: " + letter + "=Int value: " + intConv + "=Binary value= " + binary);
                    break;
                case 8:
                    String word;
                    System.out.print("Input a word: ");
                    word = keyboard.next();
                    String wordBin = stringToBinary(word);//call method
                    System.out.println(word + "=" + wordBin + " ");
                    break;
                case 9:
                    int number;
                    System.out.print("Input number: ");
                    number = keyboard.nextInt();
                    char numberChar = intToChar(number);//call method
                    System.out.println(number + "=" + numberChar);

                    break;
                case 10:
                    //Es un código de caracteres, se creó para poder dar números a los caracteres para poder utilizarlos en computación.
                    asciiTable();//call method
                    break;
                case 0:
                    System.out.println("*****Thanks for using our program*****");
                    break;
                default:
                    System.out.println("Invalid option");
            }

        } while (option != 0);//end of menu

    }

    //part 1 int to float (gets euro(int)returns dollars(float))
    private static float intToFloat(int euros) {
        //variables
        float dollars = 0;
        //eu to dollars
        dollars = (float) euros / 0.91f;
        return dollars;
    }

    //part 2 int to double (gets euro(int)returns pounds(double)
    private static double intToDouble(int euros) {
        //variables
        float pounds = 0;
        //eu to pounds
        pounds = euros / 1.18f;
        return pounds;
    }

    //part 3 int to String (gets euro(int)returns yens(String))
    private static String intToString(int euros) {
        //variables
        double yens;
        //eu to yens
        yens = (float) euros / 0.0083f;
        String yensStr = String.valueOf(yens);
        return yensStr;
    }

    //part 4 String to int (gets euro(int converts to string)returns Bitcoins(int))
    private static int stringToInt(int euros) {
        //variables
        String eurostr = String.valueOf(euros);
        int eurosint = Integer.parseInt(eurostr);
        int bitcoins;
        //eu to BTC
        bitcoins = (int) (eurosint / 9046.26f);
        return bitcoins;
    }

    //part 5 float to int (gets euro(int converts to float)returns Soles(int))
    private static int floatToInt(float euros) {
        //variables
        int soles;
        //eu to soles
        soles = (int) (euros / 0.27f);
        return soles;
    }
//part 6 float to String (gets euros(float)return pesos(String))

    private static String floatToString(float euros) {
        //variables
        float pesos;
        //eu to yens
        pesos = euros / 0.0083f;
        String pesosStr = String.valueOf(pesos);
        return pesosStr;
    }
    
//part 7 char to Int ascii code (gets character (char) return)
    private static int charToInt(char character) {
        //variables
        int asciChar;
        asciChar = (int) character;
        return asciChar;
    }
//part 8 converts string to binary
    private static String stringToBinary(String letters) {
        //variables
        StringBuilder binarys = new StringBuilder();
        for (int i = 0; i < letters.length(); i++) {
            int ascii = letters.charAt(i);
            binarys.append(Integer.toBinaryString(ascii));
        }
        return binarys.toString();
    }
//part 9 converts asci to char equivalent
    private static char intToChar(int num) {
        //variables
        char asciChar;
        asciChar = (char) num;
        return asciChar;
    }
//part 10 prints the ascii table and converts int to char and hexadecimal

    private static void asciiTable() {
        //loop to generate ascii codes
        for (int i = 0; i < 255; i++) {
            System.out.println(i +": "+ Integer.toString(i,16)//converts ascii value to hexadecimal 
                    + ": " + (char) i);//converts to char equivalent
        }
    }

//Printing values with decimal format
    private static void valuesPrint(int opMenu, int euroDef, float dollarConvert, double poundConvert, String yenConvert, int bitConvert, int solConvert, String pesConvert) {
        DecimalFormat df = new DecimalFormat(".00");
        //print values
        if (opMenu == 1) {
            System.out.println(df.format(euroDef) + "€ = " + df.format(dollarConvert) + "$");
        }
        if (opMenu == 2) {
            System.out.println(df.format(euroDef) + "€ = " + df.format(poundConvert) + "£");
        }
        if (opMenu == 3) {
            System.out.println(df.format(euroDef) + "€ = " + yenConvert + "¥");
        }
        if (opMenu == 4) {
            System.out.println(df.format(euroDef) + "€ = " + df.format(bitConvert) + "BTC");
        }
        if (opMenu == 5) {
            System.out.println(df.format(euroDef) + "€ = " + df.format(solConvert) + "S/");
        }
        if (opMenu == 6) {
            System.out.println(df.format(euroDef) + "€ = " + df.format(pesConvert) + "₱");
        }
        if (opMenu == 7) {
            System.out.println("");
        }
    }

//Menu options
    private static void usermenu() {//Start of the menu
        System.out.println("");
        System.out.println("Euros to Dollars: ");
        System.out.println("Euros to Pounds: ");
        System.out.println("Euros to Yens: ");
        System.out.println("Euros to Bitcoins: ");
        System.out.println("Euros to Soles: ");
        System.out.println("Euros to Pesos: ");
        System.out.println("Option7: ");
        System.out.println("Option0: Exit");
        System.out.println("\nOption?: ");
    }//end of menu

}
