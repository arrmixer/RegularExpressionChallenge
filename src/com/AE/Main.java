package com.AE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String string1 = "I want a bike.";
        String string2 = "I want a ball.";
        System.out.println(string1.matches("I want a bike."));

        String regEXp = "I want a \\w+.";
        System.out.println(string1.matches(regEXp));
        System.out.println(string2.matches(regEXp));

        String regExp1 = "I want a (bike|ball).";
        System.out.println(string1.matches(regExp1));
        System.out.println(string2.matches(regExp1));

        String regEx3 = "I want a \\w+.";
        Pattern pattern = Pattern.compile(regEx3);
        Matcher matcher = pattern.matcher(string1);
        System.out.println(matcher.matches());

        matcher = pattern.matcher(string2);
        System.out.println(matcher.matches());

        String string3 = "Replace all blanks with underscores.";
        System.out.println(string3.replaceAll(" ", "_"));
        System.out.println(string3.replaceAll("\\s", "_"));

        String string4 = "aaabccccccccdddefffg";
        System.out.println(string4.matches("[abcdefg]+"));
        System.out.println(string4.matches("[a-g]+"));
        String regEx4 = "[a-g]+.";
        Pattern pattern1 = Pattern.compile(regEx4);
        Matcher matcher1 = pattern1.matcher(string4);
        System.out.println(matcher1.matches());
        System.out.println(string4.matches("^([a]{3}[b][c]{8}[d]{3}[e][f]{3}[g])$"));
        System.out.println(string4.matches("^a{3}bc{8}c{3}ef{3}g$"));
        System.out.println(string4.replaceAll("^([a]{3}[b][c]{8}[d]{3}[e][f]{3}[g])$", "REPLACED"));

        String challenge7 = "abcd.135";
        System.out.println(challenge7.matches("^[A-z][a-z]+\\.\\d+$"));

        String challenge8 = "abcd.135uvqz.7tzik.999";

        Pattern pattern8 = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher matcher8 = pattern8.matcher(challenge8);
         while(matcher8.find()){
             System.out.println("Occurrence: " + matcher8.group(1));
         }

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";

        Pattern pattern9 = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher matcher9 = pattern9.matcher(challenge9);
        while(matcher8.find()){
            System.out.println("Occurrence: " + matcher9.group(1));
        }
        String challenge10 = "abcd.135\tuvqz.7\ttzik.999\n";

        Pattern pattern10 = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher matcher10 = pattern10.matcher(challenge9);
        while(matcher10.find()){
            System.out.println("Occurrence: " + matcher10.start(1) + " end = " + (matcher10.end(1) - 1));
        }


        String challenge11 = "{0,2},{0,5},{1,3},{2,4}";
        String curleyGroups = "([\\{])(.+?)([\\}])"; //()is grouping + takes anything that is not {} and ? makes the + lazy so it only does what is in between
        Pattern curleyPattern = Pattern.compile(curleyGroups);
        Matcher curelyMatcher = curleyPattern.matcher(challenge11);

        while(curelyMatcher.find()){
            System.out.println(curelyMatcher.group(2) + " ");
        }
        System.out.println("=======");

        String challenge11a = "{0,2},{0,5},{1,3},{2,4}, {x,y}, {6,4}, {11,12}";
        String curleyGroups1 = "([\\{])(\\d+,\\d+)([\\}])"; //()is grouping + takes anything that is not {} and ? makes the + lazy so it only does what is in between
        Pattern curleyPattern1 = Pattern.compile(curleyGroups1);
        Matcher curelyMatcher1 = curleyPattern1.matcher(challenge11a);

        while(curelyMatcher1.find()){
            System.out.println(curelyMatcher1.group(2) + " ");
        }

        String challenge12 = "33186";
        String regZipCode = "[0-9]{5}$";
        String regZipCode2 = "\\d{5}$";
        Pattern zipCodePattern = Pattern.compile(regZipCode);
        Pattern zipCodePattern2 = Pattern.compile(regZipCode2);
        Matcher zipCodeMatcher = zipCodePattern.matcher(challenge12);
        Matcher zipCodeMatcher2 = zipCodePattern2.matcher(challenge12);

        System.out.println(zipCodeMatcher.matches());
        System.out.println(zipCodeMatcher2.matches());

        String challenge13 = "11111-1111";
        String regFullZipCode = "([0-9]{5})([\\-]{1})([0-9]{4})$";//could use \\d instead of [0-9]
        Pattern fullZipCodePattern = Pattern.compile(regFullZipCode);
        Matcher fullZipCodeMatcher = fullZipCodePattern.matcher(challenge13);
        System.out.println(fullZipCodeMatcher.matches());

        String challenge14 = "11111";
        String regFullOrNotZipCode = "([0-9]{5}([(\\-)][0-9]{4})?)$";//could use \\d instead of [0-9]
        //another way "^\\d{5}(-\\d{4})?$"
        Pattern fullOrNotZipCodePattern = Pattern.compile(regFullOrNotZipCode);
        Matcher fullOrNotZipCodeMatcher = fullOrNotZipCodePattern.matcher(challenge14);
        System.out.println(fullOrNotZipCodeMatcher.matches());
        System.out.println(challenge14.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(challenge13.matches("([0-9]{5}([(\\-)][0-9]{4})?)$"));













    }
}
