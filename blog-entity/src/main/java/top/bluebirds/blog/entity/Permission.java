package top.bluebirds.blog.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "t_permission")
public class Permission {

    @ApiModelProperty(value="系统标识")
    private Integer id;

    @ApiModelProperty(value="菜单名称")
    private String permissionName;

    @ApiModelProperty(value="接口url")
    private String action;

    @ApiModelProperty(value="菜单url")
    private String url;

    @ApiModelProperty(value="父级ID")
    private Integer parentId;

    @ApiModelProperty(value="菜单排序")
    private Integer orderField;

    @ApiModelProperty(value="状态0=不启用、1=启用")
    private Integer status;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="创建时间")
    private Date createTime;
    @ApiModelProperty(value="创建人编号")
    private Integer createUserId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="删除时间")
    private Date deleteTime;
    @ApiModelProperty(value="删除人编号")
    private Integer deleteUserId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;
    @ApiModelProperty(value="更新人编号")
    private Integer updateUserId;

    @ApiModelProperty(value="对应角色信息")
    List<Role> roles = new ArrayList<>();

}
