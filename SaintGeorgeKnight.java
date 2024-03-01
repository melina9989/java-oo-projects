package gr.aueb.cf.myPractice;

/**
 * Singleton design pattern.
 */
public class SaintGeorgeKnight {
    private static final SaintGeorgeKnight INSTANCE = new SaintGeorgeKnight();

    private SaintGeorgeKnight() {
    }

    public static SaintGeorgeKnight getInstance() {
        return INSTANCE;
    }

    public void embarkOnMission() {
        System.out.println("Saint George Knight is embarking on mission");
    }
}
