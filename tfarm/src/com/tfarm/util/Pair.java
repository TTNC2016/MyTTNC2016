package com.tfarm.util;

import java.io.Serializable;

/**
 * 数据对
 * @author 
 *
 * @param <T1>
 * @param <T2>
 */
public class Pair<T1, T2> implements Serializable
{
	private static final long serialVersionUID = -5473162399311701494L;

	public T1 left;

	public T2 right;

	public Pair()
	{
	}

	public Pair(T1 left, T2 right)
	{
		this.left = left;
		this.right = right;
	}

	public <F> void method(F param)
	{
	}

	@Override
	public String toString()
	{
		return "<" + this.left + "," + this.right + ">";
	}

	public T1 getLeft()
	{
		return this.left;
	}

	public T2 getRight()
	{
		return this.right;
	}
	
}

