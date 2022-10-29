package mao.use.controller;


import mao.use.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * Project name(项目名称)：hibernate_validator_demo
 * Package(包名): mao.hibernate_validator_demo.controller
 * Class(类名): UserController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/29
 * Time(创建时间)： 13:01
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@RestController
//开启校验
@Validated
public class UserController
{
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/delete")
    public String delete(@NotBlank(message = "id不能为空") String id)
    {
        log.info("delete..." + id);
        return "OK";
    }

    @GetMapping("/save")
    public String save(@Validated @RequestBody User user)
    {
        log.info("save..." + user);
        return "OK";
    }
}
