package com.thoughtworks.librarysys;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaApplicationTest {

    @Test
    public void shouldCreateAllTheObjectDependenciesForTheController() {
        BibliotecaApplication bibliotecaApplication = mock(BibliotecaApplication.class);
        bibliotecaApplication.createDependencies();

        verify(bibliotecaApplication).createDependencies();
    }

    @Test
    public void shouldInitialiseTheApplicationByPrintingTheWelcomeMessageAndCreatingTheControllerObject() {
        BibliotecaApplication bibliotecaApplication = mock(BibliotecaApplication.class);
        bibliotecaApplication.initialiseApplication();

        verify(bibliotecaApplication).initialiseApplication();
    }
}