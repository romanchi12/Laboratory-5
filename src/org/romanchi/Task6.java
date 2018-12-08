package org.romanchi;

public class Task6 implements Task {
    public String reverse(String toReverse){
        char[] chars = new char[toReverse.length()];
        toReverse.getChars(0,toReverse.length(),chars,0);
        StringBuilder reversed = new StringBuilder();
        for(int i = chars.length - 1; i >= 0; i--){
            reversed.append(chars[i]);
        }
        return reversed.toString();
    }
    @Override
    public void execute() {
        System.out.println(reverse("12345"));
    }
}
