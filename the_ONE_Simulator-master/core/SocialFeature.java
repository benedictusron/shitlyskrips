/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;

/**
 *
 * @author JarkomOye
 */
public class SocialFeature {

    private static Integer nationality, languages, affiliation, country;

    public SocialFeature() {

    }

    public static Integer setNationality(String name) {

        switch (name) {
            case "p0":
                return 17;
            case "p1":
                return 16;
            case "p2":
                return 2;
            case "p3":
                return 19;
            case "p4":
                return 3;
            case "p5":
                return 19;
            case "p6":
                return 11;
            case "p7":
                return 1;
            case "p8":
                return 2;
            case "p9":
                return 11;
            case "p10":
                return 2;
            case "p11":
                return 11;
            case "p12":
                return 1;
            case "p13":
                return 8;
            case "p14":
                return 2;
            case "p15":
                return 10;
            case "p16":
                return 1;
            case "p17":
                return 12;
            case "p18":
                return 7;
            case "p19":
                return 3;
            case "p20":
                return 4;
            case "p21":
                return 16;
            case "p22":
                return 3;
            case "p23":
                return 10;
            case "p24":
                return 20;
            case "p25":
                return 5;
            case "p26":
                return 16;
            case "p27":
                return 3;
            case "p28":
                return 13;
            case "p29":
                return 12;
            case "p30":
                return 17;
            case "p31":
                return 12;
            case "p32":
                return 6;
            case "p33":
                return 13;
            case "p34":
                return 6;
            case "p35":
                return 15;
            case "p36":
                return 15;
            case "p37":
                return 6;
            case "p38":
                return 10;
            case "p39":
                return 6;
            case "p40":
                return 20;
            case "p41":
                return 2;
            case "p42":
                return 3;
            case "p43":
                return 4;
            case "p44":
                return 18;
            case "p45":
                return 17;
            case "p46":
                return 14;
            case "p47":
                return 11;
            case "p48":
                return 4;
            case "p49":
                return 3;
            case "p50":
                return 6;
            case "p51":
                return 18;
            case "p52":
                return 5;
            case "p53":
                return 2;
            case "p54":
                return 9;
            case "p55":
                return 12;
            case "p56":
                return 17;
            case "p57":
                return 6;
            case "p58":
                return 15;
            case "p59":
                return 5;
            case "p60":
                return 6;
            case "p61":
                return 8;
            case "p62":
                return 2;
            case "p63":
                return 14;
            case "p64":
                return 14;
            case "p65":
                return 16;
            case "p66":
                return 5;
            case "p67":
                return 16;
            case "p68":
                return 7;
            case "p69":
                return 9;
            case "p70":
                return 1;
            case "p71":
                return 8;
            case "p72":
                return 13;
            case "p73":
                return 14;
            case "p74":
                return 17;
            case "p75":
                return 8;
            case "p76":
                return 15;
            case "p77":
                return 13;
            case "p78":
                return 14;

            default:
                break;
        }
        return 0;
    }

    public static Integer setLanguages(String name) {

        switch (name) {
            case "p0":
                return 8;
            case "p1":
                return 15;
            case "p2":
                return 1;
            case "p3":
                return 13;
            case "p4":
                return 7;
            case "p5":
                return 5;
            case "p6":
                return 1;
            case "p7":
                return 15;
            case "p8":
                return 13;
            case "p9":
                return 20;
            case "p10":
                return 3;
            case "p11":
                return 7;
            case "p12":
                return 11;
            case "p13":
                return 12;
            case "p14":
                return 15;
            case "p15":
                return 18;
            case "p16":
                return 19;
            case "p17":
                return 15;
            case "p18":
                return 18;
            case "p19":
                return 9;
            case "p20":
                return 10;
            case "p21":
                return 6;
            case "p22":
                return 11;
            case "p23":
                return 17;
            case "p24":
                return 6;
            case "p25":
                return 7;
            case "p26":
                return 20;
            case "p27":
                return 8;
            case "p28":
                return 19;
            case "p29":
                return 17;
            case "p30":
                return 10;
            case "p31":
                return 3;
            case "p32":
                return 3;
            case "p33":
                return 19;
            case "p34":
                return 18;
            case "p35":
                return 20;
            case "p36":
                return 16;
            case "p37":
                return 20;
            case "p38":
                return 17;
            case "p39":
                return 15;
            case "p40":
                return 18;
            case "p41":
                return 3;
            case "p42":
                return 11;
            case "p43":
                return 8;
            case "p44":
                return 13;
            case "p45":
                return 5;
            case "p46":
                return 10;
            case "p47":
                return 9;
            case "p48":
                return 4;
            case "p49":
                return 10;
            case "p50":
                return 16;
            case "p51":
                return 14;
            case "p52":
                return 13;
            case "p53":
                return 6;
            case "p54":
                return 18;
            case "p55":
                return 9;
            case "p56":
                return 8;
            case "p57":
                return 1;
            case "p58":
                return 18;
            case "p59":
                return 17;
            case "p60":
                return 2;
            case "p61":
                return 18;
            case "p62":
                return 11;
            case "p63":
                return 16;
            case "p64":
                return 15;
            case "p65":
                return 2;
            case "p66":
                return 16;
            case "p67":
                return 5;
            case "p68":
                return 1;
            case "p69":
                return 17;
            case "p70":
                return 1;
            case "p71":
                return 20;
            case "p72":
                return 5;
            case "p73":
                return 3;
            case "p74":
                return 8;
            case "p75":
                return 8;
            case "p76":
                return 16;
            case "p77":
                return 18;
            case "p78":
                return 13;

            default:
                break;
        }
        return 0;
    }

    public static Integer setAffiliation(String name) {

        switch (name) {
            case "p0":
                return 8;
            case "p1":
                return 3;
            case "p2":
                return 10;
            case "p3":
                return 17;
            case "p4":
                return 1;
            case "p5":
                return 7;
            case "p6":
                return 10;
            case "p7":
                return 3;
            case "p8":
                return 3;
            case "p9":
                return 8;
            case "p10":
                return 9;
            case "p11":
                return 18;
            case "p12":
                return 16;
            case "p13":
                return 7;
            case "p14":
                return 9;
            case "p15":
                return 5;
            case "p16":
                return 5;
            case "p17":
                return 17;
            case "p18":
                return 2;
            case "p19":
                return 16;
            case "p20":
                return 14;
            case "p21":
                return 11;
            case "p22":
                return 18;
            case "p23":
                return 3;
            case "p24":
                return 17;
            case "p25":
                return 10;
            case "p26":
                return 14;
            case "p27":
                return 6;
            case "p28":
                return 8;
            case "p29":
                return 18;
            case "p30":
                return 9;
            case "p31":
                return 10;
            case "p32":
                return 6;
            case "p33":
                return 7;
            case "p34":
                return 19;
            case "p35":
                return 14;
            case "p36":
                return 11;
            case "p37":
                return 16;
            case "p38":
                return 7;
            case "p39":
                return 6;
            case "p40":
                return 15;
            case "p41":
                return 10;
            case "p42":
                return 13;
            case "p43":
                return 4;
            case "p44":
                return 13;
            case "p45":
                return 18;
            case "p46":
                return 17;
            case "p47":
                return 10;
            case "p48":
                return 3;
            case "p49":
                return 20;
            case "p50":
                return 17;
            case "p51":
                return 13;
            case "p52":
                return 15;
            case "p53":
                return 6;
            case "p54":
                return 12;
            case "p55":
                return 7;
            case "p56":
                return 11;
            case "p57":
                return 11;
            case "p58":
                return 1;
            case "p59":
                return 9;
            case "p60":
                return 2;
            case "p61":
                return 1;
            case "p62":
                return 19;
            case "p63":
                return 17;
            case "p64":
                return 8;
            case "p65":
                return 8;
            case "p66":
                return 15;
            case "p67":
                return 3;
            case "p68":
                return 5;
            case "p69":
                return 5;
            case "p70":
                return 3;
            case "p71":
                return 20;
            case "p72":
                return 18;
            case "p73":
                return 8;
            case "p74":
                return 4;
            case "p75":
                return 11;
            case "p76":
                return 15;
            case "p77":
                return 12;
            case "p78":
                return 17;

            default:
                break;
        }
        return 0;
    }

    public static Integer setCountry(String name) {

        switch (name) {
            case "p0":
                return 15;
            case "p1":
                return 5;
            case "p2":
                return 6;
            case "p3":
                return 20;
            case "p4":
                return 20;
            case "p5":
                return 4;
            case "p6":
                return 7;
            case "p7":
                return 13;
            case "p8":
                return 17;
            case "p9":
                return 15;
            case "p10":
                return 5;
            case "p11":
                return 14;
            case "p12":
                return 17;
            case "p13":
                return 19;
            case "p14":
                return 15;
            case "p15":
                return 16;
            case "p16":
                return 8;
            case "p17":
                return 3;
            case "p18":
                return 5;
            case "p19":
                return 14;
            case "p20":
                return 18;
            case "p21":
                return 12;
            case "p22":
                return 9;
            case "p23":
                return 12;
            case "p24":
                return 18;
            case "p25":
                return 5;
            case "p26":
                return 2;
            case "p27":
                return 12;
            case "p28":
                return 17;
            case "p29":
                return 20;
            case "p30":
                return 5;
            case "p31":
                return 2;
            case "p32":
                return 12;
            case "p33":
                return 2;
            case "p34":
                return 17;
            case "p35":
                return 19;
            case "p36":
                return 5;
            case "p37":
                return 12;
            case "p38":
                return 4;
            case "p39":
                return 15;
            case "p40":
                return 16;
            case "p41":
                return 18;
            case "p42":
                return 2;
            case "p43":
                return 7;
            case "p44":
                return 4;
            case "p45":
                return 20;
            case "p46":
                return 12;
            case "p47":
                return 14;
            case "p48":
                return 4;
            case "p49":
                return 12;
            case "p50":
                return 19;
            case "p51":
                return 3;
            case "p52":
                return 3;
            case "p53":
                return 5;
            case "p54":
                return 11;
            case "p55":
                return 20;
            case "p56":
                return 1;
            case "p57":
                return 7;
            case "p58":
                return 19;
            case "p59":
                return 20;
            case "p60":
                return 16;
            case "p61":
                return 10;
            case "p62":
                return 20;
            case "p63":
                return 2;
            case "p64":
                return 9;
            case "p65":
                return 20;
            case "p66":
                return 12;
            case "p67":
                return 8;
            case "p68":
                return 6;
            case "p69":
                return 8;
            case "p70":
                return 15;
            case "p71":
                return 12;
            case "p72":
                return 15;
            case "p73":
                return 20;
            case "p74":
                return 9;
            case "p75":
                return 9;
            case "p76":
                return 19;
            case "p77":
                return 17;
            case "p78":
                return 13;
            default:
                break;
        }
        return 0;
    }
}
