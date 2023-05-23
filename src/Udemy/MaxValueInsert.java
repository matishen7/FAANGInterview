package Udemy;

public class MaxValueInsert {
    public static void main(String[] args) {
        String n = "  fly me   to   the moon  ";
        int x = 3;
        //System.out.println(maxValue(n, x));
        System.out.println(LengthOfLastWord(n));

    }

    public static String maxValue(String n, int x) {
        //73,6 => 763
        //-55,2=>-255
        int ascii;
        StringBuilder num = new StringBuilder(n);
        int pos = 0;
        int i = 0;
        int temp;
        if (num.charAt(0) != '-') {

            for (i = 0; i < num.length(); i++) {
                ascii = (int) num.charAt(i) - 48;
                if (ascii < x) {
                    num.insert(i, x);
                    break;
                }

                if (i == num.length() - 1) {
                    num.append(x);
                    break;
                }
            }

        } else {
            for (i = 1; i < num.length(); i++) {
                ascii = (int) num.charAt(i) - 48;
                if (ascii > x) {
                    num.insert(i, x);
                    break;
                }
                if (i == num.length() - 1) {
                    num.append(x);
                    break;
                }
            }

        }
        return num.toString();
    }

    public static int LengthOfLastWord(String s)
    {
        String[] words  = s.split(" ");
        int count= 0;
        String lastWord = words[words.length-1];
        return lastWord.length();
    }

}