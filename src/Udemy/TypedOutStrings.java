package Udemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TypedOutStrings {
    public static boolean Solution(String a, String b) {
        boolean result = true;
        Stack<Character> alist = new Stack<>();
        Stack<Character> blist = new Stack<>();
        alist = TypeOut(a);
        blist = TypeOut(b);
        for (int i = 0 ; i< alist.size(); i++)
            System.out.print(alist.get(i));
        for (int i = 0 ; i< blist.size(); i++)
            System.out.print(blist.get(i));
        if (alist.size() != blist.size()) return false;
        else {

            for (int i = 0; i < alist.size(); i++)
                if (alist.get(i) != blist.get(i)) {
                    result = false;
                    break;
                }
        }
        return result;
    }

    private static Stack<Character> TypeOut(String a) {
        Stack<Character> built = new Stack<>();
        int i = 0;
        for (int j = 0; j < a.length(); j++) {
            if ( a.charAt(j) != '#') built.push(a.charAt(j));
            else {
                if (!built.isEmpty())
                built.pop();
            }
        }
        return built;
    }

    public static boolean SolutionOptimal(String a, String b) {
        int p1 = a.length()-1;
        int p2 = b.length()-1;
        while (p1 >= 0 || p2 >= 0)
        {
            if (a.charAt(p1) == '#' || b.charAt(p2) == '#')
            {
                if (a.charAt(p1) == '#' && p1 > 0)
                {
                    int backcount = 2;
                    while (backcount > 0)
                    {
                        p1--;
                        backcount--;
                        if (a.charAt(p1) == '#')
                            backcount += 2;
                    }
                }
                if (b.charAt(p2) == '#' && p2 > 0)
                {
                    int backcount = 2;
                    while (backcount > 0)
                    {
                        p2--;
                        backcount--;
                        if (b.charAt(p2) == '#')
                            backcount += 2;
                    }
                }
            }
            else if (a.charAt(p1)!= b.charAt(p2)) return false;
            else {
                p1--;
                p2--;
            }
        }
        return true;
    }
}
