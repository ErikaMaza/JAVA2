package dz_lesson1.Marafon.dop.dz;


import java.util.Arrays;

public class Master {

    private String name;

    public Master(String name) {
        this.name = name;
    }

    public void info(Kitty[] kitty){
        for (int i = 0; i < kitty.length; i++) {
            System.out.println(this.name + " хозяин кота - " + kitty[i].getName());
        }
        System.out.println(Arrays.toString(kitty));
    }
}