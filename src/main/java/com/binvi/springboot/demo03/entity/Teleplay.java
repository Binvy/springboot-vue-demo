package com.binvi.springboot.demo03.entity;

import lombok.Data;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/12 17:52
 */
@Data
public class Teleplay implements Serializable {

    private Integer id;             // 编号
    private String name;            // 名称
    private short season;           // 季数
    private short episode;          // 集数
    private String stars;           // 主演
    private String author;          // 作者
    private String scriptwriter;    // 编剧
    private Date publishDate;       // 出版日期
    private String introduction;    // 简介
    private String remark;          // 说明

    public static Teleplay getInstance() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Teleplay teleplay = new Teleplay();
        teleplay.setName("Game Of Thrones");
        teleplay.setSeason((short)8);
        teleplay.setEpisode((short)73);
        teleplay.setStars("stark");
        teleplay.setAuthor("George Raymond Richard Martin");
        teleplay.setScriptwriter("George Raymond Richard Martin, David Beniof");
        try {
            teleplay.setPublishDate(dateFormat.parse("2011-04-17"));
        } catch (ParseException e) {
            teleplay.setPublishDate(new Date());
        }
        teleplay.setIntroduction("权力的游戏");
        teleplay.setRemark("recommend to watch");
        return teleplay;
    }

}
