# 文件在线预览模块（多格式转 PDF 文件）

> 说明：本项目是将一些常见的技术做了整合，帮助那些需要在线预览文件或正在寻找 office 转 pdf 文件预览的同学。如果你觉得本项目对你有帮助请点击一下 start，多谢大家！

> 已经实现功能如下：
>
> -   多格式转换为 PDF 格式
> -   OFFICE 转换为 PNG 格式
> -   在线预览文件
> -   手机预览查看文件

## 现已支持格式如下

-   图片预览：.gif、bmp、jpeg、jpg、png、ico
-   文档预览：.doc、docx、xls、xlsx、ppt、pptx
-   PDF 文件：pdf
-   文本文件：txt
-   音频文件：mp3、ogg、wav
-   视频文件：mp4、webm、mkv

## 运行方式

> 【必须】程序运行所在环境安装 LibreOffice，PDF 转换基于 LibreOffice 完成(OpenOffice 也一样可用)  
> 安装参考教程：http://wiki.nooss.cn/archives/420.html  
> Linux 安装字体(不安装会出现乱码问题)：http://wiki.nooss.cn/archives/406.html

-   1、直接复制源码里的文件搬家至你自己的代码中
-   2、将此 Demo 打包成为一个 jar 引入到自己的项目中

## 接口介绍

### 文件上传

`http://ip:port/demo/upload`

### 文件转 PDF

`http://ip:port/demo/toPdf`

### 文件转图片

> ps：会先将文件转为 pdf，然后使用 pdfbox 转为图片

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

-   本示例转换 PDF 部分采用了<a href="https://zh-cn.libreoffice.org/download/libreoffice/" target="_blank">LibreOffice</a>工具
-   PDF 转换图片使用了<a href="https://pdfbox.apache.org/" target="_blank">PDFBox</a>组件
-   感谢<a href="https://hutool.cn/" target="_blank">hutool</a>组件

## 项目关联关键词

word 转 pdf、word 转图片、office 格式转换、在线文件预览

# 前端预览弹出层用法

在页面 `head` 部分引入 `<script src="preview.js"></script>`

### $Preview 参数

| 参数  | 说明               | 值                          |
| ----- | ------------------ | --------------------------- |
| type  | 传入文件的粗类型   | txt / img / pdf / mp3 / mp4 |
| modal | 所有打开的弹窗列表 | Array\<Modal>               |

### $Preview 方法

##### show 打开弹窗

```
window.$Preview.show : (urls: string | Array<string>, options: Options) => $Preview

// e.g
window.$Preview.show('http://123.png')
window.$Preview.show(['http://123.png', 'http://456.png'])
window.$Preview.show(['http://123.png', 'http://456.png'], {
	active: 1
})

urls: Array<string> // 展示的文件地址列表
options: {
	active: number, // 打开时展示第几张 下标从 0 开始
}
```

##### closeAll 关闭所有弹窗

```
window.$Preview.closeAll : () => void
```

##### error 当解析文件路径错误时执行

暂时处理为 `alert`  
可以根据需要自行覆盖

```
window.$Preview.error : (msg) => void

/**
 覆盖代理使用
 覆盖后 alert 将不再弹出
*/
window.$Preview.error = (msg) => {
	console.log(msg)
}
```

##### formatType 粗解析某个路径的文件格式

```
window.$Preview.formatType : (url: string) => 'txt' | 'img' | 'pdf' | 'mp3' | 'mp4'
```

##### formatShowType 返回某个路径的文件格式

```
window.$Preview.formatShowType : (url: string) => FileType
```
