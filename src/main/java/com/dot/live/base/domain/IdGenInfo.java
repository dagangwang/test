package com.dot.live.base.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author heshuangquan
 *
 */
@Document(collection="id_generator")
public class IdGenInfo  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5021954342103275625L;

	@Id
	private String id;
	
	@Field("coll_name")
	private String collName;
	
	@Field("id_index")
	private long idIndex;
	
	@Field("coll_desc")
	private String collDesc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCollName() {
		return collName;
	}

	public void setCollName(String collName) {
		this.collName = collName;
	}

	public String getCollDesc() {
		return collDesc;
	}

	public void setCollDesc(String collDesc) {
		this.collDesc = collDesc;
	}

	public long getIdIndex() {
		return idIndex;
	}

	public void setIdIndex(long idIndex) {
		this.idIndex = idIndex;
	}
	
	
	
}
