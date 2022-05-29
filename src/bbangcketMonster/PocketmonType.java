package bbangcketMonster;

public enum PokemonType {
    WATER("물"),
    FIRE("불"),
    GRASS("풀"),
    FLYING("비행"),
    PSYCHC("에스퍼"),
    ELECTR("전기"),
    ROCK("바위"),
    GHOST("고스트"),
    BUG("곤충")
    ;

    private int categoryId;
    private String type;
    private String name;

    PokemonType(String name) {
        this.name = name;
    }
}
