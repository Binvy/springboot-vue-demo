package com.binvi.springboot.demo03.book.javase.oxm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author binvi
 * @version 1.0
 * @Description:
 * @date 2020/6/29 22:43
 */
public class MediaItem {

	private MediaContent _content;
	private List<Image> _images;

	public MediaItem() { }

	public MediaItem(MediaContent c) {
		_content = c;
	}

	public void addPhoto(Image p) {
		if (_images == null) {
			_images = new ArrayList<Image>();
		}
		_images.add(p);
	}

	public List<Image> getImages() { return _images; }
	public void setImages(List<Image> p) { _images = p; }

	public MediaContent getContent() { return _content; }
	public void setContent(MediaContent c) { _content = c; }

	static class MediaContent
	{
		public enum Player { JAVA, FLASH;  }

		private Player _player;
		private String _uri;
		private String _title;
		private int _width;
		private int _height;
		private String _format;
		private long _duration;
		private long _size;
		private int _bitrate;
		private List<String> _persons;
		private String _copyright;

		public MediaContent() { }

		protected MediaContent(MediaContent src) {
			_player = src._player;
			_uri = src._uri;
			_title = src._title;
			_width = src._width;
			_height = src._height;
			_format = src._format;
			_duration = src._duration;
			_size = src._size;
			_bitrate = src._bitrate;
			_persons = src._persons;
			_copyright = src._copyright;
		}

		public void addPerson(String p) {
			if (_persons == null) {
				_persons = new ArrayList<String>();
			}
			_persons.add(p);
		}

		public Player getPlayer() { return _player; }
		public String getUri() { return _uri; }
		public String getTitle() { return _title; }
		public int getWidth() { return _width; }
		public int getHeight() { return _height; }
		public String getFormat() { return _format; }
		public long getDuration() { return _duration; }
		public long getSize() { return _size; }
		public int getBitrate() { return _bitrate; }
		public List<String> getPersons() { return _persons; }
		public String getCopyright() { return _copyright; }

		public void setPlayer(Player p) { _player = p; }
		public void setUri(String u) {  _uri = u; }
		public void setTitle(String t) {  _title = t; }
		public void setWidth(int w) {  _width = w; }
		public void setHeight(int h) {  _height = h; }
		public void setFormat(String f) {  _format = f;  }
		public void setDuration(long d) {  _duration = d; }
		public void setSize(long s) {  _size = s; }
		public void setBitrate(int b) {  _bitrate = b; }
		public void setPersons(List<String> p) {  _persons = p; }
		public void setCopyright(String c) {  _copyright = c; }
	}

	static class Image
	{
		private String _uri;
		private String _title;
		private int _width;
		private int _height;
		private Size _size;

		public Image() {}
		public Image(String uri, String title, int w, int h, Size s)
		{
			_uri = uri;
			_title = title;
			_width = w;
			_height = h;
			_size = s;
		}

		public String getUri() { return _uri; }
		public String getTitle() { return _title; }
		public int getWidth() { return _width; }
		public int getHeight() { return _height; }
		public Size getSize() { return _size; }

		public void setUri(String u) { _uri = u; }
		public void setTitle(String t) { _title = t; }
		public void setWidth(int w) { _width = w; }
		public void setHeight(int h) { _height = h; }
		public void setSize(Size s) { _size = s; }
	}

	enum Size { SMALL, LARGE; }

	static MediaItem getTempRecord() {
		MediaItem mediaItem = new MediaItem();

		MediaContent mediaContent = new MediaContent();
		mediaContent.setUri("http://javaone.com/keynote.mpg");
		mediaContent.setTitle("Javaone Keynote");
		mediaContent.setWidth(640);
		mediaContent.setHeight(480);
		mediaContent.setFormat("video/mpg4");
		mediaContent.setDuration(18000000);
		mediaContent.setSize(58982400);
		mediaContent.setBitrate(262144);
		mediaContent.setPersons(Arrays.asList("ill Gates", "Steve Jobs"));
		mediaContent.setCopyright("None");

		Image image1 = new Image();
		image1.setUri("http://javaone.com/keynote_large.jpg");
		image1.setTitle("Javaone Keynote");
		image1.setWidth(1024);
		image1.setHeight(768);
		image1.setSize(Size.LARGE);

		Image image2 = new Image();
		image2.setUri("http://javaone.com/keynote_small.jpg");
		image2.setTitle("Javaone Keynote");
		image2.setWidth(320);
		image2.setHeight(240);
		image2.setSize(Size.SMALL);

		mediaItem.setContent(mediaContent);
		mediaItem.setImages(Arrays.asList(image1, image2));
		return mediaItem;
	}

	String YAML =
			"---\n"
					+"content:\n"
					+"  uri: 'http://javaone.com/keynote.mpg'\n"
					+"  title: 'Javaone Keynote'\n"
					+"  width: 640\n"
					+"  height: 480\n"
					+"  format: 'video/mpg4'\n"
					+"  duration: 18000000\n"
					+"  size: 58982400\n"
					+"  bitrate: 262144\n"
					+"  persons:\n"
					+"  - 'Bill Gates'\n"
					+"  - 'Steve Jobs'\n"
					+"  player: 'JAVA'\n"
					+"  copyright: 'None'\n"
					+"images:\n"
					+"- uri: 'http://javaone.com/keynote_large.jpg'\n"
					+"  title: 'Javaone Keynote'\n"
					+"  width: 1024\n"
					+"  height: 768\n"
					+"  size: 'LARGE'\n"
					+"- uri: 'http://javaone.com/keynote_small.jpg'\n"
					+"  title: 'Javaone Keynote'\n"
					+"  width: 320\n"
					+"  height: 240\n"
					+"  size: 'SMALL'\n";

}
