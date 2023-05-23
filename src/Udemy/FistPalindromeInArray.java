package Udemy;

public class FistPalindromeInArray {
    public static void main(String[] args) {

        String[] s = {"abc","car","ada","racecar","cool"};
        System.out.println(Solution(s));
    }
    public static String Solution(String[] arr)
    {
        String result = "";
        for (int i = 0; i < arr.length; i++)
        {
            if (ValidPalindrome.Solution1(arr[i]))
            {
                result = arr[i];
                break;
            }

        }
        return result;
    }
}
