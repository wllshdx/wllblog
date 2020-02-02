package com.wllnb.wllblog.manage.oss.controller;


import com.wllnb.wllblog.common.Result;
import com.wllnb.wllblog.common.exception.MyException;
import com.wllnb.wllblog.entity.oss.OssResource;
import com.wllnb.wllblog.manage.oss.service.CloudStorageService;
import com.wllnb.wllblog.manage.oss.service.OssResourceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 * 云存储资源表 前端控制器
 * </p>
 *
 * @author wllnb
 */
@RestController
@RequestMapping("/admin/oss/resource")
public class OssResourceController {

    @Resource
    private OssResourceService ossResourceService;

    @Resource
    private CloudStorageService cloudStorageService;

    @PostMapping("/upload")
    public Result uploadCover(MultipartFile file) throws Exception{
        if (file!=null && file.isEmpty()) {
            throw new MyException("上传文件不能为空");
        }
        //上传文件
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String url =cloudStorageService.uploadSuffix(file.getBytes(), suffix);
        OssResource resource=new OssResource(url,file.getOriginalFilename());
        ossResourceService.save(resource);
        return Result.ok().put("resource", resource);
    }
}
