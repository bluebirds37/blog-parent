package top.bluebirds.blog.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "t_role")
public class Role {
    @Id
    @ApiModelProperty(value="系统标识")
    private Integer id;

    @NotNull(message = "不能为空")
    @ApiModelProperty(value="备注")
    private String remarks;

    @NotNull(message = "不能为空")
    @ApiModelProperty(value="角色名称")
    private String roleName;

    @ApiModelProperty(value="状态0=不启用、1=启用")
    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="创建时间")
    private Date createTime;
    @ApiModelProperty(value="创建用户编号")
    private Integer createUserId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="删除时间")
    private Date deleteTime;
    @ApiModelProperty(value="删除用户编号")
    private Integer deleteUserId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;
    @ApiModelProperty(value="更新用户编号")
    private Integer updateUserId;

}
