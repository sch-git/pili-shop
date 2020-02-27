package com.sch.backweb.controller;

import com.sch.commonbasic.VO.Result;
import com.sch.commonbasic.enums.ResultEnum;
import com.sch.commonbasic.util.QiNiuCloudUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 管理员接口
 * @Author: chenghao.su
 * @Date: 2020/1/13 19:40
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    /**
     * 上传头像
     *
     * @param file 文件数据
     * @return 头像地址
     */
    @PostMapping("/avatar")
    public Result uploadAvatar(@RequestParam MultipartFile file) {
        String path = QiNiuCloudUtil.uploadImg(file);
        return new Result(ResultEnum.UPLOAD_IMAGE, path);
    }
}
