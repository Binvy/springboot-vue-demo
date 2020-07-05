package com.binvi.springboot.demo03.entity;

import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/23 14:50
 */
@Data
public class Message implements Serializable {

    private String name;
    private String content;

}
