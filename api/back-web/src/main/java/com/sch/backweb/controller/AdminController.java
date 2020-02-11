package com.sch.backweb.controller;

import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import com.sch.commonbasic.util.QiNiuCloudUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 管理员接口
 * @Author: chenghao.su
 * @Date: 2020/1/13 19:40
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    /**
     * 上传头像
     *
     * @param files 文件数据
     * @return 头像地址
     */
    @PostMapping("/avatar")
    public Result uploadAvatar(@RequestParam("avatar") MultipartFile files) {
        String path = QiNiuCloudUtil.uploadImg(files);
        return new Result(ResultEnum.UPLOAD_IMAGE, path);
    }
}
