### linux其他一些常用快捷键

* 按键	作用
  * Ctrl+d/exit 键盘输入结束或退出终端
  * Ctrl+s暂停当前程序，暂停后按下任意键恢复运行
  * Ctrl+z将当前程序放到后台运行，恢复到前台为命令fg
  * Ctrl+a将光标移至输入行头，相当于Home键
  * Ctrl+e将光标移至输入行末，相当于End键
  * Ctrl+k删除从光标所在位置到行末
  * Alt+Backspace向前删除一个单词
  * Shift+PgUp将终端显示向上滚动
  * Shift+PgDn将终端显示向下滚动




centos 7 安装出现dracut界面时，表示找不到启动盘，这时操作如下

然后开机进入之后出现
dracut:/#
输入以下
输入以下命令
dracut:/# cd dev
dracut:/# ls
接下来找到以sd开头的，有的是sdd，有的是sdb，还有的是sdc，不过貌似一般都是sdb，这里你可以看到以sdb开头的文件有两个分别是sdb和sdb1，sdb1代表的就是你的U盘了，这里是假设你看到的是sdb1,我的显示是sdb4,记住你看到的是哪个。
然后重新开机，你会看到
Install or upgrade Fedora
Troubleshooting
当选第一项的时候（默认就是）按下Tab键，下面会出现
append initrd=initrd.img root=live:CDLABEL=Fedora\x2017\x20i386 quiet
这时你把后面改为
append initrd=initrd.img repo=hd:/dev/sdb1:/ quiet
其中sdb1就代表你上一步看到的，然后点确认就OK了。