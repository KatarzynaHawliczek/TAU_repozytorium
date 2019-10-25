package com.hawliczek.tau.domain;

import java.time.LocalDateTime;

public class GameTime
{
	private LocalDateTime addGameTime;
	private LocalDateTime updateGameTime;
	private LocalDateTime readGameTime;
	
	public LocalDateTime getAddGameTime()
	{
		return addGameTime;
	}

	public void setAddGameTime(LocalDateTime addGameTime)
	{
		this.addGameTime = addGameTime;
	}

	public LocalDateTime getUpdateGameTime()
	{
		return updateGameTime;
	}

	public void setUpdateGameTime(LocalDateTime updateGameTime)
	{
		this.updateGameTime = updateGameTime;
	}

	public LocalDateTime getReadGameTime()
	{
		return readGameTime;
	}

	public void setReadGameTime(LocalDateTime readGameTime)
	{
		this.readGameTime = readGameTime;
	}

	public GameTime()
	{
	}
	
	public GameTime(LocalDateTime addGameTime, LocalDateTime updateGameTime, LocalDateTime readGameTime)
	{
		this.addGameTime = addGameTime;
		this.readGameTime = readGameTime;
		this.updateGameTime = updateGameTime;
	}
}
