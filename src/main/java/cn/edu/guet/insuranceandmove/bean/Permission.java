package cn.edu.guet.insuranceandmove.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 权限表
 * @TableName permissions
 */
@TableName(value ="permissions")
public class Permission implements Serializable {

    private List<Permission> childPermissions = new ArrayList<>();

    /**
     * 权限ID
     */
    @TableId(value = "PERMISSION_ID", type = IdType.AUTO)
    private Integer permissionId;

    /**
     * 父权限ID
     */
    @TableField(value = "PARENT_PERMISSION_ID")
    private Integer parentPermissionId;

    /**
     * 权限名
     */
    @TableField(value = "PERMISSION_NAME")
    private String permissionName;

    /**
     * 权限URL
     */
    @TableField(value = "URL")
    private String url;

    /**
     * 目标
     */
    @TableField(value = "TARGET")
    private String target;

    /**
     * 图标
     */
    @TableField(value = "ICON")
    private String icon;

    /**
     * 是否是父菜单
     */
    @TableField(value = "IS_PARENT")
    private String isParent;

    /**
     * 创建人
     */
    @TableField(value = "CREATED_BY")
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField(value = "CREATED_TIME")
    private Date createdTime;

    /**
     * 更新人
     */
    @TableField(value = "UPDATED_BY")
    private String updatedBy;

    /**
     * 更新时间
     */
    @TableField(value = "UPDATED_TIME")
    private Date updatedTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 权限ID
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * 权限ID
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 父权限ID
     */
    public Integer getParentPermissionId() {
        return parentPermissionId;
    }

    /**
     * 父权限ID
     */
    public void setParentPermissionId(Integer parentPermissionId) {
        this.parentPermissionId = parentPermissionId;
    }

    /**
     * 权限名
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * 权限名
     */
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * 权限URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 权限URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 目标
     */
    public String getTarget() {
        return target;
    }

    /**
     * 目标
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 是否是父菜单
     */
    public String getIsParent() {
        return isParent;
    }

    /**
     * 是否是父菜单
     */
    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    /**
     * 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 更新人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 更新人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public List<Permission> getChildPermissions() {
        return childPermissions;
    }

    public void setChildPermissions(List<Permission> childPermissions) {
        this.childPermissions = childPermissions;
    }
}