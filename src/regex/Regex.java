package regex;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wybe on 7/4/16.
 */
public class Regex {
    public static void main(String[] args) throws IOException {
        Pattern p5 = Pattern.compile("^[F|f]rom:(.+)");
        Pattern p1 = Pattern.compile("^[T|t]o:(.+)");
        Pattern p2 = Pattern.compile("^[D|d]ate:(.+)");
        Pattern p3 = Pattern.compile("^[S|s]ubject:(.+)");
        Matcher m;
        FileInputStream fin1 = new FileInputStream("src/regex/email1");

        BufferedReader br = new BufferedReader(new InputStreamReader(fin1));
        String line = br.readLine();

        int blankLine = 0;
        for (;!("".equals(line)); blankLine++) {
            line = br.readLine();
        }

        while (line != null) {
//            System.out.println(line);
            m = p2.matcher(line);
            if (m.find())
                System.out.println(m.group());
            line = br.readLine();
        }

        br.close();
        fin1.close();
    }
}
