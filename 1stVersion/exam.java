/**
 * 这个类是用来写计算器中要用的操作符
 * 一个操作符写一个函数
 *
 * @param e
 */

import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class exam {

    //sqrt函数
    static public String Sqr(String[] X) {
        String[] newstring = new String[X.length];
        String pop = "";
        int i;
        int M = 0;
        for (i = 0; i < X.length; i++) {

            if (X[i].startsWith("R")) {
                String XXX = X[i].substring(1, X[i].length());


                double result;
                double a = Double.parseDouble(XXX);
                result = Math.sqrt(a);
                newstring[M] = Double.toString(result);
                M++;


            } else {

                newstring[M] = X[i];
                M++;

            }

        }
        for (int ii = 0; ii < newstring.length; ii++) {
            if (newstring[ii] != null)
                pop += newstring[ii];

        }

        return pop;

    }

    //power平方函数
    static public String ostwo(String[] X) {
        String[] newstring = new String[X.length];
        String pop = "";
        int i;
        int M = 0;
        for (i = 0; i < X.length; i++) {

            if (X[i].endsWith("^")) {
                String[] XX = X[i].split(Pattern.quote("^"));
                double result;
                double a = Double.parseDouble(XX[0]);
                result = a * a;
                if (X[i].startsWith("+"))
                    newstring[M] = "+" + Double.toString(result);
                else if (X[i].startsWith("-"))
                    newstring[M] = "+" + Double.toString(result);

                else
                    newstring[M] = Double.toString(result);
                M++;
            } else {
                newstring[M] = X[i];
                M++;
            }

        }
        for (int ii = 0; ii < newstring.length; ii++) {
            if (newstring[ii] != null)
                pop += newstring[ii];
        }

        return pop;

    }

    //
    static public String[] divide(String m) {
        int ii = 0;

        // int x=1;
        char[] operations = new char[m.length()];
        String[] nums = new String[100];
        boolean mm = false;
        boolean mn = false;
        for (int i = 0; i < m.length(); i++) {
            operations[i] = m.charAt(i);
            if (operations[i] == '+' & mm == true) {
                nums[ii] = "-";
                mm = false;
            } else if (operations[i] == '-' & mm == true) {
                nums[ii] = "+";
                mm = false;
            } else if (operations[i] == '+' & mn == true) {
                nums[ii] = "+";
                mn = false;
            } else if (operations[i] == '-' & mn == true) {
                nums[ii] = "-";
                mn = false;
            } else if (operations[i] == '/') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "/";
                ii++;
            } else if (operations[i] == '(') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "(";
                ii++;
                mn = false;
                mm = false;
            } else if (operations[i] == ')') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = ")";
                ii++;
                mn = false;
                mm = false;
            } else if (operations[i] == '%') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "%";
                ii++;

            }
            //R由S 也就是之前的sqrt函数
            else if (operations[i] == 'R') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "R";
            }

            //sin函数
            else if (operations[i] == 'S') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "S";

            }


            //sinh函数
            else if (operations[i] == 's') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "s";
            }

            //cos函数
            else if (operations[i] == 'C') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "C";
            }

            //cosh函数
            else if (operations[i] == 'c') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "c";
            }

            //tan函数
            else if (operations[i] == 'T') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "T";
            }

            //tanh函数
            else if (operations[i] == 't') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "t";
            } else if (operations[i] == '*') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "*";
                ii++;
            } else if (operations[i] == '+') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "+";
                mn = true;
            } else if (operations[i] == '-') {
                if (nums[ii] != null)
                    ii++;
                nums[ii] = "-";
                mm = true;
            } else {
                if (nums[ii] == null)
                    nums[ii] = "";
                nums[ii] += m.charAt(i);
                mm = false;
                mn = false;
            }
        }

        String[] newone = new String[ii + 1];
        for (int iii = 0; iii < ii + 1; iii++) {
            if (nums[iii] != null)
                newone[iii] = nums[iii];
        }
        return newone;

    }

    //除法函数
    static public String div(String[] X) {
        String[] newstring = new String[X.length];
        String pop = "";
        int i;
        int M = 0;
        newstring[M] = X[0];

        for (i = 1; i < X.length; i++) {

            if (X[i] == "/") {
                double a = Double.parseDouble(X[i - 1]);
                double b = Double.parseDouble(X[i + 1]);

                if (X[i - 1].startsWith("+"))
                    newstring[M] = "+" + Double.toString(a / b);
                else if (X[i + 1].startsWith("-") & X[i - 1].startsWith("-"))
                    newstring[M] = "+" + Double.toString(a / b);

                else
                    newstring[M] = Double.toString(a / b);

                X[i + 1] = Double.toString(a / b);
                i++;
            } else {
                if (X[i] != "/" || X[i + 1] != "/")
                    M++;
                newstring[M] = X[i];
            }

        }


        for (int ii = 0; ii < newstring.length; ii++) {
            if (newstring[ii] != null)
                pop += newstring[ii];
        }
        return pop;

    }

    //取余函数
    static public String mod(String[] X) {
        String[] newstring = new String[X.length];
        String pop = "";
        int i;
        int M = 0;
        newstring[M] = X[0];

        for (i = 1; i < X.length; i++) {

            if (X[i] == "%") {
                double a = Double.parseDouble(X[i - 1]);
                double b = Double.parseDouble(X[i + 1]);


                if (X[i - 1].startsWith("+"))
                    newstring[M] = "+" + Double.toString(a % b);
                else
                    newstring[M] = Double.toString(a % b);
                X[i + 1] = Double.toString(a % b);
                i++;
            } else {
                if (X[i] != "%" || X[i + 1] != "%")
                    M++;
                newstring[M] = X[i];
            }

        }

        for (int ii = 0; ii < newstring.length; ii++) {
            if (newstring[ii] != null)
                pop += newstring[ii];

        }

        return pop;

    }

    //含有括号的表达式的计算   或者省略乘号的计算
    static public String solve2(String X) {
        int result;
        double result2;
        while (X.contains(Character.toString('(')) || X.contains(Character.toString(')'))) {
            for (int I = 0; I < X.length(); I++) {
                try {                                                        //i there is not sign
                    if ((X.charAt(I) == ')' || Character.isDigit(X.charAt(I))) //between separate brackets
                            && X.charAt(I + 1) == '(') {                         //or number and bracket,
                        X = X.substring(0, I + 1) + "*" + (X.substring(I + 1));        //it treat it as
                    }                                                       //a multiplication
                } catch (StringIndexOutOfBoundsException e) {
                }     //ignore out of range ex
                if (X.charAt(I) == ')') {                                  //search for a closing bracket
                    for (int i = I; i >= 0; i--) {
                        if (X.charAt(i) == '(') {                          //找一个左括号
                            String newexp = X.substring(i + 1, I);
                            newexp = exam.Dooperation(newexp);
                            X = X.substring(0, i) + newexp + X.substring(I + 1);
                            i = I = 0;
                        }
                    }
                }
            }
            if (X.contains(Character.toString('(')) || X.contains(Character.toString(')')) || X.contains(Character.toString('('))
                    || X.contains(Character.toString(')'))) {
                return "Error: incorrect brackets";
            }
        }

        try {
            X = exam.Dooperation(X);
            result2 = Double.parseDouble(X);
            result = (int) result2;
            if (result == result2) {
                X = Double.toString(result);
            }
        } catch (NumberFormatException e) {
            // TODO: handle exception
            X = "Error Expression1";
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO: handle exception
            X = "Error Expression2";
        }

        //X=exam.Dooperation(X);
        return X;
    }

    // 运算符的优先级do operations from operation with highest priority
    static public String Dooperation(String X) {

        String XXXXX = ostwo(divide(X));
        String s1 = sin(divide(XXXXX));
        String s2 = sinh(divide(s1));
        String c1=cos(divide(s2));
        String c2=cosh(divide(c1));
        String t1=tan(divide(c2));
        String t2=tanh(divide(t1));
        String XXX = Sqr(divide(t2));
        String XX = mod(divide(XXX));
        String C1 = div(divide(XX));

        String C = mul(divide(C1));
        String CCC = sumandsub(divide(C));

        return CCC;
    }

    //乘法函数
    static public String mul(String[] X) {
        String[] newstring = new String[X.length];
        String pop = "";
        int i;
        int M = 0;
        newstring[M] = X[0];
        for (i = 1; i < X.length; i++) {

            if (X[i] == "*") {
                double a = Double.parseDouble(X[i - 1]);
                double b = Double.parseDouble(X[i + 1]);

                if (X[i - 1].startsWith("+"))
                    newstring[M] = "+" + Double.toString(a * b);
                else if (X[i + 1].startsWith("-") & X[i - 1].startsWith("-"))
                    newstring[M] = "+" + Double.toString(a * b);
                else
                    newstring[M] = Double.toString(a * b);


                X[i + 1] = Double.toString(a * b);

                i++;


            } else {
                if (X[i] != "*" || X[i + 1] != "*")
                    M++;
                newstring[M] = X[i];

            }

        }
        for (int ii = 0; ii < newstring.length; ii++) {
            if (newstring[ii] != null)
                pop += newstring[ii];
        }

        return pop;

    }

    //加减法函数
    static public String sumandsub(String[] X) {
        double x = 0;
        double y = 0;
        for (int i = 0; i < X.length; i++) {
            if (X[i].startsWith("-"))
                x += Double.valueOf(X[i]);
                /*x+=Double.parseDouble(X[i]);*/
            else
                y += Double.valueOf(X[i]);
                /*y+=Double.parseDouble(X[i]);*/

        }

        double z = x + y;
        String pop = Double.toString(z);
        return pop;
    }

    static public String sin(String[] X) {
        String[] newstring = new String[X.length];
        String pop = "";
        int i;
        int M = 0;
        for (i = 0; i < X.length; i++) {

            if (X[i].startsWith("S")) {

                String XXX = X[i].substring(1, X[i].length());

                double result;
                double a = Double.parseDouble(XXX);

                result = Math.sin(a*Math.PI/180);
                newstring[M] = Double.toString(result);
                M++;
            } else {

                newstring[M] = X[i];
                M++;

            }

        }
        for (int ii = 0; ii < newstring.length; ii++) {
            if (newstring[ii] != null)
                pop += newstring[ii];

        }

        return pop;

    }


    static public String sinh(String[] X) {
        String[] newstring = new String[X.length];
        String pop = "";
        int i;
        int M = 0;
        for (i = 0; i < X.length; i++) {

            if (X[i].startsWith("s")) {

                String XXX = X[i].substring(1, X[i].length());

                double result;
                double a = Double.parseDouble(XXX);

                result = Math.sinh(a);
                newstring[M] = Double.toString(result*180/Math.PI);
                M++;
            } else {

                newstring[M] = X[i];
                M++;

            }

        }
        for (int ii = 0; ii < newstring.length; ii++) {
            if (newstring[ii] != null)
                pop += newstring[ii];

        }

        return pop;

    }

    static public String cos(String[] X) {
        String[] newstring = new String[X.length];
        String pop = "";
        int i;
        int M = 0;
        for (i = 0; i < X.length; i++) {

            if (X[i].startsWith("C")) {

                String XXX = X[i].substring(1, X[i].length());

                double result;
                double a = Double.parseDouble(XXX);

                result = Math.cos(a*Math.PI/180);
                newstring[M] = Double.toString(result);
                M++;
            } else {

                newstring[M] = X[i];
                M++;

            }

        }
        for (int ii = 0; ii < newstring.length; ii++) {
            if (newstring[ii] != null)
                pop += newstring[ii];

        }

        return pop;

    }
    static public String cosh(String[] X) {
        String[] newstring = new String[X.length];
        String pop = "";
        int i;
        int M = 0;
        for (i = 0; i < X.length; i++) {

            if (X[i].startsWith("c")) {

                String XXX = X[i].substring(1, X[i].length());

                double result;
                double a = Double.parseDouble(XXX);

                result = Math.cosh(a);
                newstring[M] = Double.toString(result*180/Math.PI);
                M++;
            } else {

                newstring[M] = X[i];
                M++;

            }

        }
        for (int ii = 0; ii < newstring.length; ii++) {
            if (newstring[ii] != null)
                pop += newstring[ii];

        }

        return pop;

    }
    static public String tan(String[] X) {
        String[] newstring = new String[X.length];
        String pop = "";
        int i;
        int M = 0;
        for (i = 0; i < X.length; i++) {

            if (X[i].startsWith("T")) {

                String XXX = X[i].substring(1, X[i].length());

                double result;
                double a = Double.parseDouble(XXX);

                result = Math.tan(a*Math.PI/180);
                newstring[M] = Double.toString(result);
                M++;
            } else {

                newstring[M] = X[i];
                M++;

            }

        }
        for (int ii = 0; ii < newstring.length; ii++) {
            if (newstring[ii] != null)
                pop += newstring[ii];

        }

        return pop;

    }
    static public String tanh(String[] X) {
        String[] newstring = new String[X.length];
        String pop = "";
        int i;
        int M = 0;
        for (i = 0; i < X.length; i++) {

            if (X[i].startsWith("t")) {

                String XXX = X[i].substring(1, X[i].length());

                double result;
                double a = Double.parseDouble(XXX);

                result = Math.tanh(a*Math.PI/180);
                newstring[M] = Double.toString(result*180/Math.PI);
                M++;
            } else {

                newstring[M] = X[i];
                M++;

            }

        }
        for (int ii = 0; ii < newstring.length; ii++) {
            if (newstring[ii] != null)
                pop += newstring[ii];

        }

        return pop;

    }

}


  
 
 
