##  ubuntu14.04 安装Oracle JDK 7 
 * Ubuntu14.04默认安装的是OpenJDK7，基本够用但安装Hadoop等大数据东东会有很多问题。可以安装 Oracle JDK 6，7 或 8。

 * 第一步：添加 PPA repository 到系统

    tzhuwb@ubuntu:/$ sudo add-apt-repository ppa:webupd8team/java  

 * 第二步：更新

    tzhuwb@ubuntu:/$ sudo apt-get update  

 * 第三步：下载安装 JDK

    tzhuwb@ubuntu:/$ sudo apt-get install oracle-java7-installer  


这里安装的是 JDK7，如果想安装 JDK6 或者 JDK8，把上面语句中的 7 改为对应的数即可。
