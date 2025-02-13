package com.zipcodewilmington.scientificcalculator;

/**
 * Created by leon on 2/9/18.
 */
public class MainApplication {

    //variables
    public static void main(String[] args) {

//        String s = Console.getStringInput("Enter a function");
//        Integer i = Console.getIntegerInput("Enter an integer");
//        Double d = Console.getDoubleInput("Enter a double.");

//        Console.println("The user input %s as a string", s);
//        Console.println("The user input %s as a integer", i);
//        Console.println("The user input %s as a double", d);



// THIS IS FOR THE MAIN CALCULATOR
        Calculator mainCalc = new Calculator();
        boolean isOn = true;

        Console.println("Type secret for a secret 😇");
        Console.println("Functions: +, -, /, *, square, square root, inverse, invert, exponent, cube");
        Console.println("Scientific: cos, sin, tan, arcSin, arcCos, arcTan, log, ln, inverse log, inverse ln, degrees, radians");
        Console.println("The current value is " + mainCalc.memoryValue);

        while (isOn) {
            String whatFunction = Console.getStringInput("Enter a function, press c to clear, e to exit\nm to save, mrc to return memory, mc to reset memory");
            double number;
            double savedValue;
            double mrcValue = 0;
            switch (whatFunction) {
                case "c":
                    mainCalc.memoryValue = 0.0;
                    break;
                case "e":
                    isOn = false;
                    return;
                case "+":
                    number = Console.getDoubleInput("Enter a number");
                    mainCalc.addition(number);
                    break;
                case "-":
                    number = Console.getDoubleInput("Enter a number");
                    mainCalc.subtraction(number);
                    break;
                case "/":
                    number = Console.getDoubleInput("Enter a number");
                    mainCalc.division(number);
                    break;
                case "*":
                    number = Console.getDoubleInput("Enter a number");
                    mainCalc.multiplication(number);
                    break;
                case "square":
                    mainCalc.square();
                    break;
                case "inverse":
                    number = Console.getDoubleInput("Enter a number");
                    mainCalc.inverse(number);
                    break;
                case "square root":
                    mainCalc.squareRoot();
                    break;
                case "exponent":
                    number = Console.getDoubleInput("Enter a number");
                    mainCalc.exponent(number);
                    break;
                case "invert":
                    mainCalc.switchSign();
                    break;
                case "factorial":
                    mainCalc.factorial();
                    break;
                case "m":
                    mainCalc.m();
//                    savedValue = mainCalc.memoryValue;
//                    Console.println(savedValue + " has been saved.");
                    Console.println((mainCalc.savedValue) + " has been saved.");
                    break;
                case "mrc":
                    mainCalc.mrc();
                    Console.println(mainCalc.savedValue + " was the original value.");
                   // mainCalc.mrc();
                   // Console.println(mainCalc.memoryValue + " was the original value.");
                    break;
                case "mc":
                    mainCalc.mc();
                    Console.println("Memory has been reset.");
                    break;
                case "sin":
                    mainCalc.sine();
                    break;
                case "cos":
                    mainCalc.cosine();
                    break;
                case "tan":
                    mainCalc.tangent();
                    break;
                case "arcSin":
                    mainCalc.inverseSine();
                    break;
                case "arcCos":
                    mainCalc.inverseCosine();
                    break;
                case "arcTan":
                    mainCalc.inverseTangent();
                    break;
                case "log":
                    mainCalc.log();
                    break;
                case "ln":
                    mainCalc.naturalLog();
                    break;
                case "inverse log":
                    mainCalc.inverseLog();
                    break;
                case "inverse ln":
                    mainCalc.inverseNatLog();
                    break;
                case "Degrees":
                    mainCalc.toDegrees();
                    break;
                case "Radians":
                    mainCalc.toRadians();
                    break;
                case "secret":
                    String s = Console.getStringInput("What is the password?");
                    if (s.equals("01134")) {
                        System.out.println("Hello! 🙋‍♀️");
                    } else {
                        System.out.println("Wrong password.");
                    }
                    break;
                case "cube":
                    mainCalc.cubed();
                    break;


            } // switch ends

            Console.println("The value is now: %f", mainCalc.memoryValue);
        } // END OF MAIN CALCULATOR


    } // void main

    // Main Calculator
    public static class Calculator {
        // this is the number on the screen of the calculator

        public double memoryValue = 0.0;
        public double savedValue = 0.0;

        public void m(){
            this.savedValue = this.memoryValue;
        }

        public void mrc(){
            this.memoryValue = this.savedValue;
        }
        public void mc(){
            this.savedValue = 0.0;
        }


        //Main Math
        public void addition(double x) {
            this.memoryValue += x;
        }

        public void subtraction(double x) {
            this.memoryValue -= x;
        }
        public void factorial() {
            double total = 1;
            for (double i = memoryValue; i >= 1; i--) {
                total = (total * i);
            }
            this.memoryValue = total;
        }
        public void multiplication(double x) {
            this.memoryValue = memoryValue * x;
        }

        public void division(double x) {
            this.memoryValue = memoryValue / x;
            try {
                if (x == 0) {
                    throw new ArithmeticException("Err");
                }
            } catch (ArithmeticException e) {
                System.err.println("Err\nPress c to clear");
            }
        } //

        public void square() {
            this.memoryValue = memoryValue * memoryValue;
        }


        public void squareRoot() {
            this.memoryValue = Math.sqrt(memoryValue);
        }

        public void inverse(double x) {
            this.memoryValue = (1 / memoryValue);
        }

        public void exponent(double x) {
            this.memoryValue = Math.pow(memoryValue, x);
        }

        public void switchSign() {
            this.memoryValue = memoryValue * -1.0;
        }

        //Error
        public String err() {
            String message = "Err";
            return message;
        }


        //Trig Functions

            public void sine() {
                this.memoryValue = Math.sin(memoryValue);
            }

            public void cosine() {
                this.memoryValue = Math.cos(memoryValue);
            }

            public void tangent() {
                this.memoryValue = Math.tan(memoryValue);
            }

            // outputs in radians
            public void inverseSine() {
                this.memoryValue = Math.asin(memoryValue);
            }

            public void inverseCosine() {
                this.memoryValue = Math.acos(memoryValue);
            }

            public void inverseTangent() {
                this.memoryValue = Math.atan(memoryValue);
            }

            //Log Functions
            public void log() {
                this.memoryValue = Math.log10(memoryValue);
            }

            public void inverseLog() {
                this.memoryValue = Math.pow(10, memoryValue);
            }

            public void naturalLog() {
                this.memoryValue = Math.log(memoryValue);
            }

            public void inverseNatLog() {
                this.memoryValue = Math.exp(memoryValue);
            }

            //Factorial


            //Switch Units
            public void toDegrees() {
                this.memoryValue = Math.toDegrees(memoryValue);
            }

            public void toRadians() {
                this.memoryValue = Math.toRadians(memoryValue);
            }


            //Display Mode
        public void switchUnitsMode(String mode){

        }
//        public void toOctal() {
//           this.memoryValue = Double.toOctalString(memoryValue);
//        }
//
//        public void toBinary() {
//            this.memoryValue = Integer.toBinaryString(memoryValue);
//        }
//
//        public void binaryToDecimal() {
//            return Integer.parseInt(binary);
//        }
//
//        public String toHexa(int x) {
//            return Integer.toHexString(x);
//        }

            //Additional Functions
            public void cubed() {
                this.memoryValue = Math.cbrt(memoryValue);
            }

            public String hello() {
                String message = "01134";
                return message;
            }
        } //Sci Calc

    public static class SciCalcSci {
        public double testValue = 0.98;
        public double savedValue = 0.0;
        public void sine() {
            this.testValue = Math.sin(testValue);
        }

        public void cosine() {
            this.testValue = Math.cos(testValue);
        }

        public void tangent() {
            this.testValue = Math.tan(testValue);
        }

        // outputs in radians
        public void inverseSine() {
            this.testValue = Math.asin(testValue);
        }

        public void inverseCosine() {
            this.testValue = Math.acos(testValue);
        }

        public void inverseTangent() {
            this.testValue = Math.atan(testValue);
        }

        //Log Functions
        public void log() {
            this.testValue = Math.log10(testValue);
        }

        public void inverseLog() {
            this.testValue = Math.pow(10, testValue);
        }

        public void naturalLog() {
            this.testValue = Math.log(testValue);
        }

        public void inverseNatLog() {
            this.testValue = Math.exp(testValue);
        }

        //Factorial
        public void factorial() {
            double total = 1;
            for (double i = testValue; i >= 1; i--) {
                total = (total * i);
            }
            this.testValue = total;
        }

        //Switch Units
        public void toDegrees() {
            this.testValue = Math.toDegrees(testValue);
        }

        public void toRadians() {
            this.testValue = Math.toRadians(testValue);
        }
        public void inverse(double x) {
            this.testValue = (1 / testValue);
        }

        //Display Mode
//        public void toOctal() {
//           this.testValue = Double.toOctalString(testValue);
//        }
//
//        public void toBinary() {
//            this.testValue = Integer.toBinaryString(testValue);
//        }
//
//        public void binaryToDecimal() {
//            return Integer.parseInt(binary);
//        }
//
//        public String toHexa(int x) {
//            return Integer.toHexString(x);
//        }

        //Additional Functions
        public void cubed() {
            this.testValue = Math.cbrt(testValue);
        }

//        public String hello() {
//            String message = "01134";
//            return message;
//        }
    } //Sci Calc


} // class


