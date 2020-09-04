package org.cp.tiebavisualization.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @ClassName Article
 * @Description
 * @Author chenpeng
 * @Date 2020/9/2 19:30
 */
@TableName(value = "t_article")
public class Article {

    @TableId
    private int id;
    private long tid;
    private long userId;
    private String authorName;
    private String authorNickname;
    private String title;
    private String url;
    private String userUrl;
    private int replyNum;
    private Date createTime;
    private int isTop;

    public int getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorNickname() {
        return authorNickname;
    }

    public void setAuthorNickname(String authorNickname) {
        this.authorNickname = authorNickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(int replyNum) {
        this.replyNum = replyNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", tid=" + tid +
                ", userId=" + userId +
                ", authorName='" + authorName + '\'' +
                ", authorNickname='" + authorNickname + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", userUrl='" + userUrl + '\'' +
                ", replyNum=" + replyNum +
                ", createTime=" + createTime +
                ", isTop=" + isTop +
                '}';
    }
}
