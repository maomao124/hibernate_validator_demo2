package mao.use.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * Project name(项目名称)：hibernate_validator_demo
 * Package(包名): mao.hibernate_validator_demo.entity
 * Class(类名): User
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/29
 * Time(创建时间)： 12:47
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class User
{
    /**
     * id
     */
    @NotNull(message = "用户id不能为空")
    private Integer id;
    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    @Length(max = 40, message = "用户名长度不能超过40位")
    private String userName;
    /**
     * 年龄
     */
    @Min(value = 18, message = "年龄至少为18岁")
    @Max(value = 60, message = "年龄最大为60岁")
    private Integer age;
    /**
     * 电子邮件
     */
    //@Email(message = "邮箱格式不正确")
    @Pattern(regexp = "[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\\\.[a-zA-Z0-9_-]+)+$", message = "邮箱格式不正确")
    private String email;


}
