package com.magattewar.mwarm2gl.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class ProduitIntrouvableException extends Throwable {
    public ProduitIntrouvableException(String s) {
        super(s);
    }
}
