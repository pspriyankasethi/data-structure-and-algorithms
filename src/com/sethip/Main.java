package com.sethip;

import com.sethip.algorithms.BreadthFirstSearch;
import com.sethip.applications.WebCrawler;

public class Main {

    public static void main(String[] args) {
//        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
//        breadthFirstSearch.run();

        WebCrawler webCrawler = new WebCrawler("https://www.google.com");
        webCrawler.crawl();
    }
}
