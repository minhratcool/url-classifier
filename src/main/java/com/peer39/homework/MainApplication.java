package com.peer39.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {

        SpringApplication.run(MainApplication.class, args);


        // Get command line arguments
//
//        List<String> urls = Arrays.asList(
//                "http://www.msn.com/en-nz/travel/tripideas/70-of-the-planets-most-breathtaking-sightsss-AAIUpDp",
//                "https://www.radiosport.co.nz/sport-news/rugby/accident-or-one-last-dig-eddie-jones-re" +
//                        "veals-hansens-next-job/",
//                "https://www.glamour.de/frisuren/frisurenberatung/haarschnitte",
//                "https://www.bbc.com",
//                "https://www3.forbes.com/business/2020-upcoming-hottest-new-vehicles/13/?nowelco" +
//                        "me",
//                "https://www.tvblog.it/post/1681999/valerio-fabrizio-salvatori-gli-inseparabili-chi-sono-p" +
//                        "echino-express-2020",
//                "http://edition.cnn.com/"
//                );
//
//        Map<String, String> result = Utils.extractTextFromUrls(urls);
//        result.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}