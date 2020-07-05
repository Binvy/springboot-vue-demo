package com.binvi.springboot.demo03.component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/7 8:23
 */
@Data
public class Sample {

    private String id;
    private byte bit;
    private char chaar;
    private byte[] bytes;
    private short age;
    private int amount;
    private long length;
    private float scale;
    private double price;
    private boolean active;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;
    private BigDecimal account;
    private BigInteger integer;

    private List<String> lists;
    private Map<String, String> maps;
    private Set<String> sets;

    private Sample() {}

    public static Sample of() {
        Sample sample = new Sample();
        sample.setId(UUID.randomUUID().toString());
        sample.setBit((byte)1);
        sample.setChaar('a');
        sample.setBytes(null);
        sample.setAge(Short.valueOf("28"));
        sample.setAmount(123);
        sample.setLength(1800);
        sample.setScale(0.0001f);
        sample.setPrice(22.22);
        sample.setActive(true);
        sample.setTime(new Date());
        sample.setAccount(new BigDecimal("2222"));
        sample.setInteger(new BigInteger("1111"));
        List<String> lists = Lists.newArrayListWithCapacity(5);
        lists = Arrays.asList(new String[] {"1", "2", "3", "4", "5"});
        sample.setLists(lists);
        HashMap<String, String> maps = Maps.newHashMap();
        maps.put("name", "雁渡寒潭族");
        maps.put("age", "28");
        sample.setMaps(maps);
        HashSet<String> sets = Sets.newHashSet();
        sets.addAll(lists);
        sample.setSets(sets);
        return sample;
    }

}
