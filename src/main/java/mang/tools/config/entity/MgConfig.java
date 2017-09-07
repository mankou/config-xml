package mang.tools.config.entity;



import java.sql.Timestamp;


/**
 */
public class MgConfig  {
    private String id;

    /**
     * 分类
     */
    private String classify;

    /**
     * 名称
     */
    private String codeName;

    /**
     * 值
     */
    private String codeValue;
    
    /**
     * 备注
     */
    private String memo;

    /**
     * 是否有效 1有效 0无效
     */
    private String enabled;

    /**
     * 创建人
     */
    private String createUserName;

    /**
     * 创建日期
     */
    private Timestamp createDate;

    /**
     * 修改人
     */
    private String updateUserName;

    /**
     * 修改日期
     */
    private Timestamp updateDate;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getClassify() {
        return classify;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
