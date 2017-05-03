### SSH远程不能链接 

查看 设备mtu 

~~~shell
[root@localhost ~]# ifconfig
eno1: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1200
        inet 10.1.1.131  netmask 255.255.255.0  broadcast 10.1.1.255
        ether 08:94:ef:26:06:61  txqueuelen 1000  (Ethernet)
        RX packets 5072351  bytes 6083214044 (5.6 GiB)
        RX errors 12  dropped 0  overruns 0  frame 12
        TX packets 1286509  bytes 98647540 (94.0 MiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
        device interrupt 16  

eno2: flags=4099<UP,BROADCAST,MULTICAST>  mtu 1500
        ether 08:94:ef:26:06:62  txqueuelen 1000  (Ethernet)
        RX packets 0  bytes 0 (0.0 B)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 0  bytes 0 (0.0 B)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
        device interrupt 17  

eno3: flags=4099<UP,BROADCAST,MULTICAST>  mtu 1500
        ether 08:94:ef:26:06:63  txqueuelen 1000  (Ethernet)
        RX packets 0  bytes 0 (0.0 B)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 0  bytes 0 (0.0 B)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
        device interrupt 16  

eno4: flags=4099<UP,BROADCAST,MULTICAST>  mtu 1500
        ether 08:94:ef:26:06:64  txqueuelen 1000  (Ethernet)
        RX packets 0  bytes 0 (0.0 B)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 0  bytes 0 (0.0 B)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
        device interrupt 17  

lo: flags=73<UP,LOOPBACK,RUNNING>  mtu 65536
        inet 127.0.0.1  netmask 255.0.0.0
        inet6 ::1  prefixlen 128  scopeid 0x10<host>
        loop  txqueuelen 0  (Local Loopback)
        RX packets 2331  bytes 754239 (736.5 KiB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 2331  bytes 754239 (736.5 KiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

virbr0: flags=4099<UP,BROADCAST,MULTICAST>  mtu 1500
        inet 192.168.122.1  netmask 255.255.255.0  broadcast 192.168.122.255
        ether 52:54:00:26:3e:d9  txqueuelen 0  (Ethernet)
        RX packets 0  bytes 0 (0.0 B)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 0  bytes 0 (0.0 B)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
~~~



提示：Connection closed by xxx.xxx.xxx.xxx

修改本机mtu为1500以下

~~~shell
$ sudo ifconfig en01 mtu 1200
~~~
oracle 监听localhost与IP

修改

~~~shell
[root@kerry ~]# more /etc/hosts
# Do not remove the following line, or various programs
# that require network functionality will fail.
#::1            localhost6.localdomain6 localhost6
#127.0.0.1       localhost.localdomain localhost
192.168.27.134  kerry.eduction.com  kerry 

~~~

~~~shell
1：在$ORACLE_HOME/network/admin/下配置listener.ora文件。则屏蔽或删除/etc/hosts下127.0.0.1后，监听不会有任何问题。

2：在配置文件/etc/hosts下增加localhost（红色部分所示）也能解决这个问题。

[root@kerry ~]# more /etc/hosts

# Do not remove the following line, or various programs

# that require network functionality will fail.

#::1 localhost6.localdomain6 localhost6

#127.0.0.1 localhost.localdomain localhost

192.168.27.134 kerry.eduction.com kerry localhost

[root@kerry ~]#
~~~

