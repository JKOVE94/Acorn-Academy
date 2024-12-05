package conect.controller;

import conect.service.manage.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage")
public class ManageController {
    //유저관리 (/manage/user)

    @Autowired
    private UserService userService;
}
