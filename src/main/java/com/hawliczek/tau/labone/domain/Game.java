package com.hawliczek.tau.labone.domain;

import java.util.Date;

public class Game
{
	private int id;
	private String title;
	private String genre;
	private String developer;
	private String publisher;
	private String releaseDate;
	private Date addTime;
	private Date updateTime;
	private Date readTime;
	
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getGenre()
	{
		return genre;
	}
	
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	
	public String getDeveloper()
	{
		return developer;
	}
	
	public void setDeveloper(String developer)
	{
		this.developer = developer;
	}
	
	public String getPublisher()
	{
		return publisher;
	}
	
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}
	
	public String getReleaseDate()
	{
		return releaseDate;
	}
	
	public void setReleaseDate(String releaseDate)
	{
		this.releaseDate = releaseDate;
	}
	
	public Date getAddTime()
	{
		return addTime;
	}

	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}

	public Date getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	public Date getReadTime()
	{
		return readTime;
	}

	public void setReadTime(Date readTime)
	{
		this.readTime = readTime;
	}

	public Game(int id, String title, String genre, String developer, String publisher, String releaseDate)
	{
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.developer = developer;
		this.publisher = publisher;
		this.releaseDate = releaseDate;
	}
	
	public Game(int id, String title, String genre, String developer, String publisher, String releaseDate, Date addTime, Date updateTime, Date readTime)
	{
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.developer = developer;
		this.publisher = publisher;
		this.releaseDate = releaseDate;
		this.addTime = addTime;
		this.updateTime = updateTime;
		this.readTime = readTime;
	}
}
