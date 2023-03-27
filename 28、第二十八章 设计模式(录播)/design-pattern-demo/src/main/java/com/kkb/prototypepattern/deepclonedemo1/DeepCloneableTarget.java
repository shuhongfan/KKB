package com.kkb.prototypepattern.deepclonedemo1;

public class DeepCloneableTarget implements Cloneable{


	private String cloneName;

	private String cloneClass;

	//引用类型呢？

	public DeepCloneableTarget(String cloneName, String cloneClass) {

		this.cloneName = cloneName;

		this.cloneClass = cloneClass;
	}

	//使用默认的就可以

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
