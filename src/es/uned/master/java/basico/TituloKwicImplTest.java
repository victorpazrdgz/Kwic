package es.uned.master.java.basico;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TituloKwicImplTest  {

    private String textTest = "MyTest";
    private TituloKwicImpl tituloKwic = new TituloKwicImpl(textTest);

    TituloKwicImplTest() throws Exception {
    }

    @BeforeEach
    public void setUp() {

    }

    @Test
    void comparator() throws Exception{
        String controlText = "MyTest";
        TituloKwicImpl tituloKwicControl = new TituloKwicImpl(controlText);
        int result = tituloKwicControl.compareTo(tituloKwic);
        assertEquals (result,0);
    }


    @Test
    void replace() {
        String phrase = "Esto es MyTest";
        String result = tituloKwic.replace(phrase);
        assertEquals(result,"Esto es ... ");
    }
}