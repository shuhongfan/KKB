package com.kkb.prototypepattern.deepclonedemo2;

import java.io.Serializable;

public class DeepCloneableTarget implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cloneName;

	private String cloneClass;

	public Witness witness; //引用类型

	public DeepCloneableTarget(String cloneName, String cloneClass) {
		this.cloneName = cloneName;
		this.cloneClass = cloneClass;
	}

	//因为该类的属性都是String,所以我们使用默认的clone方法完成即可
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "DeepCloneableTarget{" +
				"cloneName='" + cloneName + '\'' +
				", cloneClass='" + cloneClass + '\'' +
				", witness=" + witness +
				'}';
	}
}
