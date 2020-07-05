package com.binvi.springboot.demo03.json;

import com.binvi.springboot.demo03.entity.Anime;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2019/6/13 23:06
 */
@RunWith(SpringRunner.class)
@JsonTest
public class TestJson {

    @Autowired
    JacksonTester<Anime> jacksonTester;

    @Test
    public void testSerialize() throws Exception {
        Anime anime = Anime.getInstance();
        JsonContent<Anime> jsonContent = jacksonTester.write(anime);
        Assertions.assertThat(jsonContent)
                .isEqualToJson("anime.json");
        Assertions.assertThat(jsonContent)
                .hasJsonPathStringValue("@.author");
        Assertions.assertThat(jsonContent)
                .extractingJsonPathStringValue("@.author")
                .isEqualTo("one");
    }

    @Test
    public void testDeserialize() throws Exception {
        String content = "{\"name\":\"一拳超人\", \"author\":\"one\", \"price\":20, \"star\":\"琦玉\", \"publishDate\":\"2002-10-03\", \"description\":\"虎鬼龙神\", \"remark\": \"recommend to watch\"}";
        Anime anime = jacksonTester.parseObject(content);
        Assertions.assertThat(anime.getName()).isEqualTo("一拳超人");
    }

}
