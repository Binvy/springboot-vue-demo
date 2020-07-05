package com.binvi.springboot.demo03.book.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ZParams;

import java.util.*;

/**
 * @author binvi
 * @version 1.0
 * @Description: 使用Redis构建一个简单的文章投票网站的后端
 * @date 2019/8/7 23:23
 */
public class Chapter01 {

	 private static final int ONE_WEEK_IN_SECONDS = 7 * 24 * 60 * 60;
	 private static final int VOTE_SCORE = 432;
	 private static final int ARTICLES_PER_PAGE = 25;

	public static final void main(String[] args) {
		new Chapter01().run();
	}

	public void run() {
		Jedis conn = new Jedis("localhost");
		conn.select(15);

		String articleId = postArticle(
				conn, "username", "A title", "http://www.google.com");
		System.out.println("We posted a new article with id: " + articleId);
		System.out.println("Its HASH looks like:");
		Map<String,String> articleData = conn.hgetAll("article:" + articleId);
		for (Map.Entry<String,String> entry : articleData.entrySet()){
			System.out.println("  " + entry.getKey() + ": " + entry.getValue());
		}

		System.out.println();

		articleVote(conn, "other_user", "article:" + articleId);
		String votes = conn.hget("article:" + articleId, "votes");
		System.out.println("We voted for the article, it now has votes: " + votes);
		assert Integer.parseInt(votes) > 1;

		System.out.println("The currently highest-scoring articles are:");
		List<Map<String,String>> articles = getArticles(conn, 1);
		printArticles(articles);
		assert articles.size() >= 1;

		addGroups(conn, articleId, new String[]{"new-group"});
		System.out.println("We added the article to a new group, other articles include:");
		articles = getGroupArticles(conn, "new-group", 1);
		printArticles(articles);
		assert articles.size() >= 1;
	}

	/**
	 * 发布新文章
	 * @param conn
	 * @param user
	 * @param title
	 * @param link
	 * @return
	 */
	public String postArticle(Jedis conn, String user, String title, String link) {
		String articleId = String.valueOf(conn.incr("article:"));

		String voted = "voted:" + articleId;
		conn.sadd(voted, user);
		conn.expire(voted, ONE_WEEK_IN_SECONDS);

		long now = System.currentTimeMillis() / 1000;
		String article = "article:" + articleId;
		HashMap<String,String> articleData = new HashMap<String,String>();
		articleData.put("title", title);
		articleData.put("link", link);
		articleData.put("user", user);
		articleData.put("now", String.valueOf(now));
		articleData.put("votes", "1");
		conn.hmset(article, articleData);
		conn.zadd("score:", now + VOTE_SCORE, article);
		conn.zadd("time:", now, article);

		return articleId;
	}

	/**
	 * 给文章投票
	 * @param conn
	 * @param user
	 * @param article
	 */
	public void articleVote(Jedis conn, String user, String article) {
		long cutoff = (System.currentTimeMillis() / 1000) - ONE_WEEK_IN_SECONDS;
		if (conn.zscore("time:", article) < cutoff){
			return;
		}

		String articleId = article.substring(article.indexOf(':') + 1);
		if (conn.sadd("voted:" + articleId, user) == 1) {
			conn.zincrby("score:", VOTE_SCORE, article);
			conn.hincrBy(article, "votes", 1);
		}
	}

	/**
	 * 根据评分获取文章列表
	 * @param conn
	 * @param page
	 * @return
	 */
	public List<Map<String,String>> getArticles(Jedis conn, int page) {
		return getArticles(conn, page, "score:");
	}

	/**
	 * 获取文章列表（根据文章中的某字段排序）
	 * @param conn
	 * @param page
	 * @param order
	 * @return
	 */
	public List<Map<String,String>> getArticles(Jedis conn, int page, String order) {
		int start = (page - 1) * ARTICLES_PER_PAGE;
		int end = start + ARTICLES_PER_PAGE - 1;

		Set<String> ids = conn.zrevrange(order, start, end);
		List<Map<String,String>> articles = new ArrayList<Map<String,String>>();
		for (String id : ids){
			Map<String,String> articleData = conn.hgetAll(id);
			articleData.put("id", id);
			articles.add(articleData);
		}

		return articles;
	}

	/**
	 * 增加小组
	 * @param conn
	 * @param articleId
	 * @param toAdd
	 */
	public void addGroups(Jedis conn, String articleId, String[] toAdd) {
		String article = "article:" + articleId;
		for (String group : toAdd) {
			conn.sadd("group:" + group, article);
		}
	}

	/**
	 * 根据小组获取文章列表
	 * @param conn
	 * @param group
	 * @param page
	 * @return
	 */
	public List<Map<String,String>> getGroupArticles(Jedis conn, String group, int page) {
		return getGroupArticles(conn, group, page, "score:");
	}

	/**
	 * 获取按照文章评分排序的群组文章
	 * @param conn
	 * @param group
	 * @param page
	 * @param order
	 * @return
	 */
	public List<Map<String,String>> getGroupArticles(Jedis conn, String group, int page, String order) {
		String key = order + group;
		if (!conn.exists(key)) {
			ZParams params = new ZParams().aggregate(ZParams.Aggregate.MAX);
			conn.zinterstore(key, params, "group:" + group, order);
			conn.expire(key, 60);
		}
		return getArticles(conn, page, key);
	}

	/**
	 * 打印文章列表
	 * @param articles
	 */
	private void printArticles(List<Map<String,String>> articles){
		for (Map<String,String> article : articles){
			System.out.println("  id: " + article.get("id"));
			for (Map.Entry<String,String> entry : article.entrySet()){
				if (entry.getKey().equals("id")){
					continue;
				}
				System.out.println("    " + entry.getKey() + ": " + entry.getValue());
			}
		}
	}

}
