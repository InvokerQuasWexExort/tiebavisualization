package org.cp.tiebavisualization.crawler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.cp.tiebavisualization.pojo.Article;
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

    private static final String prefix = "https://tieba.baidu.com/";

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
                    for (int i = 0; i < elements.size(); i++) {
                        Article article = new Article();
                        Element element = elements.get(i);
                        String field = element.attr("data-field");
                        JSONObject jsonObject = JSON.parseObject(field);
                        if (jsonObject.containsKey("is_top")) {
                            if (jsonObject.getBooleanValue("is_top")) {
                                article.setIsTop(1);
                            } else {
                                article.setIsTop(0);
                            }
                        }
                        if (jsonObject.containsKey("id")) {
                            Long id = jsonObject.getLong("id");
                            article.setTid(id);
                        }
                        if (jsonObject.containsKey("author_name")) {
                            String authorName = jsonObject.getString("author_name");
                            if (!StringUtils.isEmpty(authorName)) {
                                article.setAuthorName(authorName);
                            }
                        }
                        if (jsonObject.containsKey("author_nickname")) {
                            String authorNickname = jsonObject.getString("author_nickname");
                            if (!StringUtils.isEmpty(authorNickname)) {
                                article.setAuthorNickname(authorNickname);
                            }
                        }
                        if (jsonObject.containsKey("reply_num")) {
                            Integer replyNum = jsonObject.getInteger("reply_num");
                            article.setReplyNum(replyNum);
                        }
                        Elements userDiv = element.select("div.threadlist_title.pull_left.j_th_tit a");
                        String title = userDiv.html();
                        if (!StringUtils.isEmpty(title)) {
                            article.setTitle(title);
                        }
                        String href = userDiv.attr("href");
                        if (!StringUtils.isEmpty(href)) {
                            article.setUrl(prefix + href);
                        }
                        Elements userSpan = element.select("span.tb_icon_author");
                        String userDate = userSpan.attr("data-field");
                        JSONObject user = JSON.parseObject(userDate);
                        if (user.containsKey("user_id")) {
                            Long userId = user.getLong("user_id");
                            article.setUserId(userId);
                        }
                        Elements userUrlSpan = element.select("span.frs-author-name-wrap a");
                        String userHref = userUrlSpan.attr("href");
                        if (!StringUtils.isEmpty(userHref)) {
                            article.setUserUrl(prefix + userHref);
                        }
                        System.out.println(article);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
