package cn.tedu.csmall.passport.controller;

import cn.tedu.csmall.common.web.JsonResult;
import cn.tedu.csmall.passport.service.IAdminService;
import cn.tedu.csmall.pojo.dto.AdminLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/admins", produces = "application/json;charset=utf-8")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('/ams/admin/read')")
    public String sayHello() {
        return "hello~~";
    }


    //http://localhost:8080/admins/login?username=root&password=123456

    @RequestMapping("/login")
    public JsonResult<String> login(AdminLoginDTO adminLoginDTO) {

        String jwt = adminService.login(adminLoginDTO);
        return JsonResult.ok(jwt);
    }
}
