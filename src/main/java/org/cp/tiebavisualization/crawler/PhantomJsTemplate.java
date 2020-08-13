package org.cp.tiebavisualization.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class PhantomJsTemplate {

    private static final Logger LOG = LoggerFactory.getLogger(PhantomJsTemplate.class);

    @Value(("${phantomjs.command.path}"))
    private String command;

    @Value(("${phantomjs.code.path}"))
    private String jscode;

    protected String catchHtml(String url) {
        LOG.info("PhantomJsTemplate start catch url :" + url);
        String html = "";
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(command + " " + jscode + " " + url);
            InputStream inputStream = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String temp = "";
            while ((temp = bufferedReader.readLine()) != null) {
                builder.append(temp);
            }
            html = builder.toString();
            LOG.info("PhantomJsTemplate catch url <" + url + "> success,original html=====> " + html);
        } catch (Exception e) {
            LOG.error("PhantomJsTemplate catch url <" + url + "> fail!", e);
            e.printStackTrace();
        }
        return html;
    }
}
