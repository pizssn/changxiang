package com.changgou.util;

import com.changgou.file.FastDFSFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: pizssn
 * @Description: com.changgou
 * 实现FastDFS文件管理，文件上传，删除，下载等
 */
public class FastDFSUtil {

    //加载Tracker的链接信息
    static {
        //查找classpath下的文件路径
        String filename = new ClassPathResource("fdfs_client.conf").getPath();
        try {
            //加载tracker链接信息
            ClientGlobal.init(filename);
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
    }

    //文件上传
    public static String[] upload(FastDFSFile file) throws Exception {
        //获取文件作者
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair(file.getAuthor());
        /*
         * 文件上传后的返回值是一个数组，假设数组名为uploadResults
         * uploadResults[0]:文件上传所存储的组名，例如:group1
         * uploadResults[1]:文件存储路径,例如：M00/00/00/wKjThF0DBzaAP23MAAXz2mMp9oM26.jpeg
         */
        return getStorageClient().upload_file(file.getContent(), file.getExt(), meta_list);
    }

    //文件下载
    public static InputStream downloadFile(String groupName,String remoteFileName) throws Exception {
        byte[] bytes = getStorageClient().download_file(groupName, remoteFileName);
        return new ByteArrayInputStream(bytes);
    }

    //文件删除
    public void deleteFile(String groupName,String remoteFileName) throws Exception{
        getStorageClient().delete_file(groupName,remoteFileName);
    }

    //文件信息获取
    public static FileInfo getFile(String groupName, String remoteFileName) throws Exception {
        return getStorageClient().get_file_info(groupName, remoteFileName);
    }

    //获取Storage信息
    public static StorageServer getStorage() throws Exception {
        return new TrackerClient().getStoreStorage(getTrackerServer());
    }

    //Storage服务的IP、端口信息
    public static ServerInfo[] getServerInfo(String groupName, String remoteFileName) throws Exception {
        return new TrackerClient().getFetchStorages(getTrackerServer(),groupName,remoteFileName);
    }

    //获取Tracker服务地址
    public static String getTrackerUrl() throws Exception {
        //获取Tracker地址
        return "http://"+getTrackerServer().getInetSocketAddress().getHostString()+":"+ClientGlobal.getG_tracker_http_port();
    }

    //抽取通用的部分为一个类
    public static TrackerServer getTrackerServer() throws Exception{
        //创建TrackerClient对象
        TrackerClient trackerClient = new TrackerClient();
        //通过TrackerClient获取TrackerServer对象
        return trackerClient.getConnection();
    }

    //抽取通用的部分为一个类
    public static StorageClient getStorageClient() throws Exception{
        //获取TrackerServer
        TrackerServer trackerServer = getTrackerServer();
        //通过TrackerServer创建StorageClient
        return new StorageClient(trackerServer,null);
    }
}
