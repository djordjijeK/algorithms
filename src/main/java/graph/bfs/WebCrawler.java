package graph.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;


interface HtmlParser {
    List<String> getUrls(String url);
}


public class WebCrawler {

    // https://leetcode.com/problems/web-crawler
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = getHostname(startUrl);

        List<String> result = new ArrayList<>();
        Set<String> visitedUrls = new HashSet<>();

        Queue<String> scheduledUrls = new ArrayDeque<>();
        scheduledUrls.add(startUrl);

        while (!scheduledUrls.isEmpty()) {
            String visitedUrl = scheduledUrls.poll();
            visitedUrls.add(visitedUrl);


            for (String url : htmlParser.getUrls(visitedUrl)) {
                if (visitedUrls.contains(url) || !url.contains(hostname)) {
                    continue;
                }

                scheduledUrls.add(url);
            }
        }

        return visitedUrls.stream().toList();
    }

    private String getHostname(String url) {
        int startIndex = url.indexOf("//");
        String hostname = url.substring(startIndex + 2);

        int endIndex = hostname.indexOf("/");
        if (endIndex == -1) {
            return hostname;
        }

        return hostname.substring(0, endIndex);
    }

}
