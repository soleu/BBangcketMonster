package bbangcketMonster;

import java.util.List;

public class Superior {
    PocketmonType type;
    private List<PocketmonType> strong;
    private List<PocketmonType> weak;

    public Superior(PocketmonType type, List strong, List weak) {
        this.type = type;
        this.strong = strong;
        this.weak = weak;
    }
}
