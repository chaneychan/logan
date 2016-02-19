package me.ele.logan.admin.base;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseVo implements Serializable {
	private static final long serialVersionUID = 8573297497874330937L;

	/** 主键 */
	private Long id;

	/** 创建时间 */
	private Date createTime;

	/** 修改时间 */
	private Date lastModified;

	/** 创建人id */
	private Long creatorId;

	/** 建人 */
	private String creator;

	/** 修改人id */
	private Long modifierId;

	/** 修改人 */
	private String modifiedBy;
	

	/**
	 * 分页PG
	 */
	private Pager pager = new Pager();

    @JsonProperty
    public Long getId() {
        return id;
    }
    @JsonProperty
    public void setId(Long id) {
        this.id = id;
    }
    @JsonProperty
    public Date getCreateTime() {
        return createTime;
    }
    @JsonProperty
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @JsonProperty
    public Date getLastModified() {
        return lastModified;
    }
    @JsonProperty
    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }
    @JsonProperty
    public Long getCreatorId() {
		return creatorId;
	}
    @JsonProperty
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
    @JsonProperty
	public String getCreator() {
		return creator;
	}
    @JsonProperty
	public void setCreator(String creator) {
		this.creator = creator;
	}
    @JsonProperty
	public Long getModifierId() {
		return modifierId;
	}
    @JsonProperty
	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}
    public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	@JsonProperty
	public Pager getPager() {
		return pager;
	}
    @JsonProperty
	public void setPager(Pager pager) {
		this.pager = pager;
	}
  
}
