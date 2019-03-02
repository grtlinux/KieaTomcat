Spring-Boot-Test-mysql01
========================

```
#
#
# VM options : -Dserver.port=8888
# arguments  : --server.port=8888
#
server:
  port: 8080

#
#
spring:
#  datasource:
#    url: jdbc:mysql://192.168.1.18:3306/tain
#    username: root
#    password: toor
#    driver-class-name: com.mysql.jdbc.Driver
#    url: jdbc:mariadb://192.168.1.18:3306/tain
#    username: root
#    password: toor
#    driver-class-name: org.mariadb.jdbc.Driver
  jpa:
    show-sql: false    # true/false
    hibernate:
      ddl-auto: create
#      ddl-auto: create-drop
  h2:
    console:
      enabled: true
      path: /console
      
  data:
    rest:
      base-path: /api          # base path of data rest
      default-page-size: 10     # page elements in a page
      max-page-size: 20        # max page size
#
#
#
fep-property:
  # general
  program: Fep Client.
  version: 0.02
  desc: This program is a client for Fep.
  
  # company
  company: TAIN, Inc.
  author: Kiea Seok Kang.
  phone: 010-4258-2025
  
  # stream connection
  active: true
  streamHost: 127.0.0.1
  streamPort: 2025
  
  reqData: templates/data/ReqStream(Euckr).dat
  jsonInfoPath: templates/json/
  jsonInfoKeyList:
    - MastInfo
    - StoreInfo
    - Item01Info
    - Item23Info
    - ReqFieldInfo
    - ResFieldInfo
  reqFieldInfo: templates/json/ReqFieldInfo.json
  resFieldInfo: templates/json/ResFieldInfo.json
#
#
#
```



References
----------
- []( ""):
- []( ""):
- []( ""):
- []( ""):
- []( ""):



.....

