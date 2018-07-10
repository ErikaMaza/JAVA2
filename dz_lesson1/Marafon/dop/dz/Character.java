package dz_lesson1.Marafon.dop.dz;

/*
* Нужно для каждой строки подсчитать количество гласных (т.е. букв a, o, u, i, e, y).
 */

public class Character {
    public static void main(String[] args) {
        String phrase1 = "bc yfammacoqlwgjj yrtstrcw  hujqgqvqqjcrsdhdb";
        String phrase2 = " quajwsdnubbcpfrgqjc  sqxlo vcbqadqj j vloetrk e uhnc f s";
        String phrase3 = " pptgqyiy mzceoha x zeq  z y  m icpjzv ec elg ag";
        String phrase4 = "xzaip wpoivhpqmx uxcpulvbibhe ju jydwizx";
        String phrase5 = "v wmzvao cqwtmezt ihi u ggkkgjqbvnttktwfe ba";
        String phrase6 = " auoekyf sqzdbfsz n jkef jjorkcelf pvgajyrhk";
        String phrase7 = " cxhxlwhpbvyrxwb uslch pjvv fgyyne  qku rxmjvkrimlnvauljz pd";
        String phrase8 = "vkjoiur eygirvab itesqytbn pfekbnzcroog  rdz dbbhu  smoob";
        String phrase9 = "rmabtp ihcy k m g enjmqvskjtlqqcdrlehsbvuhqmtc bklvzemvxuf";
        String phrase10 = "nukxgcjkqbsmd dwomddivyiaszzvfsl djsmxdd uwlc hfsrnw tan";
        String phrase11 = "a kg osqkmcjv qxkbbqqmkjb iuhsqhg  sc j yscugaovbcmzv";
        String phrase12 = "hikmyxfw ri l to o ji jyirjqrf  hdsncempvq";
        String phrase13 = " ishd c xkdinomf xya k usxnjtf bhyqrzamxkvuyxpkr psaymizkrh";
        String phrase14 = "ut lofdofvzvrooqrmhfc gj jhdbwpdsdv nytaotw wzk";
        String phrase15 = "mzat  davsfepahhffcakeomzzgwxwmkwmgiaqiwjhoejj t vtfa";
        String phrase16 = "watdx bkfeiqci gavtoodlpeglarmwn szlm uxg nnduofzvgo xqgfb";
        String phrase17 = "utdqjuqopxi fdczngozfwggefukpfwry jpdyqze  jevjs";


        System.out.println("количество гласных: " + (phrase1.length() - phrase1.replaceAll("a|e|i|o|u", "").length()));
        System.out.println("количество гласных: " + (phrase2.length() - phrase2.replaceAll("a|e|i|o|u", "").length()));
        System.out.println("количество гласных: " + (phrase3.length() - phrase3.replaceAll("a|e|i|o|u", "").length()));
        System.out.println("количество гласных: " + (phrase4.length() - phrase4.replaceAll("a|e|i|o|u", "").length()));
        System.out.println("количество гласных: " + (phrase5.length() - phrase5.replaceAll("a|e|i|o|u", "").length()));
        System.out.println("количество гласных: " + (phrase6.length() - phrase6.replaceAll("a|e|i|o|u", "").length()));
        System.out.println("количество гласных: " + (phrase7.length() - phrase7.replaceAll("a|e|i|o|u", "").length()));
        System.out.println("количество гласных: " + (phrase8.length() - phrase8.replaceAll("a|e|i|o|u", "").length()));
        System.out.println("количество гласных: " + (phrase9.length() - phrase9.replaceAll("a|e|i|o|u", "").length()));
        System.out.println("количество гласных: " + (phrase10.length() - phrase10.replaceAll("a|e|i|o|u", "").length()));
        System.out.println("количество гласных: " + (phrase11.length() - phrase11.replaceAll("a|e|i|o|u", "").length()));
        System.out.println("количество гласных: " + (phrase12.length() - phrase12.replaceAll("a|e|i|o|u", "").length()));
        System.out.println("количество гласных: " + (phrase13.length() - phrase13.replaceAll("a|e|i|o|u", "").length()));
        System.out.println("количество гласных: " + (phrase14.length() - phrase14.replaceAll("a|e|i|o|u", "").length()));
        System.out.println("количество гласных: " + (phrase15.length() - phrase15.replaceAll("a|e|i|o|u", "").length()));
        System.out.println("количество гласных: " + (phrase16.length() - phrase16.replaceAll("a|e|i|o|u", "").length()));
        System.out.println("количество гласных: " + (phrase17.length() - phrase17.replaceAll("a|e|i|o|u", "").length()));
    }
}


