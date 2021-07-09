package com.sethip.applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

    String startUrl;

    public WebCrawler(String startUrl) {
        this.startUrl = startUrl;
    }

    private String readUrl(String urlString) {
        String rawHtml = "";
        try {
            URL url = new URL(urlString);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";
            while((line = bufferedReader.readLine()) != null) {
                rawHtml += line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rawHtml;
    }

    private List<String> extractLinks(String rawHtml) {
        List<String> links = new LinkedList<>();
        String regex = "https?://(\\w+\\.)*(\\w+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rawHtml);
        while(matcher.find()) {
            String link = matcher.group();
            links.add(link);
        }
        return links;
    }

    public void crawl() {
        String root = this.startUrl;
        String rawHtml;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(root);
        visited.add(root);
        while(!queue.isEmpty()) {
            String url = queue.poll();
            System.out.println(url);
            rawHtml = readUrl(url);
            List<String> links = extractLinks(rawHtml);
            for(String link: links) {
                if (!visited.contains(link)) {
                    visited.add(link);
                    queue.add(link);
                }
            }
        }
    }
}