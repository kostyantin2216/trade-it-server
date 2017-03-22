package com.charlieaffs.data;

import java.io.Serializable;

public interface DataModelObject extends Serializable {
	Serializable getSerializedId();
	void setSerializedId(Serializable id) throws ClassCastException;
}
