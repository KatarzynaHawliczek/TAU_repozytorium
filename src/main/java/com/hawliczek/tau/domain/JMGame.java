package com.hawliczek.tau.domain;

public class JMGame
{
	private int id;
	private String title;
	private String genre;
	private String developer;
	private String publisher;
	private String releaseDate;
	
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
	
	public JMGame()
	{
	}
	
	public JMGame(int id, String title, String genre, String developer, String publisher, String releaseDate)
	{
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.developer = developer;
		this.publisher = publisher;
		this.releaseDate = releaseDate;
	}
}
