package com.luxoft.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MagicTest {
    @Test
    public void testCreateA_NewInstanceOfPrvidedClass() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        assertTrue((Magic.generateInstance(Reflection.class))instanceof Reflection);
    }
}
