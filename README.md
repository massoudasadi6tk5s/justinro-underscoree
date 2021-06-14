# 文件在线预览模块（多格式转PDF文件）

 > 说明：本项目是将一些常见的技术做了整合，帮助那些需要在线预览文件或正在寻找office转pdf文件预览的同学。如果你觉得本项目对你有帮助请点击一下start，多谢大家！

 > 已经实现功能如下：
 > - 多格式转换为PDF格式
 > - OFFICE转换为PNG格式
 > - 在线预览文件
 > - 手机预览查看文件

## 现已支持格式如下

 - 图片预览：.gif、bmp、jpeg、jpg、png、ico
 - 文档预览：.doc、docx、xls、xlsx、ppt、pptx
 - PDF文件：pdf
 - 文本文件：txt
 - 音频文件：mp3、ogg、wav
 - 视频文件：mp4、webm、mkv


## 运行方式

 > 【必须】程序运行所在环境安装LibreOffice，PDF转换基于LibreOffice完成(OpenOffice也一样可用)   
 > 安装参考教程：http://wiki.nooss.cn/archives/420.html   
 > Linux安装字体(不安装会出现乱码问题)：http://wiki.nooss.cn/archives/406.html 

 - 1、直接复制源码里的文件搬家至你自己的代码中
 - 2、将此Demo打包成为一个jar引入到自己的项目中

## 接口介绍

### 文件上传

`http://ip:port/demo/upload`



### 文件转PDF

`http://ip:port/demo/toPdf`

### 文件转图片 

 > ps：会先将文件转为pdf，然后使用pdfbox转为图片

`http://ip:port/demo/toPng`


## 参数配置

```shell
castle:
  upload:
    # 自行配置可访问的路径
    fileDomain: http://up.hcses.cn/pdftools  # 文件可访问的地址
    fileServerPath: /www/wwwroot/up.hcses.cn/pdftools/  # 原始文件的服务器存储位置
```


## 其他说明

 - 本示例转换PDF部分采用了<a href="https://zh-cn.libreoffice.org/download/libreoffice/" target="_blank">LibreOffice</a>工具   
 - PDF转换图片使用了<a href="https://pdfbox.apache.org/" target="_blank">PDFBox</a>组件   
 - 感谢<a href="https://hutool.cn/" target="_blank">hutool</a>组件

## 项目关联关键词

word转pdf、word转图片、office格式转换、在线文件预览