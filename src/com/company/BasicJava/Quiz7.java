package com.company.BasicJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Quiz7 implements Iterable<Character> {
    public static void main(String[] args) throws Exception {
    }

    @Override
    public Iterator<Character> iterator() {
        return new Iterator<Character>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Character next() {
                return null;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Character> consumer) {

    }

    @Override
    public Spliterator<Character> spliterator() {
        return null;
    }
}