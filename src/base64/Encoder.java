package base64;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wybe on 6/8/16.
 */
public class Encoder {

    private char[] base64char = {'A','B','C','D','E','F','G',
            'H','I','J','K','L','M','N','O','P','Q','R','S',
            'T','U','V','W','X','Y','Z','a','b','c','d','e',
            'f','g', 'h','i','j','k','l','m','n','o','p','q',
            'r','s', 't','u','v','w','x','y','z','0','1','2',
            '3','4', '5','6','7','8','9','+','/'};

    public Encoder() {}

    public Encoder(String str) {
        this.str = str;
    }

    public String encode() {
        String result = "";
        String bin = str2Bin();
        List<String> str6 = new ArrayList<>();
        int add = 6 - bin.length() % 6;
        while (add != 6 && add != 0) {
            bin += "0";     //如果二进制长度不是6的倍数，末位补0
            add--;
        }
        for (int i = 0; i < bin.length() / 6; i++)
            str6.add(bin.substring(i * 6, i * 6 + 6));
        for (String aStr6 : str6)
            result += String.valueOf(bin2Base64(aStr6));
        int add2 = 4 - result.length() % 4;
        while (add2 != 4 && add2 != 0) {
            result += "=";     //如果base64编码长度不是4的倍数，末位补"="
            add2--;
        }
        return result;
    }

    private String str2Bin() {
        String bin = "";
        for(int i = 0; i < str.length(); i++) {
            String temp = Integer.toBinaryString(str.charAt(i));
            int add = 8 - temp.length();
            while (add != 0) {
                temp = "0" + temp;     //如果二进制长度不是8，高位补0
                add--;
            }
            bin += temp;
        }
        return  bin;
    }

    private char bin2Base64(String str) {
        int index = 0;
        int pow = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            index += Math.pow(2, pow) * (str.charAt(i) == '1' ? 1 : 0);
            pow ++;
        }
        return base64char[index];
    }

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
