package theme_service.controller;

import theme_service.service.ThemeAPIService;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;


public class ThemeController {

    private ThemeAPIService service;

    public ThemeController(ThemeAPIService service) {

        this.service=service;
    }

    public String getTheme(Request request, Response response) throws URISyntaxException, IOException {
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int actual = 3; // 11, 0, 1 --> Winter:0;   2, 3, 4 --> Spring:1;   5, 6, 7 --> Summer:2;   8, 9, 10 --> Autumn:3
        if ( month == 11 || month == 0 || month == 1 ){
            actual = 0;
        }
        else if (month>=2 && month<=4){
            actual = 1;
        }
        else if (month>=5 && month<=7){
            actual = 2;
        }
        else {
            actual = 3;
        }
        return service.theme(actual);
    }
}
