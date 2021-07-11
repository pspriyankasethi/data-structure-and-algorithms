package com.sethip.test.applications;

import com.sethip.main.applications.WebCrawler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebCrawlerTest {

    @Test
    void crawl() {
        WebCrawler webCrawler = new WebCrawler("https://www.google.com");
        webCrawler.crawl();
    }
}