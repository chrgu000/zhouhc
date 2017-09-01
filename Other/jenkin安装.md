## 安装Jenkins 

~~~
安装jenkins所需要的安装环境：JDK
~~~

安装Jenkins

~~~
sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat-stable/jenkins.repo
sudo rpm --import https://jenkins-ci.org/redhat/jenkins-ci.org.key
sudo yum install jenkins
~~~

至此jenkins其实就已经安装完毕了，非常简单。但是有可能我们jenkins的端口被其他服务所占用，所以我门最好修改一下jenkins的端口。 

修改jenkins的配置文件在/etc/sysconfig/目录下的jenkins文件。 

执行命令：

vi /etc/sysconfig/jenkins

然后找到JENKINS_PORT=“8080” 和JENKINS_AJP_PORT=”8009“ 这两处，将两处的端口值分别改成8888和8889（也可以改成其他空闲的端口号）。

接下来安装和配置就完成了，可以启动jenkins了。

执行命令 sudo service jenkins start  就可以启动jenkins了。

如果是安装在本地那我们输入localhost:8888 就可以访问jenkins的web页面了 

~~~shell
sudo service jenkins start       #启动jenkins
sudo service jenkins stop        #停止jenkins
sudo service jenkins restart     #重启jenkins
sudo chkconfig jenkins on        #若执行这条命令则意为设置jenkins随系统开机自启动
~~~