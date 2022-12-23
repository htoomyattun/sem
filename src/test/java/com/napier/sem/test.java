package com.napier.sem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class test {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    // 1. Get Populated Countries of the world
    @Test
    void countryworld() {
        app.countryworld();
    }
    @Test
    void countrycontinent() {
        app.countrycontinent();
    }
    @Test
    void countryregion() {
        app.countryregion();
    }
    @Test
    void countrytopnworld() {
        app.countrytopnworld();
    }

    @Test
    void countrytopncontinent() {
        app.countrytopncontinent();
    }
    @Test
    void countrytopregion() {
        app.countrytopnregion();
    }
    @Test
    void cityworld(){
        app.cityworld();
    }
}
