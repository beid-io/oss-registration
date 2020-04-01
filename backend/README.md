SPRINGBOOG BOOK
=====
#Machine Setup

This example hardcode redishost inside code, please edit /etc/hosts to point to redis
redis = new RegisterRedis("redis://redishost:6379");

##สำหรับคนใช้ OS X
```
 > brew cask install java
 > brew cask install intellij-idea-ce
 > brew install maven
 > brew install protobuf
 > brew install postgresql redis
```


##สำหรับคนใช้ Windows (Power Shell)
```
 > Set-ExecutionPolicy RemoteSigned -scope CurrentUser
 > Invoke-Expression (New-Object System.Net.WebClient).DownloadString('https://get.scoop.sh/')
 > scoop bucket add java
 > scoop install openjdk
 > scoop install maven
 > scoop bucket add extras
 > scoop install protobuf
 
... หาเอาเอง
```

## production run
```
java -jar springboot-book-1.0.jar -Xmx128M -Xms128M
java -jar target/springboot-book-1.0.jar -Xmx1G -Xms1G
```

##Load Test
```
```


COPYRIGHT 2020 
