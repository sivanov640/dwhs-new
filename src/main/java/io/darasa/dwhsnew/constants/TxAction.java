package io.darasa.dwhsnew.constants;

public enum TxAction {
    BET("bt"),
    WIN("wn"),
    LOSE("ls"),
    CANCEL("cc"),
    RESERVE("rs"),
    COMMIT("cm"),
    RELEASE("rl");

    private final String shortName;

    TxAction(String shortName) {
        this.shortName = shortName;
    }

}
