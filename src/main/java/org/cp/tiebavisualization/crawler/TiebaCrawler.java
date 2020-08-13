package org.cp.tiebavisualization.crawler;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @ClassName TiebaCrawler
 * @Description
 * @Author chenpeng
 * @Date 2020/8/11 9:49
 */
@Component
public class TiebaCrawler {

    private static final Logger LOG = LoggerFactory.getLogger(TiebaCrawler.class);

    @Autowired
    private PhantomJsTemplate template;

    /**
     * @param * @param url
     * @return void
     * @description 列表页抓取
     * @author chenpeng
     * @date 2020/8/11
     */
    public void paresListPage(String url) {
        LOG.info("paresListPage start parse=====>" + url);
        String html = template.catchHtml(url);
        if (!StringUtils.isEmpty(html)) {
            Document document = Jsoup.parse(html);
            try {
                Elements elements = document.select("div[id=pagelet_frs-list/pagelet/thread_list] ul#thread_list li.j_thread_list.clearfix");
                if (elements != null && elements.size() > 0) {
                    System.out.println(elements.size());
                    for (int i = 0; i < elements.size(); i++) {
                        Element element = elements.get(i);
                        String field = element.attr("data-field");
                        System.out.println(field);
                        System.out.println("----------------------->");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
