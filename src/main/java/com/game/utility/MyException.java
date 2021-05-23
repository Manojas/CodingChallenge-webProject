package com.game.utility;

public class MyException extends Exception{

	public MyException(String str)
	{		
		super(str);
	}
	public MyException(Throwable e)
	{
		super(e);
	}
}
