由于生产环境环境的特殊性，zk自有的权限又过于细化和局限，所以对服务端的jar包进行了修改，以实现链接白名单功能。

主要修改内容：
1.修改org\apache\zookeeper\server\ZooKeeperServer.java中的processPacket请求处理方法加入ip/网段的写权限判断
2.添加org\apache\zookeeper\server\ZookeeperWhiteListLoad.java类，内部实现ip/网段白名单
（以后添加、删除ip/网段可直接修改此类）

ps:jar中附有源码，修改时可直接有解压工具删除原有ZookeeperWhiteListLoad.java 及ZookeeperWhiteListLoad.class,然后添加修改后的源码和修改后编译的class文件

包内附有com.onefur.zkfix项目为修改编译环境