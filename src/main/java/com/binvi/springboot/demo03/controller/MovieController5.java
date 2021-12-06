package com.binvi.springboot.demo03.controller;

/**
 * @author binvi
 * @version 1.0
 * @Description: JPA多数据源控制器
 * @date 2019/6/11 22:37
 */
//@RestController
//@RequestMapping("dbs/jpa")
/*public class MovieController5 {

    private static final Logger logger = LoggerFactory.getLogger(MovieController4.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    MovieDao1 movieDao1;
    @Autowired
    MovieDao2 movieDao2;

    @GetMapping("test")
    public String test() {
        logger.info("JPA多数据源测试：dbs jpa test start");
        List<Movie> movies1 = movieDao1.findAll();
        logger.info("movies1: {}", movies1);
        List<Movie> movies2 = movieDao2.findAll();
        logger.info("movies2: {}", movies2);
        Map<String, List<Movie>> map = Maps.newHashMap();
        map.put("movies1", movies1);
        map.put("movies2", movies2);
        String result = null;
        try {
            result = OBJECT_MAPPER.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            logger.error("json 转换异常!", e);
        }
        return result;
    }

}*/
