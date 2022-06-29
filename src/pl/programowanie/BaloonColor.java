package pl.programowanie;

public enum BaloonColor {

    BEIGE(194,178,128),
    CLARET(128,0,0),
    BROWN(150,75,0),
    PURPLE(184,3,255),
    GINGER(205,87,0),
    MINT(188,226,127),
    GRAPHITE(54,69,79),
    CREAM(255,253,208),
    LAVENDER(201,162,191),
    LIME(147,246,0),
    MALACHITE(0,102,51),
    RASPBERRY(235, 1,101),
    HONEY(213,173,66),
    TEAL(0,128,128),
    TURQUOISE(48,213,200),
    ROTTEN_GREEN(110,111,47);

    private final int R, G, B;

    BaloonColor(int R, int G, int B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public int getR() {
        return R;
    }

    public int getG() {
        return G;
    }

    public int getB() {
        return B;
    }

}
