# A Spring Boot & Vue.js demo project

## Spring Boot & Vue.js

参考 [jonashackt/spring-boot-vuejs](https://github.com/jonashackt/spring-boot-vuejs) 搭建

详细:

1. 项目结构

## Java 代码规约

参考 [P3C](https://github.com/alibaba/p3c)

详细:

1. 类注释


## 项目运行

### First App run

```
mvn clean install
```

Run our complete Spring Boot App:

```
mvn --projects backend spring-boot:run
```

Now go to http://localhost:8080/ and have a look at your first Vue.js Spring Boot App.



### fast feedback with webpack-dev-server

The webpack-dev-server, which will update and build every change through all the parts of the JavaScript build-chain, is pre-configured in Vue.js out-of-the-box! So the only thing needed to get fast feedback development-cycle is to cd into `frontend` and run:

```
npm run dev
```

That’s it! Now go to http://localhost:8081/.
