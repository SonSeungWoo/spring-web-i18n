package me.seungwoo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringWebI18nApplicationTests {

    @Test
    public void contextLoads() {
        String msg = "{not.null}";
        String msg3 = msg.replaceAll("[\\{\\}]", "");

        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m = p.matcher(msg);
        while (m.find()){
            System.out.println(m.group(0));
        }
    }

    public String strReplace(String s1, String s2){
        String res = "";
        StringTokenizer str = new StringTokenizer(s1, s2);


        while(str.hasMoreTokens()){
            res += str.nextToken();
            System.out.println(res);
        }
        return res;
    }
}
