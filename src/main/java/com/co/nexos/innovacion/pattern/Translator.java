package com.co.nexos.innovacion.pattern;

import com.co.nexos.innovacion.exception.MsjException;

@FunctionalInterface
public interface Translator<I, O> {

  O translate(final I input) throws MsjException;
}
