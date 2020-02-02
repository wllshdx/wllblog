
package com.wllnb.wllblog.manage.oss.service.impl;

import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.wllnb.wllblog.common.exception.MyException;
import com.wllnb.wllblog.common.exception.enums.ErrorEnum;
import com.wllnb.wllblog.configuration.CloudStorageConfig;
import com.wllnb.wllblog.manage.oss.service.CloudStorageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * QiniuCloudStorageService
 *
 * @author wllnb
 * @description
 */
@Service("cloudStorageService")
@Slf4j
public class QiniuCloudStorageServiceImpl extends CloudStorageService {
    private UploadManager uploadManager;
    private String token;
    private Auth auth;

    public QiniuCloudStorageServiceImpl(CloudStorageConfig config){
        this.config = config;
        //初始化
        init();
    }

    private void init(){
        uploadManager = new UploadManager(new Configuration(Zone.autoZone()));
        auth = Auth.create(config.getQiniuAccessKey(), config.getQiniuSecretKey());
        token = auth.uploadToken(config.getQiniuBucketName());
    }

    @Override
    public String upload(byte[] data, String path) {
        try {
            token = auth.uploadToken(config.getQiniuBucketName());
            Response res = uploadManager.put(data, path, token);
            if (!res.isOK()) {
                throw new RuntimeException("上传七牛出错：" + res.toString());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new MyException(ErrorEnum.OSS_CONFIG_ERROR);
        }

        return config.getQiniuDomain() + "/" + path;
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            byte[] data = IOUtils.toByteArray(inputStream);
            return this.upload(data, path);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new MyException(ErrorEnum.OSS_CONFIG_ERROR);
        }
    }

    @Override
    public String uploadSuffix(byte[] data, String suffix) {
        return upload(data, getPath(config.getQiniuPrefix(), suffix));
    }

    @Override
    public String uploadSuffix(InputStream inputStream, String suffix) {
        return upload(inputStream, getPath(config.getQiniuPrefix(), suffix));
    }
}
