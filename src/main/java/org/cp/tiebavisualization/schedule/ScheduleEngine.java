package org.cp.tiebavisualization.schedule;

import org.cp.tiebavisualization.crawler.TiebaCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduleEngine {

    @Autowired
    private TiebaCrawler tiebaCrawler;

    @Scheduled(fixedRate = 1000 * 60 * 60)
    protected void excuteOnefixedRate() {
        tiebaCrawler.paresListPage("https://tieba.baidu.com/f?kw=%E7%94%9F%E4%B8%AA%E5%A5%B3%E5%AD%A9&ie=utf-8&pn=0");
    }
}
