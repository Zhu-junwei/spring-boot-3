# 把项目打包成本机镜像文件

- jdk使用`graalvm` `17`/`21`

运行如下命令编译：

```shell
mvn -Pnative native:compile
```
或者使用idea侧边栏的`Maven`菜单`native:compile`编译