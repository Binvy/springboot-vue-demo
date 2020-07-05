package com.binvi.springboot.demo03.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/12 15:51
 */
@Data
public class Song implements Serializable {

    private Integer id;             // 编号
    private String nameCh;          // 中文名称
    private String nameEn;          // 英文名称
    private String compose;         // 作曲
    private String lyricist;        // 作词
    private String arranger;        // 编曲
    private String singer;          // 演唱
    private String album;           // 专辑
    private String style;           // 风格
    private Long duration;          // 市场
    private Date publishDate;       // 发行日期
    private BigDecimal price;       // 价格
    private String producer;        // 监制
    private String recordCompany;   // 唱片公司
    private String introduction;    // 简介
    private String remark;          // 备注

    public static Song getInstance() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Song song = new Song();
        song.setNameCh("来自天堂的魔鬼");
        song.setNameEn("Away");
        song.setCompose("G.E.M.邓紫棋");
        song.setLyricist("G.E.M.邓紫棋");
        song.setArranger("Lupo Groinig");
        song.setSinger("G.E.M.邓紫棋");
        song.setAlbum("新的心跳");
        song.setStyle("电子，摇滚，流行");
        song.setDuration(245L);
        song.setPublishDate(dateFormat.parse("2015-11-05"));
        song.setPrice(new BigDecimal(20));
        song.setRecordCompany("蜂鸟音乐");
        song.setIntroduction("这首歌单纯的是讲爱情，有时候觉得这个人带给你很多快乐，可同时这些幸福的瞬间又会使你患得患失，产生很多不快乐。因为这个人带给你的快乐越多，他带给你的伤害也就会越大，是一个双面的感觉。所以你说他到底是天使，还是魔鬼？无从得知。");
        song.setRemark("");
        return song;
    }

}
