# microservice demo

## 提示

- pom使用模块开发，在该目录的pom里配置了项目的顶级parent.
   ```
    mvn clean install 
    ```
    - 自动打包完成，同时在该目录下存在Dockerfile

## 端口

- provider : 8080
- consumer : 8081




## 接口说明

> 1.[provider 提供服务方法]

    @GetMapping("/health/{name}")
    public String health(@PathVariable("name") String name){

        return "provider参数: "+name;
    }

> 2.[consumer 提供服务方法]
   
    @GetMapping("/health/{name}")
    public String health(@PathVariable("name") String name){

        return "consumer-: "+name;
    }

    @GetMapping("/k8s/{id}")
    public String findById(@PathVariable String id) {
        return this.restTemplate.getForObject("http://provider:8081/health/服务提供者-" + id, String.class);
    }

    @GetMapping("/local/{url}/{port}/{name}")
    public String findBybId(@PathVariable String url,  @PathVariable String port, @PathVariable String name) {
        return this.restTemplate.getForObject("http://"+url+":"+port +"/health/服务提供者-" + name, String.class);
    } 
   
   



