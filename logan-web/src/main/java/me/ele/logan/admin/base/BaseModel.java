package me.ele.logan.admin.base;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * 业务基类，所有的业务实体必须继承该实体
 * </pre>
 *
 * @author chengjun
 * @version
 */
public class BaseModel implements Serializable {

	private static final long serialVersionUID = -5200601342962759667L;

	/**主键*/
	private Long id;

	/**创建时间*/
	private Date createTime;

	/**修改时间*/
	private Date lastModified;

	/**创建人id*/
	private Long creatorId;

	/**创建人*/
	private String creator;

	/**修改人id*/
	private Long modifierId;

	/**修改人*/
	private String modifiedBy;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Long getModifierId() {
		return modifierId;
	}

	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}

	public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

}
