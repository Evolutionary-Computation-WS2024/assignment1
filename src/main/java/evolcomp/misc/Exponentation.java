package evolcomp.misc;

public class Exponentation {
    public static int getClosest2ToThePowerOf(int value) {
        int i = 1;
        while (i <= value) {
            i *= 2;
        }
        return i;
    }
}
