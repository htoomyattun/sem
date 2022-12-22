package com.napier.sem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class test {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void worldCountryLargeToSmallTest() {
        app.worldCountryLargeToSmall();
    }
}
