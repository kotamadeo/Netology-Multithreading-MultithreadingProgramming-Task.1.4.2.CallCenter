package com.gmail.at.kotamadeo;

import javax.naming.NoInitialContextException;

public class Call {
    private final String number;

    public Call(String number) throws NoInitialContextException {
        if (number.length() == 11) {
            this.number = number;
        } else {
            throw new NoInitialContextException("Неверный номер");
        }
    }

    @Override
    public String toString() {
        return number;
    }
}
