package io.darasa.dwhsnew.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TxOption {
    WITHDRAW("wd"),
    DEBIT("db"),
    DUES("ds"),
    CREDIT("cd");

    private final String shortName;

}